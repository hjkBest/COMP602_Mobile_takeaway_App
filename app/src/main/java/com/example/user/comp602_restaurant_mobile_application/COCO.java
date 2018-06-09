package com.example.user.comp602_restaurant_mobile_application;

import android.app.AlertDialog;
import android.content.Intent;
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
import java.util.HashMap;
import java.util.Map;

public class COCO extends AppCompatActivity {

    static double totalPrice = 0;
    static String orderstr = "";
    int price = 0;
    int ordernumber = 0;
    boolean isclicked = false;
    String mealname = "";
    Map<String,String> m = new HashMap<String, String>();
    ArrayList<String> comment = new ArrayList<String>();
    String num = "5556";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coco);
        setTitle("Restaurant3 Menu");
        setImage(); //method shows below, used to set up the photo
        setupsendbutton();
    }

    public void setImage() {
        ImageButton M1 = (ImageButton) findViewById(R.id.imageButton1);
        Picasso.get().load("https://a1.bbkz.net/forum/attachment.php?s=f24167ed2f035e4e0d3791faae676368&attachmentid=1916573&thumb=1&d=1474247039").into(M1);
        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M2 = (ImageButton) findViewById(R.id.imageButton2);
        Picasso.get().load("http://i.epochtimes.com/assets/uploads/2015/09/1508281257372483-600x400.jpg").into(M2);
        M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });

        ImageButton M3 = (ImageButton) findViewById(R.id.imageButton3);
        Picasso.get().load("http://grinews.com/news/wp-content/uploads/2016/08/%E9%A3%9F%E7%89%A9008.jpg").into(M3);
        M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout();
            }
        });
    }

    //show the dialog
    public void showLayout(){
        //declare the detail of the dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(COCO.this);
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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //an confirm message will be show down the bottom of the screen when the user click the confirm button
                Toast.makeText(COCO.this, "Confirm", Toast.LENGTH_LONG).show();

                //add string into the arraylist
                String commentstr = edtext.getText().toString();
                comment.add(commentstr);

                //calculate the price
                totalPrice = totalPrice + CalculatePrice(price, ordernumber);
                order.setText("Order: $ " + totalPrice);
                String strnum = String.valueOf(ordernumber);
                m.put(mealname,strnum); //put data to the map
            }
        });

        //seekbar which allow user to drag and use to change the amount of the meal
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
        Intent intent = new Intent(COCO.this, generateQR.class); //declare new intent

        if(isclicked) {
            GenerateOrderInfor();
            if(orderstr != null){
                intent.putExtra("codeinfor",orderstr);
                intent.putExtra("phone",num);
                startActivity(intent);
            }
        }else{
            Intent re = new Intent(COCO.this, MainActivity.class);
            Toast.makeText(COCO.this, "No Order Received", Toast.LENGTH_LONG).show();
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
        Button sendMassage = (Button) findViewById(R.id.send_message3);
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
