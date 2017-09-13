import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ControlsPanel extends VBox {
	public ControlsPanel()
	{
		Button b = new Button();
		b.setText("button");
		getChildren().add(b);
	}
}
