package com.chezi008.libcontacts.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.chezi008.libcontacts.R;
import com.chezi008.libcontacts.bean.ContactBean;
import com.chezi008.libcontacts.listener.ContactListener;
import com.chezi008.libcontacts.ui.ContactAdapter;
import com.chezi008.libcontacts.utils.LetterComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * - @Description:联系人控件
 * - @Author:  chezi008/chezi008@qq.com
 * - @Time:  2019/6/13 9:53
 */
public class ContactView extends FrameLayout {

    public ContactView(@NonNull Context context) {
        this(context, null);
    }

    public ContactView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_contact, this);
        initView();
    }

    private RecyclerView rvList;
    private WaveSideBarView sideBar;
    private SuspensionDecoration suspensionDecoration;

    private List<ContactBean> mData = new ArrayList<>();
    private ContactAdapter mAdapter = new ContactAdapter(mData);

    private void initView() {
        rvList = findViewById(R.id.rvList);
        sideBar = findViewById(R.id.sideBar);

        //分割线
        suspensionDecoration = new SuspensionDecoration(getContext(), new ArrayList<ContactBean>());
        rvList.addItemDecoration(suspensionDecoration);
        rvList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        sideBar.setOnTouchLetterChangeListener(new WaveSideBarView.OnTouchLetterChangeListener() {
            @Override
            public void onLetterChange(String letter) {
                int pos = mAdapter.getLetterPosition(letter);
                if (letter.equals("\u2191")) {
                    pos = 0;
                }
                if (pos != -1) {
                    rvList.scrollToPosition(pos);
                    LinearLayoutManager mLayoutManager =
                            (LinearLayoutManager) rvList.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(pos, 0);
                }
            }
        });
        rvList.setAdapter(mAdapter);
    }

    /**
     * 设置联系人数据
     *
     * @param data
     * @param isChoose 如果是选择模式，则把非联系人的数据进行过滤操作
     */
    public void setData(List<ContactBean> data, boolean isChoose) {
        if (isChoose) {
            List<ContactBean> tempList = new ArrayList<>();
            for (ContactBean contactBean :
                    data) {
                if (contactBean.getIndex()<0){
                    tempList.add(contactBean);
                }
            }
            data = tempList;
        }

        mData.clear();
        mData.addAll(data);
        //先进行排序
        Collections.sort(mData, new LetterComparator());
        suspensionDecoration.setmDatas(mData);
        mAdapter.notifyDataSetChanged();
        mAdapter.setChoose(isChoose);
    }

    /**
     * 获取选择的联系人
     *
     * @return
     */
    public List<ContactBean> getChoostContacts() {
        List<ContactBean> list = new ArrayList<>();
        for (ContactBean contactBean :
                mData) {
            if (contactBean.isChoose()) {
                list.add(contactBean);
            }
        }
        return list;
    }

    public void addContact(ContactBean contactBean) {

    }

    public void removeContact(ContactBean contactBean) {

    }

    public void setContactListener(ContactListener<ContactBean> contactListener) {
        mAdapter.setContactListener(contactListener);
    }

}
