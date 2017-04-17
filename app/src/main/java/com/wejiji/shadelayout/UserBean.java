package com.wejiji.shadelayout;

/**
 * Created by tck on 2017/4/17.
 */

public class UserBean {

    private int iconId;
    private String username;
    private String description;

    public UserBean(int iconId, String username, String description) {
        this.iconId = iconId;
        this.username = username;
        this.description = description;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
