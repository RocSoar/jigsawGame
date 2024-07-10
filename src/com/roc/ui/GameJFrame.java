package com.roc.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.roc.utils.ArrayUtils;

import java.awt.event.*;
import java.io.IOException;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];

    int x;
    int y;

    int step = 0;

    boolean succeed;

    String path = "./image/animal/animal3/";

    int[][] win = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},};
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");

    JMenuItem person = new JMenuItem("人物");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sports = new JMenuItem("运动");

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

        if (succeed) {
            JLabel win = new JLabel(new ImageIcon("./image/win.png"));
            win.setBounds(208, 283, 197, 73);
            getContentPane().add(win);
        }

        JLabel stepCount = new JLabel("步数: " + step);
        stepCount.setBounds(50, 30, 100, 20);
        getContentPane().add(stepCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon icon = new ImageIcon(path + data[i][j] + ".jpg");
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * j + 90, 105 * i + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                getContentPane().add(jLabel);
            }
        }
        ImageIcon bg = new ImageIcon("./image/background" + ".png");
        JLabel background = new JLabel(bg);
        background.setBounds(48, 40, 508, 560);
        getContentPane().add(background);
        getContentPane().repaint();
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changeJMenu = new JMenu("更换图片");

        functionJMenu.add(changeJMenu);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        changeJMenu.add(person);
        changeJMenu.add(animal);
        changeJMenu.add(sports);

        aboutJMenu.add(accountItem);

        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        person.addActionListener(this);
        animal.addActionListener(this);
        sports.addActionListener(this);

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
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) { // A键
            getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(90, 134, 420, 420);
            getContentPane().add(all);
            ImageIcon bg = new ImageIcon("./image/background" + ".png");
            JLabel background = new JLabel(bg);
            background.setBounds(48, 40, 508, 560);
            getContentPane().add(background);
            getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        checkVictory();
        if (succeed) {
            return;
        }
        switch (code) {
            case 37 -> { // 左箭头
                if (y == 3)
                    return;
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y = y + 1;
                step++;
            }
            case 38 -> { // 上箭头
                if (x == 3)
                    return;
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x = x + 1;
                step++;
            }
            case 39 -> { // 右箭头
                if (y == 0)
                    return;
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y = y - 1;
                step++;
            }
            case 40 -> { // 下箭头
                if (x == 0)
                    return;
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x = x - 1;
                step++;
            }
            case 87 -> { // W键
                data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
                succeed = true;
            }
        }
        initImage();
    }

    public void checkVictory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    succeed = false;
                    return;
                }
            }
        }
        initImage();
        succeed = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == replayItem) {
            succeed = false;
            step = 0;
            initData();
            initImage();
        } else if (source == reLoginItem) {
            setVisible(false);
            try {
                new LoginJFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (source == closeItem) {
            System.exit(0);
        } else if (source == accountItem) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("./image/about.png"));
            jLabel.setBounds(0, 0, 258, 258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344, 344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            // 弹窗不关闭则无法操作下面的界面
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (source == person) {
            changeImage("girl", 1, 13);
        } else if (source == animal) {
            changeImage("animal", 1, 8);
        } else if (source == sports) {
            changeImage("sport", 1, 10);
        }
    }

    private void changeImage(String name, int start, int end) {
        Random r = new Random();
        path = "./image/" + name + "/" + name + r.nextInt(start, end + 1) + "/";
        succeed = false;
        step = 0;
        initData();
        initImage();
    }
}
