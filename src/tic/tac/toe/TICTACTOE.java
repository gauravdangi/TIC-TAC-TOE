package tic.tac.toe;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/*
 * @author Gaurav Dangi
 */
public class TICTACTOE extends Application {
    private boolean player1 = true;
    private boolean victory = false;
    Tile[][] moves = new Tile[3][3];
    Status stat = new Status();
    // ---------------- customizedContent() -----------------------
    public Parent customizedContent(){
        Pane root = new Pane();
        root.setPrefSize(600,600);
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Tile tiles = new Tile();
                tiles.setTranslateX(i*200);
                tiles.setTranslateY(j*200);
                root.getChildren().add(tiles);
                moves[j][i] = tiles;
            }
        }
        System.out.println("Inside customizedPane!");
        return root;
    }
    
    // -------------------- start() -------------------------------
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(customizedContent());
        stage.setScene(scene);
        stage.show();
    }
    
    // ----------------- Tiles class ---------------------------
    public class Tile extends StackPane{
        private Text player = new Text();
        private boolean ticked = false;
        Tile(){
            Rectangle rec = new Rectangle(200,200);
            rec.setFill(null);  // for making it completely transparent
            rec.setStroke(Color.BLACK);  // coloring border with black
            setAlignment(Pos.CENTER);
            player.setFont(Font.font(72));
            getChildren().addAll(rec,player);
            setOnMouseClicked(e->{
                if(e.getButton() == MouseButton.PRIMARY && !ticked && !victory){
                    ticked = true;
                    if(player1){
                    System.out.println("Player 1 moved");
                    player1=false;
                    drawX();
                }
                else{
                    System.out.println("Player 2 moved");
                    player1=true;
                    drawO();
                }
                }
            });
        }
        
        public void drawX(){
            player.setText("X");
            showMoves();
            victory = checkStatus();
            if(victory){
                System.out.println("Player 1 won");
                //System.exit(0);
            }
        }
        public void drawO(){
            player.setText("O");
            player.setFill(Color.RED);
            showMoves();
            victory = checkStatus();
            if(victory){
                System.out.println("Player 2 won");
                //System.exit(0);
            }
        }
        public String getTile(){
            return player.getText();
        }
    }
    
    // -------------------- check if someone win ------------------------------
    public boolean checkStatus(){
        if(stat.checkDiag(moves) || stat.checkHorizontal(moves) || stat.checkVertical(moves))
            return true;
        else
            return false;
    }
    
    public void showMoves(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               System.out.print(moves[i][j].getTile());
            }
            System.out.println();
        }
    }

    // ------------------------ main() ---------------------------
    public static void main(String[] args) {
        launch(args);
    }
    
}
