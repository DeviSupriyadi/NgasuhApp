package latihansharedpreference;

import android.content.Intent;

import com.example.ngasuhapp.UserModel;

import latihansharedpreferences.utils.Preferences;

public class RegisterActivity {

    UserModel userModel = new UserModel();
    userModel.setUsername(userName);
    userModel.setPassword(password);
    userModel.setPhone(phoneNumber);

    Preferences.setUserPreferences(getBaseContext(), userModel);
    Preferences.setLoggedInStatus(getBaseContext(), true);

    startActivity(new Intent(getBaseContext(), HomeActivity,class));
    finish();

}
