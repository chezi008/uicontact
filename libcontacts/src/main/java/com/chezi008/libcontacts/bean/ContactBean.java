package com.chezi008.libcontacts.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.promeg.pinyinhelper.Pinyin;

/**
 * - @Description:联系人
 * - @Author:  chezi008/chezi008@qq.com
 * - @Time:  2019/6/13 9:51
 */
public class ContactBean extends IndexBean implements Parcelable {
    private String id;
    private String name;
    private int type;
    private String avatar;

    private boolean isChoose;
    private boolean checkEnable = true;
    //未读消息数量
    private int num;


    public ContactBean(){

    }


    protected ContactBean(Parcel in) {
        id = in.readString();
        name = in.readString();
        type = in.readInt();
        avatar = in.readString();
        isChoose = in.readByte() != 0;
        checkEnable = in.readByte() != 0;
        num = in.readInt();
    }

    public static final Creator<ContactBean> CREATOR = new Creator<ContactBean>() {
        @Override
        public ContactBean createFromParcel(Parcel in) {
            return new ContactBean(in);
        }

        @Override
        public ContactBean[] newArray(int size) {
            return new ContactBean[size];
        }
    };

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //设置对应的英文字母
        String upperCase = Pinyin.toPinyin(name.charAt(0)).toUpperCase();
        String value = String.valueOf(upperCase.charAt(0));
        if (!value.matches("[A-Z]")) {
            //如果不是A-Z字母开头
            value = "#";
        }
        setLetter(value);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

    public boolean isCheckEnable() {
        return checkEnable;
    }

    public void setCheckEnable(boolean checkEnable) {
        this.checkEnable = checkEnable;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ContactBean){
            ContactBean cobj = (ContactBean) obj;
            return id.equals(cobj.id);
        }
        return super.equals(obj);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeInt(type);
        dest.writeString(avatar);
        dest.writeByte((byte) (isChoose ? 1 : 0));
        dest.writeByte((byte) (checkEnable ? 1 : 0));
        dest.writeInt(num);
    }
}
