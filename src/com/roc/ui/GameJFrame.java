package com.roc.ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import com.roc.utils.ArrayUtils;

public class GameJFrame extends JFrame {
    int[][] data = new int[4][4];

    public GameJFrame() {
        initJFrame();

        initJMenuBar();

        initData();

        initImage();

        setVisible(true);
    }

    private void initData() {
        int[] tempArr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        ArrayUtils.disorderArrayInPlace(tempArr);
        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon icon = new ImageIcon(
                        "D:/Learning/Java/jigsawGame/image/animal/animal3/" + data[i][j] + ".jpg");
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * j, 105 * i, 105, 105);
                getContentPane().add(jLabel);
            }
        }

    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        setSize(603, 680);
        setTitle("拼图单机版 v1.0");
        setAlwaysOnTop(true);
        // 居中
        setLocationRelativeTo(null);
        // 设置关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(null);
    }
}
