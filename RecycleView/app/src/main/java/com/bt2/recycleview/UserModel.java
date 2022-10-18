package com.bt2.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;

import android.os.Bundle;

public class UserModel implements Serializable {

    private String userName;


    public UserModel(String userName) {

        this.userName = userName;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }
}