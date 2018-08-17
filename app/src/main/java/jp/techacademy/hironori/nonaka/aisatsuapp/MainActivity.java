package jp.techacademy.hironori.nonaka.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = findViewById(R.id.textView);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        }
    }




    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        aisatu(hourOfDay);
                    }
                },
                15, // 初期値（時間）
                0,  // 初期値（分）
                false);
        timePickerDialog.show();
    }



    private void aisatu(int hourOfDay){
        Log.d("UI-PART","挨拶メソッド");
        if(hourOfDay>=2 && hourOfDay<10){
            //ここにテキストビューに挨拶を加える
            mTextView.setText("おはよう");
        }
        else if (hourOfDay>=10 && hourOfDay<18){
            //ここにテキストビューに挨拶を加える
            mTextView.setText("こんにちわ");
        }
        else  if ((hourOfDay>=18 && hourOfDay<24)||(hourOfDay>=0 && hourOfDay<2)){
            //ここにテキストビューに挨拶を加える
            mTextView.setText("こんばんわ");
        }
    }


}
