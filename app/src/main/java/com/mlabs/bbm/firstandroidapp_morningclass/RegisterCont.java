package com.mlabs.bbm.firstandroidapp_morningclass;

/**
 * Created by reginasansolis on 10/8/16.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterCont extends AppCompatActivity {

    private EditText fnameEdit, lnameEdit, unameEdit, emailEdit, passwordEdit, cpasswordEdit;
    private Button regBtn;
    private TextView alertPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fnameEdit = (EditText)findViewById(R.id.fnameEditTxt);
        lnameEdit = (EditText)findViewById(R.id.lnameEditTxt);
        unameEdit = (EditText)findViewById(R.id.unameEditTxt);
        emailEdit = (EditText)findViewById(R.id.emailEditTxt);

        fnameEdit.setOnTouchListener(new ETextListener());
        lnameEdit.setOnTouchListener(new ETextListener());
        unameEdit.setOnTouchListener(new ETextListener());
        emailEdit.setOnTouchListener(new ETextListener());

        alertPassword = (TextView)findViewById(R.id.alertPassword);
        passwordEdit = (EditText)findViewById(R.id.passwordEditTxt);
        cpasswordEdit = (EditText)findViewById(R.id.cpasswordEditTxt);
        regBtn = (Button)findViewById(R.id.regBtn);

        regBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Register register = new Register(getApplicationContext(), fnameEdit, lnameEdit, unameEdit, emailEdit, passwordEdit, cpasswordEdit, alertPassword);

                if(register.isRegistrationSuccessful()){
                    Intent intent = new Intent(RegisterCont.this, LoginCont.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private class ETextListener implements View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (v.equals(fnameEdit)) {
                if(fnameEdit.getText().toString().equals("Please enter first name"))
                    fnameEdit.setText("");
            }

            if (v.equals(lnameEdit)) {
                if(lnameEdit.getText().toString().equals("Please enter last name"))
                    lnameEdit.setText("");
            }
            if (v.equals(unameEdit)) {
                if(unameEdit.getText().toString().equals("Please enter username") || unameEdit.getText().toString().equals("Username not available") || unameEdit.getText().toString().equals("Username must be at least 8 characters"))
                    unameEdit.setText("");
            }
            if (v.equals(emailEdit)) {
                if(emailEdit.getText().toString().equals("Please enter email address") || emailEdit.getText().toString().equals("Invalid email format"))
                    emailEdit.setText("");
            }


            return false;
        }
    }
}
