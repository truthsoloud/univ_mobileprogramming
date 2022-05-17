package com.cookandroid.self_7;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

@SuppressWarnings("deprecation")

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabDog,tabCat, tabHam, tabRabbit;
    ImageView imgV;
    MyTabFragment myFrags[] = new MyTabFragment[4];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabDog=bar.newTab();
        tabDog.setIcon(R.drawable.icondog);
        tabDog.setTabListener(this);
        tabDog.setTag("강아지");
        bar.addTab(tabDog);

        tabCat=bar.newTab();
        tabCat.setIcon(R.drawable.iconcat);
        tabCat.setTabListener(this);
        tabDog.setTag("고양이");
        bar.addTab(tabCat);

        tabHam=bar.newTab();
        tabHam.setIcon(R.drawable.iconham);
        tabHam.setTabListener(this);
        tabDog.setTag("햄스터");
        bar.addTab(tabHam);

        tabRabbit=bar.newTab();
        tabRabbit.setIcon(R.drawable.iconrabbit);
        tabRabbit.setTabListener(this);
        tabDog.setTag("토끼");
        bar.addTab(tabRabbit);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;

        if (myFrags[tab.getPosition()]==null) {
            myTabFrag=new MyTabFragment();
            Bundle data=new Bundle();
            data.putString("tabName", tab.toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()]=myTabFrag;
        }
        else
            myTabFrag=myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    public static class MyTabFragment extends androidx.fragment.app.Fragment {
        String tabName;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data=getArguments();
            tabName=data.getString("tabName");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View v=inflater.inflate(R.layout.activity_main,null);
            ImageView imgV=(ImageView)v.findViewById(R.id.imgV);

            if (tabName=="강아지") imgV.setImageResource(R.drawable.dog);
            if (tabName=="고양이") imgV.setImageResource(R.drawable.cat);
            if (tabName=="햄스터") imgV.setImageResource(R.drawable.ham);
            if (tabName=="토끼") imgV.setImageResource(R.drawable.rabbit);

            return v;
        }
    }

}