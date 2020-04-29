package latihansharedpreference;

import android.content.Intent;
import android.view.View;

import latihansharedpreferences.utils.Preferences;

public class HomeActivity {

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
