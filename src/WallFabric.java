public class WallFabric {
    public static Wall createWall(char key, int x, int y) {
        if (key == 'S') return new SteelWall(x, y);
        if (key == 'B') return new BrickWall(x, y);
        if (key == 'C') return new Road(x, y);
        if (key == 'T') return new Trees(x, y);
        return new Water(x, y);
    }
}
