public class Position {
    int row;
    int column;

    public Position(int column, int row) {
        this.row = row;
        this.column = column;

    }

    public void setY(int row) {
        this.row = row;

    }

    public void setX(int column) {
//        System.out.println(column);
        this.column = column;

    }

    public int getY() {
        return row;
    }

    public int getX() {
        return column;
    }

    public boolean equals(Position pos) {


        return this.row == pos.row && this.column == pos.column;


    }


    public String toString() {
        return "(" + column + "," + row + ")";


    }


}
