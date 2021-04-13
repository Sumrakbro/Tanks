import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Map {
    protected static int size;
    protected static Wall[][] walls;
    int[][] playerCoordinate;


    public Map() throws InvalidMapException {
        initialize(new Scanner(System.in));
    }


    public Map(Scanner scan) throws InvalidMapException {
        initialize(scan);
    }

    public static Wall getBlockAt(int row, int column) {
        try {
            return walls[row][column];
        } catch (ArrayIndexOutOfBoundsException e) {
            return new SteelWall(0, 0);

        }
    }

    public static Wall[][] getWalls() {
        return walls;
    }

    private void initialize(Scanner scan) throws InvalidMapException {
        String str;
        int row = 0;
        int column;
        int counter = 0;
        try {
            File file = new File("mapFile.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            size = Integer.parseInt(line);
            if (size == 0) {
                throw new InvalidMapException("Map size can not be zero");
            }
            walls = new Wall[size][size];
            int count = size * size;
            line = reader.readLine();
            while (line != null && count > 0) {
                System.out.println(line);
                str = line;
                column = 0;
                for (int i = 0; i < str.length(); i++) {

                    if (str.charAt(i) == 'P') {
                        MyPlayer.setPosition(new Position(column, row));
                        playerCoordinate = rowColumnValues(column, row);
                        walls[row][column] = WallFabric.createWall('C', column, row);
                        column++;
                        counter++;
                        continue;
                    }
                    if (str.charAt(i) != ' ') {
                        walls[row][column] = WallFabric.createWall(str.charAt(i), column, row);
                        column++;
                        counter++;
                    }
                }
                row++;
                count -= size;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (counter < size * size) {
            throw new InvalidMapException("Not enough map elements");
        }
    }

    public int getSize() {
        return size;
    }

    public void print() {
        for (int i = 0; i < walls.length; i++) {
            for (int j = 0; j < walls[0].length; j++) {
                System.out.print(walls[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] rowColumnValues(int column, int row) {
        int[][] temp;
        temp = new int[1][];
        temp[0] = new int[]{column, row};
        return temp;
    }
}

