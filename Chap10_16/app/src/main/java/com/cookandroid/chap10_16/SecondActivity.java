package com.cookandroid.chap10_16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent inIntent = getIntent();
        final int hapValue=inIntent.getIntExtra("Num1", 0)
                +inIntent.getIntExtra("Num2", 0);

        Button btnReturn=(Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", hapValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
