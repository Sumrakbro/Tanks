import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Map {
    int size;
    char[][] value;
    HashMap<Integer, ArrayList<int[][]>> hashMap = new HashMap();
    int[][] playerCoordinate;

    public Map() throws InvalidMapException {
        try {
            initialize(new Scanner(System.in));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public Map(Scanner scan) throws InvalidMapException {
        try {
            initialize(scan);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void initialize(Scanner scan) throws InvalidMapException, MalformedURLException {
        String str;
        int row = 0;
        int column ;
        int counter = 0;
        ArrayList<int[][]> steelList = new ArrayList<>();
        ArrayList<int[][]> brickList = new ArrayList<>();
        ArrayList<int[][]> treesList = new ArrayList<>();
        ArrayList<int[][]> waterList = new ArrayList<>();
        ArrayList<int[][]> roadList = new ArrayList<>();

        try {
            File file = new File("mapFile.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            size = Integer.parseInt(line);
            if (size == 0) {
                throw new InvalidMapException("Map size can not be zero");
            }
            value = new char[size][size];
            int count = size * size;
            line = reader.readLine();
            while (line != null && count > 0) {
                System.out.println(line);
                str = line;
                column = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == 'P') {
                        column++;
                        counter++;
                        MyPlayer.setPosition(new Position(column, row));
                        playerCoordinate = rowColumnValues(column, row);
                        continue;
                    }
                    if (str.charAt(i) != ' ') {
                        switch (str.charAt(i)) {
                            case 'S': {
                                steelList.add(rowColumnValues(column, row));
                                break;
                            }
                            case 'B': {
                                brickList.add(rowColumnValues(column, row));
                                break;
                            }
                            case 'W': {
                                waterList.add(rowColumnValues(column, row));
                                break;
                            }
                            case 'T': {
                                treesList.add(rowColumnValues(column, row));
                                break;
                            }
                            case 'R':
                            case 'L':
                            case 'U':
                            case 'D': {
                                throw new InvalidMapException("Not enough map elements");
                            }
                            default: {
                                roadList.add(rowColumnValues(column, row));
                            }
                        }
                        value[row][column] = str.charAt(i);
                        column++;
                        counter++;
                    }
                }
                row++;
                count -= size;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (counter < size * size) {
            throw new InvalidMapException("Not enough map elements");
        }
        hashMap.put(1, waterList);
        hashMap.put(2, steelList);
        hashMap.put(3, brickList);
        hashMap.put(4, treesList);
        hashMap.put(5, roadList);
    }

    public int getSize() {
        return size;

    }

    public char getValueAt(int row, int column) {
        return value[row][column];

    }

    public void print() {
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                System.out.print(value[i][j] + " ");
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
    public ArrayList<int[][]> byKey(int key) {
        return hashMap.get(key);
    }

}
