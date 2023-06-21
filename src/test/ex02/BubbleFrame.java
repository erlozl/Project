package test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObject();
        initSetting();
        setVisible(true);
    }

    private void initObject() {
        // 생성하는 메서드
        player = new Player();

        backgroundMap = new JLabel(new ImageIcon("C:\\workspace\\java_lab\\bubble\\src\\image/backgroundMap.png"));
        setContentPane(backgroundMap);
        add(player);

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
