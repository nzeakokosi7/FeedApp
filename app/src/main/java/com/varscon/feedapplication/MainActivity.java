package com.varscon.feedapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.mainFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        if(!FeedApp.hasNetwork()) {
            Toast.makeText(this, "You are currently offline, kindly check your network connectivity", Toast.LENGTH_LONG).show();
        }

    }
}