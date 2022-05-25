package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape{
    protected Color color;
    protected int x;
    protected int y;

    public Circle(Color color, int size, int x, int y, GraphicsContext gc){
        this.size = size;
        this.color = color;
        this.x = x;
        this.y = y;
        draw(gc);
    }
    public void draw(GraphicsContext gc){
        gc.setFill(color);
        gc.fillOval(x, y, size, size);
    }

}
