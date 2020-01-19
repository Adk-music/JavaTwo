package geekbrains.lessons.lessonone;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameCanvas extends JPanel {

    MainCircles gameController;
    long lastFrameTime; //время последнего обновления
    float timer;
    Random random;

    GameCanvas(MainCircles gameController){
       this.gameController = gameController;
       lastFrameTime = System.nanoTime();
       random = new Random();
    }

    @Override
    protected void paintComponent(Graphics g) { //отрисовка компонента со своим поведением.
        super.paintComponent(g);
        //60fps
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f; //нано секундды в секунды
        gameController.onDrawFrame(this,g,deltaTime);
        lastFrameTime = currentTime;
        if (timer > 2){
            random.nextInt(256);

            super.setBackground(new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)
            ));

            timer -= 2;
        }
        timer += deltaTime;
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft(){ return 0; }
    public int getRight(){ return getWidth() - 1; }
    public int getTop(){ return 0; }
    public int getBottom(){ return getHeight() - 1; }

}
