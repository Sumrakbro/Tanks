import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;

public class Tank extends MyPlayer {
    private Bullet bullet;
    private int lives;
    private boolean isVisible = true;

    protected ImageView iV;
    protected String path;

    public Tank(int x, int y) {
        this.path = "tankImage.png";
        getElement();
        pos = new Position(x, y);
        System.out.println(x + " " + y);
    }


    public void moveRight() {
        if (Game.getMap().getSize() > pos.getX() + 1 && (Game.getMap().getValueAt(pos.getY(), pos.getX() + 1) == 'C' ||
                Game.getMap().getValueAt(pos.getY(), pos.getX() + 1) == 'P')) {
            pos.setX(pos.getX() + 1);
            this.path = "tankImageRight.png";
            getElement();
        }
    }

    @Override
    public void moveLeft() {
        if (0 <= pos.getX() - 1 && (Game.getMap().getValueAt(pos.getY(), pos.getX() - 1) == 'C' ||
                Game.getMap().getValueAt(pos.getY(), pos.getX() - 1) == 'P')) {
            pos.setX(pos.getX() - 1);
            this.path = "tankImageLeft.png";
            getElement();
        }
    }

    @Override
    public void moveUp() {
        if (0 <= pos.getY() - 1 && (Game.getMap().getValueAt(pos.getY() - 1, pos.getX()) == 'C' ||
                Game.getMap().getValueAt(pos.getY() - 1, pos.getX()) == 'P')) {
            System.out.println();
            pos.setY((pos.getY() - 1));
            this.path = "tankImageUp.png";
            getElement();
        }
    }

    @Override
    public void moveDown() {
        if (Game.getMap().getSize() > pos.getY() + 1 && (Game.getMap().getValueAt(pos.getY() + 1, pos.getX()) == 'C' ||
                Game.getMap().getValueAt(pos.getY() + 1, pos.getX()) == 'P')) {
            pos.setY(pos.getY() + 1);
            this.path = "tankImageDown.png";
            getElement();
        }
    }


    public Bullet fire() {
        return new Bullet(10,this.getPosition());
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

    private void getElement() {
        System.out.println(path);
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
}