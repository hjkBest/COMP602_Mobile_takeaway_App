package com.example.user.comp602_restaurant_mobile_application;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
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
import java.util.List;
import java.util.Map;
import 	java.util.UUID;
import java.util.HashMap;

public class paparichmenu extends AppCompatActivity {
    static double total = 0; //total price of the current order
    int price = 0;  //the price of the each meal
    int ordernumber = 0; //the amount of the meal which has been ordered
    String mealname = ""; //the name of meal
    Map<String,String> m = new HashMap<String, String>(); //use to save the order detail
    String orderstr = "";  //save the order detail as a string, that could allow us to send it to the another activity
    String uniqueID = UUID.randomUUID().toString();
    String num1 = "5554";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paparichmenu);
        setTitle("Restaurant1 Menu"); //set title to the Restaurant1 menu page
        setImage(); //method shows below, used to set up the photo
        Button sendMassage = (Button) findViewById(R.id.send_message);
        //set ClickListener to the button

        sendMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(paparichmenu.this, generateQR.class); //declare new intent
                String number=num1;

                for (Map.Entry<String, String> order : m.entrySet()) {
                    String str1 = order.getKey();
                    String str2 = order.getValue();
                    orderstr = orderstr + str1 + " " + str2 + "\n";
                }
                orderstr = uniqueID + "\n" + orderstr + "\n"  + "$: " + total + "\n";//add the total price to the end of the string

                if(orderstr!=null){
                    SmsManager smsManager=SmsManager.getDefault();
                    List<String> texts=smsManager.divideMessage(orderstr);
                    for(String text:texts)
                    {
                        smsManager.sendTextMessage(number,null,text,null,null);
                        Log.i("sms","send a message");
                        Toast.makeText(getApplicationContext(),"SENT",Toast.LENGTH_SHORT).show();
                    }
                }
                intent.putExtra("codeinfor",orderstr);
                startActivity(intent);
            }
        });
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

                //calculate the price
                total = total + calorder(price, ordernumber);
                order.setText("Order: $ " + total);
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
        alert.show(); //show the dialog
    }
    //method used to calcalate the total price
    public double calorder(int fprice, int fnumber){
       double forder;
       forder = fprice * fnumber;
       return forder;
    }
}
