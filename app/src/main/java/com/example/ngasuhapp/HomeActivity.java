package com.example.ngasuhapp;

/* Tanggal Pengerjaan : 29-30 April 2020
    Deksripsi         : Bikin Home Activity dan tampilan
    Nama              : Devi Tiana Octaviani
    NIM               : 10117181
    Kelas             : IF-5
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView txtKeluar;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        declareView();
        txtKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Clear Set Preferences
                Preferences.setLogout(getBaseContext());

                //Pindah Halaman ke Login
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
                finish();
            }
        });

    }

    private void declareView() {
        txtKeluar = findViewById(R.id.out);
        txtName = findViewById(R.id.namaa);

        txtName.setText(Preferences.getRegisteredUser(getBaseContext()));
    }
}