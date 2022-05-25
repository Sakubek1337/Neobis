package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectriangle extends Shape{

    public Rectriangle(){

    }

    public void draw(GraphicsContext gc, int x1, int y1, int x2, int y2){
        int width = 0, height = 0;
        if(x1 >= x2){
            width = x1 - x2;
        }else{
            width = x2 - x1;
        }
        if(y1 >= y2){
            height = y1 - y2;
        }else{
            height = y2 - y1;
        }
        gc.setFill(Color.WHITE);
        gc.fillRect(x1, y1, width, height);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x1, y1, width, height);
    }
    public void draw(GraphicsContext gc, int x1, int y1, int x2, int y2, int x3, int y3){
        gc.strokeLine(x1, y1, x2, y2);
        gc.strokeLine(x2, y2, x3, y3);
        gc.strokeLine(x3, y3, x1, y1);
    }
}
