package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b[] = new Button[16];
    TextView tv;
    String op1,op2,op;
    int k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        b[0]=findViewById(R.id.b0);
        b[1]=findViewById(R.id.b1);
        b[2]=findViewById(R.id.b2);
        b[3]=findViewById(R.id.b3);
        b[4]=findViewById(R.id.b4);
        b[5]=findViewById(R.id.b5);
        b[6]=findViewById(R.id.b6);
        b[7]=findViewById(R.id.b7);
        b[8]=findViewById(R.id.b8);
        b[9]=findViewById(R.id.b9);
        b[10]=findViewById(R.id.bplus);
        b[11]=findViewById(R.id.bminus);
        b[12]=findViewById(R.id.bmulti);
        b[13]=findViewById(R.id.bdiv);
        b[14]=findViewById(R.id.bdot);
        b[15]=findViewById(R.id.bequal);
        for (int i=0; i<16; i++){
            b[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v==b[0] || v==b[1] || v==b[2] || v==b[3] || v==b[4] || v==b[5] || v==b[6] || v==b[7] || v==b[8] || v==b[9]){
            if (k==0){
                tv.setText(((Button) v).getText().toString());
                k=1;
            }
            else {
                tv.setText(tv.getText().toString() + ((Button) v).getText().toString());
            }
        }
        else if (v==b[10] || v==b[11] || v==b[12] || v==b[13]) {
            k=0;
            op1=tv.getText().toString();
            op=((Button) v).getText().toString();
        }
        else if (v==b[14]){
            if (!tv.getText().toString().contains(".")){
                tv.setText(tv.getText().toString()+".");
            }
        }
        else {
            op2 = tv.getText().toString();
            calc();
        }
    }

    void calc() {
        float x = Float.parseFloat(op1);
        float y = Float.parseFloat(op2);
        float z = 0;
        if(op.equals("+")) {
            z = x + y;
        }
        else if(op.equals("-")) {
            z = x - y;
        }
        else if(op.equals("*")) {
            z = x * y;
        }
        else {
            z = x / y;
        }
        tv.setText(z + "");
    }
}