package com.example.sandook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.cardview.widget.CardView;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;
    BiometricPrompt myBiometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.grid_layout);


        setGridLayout(gridLayout);

        Executor newExecutor = Executors.newSingleThreadExecutor();

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Sandook Loked")
                .setNegativeButtonText("Cancel")
                .build();

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            myBiometricPrompt = new BiometricPrompt(MainActivity.this, newExecutor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                    if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                        finish();
                    } else {
                        finish();
                    }
                }


                @Override
                public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);


                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();


                }
            });
            myBiometricPrompt.authenticate(promptInfo);
        }else{
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
            keyguardManager.isDeviceSecure();
        }


    }

    private void setGridLayout(GridLayout gridLayout) {

        for (int i= 0 ; i<gridLayout.getChildCount(); i++){

            CardView cardView = (CardView) gridLayout.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (finalI){

                        case 0:
                            Intent passIntent = new Intent(MainActivity.this, PassActivity.class);
                            startActivity(passIntent);
                            break;

                        case 1:
                            Intent notesIntent = new Intent(MainActivity.this, NotesActivity.class);
                            startActivity(notesIntent);
                            break;

                        case 2:
                            Intent idIntent = new Intent(MainActivity.this, IdActivity.class);
                            startActivity(idIntent);
                            break;

                        case 3:
                            Intent paymentIntent = new Intent(MainActivity.this, PaymentActivity.class);
                            startActivity(paymentIntent);
                            break;

                        case 4:
                            Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
                            startActivity(profileIntent);
                            break;

                        case 5:
                            Intent settingIntent = new Intent(MainActivity.this, SettingActivity.class);
                            startActivity(settingIntent);
                            break;
                        default:
                            break;
                    }
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
