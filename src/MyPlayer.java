public class MyPlayer implements Player {
    Map map;
    static Position pos;

    MyPlayer(Map map, Position pos) {
        this.map = map;
        this.pos = pos;
    }

    public MyPlayer() {
        this.pos = pos;

    }


    @Override
    public void moveRight() {
        if (Game.getMap().getSize() > pos.getX() + 1 && Game.getMap().getValueAt(pos.getY(), pos.getX() + 1) != '1') {
            pos.setX(pos.getX() + 1);
        }
    }

    @Override
    public void moveLeft() {
        if (0 <= pos.getX() - 1 && Game.getMap().getValueAt(pos.getY(), pos.getX() - 1) != '1')
            pos.setX(pos.getX() - 1);
    }

    @Override
    public void moveUp() {
        if (0 <= pos.getY() - 1 && Game.getMap().getValueAt(pos.getY() - 1, pos.getX()) != '1')
            pos.setY((pos.getY() - 1));
    }

    @Override
    public void moveDown() {
        if (Game.getMap().getSize() > pos.getY() + 1 && Game.getMap().getValueAt(pos.getY() + 1, pos.getX()) != '1')
            pos.setY(pos.getY() + 1);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public static void setPosition(Position pos) {
        MyPlayer.pos = pos;
    }

    @Override
    public Position getPosition() {
        return pos;

    }


}
