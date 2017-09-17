import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import static javafx.scene.text.TextAlignment.CENTER;

public class ControlsPanel extends VBox {
	private DisplayPanel displayPanel = null;
	public CheckBox molecule = new CheckBox();
	public CheckBox triad = new CheckBox();
	public CheckBox sixFaces = new CheckBox();
	public CheckBox triMesh = new CheckBox();
	public CheckBox teapot = new CheckBox();
	public CheckBox threeFaces = new CheckBox();
	public CheckBox helix = new CheckBox();

	public Boolean rotationStarted = false;

	public ControlsPanel(DisplayPanel _displayPanel)
	{
		displayPanel = _displayPanel;

		this.setPadding(new Insets(10, 10, 10, 10));

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

		triMesh.setText("TriMesh");
//		triMesh.setSelected(true);
		getChildren().add(triMesh);

		triMesh.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//				System.out.println("TriMesh: mouse clicked: " + triMesh.isSelected());
				displayPanel.ShowTriMesh(triMesh.isSelected());
			}
		});

		teapot.setText("Teapot");
//		teapot.setSelected(true);
		getChildren().add(teapot);

		teapot.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//				System.out.println("Teapot: mouse clicked: " + teapot.isSelected());
				displayPanel.ShowTeapot(teapot.isSelected());
			}
		});

		threeFaces.setText("ThreeFaces");
//		threeFaces.setSelected(true);
		getChildren().add(threeFaces);

		threeFaces.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//				System.out.println("ThreeFaces: mouse clicked: " + threeFaces.isSelected());
				displayPanel.ShowThreeFaces(threeFaces.isSelected());
			}
		});

		helix.setText("Helix");
//		helix.setSelected(true);
		getChildren().add(helix);

		helix.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//				System.out.println("Helix: mouse clicked: " + helix.isSelected());
				displayPanel.ShowHelix(helix.isSelected());
			}
		});

		HBox rotationBox = new HBox();
		getChildren().add(rotationBox);
		rotationBox.setPadding(new Insets(10, 10, 10, 10));

		Label xRotationDeltaLabel = new Label();
		xRotationDeltaLabel.setText("X");
		xRotationDeltaLabel.setPrefWidth(20);
		xRotationDeltaLabel.setPadding(new Insets(5,0,0,5));
		rotationBox.getChildren().add(xRotationDeltaLabel);

		TextField xRotationDeltaValue = new TextField();
		xRotationDeltaValue.setPrefWidth(40);
		xRotationDeltaValue.setText("0.1");
		rotationBox.getChildren().add(xRotationDeltaValue);

		xRotationDeltaValue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("OnAction: xRotationDeltaValue: " + xRotationDeltaValue.getText());
				Double value = Double.parseDouble(xRotationDeltaValue.getText());
				displayPanel.SetXRotationDelta(value.doubleValue());
			}
		});

		Label yRotationDeltaLabel = new Label();
		yRotationDeltaLabel.setText("Y");
		yRotationDeltaLabel.setPrefWidth(20);
		yRotationDeltaLabel.setPadding(new Insets(5,0,0,5));
		rotationBox.getChildren().add(yRotationDeltaLabel);

		TextField yRotationDeltaValue = new TextField();
		yRotationDeltaValue.setPrefWidth(40);
		yRotationDeltaValue.setText("0.1");
		rotationBox.getChildren().add(yRotationDeltaValue);

		yRotationDeltaValue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("OnAction: yRotationDeltaValue: " + yRotationDeltaValue.getText());
				Double value = Double.parseDouble(yRotationDeltaValue.getText());
				displayPanel.SetYRotationDelta(value.doubleValue());
			}
		});

		Label zRotationDeltaLabel = new Label();
		zRotationDeltaLabel.setText("Z");
		zRotationDeltaLabel.setPrefWidth(20);
		zRotationDeltaLabel.setPadding(new Insets(5,0,0,5));
		rotationBox.getChildren().add(zRotationDeltaLabel);

		TextField zRotationDeltaValue = new TextField();
		zRotationDeltaValue.setPrefWidth(40);
		zRotationDeltaValue.setText("0.1");
		rotationBox.getChildren().add(zRotationDeltaValue);

		zRotationDeltaValue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("OnAction: zRotationDeltaValue: " + zRotationDeltaValue.getText());
				Double value = Double.parseDouble(zRotationDeltaValue.getText());
				displayPanel.SetZRotationDelta(value.doubleValue());
			}
		});

		Label spacer = new Label();
		spacer.setText("");
		spacer.setPrefWidth(20);
		rotationBox.getChildren().add(spacer);

		Button rotationStartButton = new Button();
		rotationStartButton.setText("Start");
		rotationBox.getChildren().add(rotationStartButton);

		rotationStartButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				rotationStarted = rotationStarted ? false : true;
				rotationStartButton.setText(rotationStarted ? "Stop" : "Start");
				displayPanel.StartRotation(rotationStarted);
			}
		});
	}
}
