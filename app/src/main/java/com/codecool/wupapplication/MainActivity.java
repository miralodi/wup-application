package com.codecool.wupapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_title_cards:
                        Toast.makeText(MainActivity.this, "Cards", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_title_transactions:
                    case R.id.menu_title_more:
                    case R.id.menu_title_statements:
                        Toast.makeText(MainActivity.this, "Coming soon!", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        BadgeDrawable statementsBadge = navView.getOrCreateBadge(R.id.menu_title_statements);
        statementsBadge.setVisible(true);
        statementsBadge.setNumber(getResources().getInteger(R.integer.badge_number));
        statementsBadge.setBackgroundColor(getResources().getColor(R.color.orange));
    }
}