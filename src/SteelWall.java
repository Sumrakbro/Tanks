public class SteelWall extends Wall {

    public SteelWall(int x,int y) {
        super('S',x,y);
        this.isBulletCanCross = false;
        this.isTankCanCross = false;
        this.path = "Battle_City_wall.png";
        setTexture();
    }
}


