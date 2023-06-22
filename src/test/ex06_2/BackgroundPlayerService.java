package test.ex06_2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

// 이 클래스가 하는 일
// 백그라운드에서 관찰

// - 메인 스레드는 바쁨 : 키보드 이벤트를 처리하기 바쁨

// 메커니즘 ?
// 내가 100명을 아는 것보다 100명이 나를 아는 게 나음

// 새로운 스레드 생성방법 Runnable
public class BackgroundPlayerService extends JLabel implements Runnable {
    private Player player;
    private BufferedImage image; // 메모리로만 읽은 이미지

    public BackgroundPlayerService(Player player) {
        this.player = player;
        File file = new File("C:\\workspace\\java_lab\\bubble\\src\\image/backgroundMapService.png");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 이미지 읽는 방법 - 라이브러리이기 때문에 찾아서 쓰자
    }

    @Override
    // 여기서 말하는 run()는 새로운 스레드의 생명줄
    public void run() {
        while (true) {
            // 부딪힌 상태의 색깔의 값?

            Color color = new Color(image.getRGB(player.getX(), player.getY()));
            System.out.println(color);
            // -1은 흰색,
            // System.out.println("보글이의 위치의 빨간색상 : " + color.getRed());
            // System.out.println("보글이의 위치의 초록색상 : " + color.getGreen());
            // System.out.println("보글이의 위치의 블루색상 : " + color.getBlue());
            // System.out.println("보글이의 위치의 색상 : " + color.getRGB());
            System.out.println("보글이의 x 좌표 값" + (player.getX()));
            // 벽이 나를 아는 게 나아

            if ((color.getRed() == 255 && color.getGreen() == 0
                    && color.getBlue() == 0)) {
                System.out.println("오른쪽 충돌");
            } else if (player.getX() == 0 && color.getRed() == 255 && color.getGreen() == 0
                    && color.getBlue() == 0) {
                System.out.println("왼쪽 충돌");
            } else if (color.getRed() == 255 && color.getGreen() == 255
                    && color.getBlue() == 255) {
                System.out.println("충돌 안함");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
