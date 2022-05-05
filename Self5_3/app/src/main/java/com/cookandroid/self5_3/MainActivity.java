package com.cookandroid.self5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ham);

        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT        );

        LinearLayout baseLayout=new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout,params);

        //여기부터 EditText
        EditText edt=new EditText(this);
        baseLayout.addView(edt);

        //여기부터 button
        Button btn=new Button(this);
        btn.setBackgroundColor(Color.YELLOW);
        btn.setText("버튼입니다");
        baseLayout.addView(btn);

        //여기부터 TEXTVIEW
        TextView textOutput=new TextView(this) ;
        baseLayout.addView(textOutput);
        textOutput.setTextSize(30);
        textOutput.setTextColor(Color.BLUE);
        //에디트텍스트에 입력받은 값을 그대로 출력


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                textOutput.setText(edt.getText().toString());
            }
        });
    }
}