package com.example.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements ComunicationInterface {
    public static final String ACTIVITY_MESSAGE = "com.example.fragments.ACTIVITY";
    public static final String EDIT_TEXT_MESSAGE = "com.example.fragments.EDIT_TEXT_MESSAGE";

    public final FragmentManager blankFragmentManager = getSupportFragmentManager();
    private TextView textView;
    private String fragmentString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.dave);

         if (savedInstanceState != null){
            fragmentString = savedInstanceState.getString(EDIT_TEXT_MESSAGE);
            textView.setText(savedInstanceState.getString(ACTIVITY_MESSAGE));
        }


        FragmentTransaction blankFragmentTransaction = blankFragmentManager.beginTransaction();
        blankFragmentTransaction.replace(R.id.fragment_blank, BlankFragment.newInstance(fragmentString));
        blankFragmentTransaction.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void sendText(String text) {
        fragmentString = text;
        textView.setText(text);

    }


    @Override
    public void onTextChanged(String text) {
        fragmentString = text;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(ACTIVITY_MESSAGE, textView.getText().toString());
        outState.putString(EDIT_TEXT_MESSAGE, fragmentString);

        super.onSaveInstanceState(outState);
    }
}
