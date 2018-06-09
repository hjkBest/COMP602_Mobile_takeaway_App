package com.example.user.comp602_restaurant_mobile_application;

import android.app.AlertDialog;
import android.content.Intent;
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
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class paparichmenu extends AppCompatActivity {
    static double totalPrice = 0;
    static String orderstr = "";
    int price = 0;
    int ordernumber = 0;
    boolean isclicked = false;
    String mealname = "";
    Map<String,String> m = new HashMap<String, String>();
    ArrayList<String> comment = new ArrayList<String>();
    String num = "5554";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paparichmenu);
        setTitle("Restaurant1 Menu"); //set title to the Restaurant1 menu page
        setImage(); //method shows below, used to set up the photo
        setupsendbutton();
    }

    //set Image to each Imagebutton
    public void setImage(){
        ImageButton M1 = (ImageButton) findViewById(R.id.imageButton1);//declare the imagebutton

        //use picasso function which allow the application to load the photo with internet
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Noodles-F02.jpg").into(M1);

        //set ClickListener
        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set the detail of the meal(price, name)
                price = 10;
                mealname = "meal1";
                isclicked = true;
                showLayout();//a dialog will show up when the imagebutton has been click
            }
        });

        ImageButton M2 = (ImageButton) findViewById(R.id.imageButton2);
        Picasso.get().load("http://papparichnz.co.nz/wp-content/uploads/2017/10/App-Image-Noodles-F04.jpg").into(M2);
        M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = 15;
                mealname = "meal2";
                isclicked = true;
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
        //declare the detail of the dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(paparichmenu.this);
        AlertDialog alert = dialog.create();
        LayoutInflater inflater = alert.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_select, null);
        alert.setView(view);

        //declare the component of the dialog
        final Button btn = (Button) view.findViewById(R.id.buttonC);
        final TextView text = (TextView) view.findViewById(R.id.textview);
        final SeekBar seekbar = (SeekBar) view.findViewById(R.id.seekbar);
        final EditText edtext = (EditText) view.findViewById(R.id.inputtext);
        final TextView order = (TextView) findViewById(R.id.ordernum);

        //set the ClickListener
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //an confirm message will be show down the bottom of the screen when the user click the confirm button
                Toast.makeText(paparichmenu.this, "Confirm", Toast.LENGTH_LONG).show();

                //add string into the arraylist
                String commentstr = edtext.getText().toString();
                if(commentstr.isEmpty()){
                    commentstr = "None";
                }
                comment.add(commentstr);

                //calculate the price
                totalPrice = totalPrice + CalculatePrice(price, ordernumber);
                order.setText("Order: $ " + totalPrice);
                String strnum = String.valueOf(ordernumber);
                m.put(mealname,strnum); //put data to the map
            }
        });

        //seekbar which allow user to drag and use to change the amount of the meal
        seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                text.setText(progress + "");//the textview will show the number
                ordernumber = seekbar.getProgress(); //save the value to the ordernumber
            }
        });
        alert.show();
    }

    //send order that use to generate the QR code
    public void SendOrder(){
        Intent intent = new Intent(paparichmenu.this, generateQR.class); //declare new intent

        if(isclicked) {
            GenerateOrderInfor();
            if(orderstr != null){
                intent.putExtra("codeinfor",orderstr);
                intent.putExtra("phone",num);
                startActivity(intent);
            }
        }else{
            Intent re = new Intent(paparichmenu.this, MainActivity.class);
            Toast.makeText(paparichmenu.this, "No Order Received", Toast.LENGTH_LONG).show();
            startActivity(re);
        }
    }

    //generate the order detail
    public void GenerateOrderInfor(){
        for (Map.Entry<String, String> order : m.entrySet()) {
            int i =0;
            String str1 = order.getKey();
            String str2 = order.getValue();
            String mealcomment = comment.get(i).toString();
            orderstr = orderstr + str1 + " (" + str2 + ") \n"  + "Comment: " + mealcomment + "\n";
            i++;
        }
        orderstr = orderstr + "\n"  + "$: " + totalPrice + "\n";
    }

    //button use to send the message
    public void setupsendbutton(){
        Button sendMassage = (Button) findViewById(R.id.send_message1);
        //set ClickListener to the button
        sendMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendOrder();
            }
        });
    }

    //calculate the total price
    public double CalculatePrice(int price, int num){
        double order;
        order = price * num;
        return order;
    }
}
