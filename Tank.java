import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;

public class Tank extends MyPlayer {
    private Bullet bullet;
    private int lives;
    private boolean isVisible = true;
    Position positionOfTank;
    private ImageView img;
    private String path=
    public void fire() {
    }

    public int damage() {
        this.lives -= 1;
        return lives;
    }

    private void hideTank() {
        this.isVisible = false;
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

    protected void getElement() throws MalformedURLException {
        File file = new File(path);
        String localUrl = file.toURI().toURL().toString();
        Image image = new Image(localUrl);
        iV = new ImageView(image);

    }


}