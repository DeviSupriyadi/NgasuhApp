package latihansharedpreference;

import android.content.Intent;

import com.example.ngasuhapp.UserModel;

import latihansharedpreferences.utils.Preferences;

public class LoginActivity {

    UserModel userModel = new UserModel();
    userModel.setUsername(userName);
    userModel.setPassword(password);

    Preferences.setUserPreferences(getBaseContext(), userModel);
    Preferences.setLoggedInStatus(getBaseContext(), true);

    StartActivity(new Intent(getBaseContext(), HomeActivity.class));
    finish();

    private boolean CekUser(String user) {
        return user.equals(Preferences.getRegisteredUser(GetBaseContext()));
    }

    private boolean cekPassword(String password) {
        return password.equals(Preferences.getRegisteredPassword(getBaseContext()));
    }
}
