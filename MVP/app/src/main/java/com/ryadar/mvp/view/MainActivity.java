package com.ryadar.mvp.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ryada.mvp.R;

public class MainActivity extends AppCompatActivity {

    public static String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"------onCreate------");
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        ShowDataFragment showDataFragment = new ShowDataFragment();
        fragmentTransaction.add(R.id.activity_main,showDataFragment,TAG);
        fragmentTransaction.commit();
    }
}
