package com.codecool.wupapplication.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codecool.wupapplication.R;
import com.codecool.wupapplication.model.Card;

public class CardFragment extends Fragment {

    private TextView mCardHolderName;

    private Card currentCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_card, container, false);

        assert getArguments() != null;
        currentCard = getArguments().getParcelable("currentCard");

        mCardHolderName = view.findViewById(R.id.fragment_card_holder_name);
        mCardHolderName.setText(currentCard.getCardHolderName());

        return view;
    }
}