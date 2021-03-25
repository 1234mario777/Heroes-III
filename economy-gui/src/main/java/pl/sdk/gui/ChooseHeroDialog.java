package pl.sdk.gui;

import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.StageStyle;
import pl.sdk.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pl.sdk.Fraction.TEST_FRACTION;

class ChooseHeroDialog
{

    private static String HEADER_TITLE = "Please choose your Hero";
    private static String CONTENT_TEXT = "Select Hero:";

    static Hero chooseHeroDialog()
    {
        List<Hero> fractions = new ArrayList<>( Arrays.asList( Hero.class.getEnumConstants() ) );
        fractions.removeIf( f -> f.name()
                .equals( TEST_FRACTION.name() ) );

        ChoiceDialog dialog = new ChoiceDialog( fractions.get( 0 )
                .name(), fractions.stream()
                .map( Enum::name )
                .toArray() );

        for ( ButtonType button : dialog.getDialogPane()
                .getButtonTypes() )
        {
            if ( button.equals( ButtonType.CANCEL ) )
            {
                dialog.getDialogPane()
                        .lookupButton( button )
                        .setVisible( false );
            }
        }

        dialog.initStyle( StageStyle.UNDECORATED );
        dialog.setHeaderText( HEADER_TITLE );
        dialog.setContentText( CONTENT_TEXT );
        dialog.showAndWait();
        return Hero.valueOf( dialog.getSelectedItem()
                .toString() );
    }
}