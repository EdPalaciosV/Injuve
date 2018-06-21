package com.example.usuario.injuve;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.injuve.Interface.Comunicar;
import com.example.usuario.injuve.POJOclasses.CompanyData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSheetMenu extends Fragment implements View.OnClickListener {


    View view;
    CardView cvEmpresas,cvOscs,cvPolitico,cvAliados;
    Comunicar comunicar;
    DatabaseReference mdatabaseRef;
    List<CompanyData> items;
    BottomSheetBehavior bottomSheetBehavior;
    public FragmentSheetMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      view= inflater.inflate(R.layout.fragment_design_menu_sheet, container, false);
      comunicar=(Comunicar)getActivity();
      cvEmpresas=view.findViewById(R.id.cvEmpresa);
      cvEmpresas.setOnClickListener(this);
      cvOscs=view.findViewById(R.id.cvSocial);
      cvOscs.setOnClickListener(this);
      cvPolitico=view.findViewById(R.id.cvPolitico);
      cvPolitico.setOnClickListener(this);
      cvAliados=view.findViewById(R.id.cvGubernaamental);
      cvAliados.setOnClickListener(this);

      return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.cvEmpresa:
                getValueCompanies("PyMES",R.drawable.empresa);

                break;
            case R.id.cvSocial:

                getValueCompanies("Oscs",R.drawable.social);

                break;

            case R.id.cvPolitico:

                break;

            case R.id.cvGubernaamental:

                break;

                default:
                    break;
        }

    }
    public void getValueCompanies(String reference, final int icon)
    {
        items=new ArrayList<>();
        mdatabaseRef= FirebaseDatabase.getInstance().getReference(reference);
        mdatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    items.add(new CompanyData(snapshot.getValue(CompanyData.class).getLatitud(),snapshot.getValue(CompanyData.class).getLongitud()));

                }

                bottomSheetBehavior=BottomSheetBehavior.from(view);
               comunicar.enviarDato(items,icon,bottomSheetBehavior);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
