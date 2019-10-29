package com.example.sinapses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder>{

    private ArrayList<CardModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        ImageView imageCard;
        TextView abstractText;
//        Button buttonText;

        public MyViewHolder(View view){
            super(view);
            this.titleText=view.findViewById(R.id.textTitleCard);
            this.imageCard=view.findViewById(R.id.imageCard);
            this.abstractText=view.findViewById(R.id.textAbstractCard);
//            this.buttonText=view.findViewById(R.id.btnFullText);
        }
    }

    public CardAdapter(ArrayList<CardModel> card){
        this.dataSet=card;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textTitleHolder = holder.titleText;
        ImageView imageCardHolder = holder.imageCard;
        TextView abstractTextHolder = holder.abstractText;

        textTitleHolder.setText(dataSet.get(listPosition).getTitle());
        imageCardHolder.setImageResource(dataSet.get(listPosition).getImage());
        abstractTextHolder.setText(dataSet.get(listPosition).getAbstractText());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }



}