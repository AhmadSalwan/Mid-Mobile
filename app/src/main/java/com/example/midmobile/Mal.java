package com.example.midmobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Mal extends Fragment {
    View view;
    String[]item={"Penghasilan","Emas"};
    AutoCompleteTextView autoCompleteTextView;
    Button hitung;
    EditText main,second;
    TextView result,lain,textutama;
    ArrayAdapter<String> adapterItems;
    String current;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         view=inflater.inflate(R.layout.fragment_mal, container, false);
         autoCompleteTextView=view.findViewById(R.id.auto_complete_txt);
         adapterItems=new ArrayAdapter<String>(requireContext(),R.layout.list_items,item);
         autoCompleteTextView.setAdapter(adapterItems);

        current="Penghasilan";
         autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 current=parent.getItemAtPosition(position).toString();
                 if(current.equals("Emas")){
                     second.setVisibility(View.GONE);
                     lain.setVisibility(View.GONE);
                     textutama.setText("kepemilikan Emas");
                 }else {
                     second.setVisibility(View.VISIBLE);
                     lain.setVisibility(View.VISIBLE);
                     textutama.setText("Penghasilan Utama");
                 }
             }
         });
         hitung=view.findViewById(R.id.hitung_mal);
         main=view.findViewById(R.id.utama);
         second=view.findViewById(R.id.lain);
         result=view.findViewById(R.id.total);
         lain=view.findViewById(R.id.textlain);
         textutama=view.findViewById(R.id.textutama);

         hitung.setOnClickListener(v -> hitung_zakat_mal());

         return view;
    }

    private void hitung_zakat_mal() {

        if (current.equals("Penghasilan")){
            try{
            String utama=main.getText().toString();
            String seken=second.getText().toString();
            if(!utama.isEmpty() && !seken.isEmpty()){
                try{
                long pertama=Integer.parseInt(utama);
                long kedua=Integer.parseInt(seken);
                long hasil=pertama+kedua;
                if(hasil<6859394){
                    result.setText("Belum Mencapai Nishab,anda belum wajib membayar zakat Mal");
                }else {
                    long akhir=hasil*25/1000;
                    result.setText("Zakat Anda Sebesar \n Rp."+String.valueOf(akhir));
                }}
                catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(requireContext(), "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(requireContext(), "Masukkan Jumlah Penghasilan", Toast.LENGTH_SHORT).show();
            }
            }catch (NumberFormatException e){
                e.printStackTrace();
                Toast.makeText(requireContext(), "Pilih Dahulu Jenis Zakat Mal", Toast.LENGTH_SHORT).show();
        }
        }
        else{
            try {
                String utama = main.getText().toString();
                if (!utama.isEmpty()) {
                    try {
                        long pertama = Integer.parseInt(utama);
                        if (pertama < 82312725) {
                            result.setText("Belum Mencapai Nishab,anda belum wajib membayar zakat Mal");
                        } else {
                            long akhir = pertama * 25 / 1000;
                            result.setText("Zakat Anda Sebesar \n Rp." + String.valueOf(akhir));
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        Toast.makeText(requireContext(), "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
                    }
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
                Toast.makeText(requireContext(), "Pilih Dahulu Jenis Zakat Mal", Toast.LENGTH_SHORT).show();
            }

        }
    }
}