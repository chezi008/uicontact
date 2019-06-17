package com.chezi008.uicontact;

import com.chezi008.libcontacts.bean.ContactBean;

import java.util.ArrayList;
import java.util.List;

/**
 * - @Description:
 * - @Author:  chezi008/chezi008@qq.com
 * - @Time:  2019/6/14 16:46
 */
public class DataManager {

    private DataManager(){

    }

    public static DataManager getInstance() {
        return DataManagerHolder.instance;
    }

    static class DataManagerHolder{
        private final static DataManager instance = new DataManager();
    }
    String imgs[] = new String[]{
            "http://img5.duitang.com/uploads/item/201507/05/20150705000710_zwPH5.thumb.700_0.jpeg",
            "http://b-ssl.duitang.com/uploads/item/201706/22/20170622131955_h4eZS.thumb.700_0.jpeg",
            "http://5b0988e595225.cdn.sohucs.com/images/20171030/26ed195281334ba4b1752394b60eb29a.jpeg",
            "http://img.52z.com/upload/news/image/20180411/20180411111738_20831.jpg",
            "http://img.52z.com/upload/news/image/20181011/20181011092002_79347.jpg"
    };
    public List<ContactBean> getTestData(String[] array ){
        List<ContactBean> mData = new ArrayList<>();
        //模拟一些数据
        for (int i = 0; i < 20; i++) {
            ContactBean contactBean = new ContactBean();
            contactBean.setName(array[i%12]);
            contactBean.setAvatar(imgs[i%5]);
            mData.add(contactBean);
        }
        //添加三个头部
        ContactBean contactBean = new ContactBean();
        contactBean.setName("头部1");
        contactBean.setIndex(1);
        contactBean.setNum(10);
        contactBean.setAvatar("intres"+R.drawable.ic_default_avatar);
        mData.add(contactBean);
        ContactBean contactBean2 = new ContactBean();
        contactBean2.setName("z头部2");
        contactBean2.setAvatar("intres"+R.mipmap.ic_friend);
        contactBean2.setIndex(2);
        mData.add(contactBean2);
        ContactBean contactBean3 = new ContactBean();
        contactBean3.setName("y头部3");
        contactBean3.setAvatar("intres"+R.mipmap.ic_group_avatar);
        contactBean3.setIndex(3);
        mData.add(contactBean3);

        mData.get(5).setChoose(true);
        mData.get(5).setCheckEnable(false);
        return mData;
    }
}
