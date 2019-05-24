package com.example.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements ComunicationInterface {
    public static final String ACTIVITY_MESSAGE = "com.example.fragments.ACTIVITY";
    public final FragmentManager managerBlankFragment = getSupportFragmentManager();
    private TextView textView;
    private String keepString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        keepString = getString(R.string.welcome);
        textView = findViewById(R.id.dave);


        if (savedInstanceState != null){
            String msg = savedInstanceState.getString(ACTIVITY_MESSAGE);
            keepString = msg;
            textView.setText(msg);
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
        textView.setText(text);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(ACTIVITY_MESSAGE, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
