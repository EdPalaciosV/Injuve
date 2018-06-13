package com.example.usuario.injuve;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentResources extends Fragment {


    View view;
    String item;
    TextView TVfragment;
    public FragmentResources() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fragment_resources, container, false);
        TVfragment=view.findViewById(R.id.tvFragment);
        if (getArguments()!=null)
        {
            item=getArguments().getString("VAL");

            TVfragment.setText(item);
        }

        return view;
    }
}
