package com.example.hristian.knowhowcom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ((TextView)this.findViewById(R.id.tv))
                .setText(this.getIntent().getStringExtra("Extra"));
    }
}
