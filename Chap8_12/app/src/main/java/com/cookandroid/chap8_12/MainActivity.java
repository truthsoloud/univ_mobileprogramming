package com.cookandroid.chap8_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                MODE_PRIVATE);

        Button btnMkdir, btnRmdir;
        btnMkdir = (Button) findViewById(R.id.btnMkdir);
        btnRmdir = (Button) findViewById(R.id.btnRmdir);

        final String strSDpath =
                Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(strSDpath+"/mydir");

        btnMkdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDir.mkdir();
            }
        });
        btnRmdir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myDir.delete();
            }
        });

    }
}