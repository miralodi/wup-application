package com.codecool.wupapplication.detail;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.codecool.wupapplication.R;
import com.codecool.wupapplication.model.Card;
import com.codecool.wupapplication.util.ChartCalculator;
import com.codecool.wupapplication.util.CurrencyFormatter;

public class DetailActivity extends AppCompatActivity {

    private Card currentCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        actionBar.setTitle(getResources().getString(R.string.action_bar_details_title));

        Intent intent = getIntent();
        currentCard = intent.getParcelableExtra("currentCard");

        initializeViews();
    }



    private void initializeViews() {
        String currency = currentCard.getCurrency();
        final int currentBalance = currentCard.getCurrentBalance();
        final int availableBalance = currentCard.getAvailableBalance();
        final int reservations = currentCard.getReservations();

        TextView mCurrentBalanceValue = findViewById(R.id.details_chart_value_current);
        TextView mAvailableValue = findViewById(R.id.details_chart_value_available);
        mCurrentBalanceValue.setText(CurrencyFormatter.formatIntToCurrency(currentBalance));
        mAvailableValue.setText(CurrencyFormatter.formatIntToCurrency(availableBalance));

        final FrameLayout mChartContainer = findViewById(R.id.chart_diagram_container);
        final View mChartCurrent = findViewById(R.id.chart_current);
        final View mChartAvailable = findViewById(R.id.chart_available);
        mChartContainer.post(new Runnable() {
            @Override
            public void run() {
                int chartContainerWidth = mChartContainer.getWidth();
                ChartCalculator.calculateChartFromThreeValues(
                        chartContainerWidth,
                        availableBalance, currentBalance, reservations,
                        mChartCurrent, mChartAvailable);
            }
        });

        TextView mReservationCurrency = findViewById(R.id.reservations_currency);
        TextView mReservationValue = findViewById(R.id.reservations_value);
        mReservationCurrency.setText(currency);
        mReservationValue.setText(CurrencyFormatter.formatIntToCurrency(reservations));
    }
}