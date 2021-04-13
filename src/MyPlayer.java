public class MyPlayer implements Player {
    protected static Position pos;
    protected Map map;


    @Override
    public void moveRight() {
        if (Game.getMap().getSize() > pos.getX() + 1 && Map.getBlockAt(pos.getY(), pos.getX() + 1).getKey() != '1') {
            pos.setX(pos.getX() + 1);
        }
    }

    @Override
    public void moveLeft() {
        if (0 <= pos.getX() - 1 && Map.getBlockAt(pos.getY(), pos.getX() - 1).getKey() != '1')
            pos.setX(pos.getX() - 1);
    }

    @Override
    public void moveUp() {
        if (0 <= pos.getY() - 1 && Map.getBlockAt(pos.getY() - 1, pos.getX()).getKey() != '1')
            pos.setY((pos.getY() - 1));
    }

    @Override
    public void moveDown() {
        if (Game.getMap().getSize() > pos.getY() + 1 && Map.getBlockAt(pos.getY() + 1, pos.getX()).getKey() != '1')
            pos.setY(pos.getY() + 1);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public Position getPosition() {
        return pos;

    }

    public static void setPosition(Position pos) {
        MyPlayer.pos = pos;
    }


}
