# uicontact

该模块中抽离了联系人模块的功能，包含显示联系人，选择联系人功能。

[![](https://jitpack.io/v/chezi008/uicontact.svg)](https://jitpack.io/#chezi008/uicontact)

#### 如何依赖
第一步：
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
第二步：
```
dependencies {
	        implementation 'com.github.chezi008:uicontact:1.x.x'
	}
```

#### 功能介绍：

该库主要功能包含：

1、联系人显示，支持头部显示，未读消息显示，类似微信通讯录。

2、支持选择联系人，可以设置已选联系人，禁止选择等多项功能。

3、右侧字母条使用的是WaveSideBarView，具体视图查询演示效果。

#### 效果演示视频

[点击跳转](https://v.youku.com/v_show/id_XNDIzMTUwMjcxNg==.html?spm=a2h3j.8428770.3416059.1)


#### 如何使用

1、使用前需要导入uicontact库。

2、在xml引入写好的ContactView即可。

```
<com.chezi008.libcontacts.widget.ContactView
    android:id="@+id/contactView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

3、初始化并设置联系人数据

```
/**
 * 设置联系人数据
 *
 * @param data
 * @param isChoose 如果是选择模式，则把非联系人的数据进行过滤操作
 */
public void setData(List<ContactBean> data, boolean isChoose)
```

4、设置回调setContactListener()

```
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
```

#### 显示控制

联系人界面未读消息的数量、checkbox的状态都与由ContactBean类中的相应字段进行控制。

```
 	/**
     * 设置本地图片请设置为
     *"intres"+R.mipmap.ic_group_avatar
     */
    private String avatar;
 	/**
     * 是否选择，checkbox的状态由该字段控制
     */
    private boolean isChoose;
    /**
     * checkBox的enable状态
     */
    private boolean checkEnable = true;
    /**
     * 未读消息数量
     */
    private int num;
```
