package com.example.logginvalorant;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemClock.sleep(1000);
        setTheme(R.style.Theme_Valorant);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.Btn);
        EditText edtText = (EditText) findViewById(R.id.Usertxt);
        EditText edtpass = (EditText) findViewById(R.id.Pwdtxt);

        /*we use Intent to redricte to another page */
        Intent Redrict= new Intent(this,MainMenu.class);
        btn.setOnClickListener(new View.OnClickListener() {
            /* we add an event on click ,it will work only when we click on botton */
            @Override
            public void onClick(View v) {
                /* here we get information from input */
                String name = edtText.getText().toString();
                String pass = edtpass.getText().toString();
                /*we are comparing if user is valid or not */
                if(name.equals("admin") && pass.equals("admin")){
                    startActivity(Redrict);

                    Log.i("Login","you are inside");
                }else{

                }
            }}


    );

    }
}