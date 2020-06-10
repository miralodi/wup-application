package com.codecool.wupapplication.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codecool.wupapplication.R;
import com.codecool.wupapplication.model.Card;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CardContract.View {

    private BottomNavigationView navView;
    private CardContract.Presenter mPresenter;
    private ProgressBar progressBar;
    private View overlay;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);

        progressBar = findViewById(R.id.progress_circular);
        overlay = findViewById(R.id.overlay);

        mPresenter = new CardPresenter(this);
        mPresenter.requestCards();

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

    @Override
    public void showCardFragments(List<Card> cards) {
        CardFragmentAdapter cardFragmentAdapter = new CardFragmentAdapter(getSupportFragmentManager(), cards);
        viewPager = findViewById(R.id.card_pager);
        viewPager.setAdapter(cardFragmentAdapter);
    }

    @Override
    public void showProgress() {
        overlay.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        overlay.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(CardContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }
}