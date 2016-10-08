package com.mlabs.bbm.firstandroidapp_morningclass;

/**
 * Created by reginasansolis on 10/8/16.
 */

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;



public class Login {

    private TextView emailTxtView;
    private TextView passwordTxtView;
    private Context context;

    public Login(Context context, TextView emailTxtView, TextView passwordTxtView){
        this.context = context;
        this.emailTxtView = emailTxtView;
        this.passwordTxtView = passwordTxtView;
    }

    public boolean validateLogin(EditText emailEditTxt, EditText passwordEditTxt){
        String email = emailEditTxt.getText().toString();
        String password = passwordEditTxt.getText().toString();
        boolean loginName = false, isPasswordCorrect = false;
        User user = null;
        email = email.replace(" ","");
        UserData usersDataSource = new UserData(context);

        usersDataSource.open();

        user = usersDataSource.getUser(email);
        Log.v("USERNAME:",""+user.getUname());
        if (!email.equals(null)) {
            if (!email.equals(user.getEmail()) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailTxtView.setText(String.format("%s", "Email doesnt exist!"));

                loginName = false;
            }else if(!email.equals(user.getUname()) && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailTxtView.setText(String.format("%s", "Username doesnt exist!"));

                loginName = false;
            } else {
                loginName = true;
            }
        }


        usersDataSource.close();

        if(loginName && password.equals(user.getPassword()))
            isPasswordCorrect = true;
        else if(password.length() == 0) {
            passwordTxtView.setText(String.format("%s","Please enter password"));
        }else if(!loginName && password.length() < 8){
            passwordTxtView.setText(String.format("%s","Password length must be more than 7"));
        }else if(loginName && !password.equals(user.getPassword())){
            passwordTxtView.setText(String.format("%s", "Password is incorrect"));
        }

        if(loginName && isPasswordCorrect)
            return true;
        else
            return false;
    }


}
