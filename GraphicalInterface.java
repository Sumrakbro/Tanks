import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class GraphicalInterface extends Application {
    Pane root = new Pane();
    Map map = new Map();



    Scene scene = new Scene(root, map.getSize() * 64,map.getSize() * 64, Color.BLACK);

    public GraphicalInterface() throws InvalidMapException, MalformedURLException {
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws MalformedURLException, InvalidMapException {

        root.setStyle("-fx-background-color: BLACK");


        for(int i=1;i<=5;i++){
            addBlocks(i);
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void addBlocks(int key) throws InvalidMapException, MalformedURLException {

        ArrayList<int[][]> list =  map.byKey(key);
        for (int[][] temp:list) {
            if(key == 1){
                Water waterWall = new Water();
                waterWall.getImageView().setTranslateX(temp[0][0] * 64);
                waterWall.getImageView().setTranslateY(temp[0][1] * 64);

                root.getChildren().add(waterWall.getImageView());

            }
            else if(key == 2){
                SteelWall steelWall = new SteelWall();
                steelWall.getImageView().setTranslateX(temp[0][0] * 64);
                steelWall.getImageView().setTranslateY(temp[0][1] * 64);

                root.getChildren().add(steelWall.getImageView());

            }
            else if(key == 3){
                BrickWall brickWall = new BrickWall();
                brickWall.getImageView().setTranslateX(temp[0][0] * 64);
                brickWall.getImageView().setTranslateY(temp[0][1] * 64);

                root.getChildren().add(brickWall.getImageView());

            }
            else if(key == 4){
                Trees trees = new Trees();
                trees.getImageView().setTranslateX(temp[0][0] * 64);
                trees.getImageView().setTranslateY(temp[0][1] * 64);

                root.getChildren().add(trees.getImageView());

            }
            else if(key == 5){
                Road road = new Road();
                road.getImageView().setTranslateX(temp[0][0] * 64);
                road.getImageView().setTranslateY(temp[0][1] * 64);

                root.getChildren().add(road.getImageView());


            }



        }

    }
    private void printList(ArrayList<int[][]> list) {
        for (int[][] arr : list) {
            for (int[] ar : arr) {
                for (int i : ar) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}
