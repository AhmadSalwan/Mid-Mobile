package com.example.midmobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fitrah extends Fragment {
    View view;
    EditText target;
    TextView result;
    private final int fitrah=45000;
    Button submit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fitrah, container, false);
        target=view.findViewById(R.id.target);
        result=view.findViewById(R.id.result);
        submit=view.findViewById(R.id.hitung);
        submit.setOnClickListener(v -> hitungzakat());
        return view;
    }

    private void hitungzakat() {
        String targetText=target.getText().toString();
        if(!targetText.isEmpty()){
            try {
                int people=Integer.parseInt(targetText);
                int hasil=people*fitrah;
                result.setText("Zakat yang Harus Anda Keluarkan \n RP. "+String.valueOf(hasil));
            }
            catch (NumberFormatException e){
                e.printStackTrace();
                Toast.makeText(requireContext(), "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(requireContext(), "Masukkan Jumlah Tanggungan", Toast.LENGTH_SHORT).show();
        }
    }
}