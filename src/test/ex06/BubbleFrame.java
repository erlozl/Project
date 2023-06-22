package test.ex06;

// 벽에 충돌 감지

// 점프
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
                        // isRight() = false 그걸 !로 하면 true로 바뀌니까
                        player.right();
                    } // 중복 if문 안에 내용을 이렇게 제어를 안해주면
                      // 계속 연속적으로 실행이 될것임
                      // player.right();

                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (!player.isLeft()) {
                        player.left();
                    }
                    // player.left();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("UP");
                    // UP이라는 메세지가 출력되는지 먼저 확인
                    if (!player.isUp() && !player.isDown()) {
                        player.up();
                        // 점프하고 있는 상태가 아닐 때 UP
                    }
                    // player.up();
                    // UP이라는 메시지가 연속으로 클릭되는 걸 막아야 함
                }
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setRight(false);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setLeft(false);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    player.setUp(false);
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
