import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Controls extends VBox {
	public Controls()
	{
		Button b = new Button();
		b.setText("button");
		getChildren().add(b);
	}
}