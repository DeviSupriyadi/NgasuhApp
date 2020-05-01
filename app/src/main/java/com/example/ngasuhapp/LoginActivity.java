package com.example.ngasuhapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView txtMasuk;
    private TextView txtregis;
    private EditText edtuname;
    private EditText edtpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        declareView();

        txtMasuk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                validasiLogin();
            }
        });

        txtregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())) {
            startActivity(new Intent(getBaseContext(), HomeActivity.class));
            finish();
        }
    }

    private void declareView() {
        txtregis = findViewById(R.id.regis);
        txtMasuk = findViewById(R.id.in_login);
        edtuname = findViewById(R.id.uname);
        edtpw = findViewById(R.id.pw);
    }

    private void validasiLogin(){
        edtuname.setError(null);
        edtpw.setError(null);
        View fokus = null;
        boolean cancel = false;

        String userName = edtuname.getText().toString();
        String password = edtpw.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            edtuname.setError("Harus diisi");
            fokus = edtuname;
            cancel = true;
        }else if (!cekUser(userName)) {
            edtuname.setError("Username Tidak Ditemukan");
            fokus = edtuname;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            edtpw.setError("Harus diisi");
            fokus = edtpw;
            cancel = true;
        } else if (!cekPassword(password)) {
            edtpw.setError("Data yang dimasukkan tidak sesuai");
            fokus = edtpw;
            cancel = true;
        }

        if (cancel) {
            fokus.requestFocus();
        }else {
            UserModel userModel = new UserModel();
            userModel.setUsername(userName);
            userModel.setPassword(password);

            Preferences.setUserPreferences(getBaseContext(), userModel);
            Preferences.setLoggedInStatus(getBaseContext(), true);

            startActivity(new Intent(getBaseContext(), HomeActivity.class));
            finish();
        }
    }

    private boolean cekUser(String user) {
        return user.equals((Preferences.getRegisteredUser(getBaseContext())));
    }

    private boolean cekPassword(String password) {
        return password.equals(Preferences.getRegisteredPassword(getBaseContext()));
    }
}