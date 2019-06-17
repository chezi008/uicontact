package com.chezi008.libcontacts;

/**
 * - @Description:
 * - @Author:  chezi008/chezi008@qq.com
 * - @Time:  2019/6/14 11:38
 */
public class ContactManager {

    private ContactManager(){

    }

    public static ContactManager getInstance() {
        return ContactManagerHolder.instance;
    }

    static class ContactManagerHolder {
        private static final ContactManager instance = new ContactManager();
    }
}
