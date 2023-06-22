package exam.day02;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerEx extends JLabel {
    private int x;
    private int y;
    // 사람의 좌표값 지정
    private ImageIcon playerR, playerL;
    // 오른쪽으로 향해 돌린 player와 왼쪽으로 향해 돌린 player는 다름

    public PlayerEx() {
        playerR = new ImageIcon("C:\\workspace\\java_lab\\bubble\\src\\image/playerR.png");
        playerL = new ImageIcon("C:\\workspace\\java_lab\\bubble\\src\\image/playerL.png");
    }

}
