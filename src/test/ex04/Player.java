package test.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {
    // 위치 상태
    private int x;
    private int y;
    // 플레이어의 방향 상태
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

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

        // 상태 초기화
        left = false;
        right = false;
        up = false;
        down = false;
        // 키보드 눌리는 순간 정의할거기 때문에 다 false

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
        setVisible(true);
    }

    public void right() {
        // 메서드가 단 한번만 실행되면 어떨까? - 스레드 동작시키기
        new Thread(() -> {
            // player의 상태값이 true이기 때문에 넣기
            right = true;
            while (right) {
                setIcon(playerR);
                x = x + 10;
                setLocation(x, y);
                try {
                    Thread.sleep(10); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 이벤트 루프를 소비하는 애 - 메인스레드
                // 메인스레드가 바쁘면 안됨
                // 어떤 이벤트가 발생하면 어떤 사용자의 요청에 의해서 발동
                // 클릭하는 동안 이벤트 루프에 등록부터 함 (등록->실행)
                // 이벤트 루프 등록되는 거 - 시간이 오래 걸리는 거
                // 이벤트 루프가 소비되는 시점 (메인 스레드가 안 바쁠 때)

            }
        }).start(); // 새로운 스레드
    }

    public void left() {
        new Thread(() -> {
            // player의 상태값이 true이기 때문에 넣기
            left = true;
            while (left) {
                setIcon(playerL);
                x = x - 10;
                setLocation(x, y);
                try {
                    Thread.sleep(10); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 이벤트 루프를 소비하는 애 - 메인스레드
                // 메인스레드가 바쁘면 안됨
                // 어떤 이벤트가 발생하면 어떤 사용자의 요청에 의해서 발동
                // 클릭하는 동안 이벤트 루프에 등록부터 함 (등록->실행)
                // 이벤트 루프 등록되는 거 - 시간이 오래 걸리는 거
                // 이벤트 루프가 소비되는 시점 (메인 스레드가 안 바쁠 때)

            }
        }).start(); // 새로운 스레드
    }

    //////////// getter, setter

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public ImageIcon getPlayerR() {
        return playerR;
    }

    public void setPlayerR(ImageIcon playerR) {
        this.playerR = playerR;
    }

    public ImageIcon getPlayerL() {
        return playerL;
    }

    public void setPlayerL(ImageIcon playerL) {
        this.playerL = playerL;
    }

}
