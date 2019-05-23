package com.example.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    public BlankFragment() {
    }

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_blank, container, false);
        Button button = root.findViewById(R.id.hide_fragment);
        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("tag", "ME CLICK BUTTON");
                root.setVisibility(View.INVISIBLE);
             }
        });

        return root;


    }
}
