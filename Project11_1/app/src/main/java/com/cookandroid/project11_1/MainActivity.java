package com.cookandroid.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

        public class MyGridAdapter extends BaseAdapter {
            Context context;
            public MyGridAdapter(Context c) {
                context=c;
            }

            public int getCount() {
                return posterID.length;
            }

            public Object getItem(int arg0) {
                return null;
            }

            public long getItemId(int arg0) {
                return 0;
            }

            Integer[] posterID = {
                    R.drawable.movie1, R.drawable.movie2,R.drawable.movie3,R.drawable.movie4,R.drawable.movie5,
                    R.drawable.movie6,R.drawable.movie7,R.drawable.movie8,R.drawable.movie9,R.drawable.movie10,
                    R.drawable.movie1, R.drawable.movie2,R.drawable.movie3,R.drawable.movie4,R.drawable.movie5,
                    R.drawable.movie6,R.drawable.movie7,R.drawable.movie8,R.drawable.movie9,R.drawable.movie10,
                    R.drawable.movie1, R.drawable.movie2,R.drawable.movie3,R.drawable.movie4,R.drawable.movie5,
                    R.drawable.movie6,R.drawable.movie7,R.drawable.movie8,R.drawable.movie9,R.drawable.movie10
            };

            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageview=new ImageView(context);
                imageview.setLayoutParams(new ViewGroup.LayoutParams(200,300));
                imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageview.setPadding(5, 5, 5, 5);

                imageview.setImageResource(posterID[position]);

                final int pos = position;
                imageview.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        View dialogView=(View) View.inflate(MainActivity.this,
                                R.layout.dialog, null);
                        AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                        ImageView ivPoster=(ImageView) dialogView.findViewById(R.id.ivPoster);
                        ivPoster.setImageResource(posterID[pos]);
                        dlg.setTitle("큰 포스터");
                        dlg.setIcon(R.drawable.icon);
                        dlg.setView(dialogView);
                        dlg.setNegativeButton("닫기", null);
                        dlg.show();
                    }
                });

                return imageview;
            }
        }

    }
