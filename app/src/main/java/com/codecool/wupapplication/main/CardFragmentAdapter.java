package com.codecool.wupapplication.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.codecool.wupapplication.model.Card;

import java.util.List;

public class CardFragmentAdapter extends FragmentPagerAdapter {

    private List<Card> cards;

    public CardFragmentAdapter(@NonNull FragmentManager fm, List<Card> cards) {
        super(fm);
        this.cards = cards;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        CardFragment cardFragment = new CardFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable("currentCard", cards.get(position));
        bundle.putInt("position", position);

        cardFragment.setArguments(bundle);
        return cardFragment;
    }

    @Override
    public int getCount() {
        return cards.size();
    }
}
