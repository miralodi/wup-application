package com.codecool.wupapplication.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
    String currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        currentCard = intent.getParcelableExtra("currentCard");

        initializeViews();
    }

    private void initializeViews() {
        currency = currentCard.getCurrency();

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

        DetailItem balance = findViewById(R.id.carried_balance);
        balance.setCurrencyText(currency);
        balance.setValueText(CurrencyFormatter.formatIntToCurrency(currentCard.getBalanceCarriedOverFromLastStatement()));

        DetailItem totalSpendings = findViewById(R.id.total_spendings);
        totalSpendings.setCurrencyText(currency);
        totalSpendings.setValueText(CurrencyFormatter.formatIntToCurrency(currentCard.getSpendingsSinceLastStatement()));

        DetailItem lastRepayment = findViewById(R.id.last_repayment);
        lastRepayment.setValueText(currentCard.getYourLastRepayment());

        DetailItem accountLimit = findViewById(R.id.account_limit);
        accountLimit.setCurrencyText(currency);
        accountLimit.setValueText(CurrencyFormatter.formatIntToCurrency(currentCard.getAccountDetails().getAccountLimit()));

        DetailItem accountNumber = findViewById(R.id.account_number);
        accountNumber.setValueText(currentCard.getAccountDetails().getAccountNumber());

        DetailItem cardNumber = findViewById(R.id.card_number);
        cardNumber.setValueText(currentCard.getCardNumber());

        DetailItem cardHolder = findViewById(R.id.card_holder_name);
        cardHolder.setValueText(currentCard.getCardHolderName());
    }
}