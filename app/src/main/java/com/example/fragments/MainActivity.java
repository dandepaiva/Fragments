package com.example.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements ComunicationInterface {
    public static final String ACTIVITY_MESSAGE = "com.example.fragments.ACTIVITY";
    public static final String BUNDLE_STRING = "com.example.fragments.BUNDLE_STRING";

    public final FragmentManager managerBlankFragment = getSupportFragmentManager();
    private TextView textView;
    private String keepString;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //keepString = getString(R.string.welcome);
        textView = findViewById(R.id.dave);

         if (savedInstanceState != null){
            keepString = savedInstanceState.getString(BUNDLE_STRING);
            String textViewText = savedInstanceState.getString((ACTIVITY_MESSAGE));
            textView.setText(textViewText);
        }


        FragmentTransaction transactionBlankFragment = managerBlankFragment.beginTransaction();
        transactionBlankFragment.replace(R.id.fragment_blank, BlankFragment.newInstance(keepString));
        transactionBlankFragment.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onTextChanged(String text) {
        keepString = text;
        textView.setText(text);

    }


    @Override
    public void saveKeepString(String text) {
        this.text = text;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(ACTIVITY_MESSAGE, textView.getText().toString());
        outState.putString(BUNDLE_STRING, text);

        super.onSaveInstanceState(outState);
    }
}
