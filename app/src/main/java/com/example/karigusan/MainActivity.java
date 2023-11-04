package com.example.karigusan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ImageView backButton;
    TextView title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        backButton = findViewById(R.id.back);
        title = findViewById(R.id.resort_title);

    }


    public void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Toast.makeText(this, "Choose about", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.fav) {
            Toast.makeText(this, "Choose Favorite", Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Favorites fragment = new Favorites(); // Replace with your actual fragment class
            fragmentTransaction.replace(R.id.fragmentContainerView2, fragment); // Replace R.id.fragment_container with your actual container ID
            fragmentTransaction.addToBackStack(null); // Add the transaction to the back stack
            fragmentTransaction.commit();
            return true;
        } else {
            return false;
        }

    }


    public void locate(View view) {
        Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=&destination=Bagasbas+Daet");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

            startActivity(mapIntent);

    }

    public void back(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            Toast.makeText(this, "Already in Home Screen", Toast.LENGTH_SHORT).show();
        }
    }

    public void favbutton(View view) {

           Toast.makeText(this, "You Clicked on favorites", Toast.LENGTH_SHORT).show();
        }





}