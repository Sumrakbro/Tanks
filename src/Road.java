public class Road extends Wall {
    public Road(int x, int y) {
        super('C', x, y);
        this.path = "roadWall.jpg";
        setTexture();
    }
}
