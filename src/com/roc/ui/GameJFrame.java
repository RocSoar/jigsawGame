package com.roc.ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import com.roc.utils.ArrayUtils;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameJFrame extends JFrame implements KeyListener {
    int[][] data = new int[4][4];

    int x;
    int y;

    public GameJFrame() {
        initJFrame();

        initJMenuBar();

        initData();

        initImage();

        setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        ArrayUtils.disorderArrayInPlace(tempArr);
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
        getContentPane().removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon icon = new ImageIcon("./image/animal/animal3/" + data[i][j] + ".jpg");
//                ImageIcon icon = new ImageIcon(
//                        "D:/Learning/Java/jigsawGame/image/animal/animal3/" + data[i][j] + ".jpg");
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * j + 90, 105 * i + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                getContentPane().add(jLabel);
            }
        }
        ImageIcon bg = new ImageIcon("./image/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(48, 40, 508, 560);
        getContentPane().add(background);
        getContentPane().repaint();
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
        addKeyListener(this);
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case 37 -> {
                if (y == 3)
                    return;
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y = y + 1;
            }
            case 38 -> {
                if (x == 3)
                    return;
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x = x + 1;
            }
            case 39 -> {
                if (y == 0)
                    return;
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y = y - 1;
            }
            case 40 -> {
                if (x == 0)
                    return;
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x = x - 1;
            }
        }
        initImage();
    }
}
