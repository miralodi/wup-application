package com.codecool.wupapplication.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codecool.wupapplication.R;
import com.codecool.wupapplication.model.Card;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CardContract.View {

    private BottomNavigationView navView;
    private CardContract.Presenter mPresenter;
    private ProgressBar progressBar;
    private View overlay;
    private ViewPager viewPager;
    private TextView mAvailableBalance;
    private TextView mCurrentBalance;
    private TextView mMinPayment;
    private TextView mDueDate;
    private TextView mCurrentBalanceCurrency;
    private TextView mPaymentCurrency;
    private TextView mDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);

        progressBar = findViewById(R.id.progress_circular);
        overlay = findViewById(R.id.overlay);
        mAvailableBalance = findViewById(R.id.main_available_value);
        mCurrentBalance = findViewById(R.id.current_balance_value);
        mMinPayment = findViewById(R.id.min_payment_value);
        mDueDate = findViewById(R.id.due_date_value);
        mCurrentBalanceCurrency = findViewById(R.id.current_balance_currency);
        mPaymentCurrency = findViewById(R.id.min_payment_currency);
        mDetailsButton = findViewById(R.id.details_button);

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
    public void showCardFragments(final List<Card> cards) {
        CardFragmentAdapter cardFragmentAdapter = new CardFragmentAdapter(getSupportFragmentManager(), cards);
        viewPager = findViewById(R.id.card_pager);
        viewPager.setAdapter(cardFragmentAdapter);
        TabLayout tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
        fillData(0, cards);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                fillData(position, cards);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void fillData(int position, List<Card> cards) {
        mAvailableBalance.setText(String.valueOf(cards.get(position).getAvailableBalance()));
        mCurrentBalance.setText(String.valueOf(cards.get(position).getCurrentBalance()));
        mMinPayment.setText(String.valueOf(cards.get(position).getMinPayment()));
        mDueDate.setText(cards.get(position).getDueDate());
        mCurrentBalanceCurrency.setText(cards.get(position).getCurrency());
        mPaymentCurrency.setText(cards.get(position).getCurrency());
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