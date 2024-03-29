package com.example.sinapses;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ContentActivity extends Activity {

    private Button btnClose;
    private ArrayList<CardModel> dataSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int w = dm.widthPixels;
        int h = dm.widthPixels;

        getWindow().setLayout((int) (w*.9), (int)(h*1.5));

        btnClose = findViewById(R.id.btnCloseContent);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        TextView moreTitle = findViewById(R.id.textViewContent);
        String tS = getIntent().getStringExtra("TITLE_KEY");
        moreTitle.setText(tS);

        TextView moreContent = findViewById(R.id.textViewMore);
        String cM = getIntent().getStringExtra("CONTENT_KEY");
        moreContent.setText(cM);

        TextView moreReference = findViewById(R.id.textReferences);
        String mR = getIntent().getStringExtra("REFERENCE_KEY");
        moreReference.setText(mR);

    }
}
