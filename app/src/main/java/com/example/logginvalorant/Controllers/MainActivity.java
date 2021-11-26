package com.example.logginvalorant.Controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.logginvalorant.R;

import java.util.Locale;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemClock.sleep(1000);
        setTheme(R.style.Theme_Valorant);


        super.onCreate(savedInstanceState);
        //cache to save user login
        SharedPreferences prefs= getSharedPreferences("cache", Context.MODE_PRIVATE);
        SharedPreferences.Editor Editor=prefs.edit();
        Boolean login = prefs.getBoolean("login",false);
        //cache to save user login
        Intent Redrict= new Intent(this, MainMenu.class);


        //if its true it will go to Main Page in my case Menu with Agent fragment
        if(login){
            //Editor.clear().commit();

            startActivity(Redrict);
        }else{
            //else it will ask to login
            setContentView(R.layout.activity_main);
            Button btn = (Button) findViewById(R.id.Btn);
            EditText edtText = (EditText) findViewById(R.id.Usertxt);
            EditText edtpass = (EditText) findViewById(R.id.Pwdtxt);
            //Biomatic
            executor = ContextCompat.getMainExecutor(this);
            biometricPrompt = new BiometricPrompt(MainActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                    //Error
                }

                @Override
                public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    String name = edtText.getText().toString();
                    String pass = edtpass.getText().toString();
                    //here we storing data inside cache file
                    Editor.putString("user", name);
                    Editor.putBoolean("login", true);
                    Editor.commit();
                    startActivity(Redrict);
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();

                }
            });
            promptInfo = new BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Biometric login for my app")
                    .setSubtitle("Log in using your biometric credential")
                    .setNegativeButtonText("Use account password")
                    .build();
            biometricPrompt.authenticate(promptInfo);
            //Finish Biomatric
            /*we use Intent to redricte to another page */
            btn.setOnClickListener(new View.OnClickListener() {
                /* we add an event on click ,it will work only when we click on botton */
                @Override
                public void onClick(View v) {
                    /* here we get information from input */
                    String name = edtText.getText().toString();
                    String pass = edtpass.getText().toString();

                    /*we are comparing if user is valid or not */
                    if(name.equals("admin") && pass.equals("admin")){
                        //here we storing data inside cache file
                        Editor.putString("user", name);
                        Editor.putBoolean("login", true);
                        Editor.commit();
                        startActivity(Redrict);
                        Log.i("Login","you are inside");
                    }
                }
            });
        }
    }
    //this function is usefull if you want to switch application languaje (it will always get Same Langaje us your mobile internal languaje)
    private void setAppLocale(String localeCode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        } else {
            config.locale = new Locale(localeCode.toLowerCase());
        }
        res.updateConfiguration(config, dm);
    }
}