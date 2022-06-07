package com.cookandroid.assignment6_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost=getTabHost();

        TabHost.TabSpec tabSpecdog=tabHost.newTabSpec("dog").setIndicator("강아지");
        tabSpecdog.setContent(R.id.dog);
        tabHost.addTab(tabSpecdog);

        TabHost.TabSpec tabSpeccat=tabHost.newTabSpec("cat").setIndicator("고양이");
        tabSpeccat.setContent(R.id.cat);
        tabHost.addTab(tabSpeccat);

        TabHost.TabSpec tabSpecham=tabHost.newTabSpec("ham").setIndicator("햄스터");
        tabSpecham.setContent(R.id.ham);
        tabHost.addTab(tabSpecham);

        TabHost.TabSpec tabSpecrabbit=tabHost.newTabSpec("rabbit").setIndicator("토끼");
        tabSpecrabbit.setContent(R.id.rabbit);
        tabHost.addTab(tabSpecrabbit);

        tabHost.setCurrentTab(0);
    }
}