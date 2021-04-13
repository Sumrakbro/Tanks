import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;

public abstract class Wall {
    protected char key;
    protected float live = Float.POSITIVE_INFINITY;
    protected boolean isTankCanCross = true;
    protected boolean isBulletCanCross = true;
    protected ImageView texture;
    protected String path;
    protected Position position;

    public Wall(char key, int x, int y) {
        this.key = key;
        this.position = new Position(x, y);
    }

    protected void chandeStatus() {
        isBulletCanCross = !isBulletCanCross;
        isTankCanCross = !isTankCanCross;
    }

    public char getKey() {
        return key;
    }

    public ImageView getTexture() {
        return texture;
    }

    public boolean getIsBulletCanCross() {
        return isBulletCanCross;
    }

    public boolean getIsTankCanCross() {
        return isTankCanCross;
    }

    public Position getPosition() {
        return position;
    }

    public String getPath() {
        return path;
    }

    protected void setTexture() {
        File file;
        file = new File(path);
        String localUrl;
        try {
            localUrl = file.toURI().toURL().toString();
            Image image = new Image(localUrl);
            texture = new ImageView(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void changeTexture() {
        File file = new File("roadWall.jpg");
        String localUrl;
        try {
            localUrl = file.toURI().toURL().toString();
            Image image = new Image(localUrl);
            texture = new ImageView(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void damageWall() {
        if (key == 'B')
            System.out.println(live);
        if (live > 0) {
            live--;
            if (live == 0) {
                chandeStatus();
                changeTexture();
            }
        }
    }
}


