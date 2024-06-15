package com.roc.ui;

import com.roc.data.User;
import com.roc.utils.CodeUtils;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {

    static ArrayList<User> list = new ArrayList<>();

    static {
        list.add(new User("rocSoar", "1234"));
        list.add(new User("gpx", "5678"));
    }

    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();
    JLabel rightCode = new JLabel();

    JButton login = new JButton();
    JButton register = new JButton();

    JDialog jDialog = new JDialog();

    public LoginJFrame() {

        initJFrame();

        initView();

        setVisible(true);
    }

    private void initJFrame() {
        setSize(488, 430);
        setTitle("拼图单机版 登录");

        setAlwaysOnTop(true);
        // 居中
        setLocationRelativeTo(null);
        // 设置关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        取消内部默认布局
        setLayout(null);
    }

    private void initView() {
        JLabel usernameText = new JLabel(new ImageIcon("./image/login/用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        getContentPane().add(usernameText);

        username.setBounds(195, 134, 200, 30);
        getContentPane().add(username);

        JLabel passwordText = new JLabel(new ImageIcon("./image/login/密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        getContentPane().add(passwordText);

        password.setBounds(195, 195, 200, 30);
        getContentPane().add(password);

        JLabel codeText = new JLabel(new ImageIcon("./image/login/验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        getContentPane().add(codeText);

        code.setBounds(195, 256, 100, 30);
        getContentPane().add(code);

        rightCode.setText(CodeUtils.generateCheckCode(5));
        rightCode.setBounds(300, 256, 50, 30);
        getContentPane().add(rightCode);

        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("./image/login/登录按钮.png"));

        login.setBorderPainted(false); //去除按钮默认边框
        login.setContentAreaFilled(false); //去除按钮默认背景
        getContentPane().add(login);

        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("./image/login/注册按钮.png"));

        register.setBorderPainted(false); //去除按钮默认边框
        register.setContentAreaFilled(false); //去除按钮默认背景
        getContentPane().add(register);

        JLabel background = new JLabel(new ImageIcon("./image/login/background.png"));
        background.setBounds(0, 0, 470, 390);
        getContentPane().add(background);

        login.addMouseListener(this);
        register.addMouseListener(this);
        rightCode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightCode.setText(CodeUtils.generateCheckCode(5));
            }
        });
    }

    public void showDialogue(String content) {
        jDialog.setSize(200, 150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null); //居中
        jDialog.setModal(true); //让弹窗不关闭无法操作下面的界面

        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().removeAll();
        jDialog.getContentPane().add(warning);

        jDialog.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object s = e.getSource();
        if (s == login) {
            login.setIcon(new ImageIcon("./image/login/登录按下.png"));
        } else if (s == register) {
            register.setIcon(new ImageIcon("./image/login/注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object s = e.getSource();
        if (s == login) {
            login.setIcon(new ImageIcon("./image/login/登录按钮.png"));
            String un = username.getText();
            String pwd = new String(password.getPassword());
            String c = code.getText();
            if (!rightCode.getText().equalsIgnoreCase(c)) {
                showDialogue("验证码错误!");
                rightCode.setText(CodeUtils.generateCheckCode(5));
                return;
            }
            if (un.isEmpty() || pwd.isEmpty()) {
                showDialogue("用户名或者密码不能为空!");
                rightCode.setText(CodeUtils.generateCheckCode(5));
                return;
            }
            if (!contains(un)) {
                showDialogue("用户名不存在!");
                rightCode.setText(CodeUtils.generateCheckCode(5));
                return;
            }
            User user = queryOne(un);
            if (!user.getPassword().equals(pwd)) {
                showDialogue("密码错误!");
                rightCode.setText(CodeUtils.generateCheckCode(5));
                return;
            }
            setVisible(false);
            new GameJFrame();
        } else if (s == register) {
            register.setIcon(new ImageIcon("./image/login/注册按钮.png"));
//            TODO:
            System.out.println("注册逻辑实现");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private boolean contains(String username) {
        return list.stream().anyMatch(u -> u.getName().equals(username));
    }

    private User queryOne(String username) {
        return list.stream().filter(u -> u.getName().equals(username)).findFirst().orElse(null);
    }
}
