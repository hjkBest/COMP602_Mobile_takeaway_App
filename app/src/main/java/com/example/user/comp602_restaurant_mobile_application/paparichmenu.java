package com.example.user.comp602_restaurant_mobile_application;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.view.View.OnClickListener;
import com.squareup.picasso.Picasso;
import android.widget.EditText;
import java.util.Map;

import java.util.HashMap;

public class paparichmenu extends AppCompatActivity {
    static double total = 0;
    int price = 0;
    int ordernumber = 0;
    String mealname = "";
    Map<String,String> m = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paparichmenu);
        setTitle("Restaurant1 Menu");
        setImage();

    }

    //set Image to Imagebutton
    public void setImage(){
        ImageButton M1 = (ImageButton) findViewById(R.id.imageButton1);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Noodles-F02.jpg").into(M1);
        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = 10;
                mealname = "meal1";
                showLayout();
            }
        });

        ImageButton M2 = (ImageButton) findViewById(R.id.imageButton2);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Noodles-F04.jpg").into(M2);
        M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = 15;
                mealname = "meal2";
                showLayout();
            }
        });

        ImageButton M3 = (ImageButton) findViewById(R.id.imageButton3);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Noodles-N01.jpg").into(M3);
        M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M4 = (ImageButton) findViewById(R.id.imageButton4);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Noodles-N02.jpg").into(M4);
        M4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M5 = (ImageButton) findViewById(R.id.imageButton5);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Noodles-N03.jpg").into(M5);
        M5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M6 = (ImageButton) findViewById(R.id.imageButton6);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Noodles-N04.jpg").into(M6);
        M6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M7 = (ImageButton) findViewById(R.id.imageButton7);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Noodles-N17.jpg").into(M7);
        M7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M8 = (ImageButton) findViewById(R.id.imageButton8);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/00.FOOD_V02.Vegetarian.jpg.jpg").into(M8);
        M8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();

            }
        });

        ImageButton M9 = (ImageButton) findViewById(R.id.imageButton9);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/00.FOOD_W02.Rice_-1.jpg-1.jpg").into(M9);
        M9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M10 = (ImageButton) findViewById(R.id.imageButton10);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Bread-B16.jpg").into(M10);
        M10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M11 = (ImageButton) findViewById(R.id.imageButton11);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Roti-C08.jpg").into(M11);
        M11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M12 = (ImageButton) findViewById(R.id.imageButton12);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Roti-C06.jpg").into(M12);
        M12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });
    }

    //show the dialog
    public void showLayout(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(paparichmenu.this);
        AlertDialog alert = dialog.create();
        LayoutInflater inflater = alert.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_select, null);//
        alert.setView(view);
        final Button btn = (Button) view.findViewById(R.id.buttonC);
        final TextView text = (TextView) view.findViewById(R.id.textview);
        final SeekBar seekbar = (SeekBar) view.findViewById(R.id.seekbar);
        final EditText edtext = (EditText) view.findViewById(R.id.inputtext);
        final TextView order = (TextView) findViewById(R.id.ordernum);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(paparichmenu.this, "Confirm", Toast.LENGTH_LONG).show();

                total = total + calorder(price, ordernumber);
                order.setText("Order: $ " + total);
                String ordernumstr = String.valueOf(ordernumber);
                m.put(mealname,ordernumstr);
            }
        });
        seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                text.setText(progress + "");
                ordernumber = seekbar.getProgress();
            }
        });
        alert.show();
    }

    public double calorder(int fprice, int fnumber){
       double forder;
       forder = fprice * fnumber;
       return forder;
    }
}
