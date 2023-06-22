package test.ex05;

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

    // 플레이어의 스피드
    private final int SPEED = 3; // x 축
    private final int JUMPSPEED = 5; // y축

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
        x = 55; // 객체의 x 좌표를 고정하는 역할
        y = 535; // 객체의 y 좌표를 고정하는 역할

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
        right = true;
        // 메서드가 단 한번만 실행되면 어떨까? - 스레드 동작시키기
        new Thread(() -> {
            // player의 상태값이 true이기 때문에 넣기
            while (right) {
                setIcon(playerR);
                x = x + SPEED;
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
    // 우측으로 갈수록 값이 증가

    public void left() {
        left = true;
        new Thread(() -> {
            // player의 상태값이 true이기 때문에 넣기
            while (left) {
                setIcon(playerL);
                x = x - SPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(10); // 0.01초
                    // 이걸함으로써 실행시간이 짧아짐
                    // 키보드를 1번 누를 때와 2번 누를때의 시간 간격이
                    // 1초라고 생각을 했을 때 0.01초로 빠르게 실행됨
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
    // 우측으로 갈수록 값이 감소

    public void up() {
        up = true; // 키보드 2번 못 눌려지게 할라고
        new Thread(() -> {
            // -50 * 1
            // -5 * 10
            // -2 * 25
            // -1 * 50 // 제일 부드러워짐

            // 움직이는 거에 따라 for문에 횟수가 달라짐
            // for문 횟수를 올리고 점프 횟수를 작게 하면 제일 부드러워짐

            for (int i = 0; i < 30; i++) {
                // 점프값 30 * 5 150이 올라가는 거임
                y = y - JUMPSPEED;
                // for문을 1로 하고 점프를 정해놓으면 순간이동함
                // 점프 시에 y 좌표가 얼마나 위로 이동할지 결정
                // 점프 값이 클수록 멀어짐
                setLocation(x, y);
                try {
                    Thread.sleep(5); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            up = false; // 멈춰
            down(); // 내려와
            // 이 for문 자체는 점프를 부드럽게 만드는 실행문
        }).start(); // 새로운 스레드
    }
    // 위로 갈수록 Y값이 감소
    // 아래로 갈수록 Y값이 증가

    public void down() {
        down = true;
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                // 점프값
                y = y + JUMPSPEED; // 이런 상수값은 고정하자(안전하게 상수화)
                // 숫자로 해버리면 프로그램 망가짐
                // 이 숫자는 움직이는 값(스피드)
                setLocation(x, y);
                try {
                    Thread.sleep(3);
                    // 3만큼 잔다
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            down = false;
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
