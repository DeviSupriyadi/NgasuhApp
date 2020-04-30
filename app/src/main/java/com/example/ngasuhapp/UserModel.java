package com.example.ngasuhapp;

import android.content.Intent;
import android.view.View;

public class UserModel {

    private void declareView() {
        txtKeluar = findViewById(R.id.txt_Logout);
        txtName = findViewById(R.id.txtName);

        txtName.setText(Preferences.getRegisteredUser(getBaseContext()));
    }

    txtKeluar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Preferences.setLogout(getBaseContext());

        startActivity(new Intent(getBaseContext(), LoginActivity.class));
        finish();
        }
    });
}
