package com.chezi008.uicontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chezi008.libcontacts.bean.ContactBean;
import com.chezi008.libcontacts.widget.ContactView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private static final String TAG = "MainActivity";
    private void initView() {
        findViewById(R.id.btnChoose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseContactActivity.start(MainActivity.this);
            }
        });

        findViewById(R.id.btnContact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactActivity.start(MainActivity.this);
            }
        });
    }
}
