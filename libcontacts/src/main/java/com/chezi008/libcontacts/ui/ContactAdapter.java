package com.chezi008.libcontacts.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chezi008.libcontacts.R;
import com.chezi008.libcontacts.bean.ContactBean;
import com.chezi008.libcontacts.listener.ContactListener;

import java.util.List;

/**
 * - @Description:
 * - @Author:  chezi008/chezi008@qq.com
 * - @Time:  2019/6/13 10:05
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactAdapterHolder> {

    private List<ContactBean> mData;

    public ContactAdapter(List<ContactBean> data) {
        mData = data;
    }

    @NonNull
    @Override
    public ContactAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact, viewGroup, false);
        ContactAdapterHolder contactAdapterHolder = new ContactAdapterHolder(view);
        return contactAdapterHolder;
    }

    public int getLetterPosition(String letter) {
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).getLetter().equals(letter)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void onBindViewHolder(@NonNull final ContactAdapterHolder contactAdapterHolder, int position) {
        final ContactBean contactBean = mData.get(position);
        contactAdapterHolder.tvName.setText(contactBean.getName());
        contactAdapterHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChoose) {
                    if (contactBean.isCheckEnable()){
                        boolean result = !contactBean.isChoose();
                        contactAdapterHolder.cbCheck.setChecked(result);
                        contactBean.setChoose(result);
                    }
                } else {
                    if (contactListener != null) {
                        contactListener.onClick(contactBean);
                    }
                }
            }
        });
        contactAdapterHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (contactListener != null) {
                    contactListener.onClick(contactBean);
                }
                return contactListener != null;
            }
        });
        //加载头像
        if (contactBean.getAvatar() != null && contactBean.getAvatar().contains("intres")) {
            int res = Integer.parseInt(contactBean.getAvatar().replace("intres", ""));
            contactAdapterHolder.ivAvatar.setImageResource(res);
        } else if (contactListener != null) {
            contactListener.loadAvatar(contactAdapterHolder.ivAvatar, contactBean.getAvatar());
        }
        //checkbox
        contactAdapterHolder.cbCheck.setVisibility(isChoose ? View.VISIBLE : View.GONE);
        contactAdapterHolder.cbCheck.setChecked(contactBean.isChoose());
        contactAdapterHolder.cbCheck.setEnabled(contactBean.isCheckEnable());
        //num
        contactAdapterHolder.tvNum.setText(String.valueOf(contactBean.getNum()));
        contactAdapterHolder.tvNum.setVisibility(contactBean.getNum()>0?View.VISIBLE:View.GONE);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ContactAdapterHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvNum;
        ImageView ivAvatar;
        CheckBox cbCheck;

        ContactAdapterHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            cbCheck = itemView.findViewById(R.id.cbCheck);
            tvNum = itemView.findViewById(R.id.tvNum);
        }
    }

    private ContactListener<ContactBean> contactListener;

    public void setContactListener(ContactListener<ContactBean> contactListener) {
        this.contactListener = contactListener;
    }

    private boolean isChoose;

    public void setChoose(boolean choose) {
        isChoose = choose;
    }
}
