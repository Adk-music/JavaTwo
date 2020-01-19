package geekbrains.lessons.lessonone;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.util.Random;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final Random random = new Random();

    Sprite[]sprites = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });

    }
    private MainCircles(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X,POS_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        initApplication();
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER); //отрисовка в заданной области
        setTitle("Circles");
        setVisible(true);
    }
    private void initApplication(){
        for (int i = 0; i < sprites.length ; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas,g);

    }

    private void update(GameCanvas canvas, float deltaTime){ //обновление
        for (int i = 0; i < sprites.length ; i++) {
            sprites[i].update(canvas,deltaTime);
        }
    }

    private void render(GameCanvas canvas,Graphics g){ //отрисовка
        for (int i = 0; i < sprites.length ; i++) {
            sprites[i].render(canvas,g);
        }
    }
}
