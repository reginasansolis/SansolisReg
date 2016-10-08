package com.mlabs.bbm.firstandroidapp_morningclass;

/**
 * Created by reginasansolis on 10/8/16.
 */
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class OnTouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontouch);

        final ImageView imgView = (ImageView)findViewById(R.id.imgView);
        final EditText x1Edit = (EditText)findViewById(R.id.x1Edit);
        final EditText x2Edit = (EditText)findViewById(R.id.x2Edit);
        final EditText y1Edit = (EditText)findViewById(R.id.y1Edit);
        final EditText y2Edit = (EditText)findViewById(R.id.y2Edit);

        imgView.setOnTouchListener(new View.OnTouchListener() {
            float initX = 0, initY = 0, finalX = 0, finalY = 0;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        initX = motionEvent.getX();
                        initY = motionEvent.getY();
                        x1Edit.setText(String.format("%.2f",initX));
                        y1Edit.setText(String.format("%.2f",initY));
                        return true;
                    case MotionEvent.ACTION_UP:
                        finalX = motionEvent.getX();
                        finalY = motionEvent.getY();
                        x2Edit.setText(String.format("%.2f",finalX));
                        y2Edit.setText(String.format("%.2f",finalY));
                        getQuadrant(imgView, initX, initY, finalX, finalY);
                        return true;
                }
                return false;
            }
        });


    }

    public void getQuadrant(ImageView imgview, double x1, double y1, double x2, double y2){
        final EditText diffEdit = (EditText)findViewById(R.id.differenceEditText);
        final EditText quadEdit = (EditText)findViewById(R.id.quadrantEditText);
        String diff = "";

        diff = (x1 > x2) ? "X's: "+ String.format("%.2f",(x1 - x2)) : "X's: "+ String.format("%.2f",(x2 - x1));

        diff += (y1 > y2) ? " Y's: "+ String.format("%.2f",(y1 - y2)) : " Y's: "+ String.format("%.2f",(y2 - y1));

        diffEdit.setText(String.format("%s", diff));

        double midX = imgview.getWidth()/2, midY = imgview.getHeight()/2;


        if (x2 > midX && y2 < midY) {
            quadEdit.setText(String.format("%s", "QUADRANT 1"));
        }else if (x2 < midX && y2 < midY) {
            quadEdit.setText(String.format("%s", "QUADRANT 2"));
        }else if (x2 < midX && y2 > midY) {
            quadEdit.setText(String.format("%s", "QUADRANT 3"));
        }else if (x2 > midX && y2 > midY) {
            quadEdit.setText(String.format("%s", "QUADRANT 4"));
        }

    }
}
