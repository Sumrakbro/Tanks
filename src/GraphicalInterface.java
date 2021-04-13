import javafx.animation.AnimationTimer;
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
                    tank.moveUp();
                    break;
                }
                case DOWN: {
                    tank.moveDown();
                    break;
                }
                case LEFT: {
                    tank.moveLeft();
                    break;
                }
                case RIGHT: {
                    tank.moveRight();
                    break;
                }
                case SPACE:
                    bullets.add(tank.fire());
                    break;
            }
        });

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    Thread.sleep(50);
                    reDraw();
                } catch (MalformedURLException | InterruptedException e) {
                    e.printStackTrace();
                } catch (InvalidMapException e) {
                    e.printStackTrace();
                }
            }

        };
        at.start();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addBlocks() {
        for (Wall[] wallArray : Map.getWalls()) {
            for (Wall wall : wallArray) {
                if (wall != null) {
                    Position position = wall.getPosition();
                    wall.getTexture().setTranslateX(position.getX() * 64);
                    wall.getTexture().setTranslateY(position.getY() * 64);
                    root.getChildren().add(wall.getTexture());
                }
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
            if (bullet.getStatus() && bullet.isAlive) bullet.fly();
            if (bullet.isAlive) {
                bullet.getImageView().setTranslateX(bullet.getPosition().getX() * 64);
                bullet.getImageView().setTranslateY((bullet.getPosition().getY() * 64));
                root.getChildren().add(bullet.getImageView());
                bullet.changeStatus();

            }
        }
    }

    private void reDraw() throws MalformedURLException, InvalidMapException {
        if (root.getChildren() != null) {
            root.getChildren().clear();
        }
        addBlocks();
        addTank();
        addBullets();
    }

}
