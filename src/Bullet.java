import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;

public class Bullet {
    private int speed;
    Position position;
    private String path;
    ImageView imageView;


    public Bullet(int speed, String path, Position coordinates) {
        this.speed = speed;
        this.path = path;
        this.position = coordinates;
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
        System.out.println(path);
        File file = new File(path);
        try {
            String localUrl = file.toURI().toURL().toString();
            Image image = new Image(localUrl);
            imageView = new ImageView(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
