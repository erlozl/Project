package exam.day02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFra extends JFrame {
    private JLabel bgMap;
    private PlayerEx playerEx;

    // 생성자는 클래스의 멤버 변수를 초기화하거나,
    // 멤버 메소드를 호출하여 원하는 동작을 수행할 수 있다.
    BubbleFra() {

        playerEx = new PlayerEx();
        // 버블프레임안에 플레이어가 하나 있어야 되므로
        // 객체 간의 포함 관계를 의미하고 한 클래스가 다른 클래스의 객체를
        // 내부에 포함시키게 만드는 구성관계를 나타내자

        bgMap = new JLabel(new ImageIcon("C:\\workspace\\java_lab\\bubble\\src\\image/backgroundMap.png"));
        // JLabel로 backgroundImg르 가져와서 설정
        setContentPane(bgMap);
        // ContentPane에 이미지 넣기

        setTitle("bubbleExam");
        setSize(1000, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BubbleFra();
    }

}
