package com.roc.ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class LoginJFrame extends JFrame {
    public LoginJFrame() {
        setSize(488, 430);
        setTitle("拼图单机版 登录");

        setAlwaysOnTop(true);
        // 居中
        setLocationRelativeTo(null);
        // 设置关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
