package test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {
    private int x;
    private int y;

    private ImageIcon playerR, playerL;

    public Player() {
        initObject();
        initSetting();
    }

    private void initObject() {
        // 생성하는 메서드
        playerR = new ImageIcon("C:\\workspace\\java_lab\\bubble\\src\\image/playerR.png");
        playerL = new ImageIcon("C:\\workspace\\java_lab\\bubble\\src\\image/playerL.png");

    }

    private void initSetting() {
        // 상태 메서드
        x = 55;
        y = 535;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
        setVisible(true);
    }

}
