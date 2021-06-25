package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.miwok.R;

public class NumberClickListener implements View.OnClickListener {


    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),"Open the list of numbers",Toast.LENGTH_SHORT).show();
    }
}
