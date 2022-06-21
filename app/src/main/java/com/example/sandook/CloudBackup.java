package com.example.sandook;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.MetadataChangeSet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static android.provider.ContactsContract.Directory.PACKAGE_NAME;
import static com.example.sandook.BackupActivity.DATABASE_NAME;

public class CloudBackup extends Activity
        implements ConnectionCallbacks, OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {

    private static final String TAG = "sandook";
    private static final int REQUEST_CODE_RESOLUTION = 3;
    public static DriveFile mfile;
    private static GoogleApiClient mGoogleApiClient;
    private static final String DATABASE_PATH = "/data/data/" + PACKAGE_NAME + "/databases/" + DATABASE_NAME;
    private static final File DATA_DIRECTORY_DATABASE =
            new File(Environment.getDataDirectory() + "/data/" + PACKAGE_NAME + "/databases/" + DATABASE_NAME);
    private static final String MIME_TYPE = "application/x-sqlite-3";

    /*
     * Create a new file and save it to Drive.
     */
    public void saveFileToDrive() {
        // Start by creating a new contents, and setting a callback.
        Log.i(TAG, "Creating new contents.");
        Drive.DriveApi.newDriveContents(mGoogleApiClient).setResultCallback(new ResultCallback<DriveApi.DriveContentsResult>() {
            @Override
            public void onResult(@NonNull DriveApi.DriveContentsResult result) {
                if (!result.getStatus().isSuccess()) {
                    Toast.makeText(CloudBackup.this, "Error while trying to create new file contents", Toast.LENGTH_LONG).show();
                    return;
                }

                String mimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(MIME_TYPE);
                MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                        .setTitle(DATABASE_NAME) // Google Drive File name
                        .setMimeType(mimeType)
                        .setStarred(true).build();
                // create a file on root folder
                Drive.DriveApi.getRootFolder(mGoogleApiClient)
                        .createFile(mGoogleApiClient, changeSet, result.getDriveContents()).setResultCallback(backupFileCallback);

            }
        });
    }

    public static void doGDriveBackup() {
        Drive.DriveApi.newDriveContents(mGoogleApiClient).setResultCallback(backupContentsCallback);

    }

    static final private ResultCallback<DriveApi.DriveContentsResult> backupContentsCallback = new
            ResultCallback<DriveApi.DriveContentsResult>() {
                @Override
                public void onResult(DriveApi.DriveContentsResult result) {
                    if (!result.getStatus().isSuccess()) {
                        return;
                    }
                    String mimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(MIME_TYPE);
                    MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                            .setTitle(DATABASE_NAME) // Google Drive File name
                            .setMimeType(mimeType)
                            .setStarred(true).build();
                    // create a file on root folder
                    Drive.DriveApi.getRootFolder(mGoogleApiClient)
                            .createFile(mGoogleApiClient, changeSet, result.getDriveContents())
                            .setResultCallback(backupFileCallback);
                }
            };

    static final private ResultCallback<DriveFolder.DriveFileResult> backupFileCallback = new
            ResultCallback<DriveFolder.DriveFileResult>() {
                @Override
                public void onResult(DriveFolder.DriveFileResult result) {
                    if (!result.getStatus().isSuccess()) {
                        return;
                    }
                    mfile = result.getDriveFile();
                    mfile.open(mGoogleApiClient, DriveFile.MODE_WRITE_ONLY, new DriveFile.DownloadProgressListener() {
                        @Override
                        public void onProgress(long bytesDownloaded, long bytesExpected) {
                        }
                    }).setResultCallback(backupContentsOpenedCallback);
                }
            };

    static final private ResultCallback<DriveApi.DriveContentsResult> backupContentsOpenedCallback = new
            ResultCallback<DriveApi.DriveContentsResult>() {
                @Override
                public void onResult(DriveApi.DriveContentsResult result) {
                    if (!result.getStatus().isSuccess()) {
                        return;
                    }
//            DialogFragment_Sync.setProgressText("Backing up..");
                    DriveContents contents = result.getDriveContents();
                    BufferedOutputStream bos = new BufferedOutputStream(contents.getOutputStream());
                    byte[] buffer = new byte[1024];
                    int n;

                    try {
                        FileInputStream is = new FileInputStream(DATA_DIRECTORY_DATABASE);
                        BufferedInputStream bis = new BufferedInputStream(is);

                        while ((n = bis.read(buffer)) > 0) {
                            bos.write(buffer, 0, n);
//                    DialogFragment_Sync.setProgressText("Backing up...");
                        }
                        bos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    contents.commit(mGoogleApiClient, null).setResultCallback(new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status status) {
//                    DialogFragment_Sync.setProgressText("Backup completed!");
//                    mToast(act.getResources().getString(R.string.backupComplete));
//                    DialogFragment_Sync.dismissDialog();
                        }
                    });
                }
            };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(CloudBackup.this, BackupActivity.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addApi(Drive.API).addScope(Drive.SCOPE_FILE).addConnectionCallbacks(this).addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this).build();
        }
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause() {
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
        super.onPause();
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            saveFileToDrive();
        }

    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "GoogleApiClient connection failed: " + result.toString());
        if (!result.hasResolution()) {
            // show the localized error dialog.
            GoogleApiAvailability.getInstance().getErrorDialog(this, result.getErrorCode(), 0).show();
            return;
        }
        try {
            result.startResolutionForResult(this, REQUEST_CODE_RESOLUTION);
        } catch (IntentSender.SendIntentException e) {
            Log.e(TAG, "Exception while starting resolution activity", e);
        }
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        Log.i(TAG, "API client connected.");

        saveFileToDrive();
//        doDriveBackup();
    }

    @Override
    public void onConnectionSuspended(int cause) {
        Log.i(TAG, "GoogleApiClient connection suspended");
    }
}
