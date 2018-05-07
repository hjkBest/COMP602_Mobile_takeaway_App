package com.example.user.comp602_restaurant_mobile_application;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Cave extends AppCompatActivity {
    ArrayList<Integer> R1order = new ArrayList<Integer>();
    ArrayList<String> R1comment = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cave);
        setTitle("Restaurant3 Menu");
        setImage();
    }
    public void setImage() {
        ImageButton M1 = (ImageButton) findViewById(R.id.imageButton1);
        Picasso.get().load("http://upload.stnn.cc/2017/1018/1508316448193.jpg").into(M1);
        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M2 = (ImageButton) findViewById(R.id.imageButton2);
        Picasso.get().load("http://upload.stnn.cc/2017/1018/1508316454970.jpg").into(M2);
        M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M3 = (ImageButton) findViewById(R.id.imageButton3);
        Picasso.get().load("http://grinews.com/news/wp-content/uploads/2016/08/%E9%A3%9F%E7%89%A9002.jpg").into(M3);
        M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });
    }

    public void showLayout(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(Cave.this);
        AlertDialog alert = dialog.create();
        LayoutInflater inflater = alert.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_select, null);//
        alert.setView(view);
        final Button btn = (Button) view.findViewById(R.id.buttonC);
        final TextView text = (TextView) view.findViewById(R.id.textview);
        final SeekBar seekbar = (SeekBar) view.findViewById(R.id.seekbar);
        final EditText edtext = (EditText) view.findViewById(R.id.inputtext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Toast.makeText(Cave.this, "Confirm", Toast.LENGTH_LONG).show();
                String comment = "";
                comment = edtext.getText().toString();
                R1comment.add(comment);

            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                text.setText(progress + "");
                int number = 0;
                number = seekbar.getProgress();
                R1order.add(number);
                //get the amount of food
            }
        });
        alert.show();
    }
}
