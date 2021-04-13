import java.net.MalformedURLException;

public class Water extends Walls {
    public Water() throws MalformedURLException {
        super();

        this.abilityToMoveForTank = false;
        this.path = "Battle_City_water.png";
        getElement();
    }

}
