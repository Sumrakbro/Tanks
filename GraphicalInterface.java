import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class GraphicalInterface extends Application {
    Pane root = new Pane();
    Map map = new Map();
    Tank tank = new Tank(map.playerCoordinate[0][0], map.playerCoordinate[0][1]);
    Game game = new Game(map);
    ArrayList<Bullet> bullets = new ArrayList<>();

    Scene scene = new Scene(root, map.getSize() * 64, map.getSize() * 64, Color.BLACK);

    public GraphicalInterface() throws InvalidMapException, MalformedURLException {
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws MalformedURLException, InvalidMapException {
        root.setStyle("-fx-background-color: BLACK");
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP: {
                    System.out.println(tank.getPosition());
                    tank.moveUp();
                    System.out.println(tank.getPosition());
                    break;
                }
                case DOWN: {
                    System.out.println(tank.getPosition());
                    tank.moveDown();
                    System.out.println(tank.getPosition());
                    break;
                }
                case LEFT: {
                    System.out.println(tank.getPosition());
                    tank.moveLeft();
                    System.out.println(tank.getPosition());
                    break;
                }
                case RIGHT: {
                    System.out.println(tank.getPosition());
                    tank.moveRight();
                    System.out.println(tank.getPosition());
                    break;
                }
                case SHIFT:
                    bullets.add(tank.fire());
                    break;
            }
            try {
                reDraw();
            } catch (MalformedURLException | InvalidMapException e) {
                e.printStackTrace();
            }
        });
        reDraw();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addBlocks(int key) throws MalformedURLException {
        ArrayList<int[][]> list = map.byKey(key);
        Walls walls;
        for (int[][] temp : list) {
            if (key == 1) {
                walls = new Water();
            } else if (key == 2) {
                walls = new SteelWall();
            } else if (key == 3) {
                walls = new BrickWall();
            } else if (key == 4) {
                walls = new Trees();
            } else {
                walls = new Road();
            }
            walls.getImageView().setTranslateX(temp[0][0] * 64);
            walls.getImageView().setTranslateY(temp[0][1] * 64);
            root.getChildren().add(walls.getImageView());
        }
    }

    private void printList(ArrayList<int[][]> list) {
        for (int[][] arr : list) {
            for (int[] ar : arr) {
                for (int i : ar) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    private void addTank() {
        tank.getImageView().setTranslateX(tank.getPosition().getX() * 64);
        tank.getImageView().setTranslateY((tank.getPosition().getY() * 64));
        root.getChildren().add(tank.getImageView());
    }

    private void addBullets() {
        for (Bullet bullet : bullets) {
            bullet.getImageView().setTranslateX(bullet.getPosition().getX() * 64);
            bullet.getImageView().setTranslateY((bullet.getPosition().getY() * 64));
            root.getChildren().add(bullet.getImageView());
        }
    }

    private void reDraw() throws MalformedURLException, InvalidMapException {
        if (root.getChildren() != null) {
            root.getChildren().clear();
        }
        for (int i = 1; i <= 5; i++) {
            addBlocks(i);
        }
        addTank();
        addBullets();
    }
}
