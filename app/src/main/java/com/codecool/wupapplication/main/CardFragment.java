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

import com.codecool.wupapplication.R;
import com.codecool.wupapplication.model.Card;

public class CardFragment extends Fragment {

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
        ImageView mCardImage = view.findViewById(R.id.card_image);
        ImageButton mArrowLeft = view.findViewById(R.id.arrow_left);
        ImageButton mArrowRight = view.findViewById(R.id.arrow_right);

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