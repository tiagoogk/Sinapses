package com.example.sinapses;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContentActivity extends Activity {

    private Button btnClose;
    private TextView moreContent;

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

        moreContent =findViewById(R.id.textViewMore);

    }
}
