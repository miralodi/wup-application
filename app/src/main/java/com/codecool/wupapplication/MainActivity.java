package com.codecool.wupapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.codecool.wupapplication.model.Card;
import com.codecool.wupapplication.model.CardAdapter;
import com.codecool.wupapplication.model.ResponseCards;
import com.codecool.wupapplication.network.BaseApiService;
import com.codecool.wupapplication.network.UtilsApi;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;
    BaseApiService mApiService;
    List<Card> cardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApiService = UtilsApi.getAPIService();
        requestCards();

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

    private void requestCards() {
        mApiService.requestCards()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<List<ResponseCards>>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(List<ResponseCards> responseCards) {
                    for (ResponseCards resCard : responseCards) {
                        cardList.add(CardAdapter.convertResponseCardToCard(resCard));
                    }
                }

                @Override
                public void onError(Throwable e) {
                    System.out.println(e.getMessage());
                }

                @Override
                public void onComplete() {
                    System.out.println("SUCCESS");
                }
            });
    }

}