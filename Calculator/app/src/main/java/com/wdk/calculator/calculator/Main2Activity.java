package com.wdk.calculator.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView content_txt1, content_txt2, content_txt3, content_txt4;
    Button C, X, except, ride, seven, night, nine, reduce, four, five, six, plus,
            one, two, three, perc, zero, spot, equal;
    boolean fist = true;
    boolean equa = false;
    boolean showequal = true;
    boolean txt2 = false;
    boolean logo = true;
    boolean time = true;
    boolean tt = true;
    boolean gg = true;
    boolean kk = true;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String t1 = null;
    String str = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        content_txt1 = (TextView) findViewById(R.id.content_txt1);
        content_txt2 = (TextView) findViewById(R.id.content_txt2);
        content_txt3 = (TextView) findViewById(R.id.content_txt3);
        content_txt4 = (TextView) findViewById(R.id.content_txt4);
        content_txt1.setMovementMethod(new ScrollingMovementMethod());
        C = (Button) findViewById(R.id.C);
        X = (Button) findViewById(R.id.X);
        except = (Button) findViewById(R.id.except);
        ride = (Button) findViewById(R.id.ride);
        seven = (Button) findViewById(R.id.seven);
        night = (Button) findViewById(R.id.night);
        nine = (Button) findViewById(R.id.nine);
        reduce = (Button) findViewById(R.id.reduce);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        plus = (Button) findViewById(R.id.plus);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        perc = (Button) findViewById(R.id.perc);
        zero = (Button) findViewById(R.id.zero);
        spot = (Button) findViewById(R.id.spot);
        equal = (Button) findViewById(R.id.equal);
        //绑定监听
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
            /*
            数字
             */
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

                C.setText("C");
                if (fist && logo) {
                    content_txt3.setText("");
                    content_txt4.setText("");
                    fist = false;
                }
                content_txt3.append(((Button) v).getText());
                content_txt3.setTextSize(36);
                content_txt4.setTextSize(20);
                if (showequal) {
                    content_txt4.setText("=" + " " + ((Button) v).getText());
                    showequal = false;
                } else {
                    String s = content_txt3.getText().toString();
                    if (!kk && s.charAt(s.length() - 2) == '.' && content_txt2.getText().toString().isEmpty()) {
                        content_txt4.append("." + ((Button) v).getText());
                    } else {
                        if (time && gg) {
                            if (!content_txt4.getText().toString().contains("=")) {
                                content_txt4.setText("=" + " " + ((Button) v).getText());
                            } else {
                                content_txt4.append(((Button) v).getText());
                            }
                        } else {
                            if (tt) {
                                t1 = content_txt4.getText().toString();
                                tt = false;
                            }
                            content_txt4.setText("=" + " " + result(t1).toString());
                        }

                    }
                }
                /*
                判断content_txt2里是否有数据
                /
                 */
                if (str3 != null && txt2) {
                    content_txt1.append("\n" + str3 + "\n");
                    content_txt1.append(str1 + "\n");
                    content_txt1.append(str2 + "\n");
                    content_txt1.append("----------------------------------------------------------");
                    content_txt2.setText("");
                    content_txt2.setVisibility(View.GONE);
                    txt2 = false;
                }
                if (str3 == null && !txt2)
                    if (equa) {
                        content_txt1.append("\n" + str1 + "\n");
                        content_txt1.append(str2 + "\n");
                        content_txt1.append("----------------------------------------------------------");
                        equa = false;
                        txt2 = false;
                    }
                logo = true;
                break;
            /*
            加减乘除UI
             */
            case R.id.ride:
            case R.id.reduce:
            case R.id.plus:
            case R.id.except:
                if (gg) {
                    str = content_txt3.getText().toString();
                    if (str.equals("+ ") || str.equals("- ") || str.equals("* ") || str.equals("÷ ")) {
                        content_txt3.setText(((Button) v).getText() + " ");
                    }
                    if (logo) {
                        content_txt2.setVisibility(View.VISIBLE);
                        content_txt3.setText(((Button) v).getText() + " ");
                        content_txt2.append(str + "\n");
                        fist = false;
                        txt2 = false;
                        logo = false;
                        time = true;
                        tt = true;
                        gg = false;
                    }
                } else {
                    str = content_txt3.getText().toString();
                    if (str.equals("+ ") || str.equals("- ") || str.equals("* ") || str.equals("÷ ")) {
                        content_txt3.setText(((Button) v).getText() + " ");
                    }
                    if (logo) {
                        content_txt2.setVisibility(View.VISIBLE);
                        content_txt3.setText(((Button) v).getText() + " ");
                        content_txt2.append(str + "\n");
                        txt2 = false;
                        logo = false;
                        time = false;
                        tt = true;

                    }
                }
                break;
             /*
                转换小数UI
                 */
            case R.id.perc:
                str4 = content_txt3.getText().toString();
                if (str4.contains("+") || str4.contains("-") || str4.contains("*") || str4.contains("÷") || str4.equals(".")) {
                    return;
                } else {
                    Double a = Double.valueOf(str4);
                    content_txt3.setText(String.valueOf(a / 100));
                }
                break;
            /*
            等号UI
             */
            case R.id.equal:
                if (!content_txt4.getText().toString().isEmpty()) {
                    content_txt3.setTextSize(20);
                    content_txt4.setTextSize(36);
                }
                str1 = content_txt3.getText().toString();
                str2 = content_txt4.getText().toString();
                str3 = content_txt2.getText().toString();
                fist = true;
                equa = true;
                txt2 = true;
                time = true;
                tt = true;
                gg = true;
                if (str1.contains("+") || str1.contains("-") || str1.contains("*") || str1.contains("÷")) {
                    return;
                } else {
                    logo = true;

                }
                break;
            /*
            全部清除AC
            所有值初始化
             */
            case R.id.C:
                C.setText("AC");
                content_txt1.setText("");
                content_txt2.setText("");
                content_txt2.setVisibility(View.GONE);
                content_txt3.setText("0");
                content_txt4.setText("");
                content_txt1.setTextSize(20);
                content_txt3.setTextSize(36);
                content_txt4.setTextSize(20);
                fist = true;
                equa = false;
                showequal = true;
                txt2 = false;
                logo = true;
                time = true;
                tt = true;
                gg = true;
                kk = true;
                break;
            /*
            清除一个X
             */
            case R.id.X:
                C.setText("C");
                String x = content_txt3.getText().toString();
                String x2 = content_txt4.getText().toString();
                content_txt2.setText("");
                content_txt2.setVisibility(View.GONE);
                if (!x.isEmpty() && !x.equals("0")) {
                    content_txt3.setText(x.substring(0, x.length() - 1));
                    if (content_txt3.getText().toString().isEmpty()) {
                        content_txt3.setText("0");
                        fist = true;
                        equa = false;
                        showequal = true;
                        txt2 = false;
                        logo = true;
                        time = true;
                        tt = true;
                        gg = true;
                        kk = true;
                    }
                }
                if (!x2.isEmpty() && x2.contains("=")) {
                    content_txt4.setText(x2.substring(0, x2.length() - 1));
                    if (content_txt4.getText().toString().equals("=")) {
                        content_txt4.append("0");
                    }
                }
                break;
            /*
            小数点UI
             */
            case R.id.spot:
                C.setText("C");
                str4 = content_txt3.getText().toString();
                if (str4.contains(".")) {
                    return;
                } else {
                    content_txt3.append(((Button) v).getText());
                }
                kk = false;
                break;
        }
    }

    /*
    算数函数，返回值double result
     */
    public Double result(String t) {
        String a = t;
        if (!a.isEmpty()) {
            a = a.substring(1);
        } else {
            content_txt3.setTextSize(36);
            content_txt4.setTextSize(20);
        }
        String b = content_txt3.getText().toString();
        Double result = 0.0;
        Double c = 0.0;
        Double d = 0.0;
        if (b.contains("+")) {
            String[] arr1 = b.split(" ");
            if (arr1[1] != null) {
                b = arr1[1];
                c = Double.valueOf(a);
                d = Double.valueOf(b);
                result = c + d;
            } else {
                c = Double.valueOf(a);
                result = c;
            }
        } else if (b.contains("-")) {
            String[] arr2 = b.split(" ");
            if (arr2[1] != null) {
                b = arr2[1];
                c = Double.valueOf(a);
                d = Double.valueOf(b);
                result = c - d;
            } else {
                c = Double.valueOf(a);
                result = c;
            }
        } else if (b.contains("*")) {
            String[] arr3 = b.split(" ");
            if (arr3[1] != null) {
                b = arr3[1];
                c = Double.valueOf(a);
                d = Double.valueOf(b);
                result = c * d;
            } else {
                c = Double.valueOf(a);
                result = c;
            }
        } else if (b.contains("÷")) {
            String arr4[] = b.split(" ");
            if (arr4[1] != null) {
                b = arr4[1];
                c = Double.valueOf(a);
                d = Double.valueOf(b);
                result = c / d;
            } else {
                c = Double.valueOf(a);
                result = c;
            }
        }
        return result;
    }
}
