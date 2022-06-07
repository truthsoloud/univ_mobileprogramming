package com.cookandroid.project10_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("액티비티 테스트 예제");
        android.util.Log.i("액티비티 테스트", "onCreate()");

        Button btnDial = (Button) findViewById(R.id.btnDial);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
        @Override
        protected void onStart() {
            super.onStart();
            android.util.Log.i("액티비티 테스트", "onStart()");
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            android.util.Log.i("액티비티 테스트", "onRestart()");

        }

        @Override
        protected void onPause() {
            super.onPause();
            android.util.Log.i("액티비티 테스트", "onPause()");

        }

        @Override
        protected void onStop() {
            super.onStop();
            android.util.Log.i("액티비티 테스트", "onStop()");

        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            android.util.Log.i("액티비티 테스트", "onDestroy()");

        }
    }
