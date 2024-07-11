package com.roc.data;

public class User {
    private String name;
    private String password;
    private int count = 3;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String line) {
        String[] ss = line.split("[=&]");
        name = ss[1];
        password = ss[3];
        count = Integer.parseInt(ss[5]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void decrementCount() {
        count--;
    }

    @Override
    public String toString() {
        return "username=" + name + "&password=" + password + "&count=" + count;
    }
}
