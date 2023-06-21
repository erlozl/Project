package test.ex03_2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BubbleFrame extends JFrame {
    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true);
    }

    private void initObject() {
        // 생성하는 메서드
        player = new Player();

        backgroundMap = new JLabel(new ImageIcon("C:\\workspace\\java_lab\\bubble\\src\\image/backgroundMap.png"));
        setContentPane(backgroundMap);
        add(player);

    }

    private void initListener() {
        // 키보드 입력은 JPrame에
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.right();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.left();
                }
            }
        });
    }

    private void initSetting() {
        // 상태 메서드

        setSize(1000, 640);
        setTitle("bubble");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new BubbleFrame();
    }
}
