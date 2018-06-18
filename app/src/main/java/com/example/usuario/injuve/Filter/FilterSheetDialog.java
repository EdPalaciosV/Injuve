package com.example.usuario.injuve.Filter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.injuve.R;

public class FilterSheetDialog extends BottomSheetDialogFragment {
    @Nullable
    View view;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.filter_design,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
