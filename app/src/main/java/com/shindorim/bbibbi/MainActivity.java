package com.shindorim.bbibbi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private receive fragmentReceive;
    private  send fragmentSend;
    private  setting fragmentSetting;
    private  dictionary fragmentDictionary;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        fragmentReceive = new receive();
        fragmentSend = new send();
        fragmentDictionary = new dictionary();
        fragmentSetting = new setting();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentSend).commitAllowingStateLoss();
    }

    public void clickHandler(View view) {
        transaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.btnReceive:
                transaction.replace(R.id.frameLayout, fragmentReceive).commitAllowingStateLoss();
                break;
            case R.id.btnSend:
                transaction.replace(R.id.frameLayout, fragmentSend).commitAllowingStateLoss();
                break;
            case R.id.btnDictionary:
                transaction.replace(R.id.frameLayout, fragmentDictionary).commitAllowingStateLoss();
                break;
            case R.id.btnSetting:
                transaction.replace(R.id.frameLayout, fragmentSetting).commitAllowingStateLoss();
        }
    }
}
