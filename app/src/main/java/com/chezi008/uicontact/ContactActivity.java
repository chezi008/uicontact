package com.chezi008.uicontact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chezi008.libcontacts.bean.ContactBean;
import com.chezi008.libcontacts.listener.ContactListener;
import com.chezi008.libcontacts.widget.ContactView;

public class ContactActivity extends AppCompatActivity implements ContactListener<ContactBean> {

    private ContactView contactView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        contactView = findViewById(R.id.contactView);
        String[] array = getResources().getStringArray(com.chezi008.libcontacts.R.array.contacts);

        contactView.setData(DataManager.getInstance().getTestData(array),false);
        contactView.setContactListener(this);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ContactActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void onClick(ContactBean item) {
        Toast.makeText(this, "onclick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongClick(ContactBean item) {
        Toast.makeText(this, "onLongClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadAvatar(ImageView imageView, String avatar) {
        Glide.with(imageView)
                .load(avatar)
                .into(imageView);
    }
}
