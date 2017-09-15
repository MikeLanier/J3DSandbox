import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ControlsPanel extends VBox {
	private DisplayPanel displayPanel = null;
	public CheckBox molecule = new CheckBox();
	public CheckBox triad = new CheckBox();
	public CheckBox sixFaces = new CheckBox();

	public ControlsPanel(DisplayPanel _displayPanel)
	{
		displayPanel = _displayPanel;

		molecule.setText("Molecule");
		getChildren().add(molecule);
		
		molecule.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//				System.out.println("Molecule: mouse clicked: " + molecule.isSelected());
				displayPanel.ShowMolecule(molecule.isSelected());
			}
		});

		triad.setText("Triad");
		getChildren().add(triad);

		triad.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//				System.out.println("Triad: mouse clicked: " + triad.isSelected());
				displayPanel.ShowTriad(triad.isSelected());
			}
		});
		
		sixFaces.setText("SixFaces");
		sixFaces.setSelected(true);
		getChildren().add(sixFaces);

		sixFaces.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//				System.out.println("SixFaces: mouse clicked: " + sixFaces.isSelected());
				displayPanel.ShowSixFaces(sixFaces.isSelected());
			}
		});
	}
}
