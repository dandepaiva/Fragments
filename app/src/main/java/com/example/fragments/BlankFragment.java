package com.example.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
    public static final String FRAGMENT_MESSAGE = "com.example.fragments.FRAGMENT";
    private static final Boolean HIDE_THE_FRAGMENT = false;
    private ComunicationInterface callback;
    private EditText editText;
    private String keepString;

    public BlankFragment() {
    }

    public static BlankFragment newInstance(String string) {

        Bundle args = new Bundle();
        args.putString(FRAGMENT_MESSAGE, string);
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /*TODO
    editText must persist through rotation
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_blank, container, false);

        Button button = root.findViewById(R.id.hide_fragment);
        editText = root.findViewById(R.id.text_edit);
        editText.setText(keepString);
        if (savedInstanceState != null) {
            String aux = savedInstanceState.getString(FRAGMENT_MESSAGE);
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                keepString = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(HIDE_THE_FRAGMENT) {
                    root.setVisibility(View.INVISIBLE);
                } else {
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
        }

    }

}
