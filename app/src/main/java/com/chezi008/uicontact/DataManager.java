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

    private DataManager() {

    }

    public static DataManager getInstance() {
        return DataManagerHolder.instance;
    }

    static class DataManagerHolder {
        private final static DataManager instance = new DataManager();
    }

    String imgs[] = new String[]{
            "https://pqcloud-data.oss-cn-hangzhou.aliyuncs.com/0/dp/type_images/103042_1.png",
            "http://b-ssl.duitang.com/uploads/item/201410/09/20141009224754_AswrQ.jpeg",
            "http://pic1.zhimg.com/50/v2-6444e641d0235006e81bc4210b5da89b_hd.jpg",
            "http://pic3.zhimg.com/50/v2-3f343ce2639268c29a21c1fb01bdc2a2_hd.jpg",
            "https://fc3tn.baidu.com/it/u=3025909226,1763324618&fm=202&src=bqdata",
            "http://uploadfile.bizhizu.cn/2015/0514/20150514023641335.jpg"
    };

    public List<ContactBean> getTestData(String[] array) {
        List<ContactBean> mData = new ArrayList<>();
        //模拟一些数据
        for (int i = 0; i < 20; i++) {
            ContactBean contactBean = new ContactBean();
            contactBean.setName(array[i % 12]);
            contactBean.setAvatar(imgs[i % 6]);
            mData.add(contactBean);
        }
        //添加三个头部
        ContactBean contactBean = new ContactBean();
        contactBean.setName("头部1");
        contactBean.setIndex(1);
        contactBean.setNum(10);
        contactBean.setAvatar("intres" + R.drawable.ic_default_avatar);
        mData.add(contactBean);
        ContactBean contactBean2 = new ContactBean();
        contactBean2.setName("z头部2");
        contactBean2.setAvatar("intres" + R.mipmap.ic_friend);
        contactBean2.setIndex(2);
        mData.add(contactBean2);
        ContactBean contactBean3 = new ContactBean();
        contactBean3.setName("y头部3");
        contactBean3.setAvatar("intres" + R.mipmap.ic_group_avatar);
        contactBean3.setIndex(3);
        mData.add(contactBean3);

        mData.get(5).setChoose(true);
        mData.get(5).setCheckEnable(false);
        return mData;
    }
}
