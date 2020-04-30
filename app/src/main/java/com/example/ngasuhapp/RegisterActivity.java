package com.example.ngasuhapp;

import android.content.Intent;

public class RegisterActivity {

    activity_home userModel = new activity_home();
    userModel.setUsername(userName);
    userModel.setPassword(password);
    userModel.setPhone(phoneNumber);

    Preferences.setUserPreferences(getBaseContext(), userModel);
    Preferences.setLoggedInStatus(getBaseContext(), true);

    startActivity(new Intent(getBaseContext(), HomeActivity,class));
    finish();

}
