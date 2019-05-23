package com.example.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    public static final String FRAGMENT_MESSAGE = "com.example.fragments.FRAGMENT1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager managerBlankFragment = getSupportFragmentManager();
        FragmentTransaction transactionBlankFragment = managerBlankFragment.beginTransaction();

        transactionBlankFragment.add(R.id.fragment_blank, new BlankFragment());
        transactionBlankFragment.commit();
/*
        Fragment fragment = managerBlankFragment.findFragmentById(R.id.fragment_blank);
        transactionBlankFragment.remove(fragment);
        transactionBlankFragment.commit();
*/
    }
}
