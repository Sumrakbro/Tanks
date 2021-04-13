import java.net.MalformedURLException;

public class SteelWall extends Walls {

    public SteelWall() throws MalformedURLException {
        super();
        this.abilityToMoveForBullet = false;
        this.abilityToMoveForTank = false;
        this.path = "Battle_City_wall.png";
        getElement();
    }
}


