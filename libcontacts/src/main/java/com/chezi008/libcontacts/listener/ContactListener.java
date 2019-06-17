package com.chezi008.libcontacts.listener;

import android.widget.ImageView;

/**
 * - @Description:
 * - @Author:  chezi008/chezi008@qq.com
 * - @Time:  2019/6/13 17:30
 */
public interface ContactListener<T> {
    /**
     * 点击事件
     * @param item
     */
    void onClick(T item);

    /**
     * 长按事件
     * @param item
     */
    void onLongClick(T item);

    /**
     * 加载头像
     */
    void loadAvatar(ImageView imageView,String avatar);
}
