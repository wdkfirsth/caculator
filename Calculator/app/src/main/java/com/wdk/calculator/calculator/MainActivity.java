package com.wdk.calculator.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
TextView content_txt1,content_txt2,content_txt3;
    Button C,X,except,ride,seven,night,nine,reduce,four,five,six,plus,
                one,two,three,perc,zero,spot,equal;
    boolean fist=true;
    boolean equa=false;
    String str1=null;
    String str2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.id.main);
        content_txt1=(TextView)findViewById(R.id.content_txt1);
        content_txt2=(TextView)findViewById(R.id.content_txt2);
        content_txt3=(TextView)findViewById(R.id.content_txt3);
        content_txt1.setMovementMethod(new ScrollingMovementMethod());
        C=(Button)findViewById(R.id.C);
        X=(Button)findViewById(R.id.X);
        except=(Button)findViewById(R.id.except);
        ride=(Button)findViewById(R.id.ride);
        seven=(Button)findViewById(R.id.seven);
        night=(Button)findViewById(R.id.night);
        nine=(Button)findViewById(R.id.nine);
        reduce=(Button)findViewById(R.id.reduce);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        plus=(Button)findViewById(R.id.plus);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        perc=(Button)findViewById(R.id.perc);
        zero=(Button)findViewById(R.id.zero);
        spot=(Button)findViewById(R.id.spot);
        equal=(Button)findViewById(R.id.equal);
        //°ó¶¨¼àÌý
        C.setOnClickListener(this);
        X.setOnClickListener(this);
        except.setOnClickListener(this);
        ride.setOnClickListener(this);
        seven.setOnClickListener(this);
        night.setOnClickListener(this);
        nine.setOnClickListener(this);
        reduce.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        plus.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        perc.setOnClickListener(this);
        zero.setOnClickListener(this);
        spot.setOnClickListener(this);
        equal.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.night:
            case R.id.nine:
            case R.id.spot:

                if(fist){
                    content_txt2.setText("");
                    content_txt3.setText("");
                    fist=false;
                }
                content_txt2.append(((Button)v).getText()+"\n");
                content_txt2.append(((Button)v).getText());
                content_txt2.setTextSize(50);
                content_txt3.setTextSize(30);
                content_txt3.append(((Button)v).getText());

                if(equa){
                    content_txt1.append("\n"+str1+"\n");
                    content_txt1.append(str2+"\n");
                    content_txt1.append("--------------------------------");
                    equa=false;
                }
                break;
            case R.id.equal:
                content_txt2.setTextSize(30);
                content_txt3.setTextSize(50);
                str1=content_txt2.getText().toString();
                str2=content_txt3.getText().toString();
                fist=true;
                equa=true;

        }
    }
}
