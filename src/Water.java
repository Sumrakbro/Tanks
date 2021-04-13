public class Water extends Wall {
    public Water(int x, int y) {
        super('W', x, y);
        this.isTankCanCross = false;
        this.path = "Battle_City_water.png";
        setTexture();
    }
}
