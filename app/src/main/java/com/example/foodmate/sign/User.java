package com.example.foodmate.sign;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {
    private String Account;
    private String Code;

    public void setAccount(String account) {
        Account = account;
    }
    public void setCode(String code) {
        Code = code;
    }

    public String getAccount() {
        return Account;
    }

    public String getCode() {
        return Code;
    }
}
