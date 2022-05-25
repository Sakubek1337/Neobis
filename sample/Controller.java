package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.io.FileReader;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Canvas canvas;
    @FXML
    Canvas bgcanvas;
    @FXML
    Label timelabel;
    @FXML
    Line arrow;
    int mins = 0, secs = 0, millis = 0;
    int count = 5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        GraphicsContext gcbg = bgcanvas.getGraphicsContext2D();
        gcbg.setStroke(Color.BLACK);
        gcbg.strokeLine(0, 0, 600, 600);
        gcbg.setFill(Color.DARKCYAN);
        gcbg.fillRect(0, 0, 600, 600);
        gcbg.setFill(Color.WHITE);
        gcbg.fillOval(0, 0, 600, 600);

        gc.setFill(Color.BLACK);
        gc.fillOval(200, 200, 200, 200);
        gc.strokeOval(200, 200, 200, 200);
        gc.strokeOval(0, 0, 600, 600);
        gc.strokeLine(300, 0, 300, 12);
        gc.strokeLine(300, 600, 300, 588);
        gc.strokeLine(0, 300, 12, 300);
        gc.strokeLine(600, 300, 588, 300);
        Shape c1 = new Circle(Color.WHITE, 50, 25, 25, gc);
        Shape c2 = new Circle(Color.WHITE, 50, 525, 25, gc);
        Shape c3 = new Circle(Color.WHITE, 50, 25, 525, gc);
        Shape c4 = new Circle(Color.WHITE, 50, 525, 525, gc);
        Rectriangle rect = new Rectriangle();
        rect.draw(gc, 226, 287, 376, 315);
        Rectriangle tri = new Rectriangle();
        tri.draw(gc, 300, 12, 325, 57, 275, 57);
        tri.draw(gc, 12, 300, 57, 275, 57, 325);
        tri.draw(gc, 588, 300, 543, 275, 543, 325);
        tri.draw(gc, 300, 588, 325, 543, 275, 543);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            change(timelabel);
            move();
        }));
        timeline.setAutoReverse(false);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    void change(Label timelabel){
        if (millis == 100) {
            secs ++;
            count -= 1;
            if (count == 0){
                chngbg();
                count = 5;
            }
            millis = 0;
        }
        if (secs == 60) {
            arrow.setEndX(300);
            arrow.setEndY(0);
            mins ++;
            chngbg();
            secs = 0;
        }
        timelabel.setText((((mins/10) == 0) ? "0" : "") + mins + ":"
        + (((secs / 10) == 0) ? "0" : "") + secs + ":" + (((millis/10) == 0) ? "0" : "") + millis++);
    }
    void chngbg(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.strokeOval(200, 200, 200, 200);
        gc.strokeOval(0, 0, 600, 600);
        Random rnd = new Random();
        int a = rnd.nextInt(255);
        int b = rnd.nextInt(255);
        int c = rnd.nextInt(255);
        gc.setFill(Color.rgb(c, a, b));
        gc.fillOval(200, 200, 200, 200);
        Rectriangle rect = new Rectriangle();
        rect.draw(gc, 226, 287, 376, 315);
    }
    void move() {
        double x = arrow.getEndX();
        double y = arrow.getEndY();
        if(secs < 5 && x < 450){
            x += .35294;
            if(x > 449.8){
                x = 450;
            }
            arrow.setEndX(x);

        }else if (secs < 8 && x < 600){
            x += .4615384;
            if(x > 599.9){
                x = 600;
            }
            arrow.setEndX(x);
        }else if (secs < 11 && y < 150){
            y += .4615384;
            if(y > 149.9){
                y = 150;
            }
            arrow.setEndY(y);
        }else if(secs < 15 && y < 300){
            y += .35294;
            if(y > 299.9){
                y = 300;
            }
            arrow.setEndY(y);
        }else if(secs < 20 && y < 450){
            y += .35294;
            if(y > 449.9){
                y = 450;
            }
            arrow.setEndY(y);
        }else if(secs < 23 && y < 600){
            y += .4615384;
            if(y > 599.9){
                y = 600;
            }
            arrow.setEndY(y);
        }else if(secs < 26 && x > 450){
            x -= .4615384;
            if(x < 450.1){
                x = 450;
            }
            arrow.setEndX(x);
        }else if(secs < 30 && x > 300){
            x -= .35294;
            if(x < 300.1){
                x = 300;
            }
            arrow.setEndX(x);
        }else if(secs < 35 && x > 150){
            x -= .35294;
            if(x < 150.1){
                x = 150;
            }
            arrow.setEndX(x);
        }else if(secs < 38 && x > 0){
            x -= .4615384;
            if(x < 0.1){
                x = 0;
            }
            arrow.setEndX(x);
        }else if(secs < 41 && y > 450){
            y -= .4615384;
            if(y < 450.1){
                y = 450;
            }
            arrow.setEndY(y);
        }else if(secs < 45 && y > 300){
            y -= .35294;
            if(y < 300.1){
                y = 300;
            }
            arrow.setEndY(y);
        }else if(secs < 50 && y > 150){
            y -= .35294;
            if(y < 150.1){
                y = 150;
            }
            arrow.setEndY(y);
        }else if(secs < 53 && y > 0){
            y -= .4615384;
            if(y < 0.1){
                y = 0;
            }
            arrow.setEndY(y);
        }else if(secs < 56 && x < 150){
            x += .4615384;
            if(x > 149.9){
                x = 150;
            }
            arrow.setEndX(x);
        }else{
            x += .35294;
            if(x > 299.9){
                x = 300;
            }
            arrow.setEndX(x);
        }
    }
}
