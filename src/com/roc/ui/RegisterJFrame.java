package com.roc.ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class RegisterJFrame extends JFrame {
    public RegisterJFrame() {
        setSize(488, 500);
        setTitle("拼图单机版 注册");

        setAlwaysOnTop(true);
        // 居中
        setLocationRelativeTo(null);
        // 设置关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
