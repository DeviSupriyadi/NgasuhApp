package com.example.ngasuhapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_register extends AppCompatActivity {

    private TextView txtMasuk;
    private EditText edtuname;
    private EditText edtpw;
    private EditText edtrepw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        declareView();
        txtMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiRegister();
            }
        });
    }

    private void declareView() {
        txtMasuk = findViewById(R.id.reg_in);
        edtuname = findViewById(R.id.regis_uname);
        edtpw = findViewById(R.id.regis_pw);
        edtrepw = findViewById(R.id.regis_repw);
    }

    private void validasiRegister(){

        edtuname.setError(null);
        edtpw.setError(null);
        edtrepw.setError(null);
        View fokus = null;
        boolean cancel = false;

        String userName = edtuname.getText().toString();
        String password = edtpw.getText().toString();
        String rePassword = edtrepw.getText().toString();

        if(TextUtils.isEmpty(userName)){
            edtuname.setError("Harus diisi");
            fokus = edtuname;
            cancel = true;
        }else if (cekUser(userName)){
            edtuname.setError("Username sudah terdaftar");
            fokus = edtuname;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)){
            edtpw.setError("Harus Diisi");
            fokus = edtpw;
            cancel = true;
        }else if (!cekPassword(password,rePassword)){
            edtpw.setError("Password yang dimasukkan tidak sesuai");
            fokus = edtpw;
            cancel = true;
        }

        if (cancel){
            fokus.requestFocus();
        }else{
            UserModel userModel = new UserModel();
            userModel.setUsername(userName);
            userModel.setPassword(password);

            Preferences.setUserPreferences(getBaseContext(),userModel);
            Preferences.setLoggedInStatus(getBaseContext(), true);

            startActivity(new Intent(getBaseContext(), activity_home.class));
            finish();
        }
    }
    private boolean cekUser(String user) {
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
    private boolean cekPassword(String password, String repassword) {
        return password.equals(repassword);
    }

}
