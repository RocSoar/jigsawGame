package com.roc.data;

import java.io.Serial;
import java.io.Serializable;

public class GameInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = -427578994907549656L;
    
    private String username;
    private int[][] data;

    // 记录空白方块在二维数组中的位置
    private int x;
    private int y;

    private int step;
    private String imagePath;
    private boolean succeed;

    public GameInfo() {
    }

    public GameInfo(String username, int[][] data, int x, int y, int step, String imagePath, boolean succeed) {
        this.username = username;
        this.data = data;
        this.x = x;
        this.y = y;
        this.step = step;
        this.imagePath = imagePath;
        this.succeed = succeed;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
