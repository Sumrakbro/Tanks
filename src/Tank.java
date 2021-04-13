import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class Tank extends MyPlayer {
    protected char key;
    protected ImageView iV;
    protected String path;
    boolean isAlive = true;
    private boolean isVisible = true;

    public Tank() {

    }

    public Tank(int x, int y) {
        this.path = "tankImage.png";
        this.key = 'P';
        getTexture();
        pos = new Position(x, y);
     }


    public void moveRight() {
        if (Game.getMap().getSize() > pos.getX() + 1 && Map.getBlockAt(pos.getY(), pos.getX() + 1).getIsTankCanCross()) {
            pos.setX(pos.getX() + 1);
            this.path = "tankImageRight.png";
            if (Map.getBlockAt(pos.getY(), pos.getX()).getKey() == 'T') {
                hideTank();
            }
            getTexture();
        }
    }

    @Override
    public void moveLeft() {
        if (0 <= pos.getX() - 1 && Map.getBlockAt(pos.getY(), pos.getX() - 1).getIsTankCanCross()) {
            pos.setX(pos.getX() - 1);
            this.path = "tankImageLeft.png";
            if (Map.getBlockAt(pos.getY(), pos.getX()).getKey() == 'T') {
                hideTank();
            }
            getTexture();
        }
    }

    @Override
    public void moveUp() {
        if (0 <= pos.getY() - 1 && Map.getBlockAt(pos.getY() - 1, pos.getX()).getIsTankCanCross()) {
            pos.setY((pos.getY() - 1));
            this.path = "tankImageUp.png";
            if (Map.getBlockAt(pos.getY(), pos.getX()).getKey() == 'T') {
                hideTank();
            }
            getTexture();
        }
    }

    @Override
    public void moveDown() {
        if (Game.getMap().getSize() > pos.getY() + 1 &&
                Map.getBlockAt(pos.getY() + 1, pos.getX()).getIsTankCanCross()) {
            pos.setY(pos.getY() + 1);
            this.path = "tankImageDown.png";
            if (Map.getBlockAt(pos.getY(), pos.getX()).getKey() == 'T') {
                hideTank();
            }
            getTexture();
        }
    }


    public Bullet fire() {
        Position position;
        if (this.path.equals("tankImageLeft.png") &&
                Map.getBlockAt(this.getPosition().getY(), this.getPosition().getX() - 1).isBulletCanCross) {
            position = new Position(this.getPosition().getX() - 1, this.getPosition().getY());
            return new Bullet(10, "bullet_left.png", position);
        } else if (this.path.equals("tankImageDown.png") &&
                Map.getBlockAt(this.getPosition().getY(), this.getPosition().getX()).isBulletCanCross) {
            position = new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
            return new Bullet(10, "bullet_down.png", position);
        } else if (this.path.equals("tankImageUp.png") &&
                Map.getBlockAt(this.getPosition().getY() - 1, this.getPosition().getX()).isBulletCanCross) {
            position = new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
            return new Bullet(10, "bullet_up.png", position);
        } else if (this.path.equals("tankImageRight.png") &&
                Map.getBlockAt(this.getPosition().getY(), this.getPosition().getX() + 1).isBulletCanCross) {
            position = new Position(this.getPosition().getX() + 1, this.getPosition().getY());
            return new Bullet(10, "bullet_right.png", position);
        }
        return new Bullet(10, "bullet_right.png", new Position(Map.size, Map.size));
    }


    private void hideTank() {
        this.isVisible = false;
        setImageView();
    }

    private void showTank() {
        this.isVisible = true;
    }

    public void setVisibility() {
        if (isVisible) {
            hideTank();
        } else {
            showTank();
        }
    }

    private void getTexture() {
        File file = new File(path);
        try {
            String localUrl = file.toURI().toURL().toString();
            Image image = new Image(localUrl);
            iV = new ImageView(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public ImageView getImageView() {
        return iV;
    }

    public void gameOver() {
        Stage stage = new Stage();
        StackPane root = new StackPane();
        Scene scene2 = new Scene(root, 500, 500);
        root.setStyle("-fx-background-color: BLACK");
        Label label = new Label("GAME OVER!!!");
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-size: 25");
        label.setAlignment(Pos.CENTER);
        root.getChildren().add(label);
        stage.setScene(scene2);
        stage.show();

    }

    public void setImageView() {
        this.path = "Battle_City_trees.png";
    }
}