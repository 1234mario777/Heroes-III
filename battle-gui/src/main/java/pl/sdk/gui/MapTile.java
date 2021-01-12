package pl.sdk.gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


class MapTile extends StackPane implements PropertyChangeListener
{

    private final Rectangle rec;

    public MapTile() {
        rec = new Rectangle(60, 60, Color.WHITE);
        rec.setStroke(Color.BLACK);
        getChildren().add(rec);
    }

    void addCreature( String aName, int aAmount, boolean aShouldFlip ){
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/creatures/" + aName + ".png")));
        image.setFitHeight(46);
        image.setFitWidth(46);
        if(aShouldFlip)
        {
            image.setScaleX(-1);
        }
        vbox.getChildren().add(image);
        Text text = new Text(String.valueOf(aAmount));
        text.setFont(new Font(10.0));
        vbox.getChildren().add(text);
        getChildren().add(vbox);
    }

    void setBackground(Color aColor){
        rec.setFill(aColor);
    }

    @Override
    public void propertyChange( PropertyChangeEvent aPropertyChangeEvent )
    {

    }
}
