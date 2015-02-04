package com.romainpiel.bitcointracker.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.romainpiel.bitcointracker.R;
import com.romainpiel.bitcointracker.model.BPI;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BPIViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.date)
    TextView date;

    @InjectView(R.id.close)
    TextView close;

    @InjectView(R.id.change)
    TextView change;

    public BPIViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }

    public void bind(BPI bpi) {
        date.setText(bpi.getDate());
        close.setText(String.format("$%.2f", bpi.getClose()));

        String changeText = "";
        String changeArrow = "";
        int changeTextColorRes = R.color.textColorSecondary;
        if (bpi.getChange() != null) {
            changeText = String.format("%.2f%%", bpi.getChange() * 100);
            if (bpi.getChange() > 0) {
                changeArrow = " ▲";
                changeTextColorRes = R.color.bpiChangeIncrease;
            } else if (bpi.getChange() < 0) {
                changeArrow = " ▼";
                changeTextColorRes = R.color.bpiChangeDecrease;
            }
        }
        change.setText(changeText + changeArrow);
        change.setTextColor(change.getResources().getColor(changeTextColorRes));
    }
}
