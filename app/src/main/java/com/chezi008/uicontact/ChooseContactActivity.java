package com.chezi008.uicontact;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chezi008.libcontacts.widget.ContactView;

import java.util.Arrays;

public class ChooseContactActivity extends AppCompatActivity {
    private ContactView contactView;
    private static final String TAG = "ChooseContactActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_contact);

        contactView = findViewById(R.id.contactView);
        String[] array = getResources().getStringArray(com.chezi008.libcontacts.R.array.contacts);

        contactView.setData(DataManager.getInstance().getTestData(array),true);
        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: "+ Arrays.toString(contactView.getChoostContacts().toArray()));
                Toast.makeText(ChooseContactActivity.this, ""+contactView.getChoostContacts().size(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ChooseContactActivity.class);
        context.startActivity(starter);
    }
}
