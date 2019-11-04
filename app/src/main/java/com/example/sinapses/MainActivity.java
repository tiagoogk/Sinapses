package com.example.sinapses;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CardModel> card;
    static View.OnClickListener myOnClickListener;
    private int i;
    private String titleString;
    private String contentString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        card = new ArrayList<CardModel>();
        for (i = 0; i < CardData.id_.length; i++) {
            card.add(new CardModel(
                    CardData.titleArray[i],
                    CardData.drawablesArray[i],
                    CardData.abstractArray[i],
                    CardData.id_[i],
                    CardData.content[i]
            ));
        }

        adapter = new CardAdapter(card);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        adapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {

            @Override
            public void onClickText(int listPosition) {
                openText(listPosition);
            }

        });
    }

    public void openText(int position){
        Intent intent = new Intent(this, ContentActivity.class);
        titleString = CardData.titleArray[position];
        contentString = CardData.content[position];
        intent.putExtra("TITLE_KEY", titleString);
        intent.putExtra("CONTENT_KEY", contentString);
        startActivity(intent);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.itemAboutApp:
                AlertDialog.Builder alertApp = new AlertDialog.Builder(this);
                alertApp.setTitle(R.string.appAbout)
                        .setMessage(R.string.appAboutText);
//                        .setIcon(R.drawable.logo_menu);
                alertApp.show();
                break;

            case R.id.itemAboutLIPECIN:
                AlertDialog.Builder alertMetodo = new AlertDialog.Builder(this);
                alertMetodo.setTitle(R.string.lipecinAbout)
                        .setMessage(R.string.lipecinAboutText);
//                        .setIcon(R.drawable.logo_menu);
                alertMetodo.show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

}
