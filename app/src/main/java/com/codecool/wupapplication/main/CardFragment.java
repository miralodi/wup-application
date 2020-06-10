package com.codecool.wupapplication.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.codecool.wupapplication.R;
import com.codecool.wupapplication.model.Card;

public class CardFragment extends Fragment {

    private TextView mAvailableBalance;
    private TextView mCurrentBalance;
    private TextView mMinPayment;
    private TextView mDueDate;
    private TextView mDetailsButton;
    private ImageView mCardImage;
    private ImageButton mArrowLeft;
    private ImageButton mArrowRight;

    private Card currentCard;
    private int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        currentCard = getArguments().getParcelable("currentCard");
        position = getArguments().getInt("position");
        initializeViews(view);
    }

    private void initializeViews(View view) {
        mAvailableBalance = view.findViewById(R.id.main_available_value);
        mCurrentBalance = view.findViewById(R.id.current_balance_value);
        mMinPayment = view.findViewById(R.id.min_payment_value);
        mDueDate = view.findViewById(R.id.due_date_value);
        mDetailsButton = view.findViewById(R.id.details_button);
        mCardImage = view.findViewById(R.id.card_image);
        mArrowLeft = view.findViewById(R.id.arrow_left);
        mArrowRight = view.findViewById(R.id.arrow_right);

        mAvailableBalance.setText(String.valueOf(currentCard.getAvailableBalance()));
        mCurrentBalance.setText(String.valueOf(currentCard.getCurrentBalance()));
        mMinPayment.setText(String.valueOf(currentCard.getMinPayment()));
        mDueDate.setText(currentCard.getDueDate());

        switch (currentCard.getCardImage()) {
            case 1: mCardImage.setImageResource(R.drawable.cccard); break;
            case 2: mCardImage.setImageResource(R.drawable.cccard2); break;
            case 3: mCardImage.setImageResource(R.drawable.cccard3); break;
            default: break;
        }

        mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setCurrentItem(--position, true);
            }
        });

        mArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setCurrentItem(++position, true);
            }
        });
    }
}