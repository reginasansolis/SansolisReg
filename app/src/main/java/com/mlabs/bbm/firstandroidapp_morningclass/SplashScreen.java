package com.mlabs.bbm.firstandroidapp_morningclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by benjarmanalili on 31/07/2016.
 */

public class SplashScreen extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread thread = new Thread(){

            public void run(){
                try{
                    sleep(3000);
                }catch(Exception exception){
                    exception.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this, LoginCont.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        thread.start();
    }

}