package test.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
// 풍선서비스
// 풍성 ,플레이어, 맵, 적군
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 이 자체가 스레드
// 타겟이 없다는 건 자기만의 실이 없다는 것 - run()이 없다는 것
// 움직이는 짧은 코드들은 new 
public class BackgroundPlayerService implements Runnable {
    private BufferedImage image;
    private Player player;
    // 무엇을 관찰하는지 지정
    // 자기 자신의 위치를 알아야 함

    public BackgroundPlayerService(Player player) {
        // 이미지는 못 받기 때문에 직접 작성
        this.player = player;
        File file = new File("C:\\workspace\\java_lab\\bubble\\src\\image/backgroundMapService.png");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        // 실의 길이
        while (true) {
            // 색상 확인

            // import하는 방법 alt shift o?
            Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25)); // 빨간색, 하얀색
            Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25)); // 하얀색, 빨간색
            System.out.println("leftColor : " + leftColor);
            System.out.println("rightColor : " + rightColor);
            // 색상 체크해서 벽 감지
            // 0.0 좌표는 네모라고 생각했을 때 왼쪽 위 꼭지점 그걸 기준으로 함

            int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
                    + image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

            // 바닥 충돌 확인
            if (bottomColor != -2) {
                // System.out.println("바텀 칼러 : "+bottomColor);
                // System.out.println("바닥에 충돌함");
                player.setDown(false);
            }

            // 항상 상태를 만들고 상태를 확인하는 식으로 프로그래밍해보자
            if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
                System.out.println("왼쪽 벽에 충돌함");
                player.setLeftWallCrash(true);
                player.setLeft(false);
            } else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
                System.out.println("오른쪽 벽에 충돌함");
                player.setRightWallCrash(true);
                player.setRight(false);
            } else {
                player.setRightWallCrash(false);
                player.setLeftWallCrash(false);
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
