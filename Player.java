import java.net.MalformedURLException;

public interface Player {
    void moveRight() throws MalformedURLException;


    void moveLeft() throws MalformedURLException;

    void moveUp() throws MalformedURLException;

    void moveDown() throws MalformedURLException;

    void setMap(Map map);

    Position getPosition();


    static void setPosition(Position position) {

    }
}
