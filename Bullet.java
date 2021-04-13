import javafx.geometry.Pos;

public class Bullet {
    private int speed;

    Position positionOfBullet;


    public Bullet(int speed,Position coordinates){
        this.speed = speed;
        this.positionOfBullet = coordinates;
    }



    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void setCoordinateX(int y){
        positionOfBullet.setY(y);

    }
    public void setCoordinateY(int x){
        positionOfBullet.setX(x);

    }
}
