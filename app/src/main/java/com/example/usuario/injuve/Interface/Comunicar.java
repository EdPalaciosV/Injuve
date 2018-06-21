package com.example.usuario.injuve.Interface;

import android.support.design.widget.BottomSheetBehavior;

import com.example.usuario.injuve.POJOclasses.CompanyData;

import java.util.List;

public interface Comunicar {
     void enviarDato(List<CompanyData> data, int icon, BottomSheetBehavior bottomSheetBehavior);
}
