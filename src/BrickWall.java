import javafx.scene.image.ImageView;

import java.net.MalformedURLException;

public class BrickWall extends Walls {
    private int forDestroy = 4;
    private static ImageView removeImageOfWall;

    public BrickWall() throws MalformedURLException {
        super();
        this.abilityToMoveForBullet = false;
        this.abilityToMoveForTank = false;
        this.path = "Battle_City_bricks.png";
        getElement();
    }

    private void destroyBrickWall() {
        this.abilityToMoveForBullet = true;
        this.abilityToMoveForTank = true;
        this.iV = removeImageOfWall;
    }


    //Проверяет есть ли у стены жизнь, если нет, то вызывает метод дестройУолл
    public void damageWall() {
        if (forDestroy > 0) {
            forDestroy--;
            if (forDestroy == 0) {
                destroyBrickWall();
            }
        }

    }


}
