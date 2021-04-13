public class BrickWall extends Wall {
    public BrickWall(int x, int y) {
        super('B', x, y);
        this.live = 4;
        this.isBulletCanCross = false;
        this.isTankCanCross = false;
        this.path = "Battle_City_bricks.png";
        setTexture();
    }
}
