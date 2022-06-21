package com.example.sandook;

import android.content.Intent;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preference);

        findPreference("backup_key")
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                       Intent backIntent =  new Intent(getActivity(),BackupActivity.class);
                       startActivity(backIntent);
                        return false;
                    }
                });

        findPreference("finger_key")
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        return false;
                    }
                });

        findPreference("privacy_key")
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        Intent privacyIntent = new Intent(getActivity(),PrivacyActivity.class);
                        startActivity(privacyIntent);

                        return false;
                    }
                });
    }
}
