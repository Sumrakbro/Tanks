import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;

public abstract class Walls {
    protected boolean abilityToMoveForTank = true;
    protected boolean abilityToMoveForBullet = true;
    protected ImageView iV;
    protected String path;
    Position positionOfWall;

    public Walls() throws MalformedURLException {

    }

    public boolean getAbilityTank() {
        return abilityToMoveForTank;
    }


    public boolean getAbilityBullet() {
        return abilityToMoveForBullet;
    }

    public ImageView getImageView() {
        return iV;
    }

    protected void getElement() throws MalformedURLException {
        File file = new File(path);
        String localUrl = file.toURI().toURL().toString();
        Image image = new Image(localUrl);
        iV = new ImageView(image);
    }
}


