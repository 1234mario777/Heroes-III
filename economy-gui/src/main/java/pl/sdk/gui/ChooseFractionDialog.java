package pl.sdk.gui;

import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.StageStyle;
import pl.sdk.Fraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pl.sdk.Fraction.NECROPOLIS;
import static pl.sdk.Fraction.TEST_FRACTION;

class ChooseFractionDialog
{

	private static String HEADER_TITLE = "Please choose your fraction";
	private static String CONTENT_TEXT = "Select Fraction:";

	static Fraction chooseFractionDialog()
	{
		List<Fraction> fractions = new ArrayList<>( Arrays.asList( Fraction.class.getEnumConstants() ) );
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
		return Fraction.valueOf( dialog.getSelectedItem()
		                               .toString() );
	}
}