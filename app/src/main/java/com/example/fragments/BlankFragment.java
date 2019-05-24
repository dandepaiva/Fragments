package com.example.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment{
    private static final Boolean HIDE_THE_FRAGMENT = false;
    private ComunicationInterface callback;
    private EditText editText;
    private static String keepString;

    public BlankFragment() {
    }

    public static BlankFragment newInstance(String string) {
        keepString = string;
        return new BlankFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_blank, container, false);
        Button button = root.findViewById(R.id.hide_fragment);
        editText = root.findViewById(R.id.text_edit);
        editText.setText(keepString);
        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(HIDE_THE_FRAGMENT) {
                    Log.d("true", "ME CLICK BUTTON");
                    root.setVisibility(View.INVISIBLE);
                } else {
                    Log.d("false", "I ASTH CLICKETH THY BUTTON");
                    superCoolFunction(editText.getText().toString());
                }
            }
        });

        return root;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComunicationInterface) {
            callback = (ComunicationInterface) context;
        }
    }

    @Override
    public void onDetach() {
        callback = null;
         super.onDetach();
    }

    private void superCoolFunction(String string){
        if (callback != null) {
            callback.onTextChanged(string);
            editText.setText(keepString);
        }

    }

}
