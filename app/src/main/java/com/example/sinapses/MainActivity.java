package com.example.sinapses;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CardModel> card;
    private int i,contentString;
    private String titleString, uri;
    private Snackbar snack;


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

            @Override
            public void onClickDownload(int listPosition) {
                downloadFile(listPosition);
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

    public void downloadFile(int position){
        uri = CardData.file[position];

        if (uri == ""){
            snack = Snackbar.make(recyclerView, "Arquivo não disponível", Snackbar.LENGTH_SHORT);
            snack.show();

        }else {
            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            DownloadManager.Request req = new DownloadManager.Request(Uri.parse(uri));
            req.setTitle(CardData.titleArray[position]);
            req.setDescription("Baixando STL");
            req.allowScanningByMediaScanner();
            req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            dm.enqueue(req);

        }
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
                AlertDialog.Builder builderAlertApp = new AlertDialog.Builder(this);
                builderAlertApp.setTitle(R.string.appAbout)
                .setMessage(R.string.appAboutText)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
//                        .setIcon(R.drawable.logo_menu);
                AlertDialog alertApp = builderAlertApp.create();
                alertApp.show();
                break;

            case R.id.itemAboutLIPECIN:
                AlertDialog.Builder builderAlertLIPECIN = new AlertDialog.Builder(this);
                builderAlertLIPECIN.setTitle(R.string.lipecinAbout)
                        .setMessage(R.string.lipecinAboutText)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
//                        .setIcon(R.drawable.logo_menu);
                AlertDialog alertLIPECIN = builderAlertLIPECIN.create();
                alertLIPECIN.show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

}
