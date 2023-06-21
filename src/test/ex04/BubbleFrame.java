package test.ex04;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// main스레드를 GUI 프로그램에서는 ui스레드라고 부른다
// 그림을 다시 그린다라는 뜻 - 움직이는 거 자체가 그림이 바뀌기 때문에
public class BubbleFrame extends JFrame {
    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true); // while (실의 길이 무한)
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
                // System.out.println(e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("오른쪽 키보드 클릭됨");
                    // boolean은 is가 붙음
                    if (!player.isRight()) {
                        player.right();
                    }
                    player.right();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (!player.isLeft()) {
                        player.left();
                    }
                    player.left();
                }
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setRight(false);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setLeft(false);
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
