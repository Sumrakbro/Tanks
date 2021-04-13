import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;

public class Bullet {
    private final String path;
    boolean isAlive = true;
    Position position;
    ImageView imageView;
    private int speed;
    private boolean isAddedYet = false;


    public Bullet(int speed, String path, Position coordinates) {
        this.speed = speed;
        this.position = coordinates;
        this.path = path;
        getElement();
    }

    public Position getPosition() {
        return position;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCoordinateX(int y) {
        position.setY(y);
    }

    public void setCoordinateY(int x) {
        position.setX(x);
    }

    private void getElement() {
        File file = new File(path);
        try {
            String localUrl = file.toURI().toURL().toString();
            Image image = new Image(localUrl);
            imageView = new ImageView(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void fly() {
        Position position = this.position;
        if (this.path.equals("bullet_down.png")) {
            if (Map.getBlockAt(this.getPosition().getY() + 1, this.getPosition().getX()).isBulletCanCross) {
                position = new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
            } else {
                Map.getBlockAt(this.getPosition().getY() + 1, this.getPosition().getX()).damageWall();
                isAlive = false;
            }
        } else if (this.path.equals("bullet_up.png")) {
            if (Map.getBlockAt(this.getPosition().getY() - 1, this.getPosition().getX()).isBulletCanCross) {
                position = new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
            } else {
                Map.getBlockAt(this.getPosition().getY() - 1, this.getPosition().getX()).damageWall();
                isAlive = false;
            }
        } else if (this.path.equals("bullet_left.png")) {
            if (Map.getBlockAt(this.getPosition().getY(), this.getPosition().getX() - 1).isBulletCanCross) {
                position = new Position(this.getPosition().getX() - 1, this.getPosition().getY());
            } else {
                Map.getBlockAt(this.getPosition().getY(), this.getPosition().getX() - 1).damageWall();
                isAlive = false;
            }
        } else if (Map.getBlockAt(this.getPosition().getY(), this.getPosition().getX() + 1).isBulletCanCross) {
            position = new Position(this.getPosition().getX() + 1, this.getPosition().getY());
        } else {
            Map.getBlockAt(this.getPosition().getY(), this.getPosition().getX() + 1).damageWall();
            isAlive = false;
        }
        this.position = position;
    }

    public boolean getStatus() {
        return isAddedYet;
    }

    public void changeStatus() {
        isAddedYet = true;
    }
}
