package Sandbox;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class MainFrm extends GridPane {
	public MainFrm()
	{
		System.out.println("Sandbox.MainFrm");

		ColumnConstraints col1 = new ColumnConstraints();
		ColumnConstraints col2 = new ColumnConstraints();
		col1.setPrefWidth(300);
		col2.setPercentWidth(70);
		getColumnConstraints().addAll(col1, col2);

		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(100);
		getRowConstraints().addAll(row1);

		DisplayPanel displayPanel = new DisplayPanel();
		ControlsPanel controlsPanel = new ControlsPanel(displayPanel);

		add(controlsPanel, 0, 0);
		add(displayPanel, 1, 0);

		displayPanel.ShowMolecule(controlsPanel.molecule.isSelected());
		displayPanel.ShowTriad(controlsPanel.triad.isSelected());
		displayPanel.ShowSixFaces(controlsPanel.sixFaces.isSelected());
		displayPanel.ShowTriMesh(controlsPanel.triMesh.isSelected());
		displayPanel.ShowTeapot(controlsPanel.teapot.isSelected());
		displayPanel.ShowThreeFaces(controlsPanel.threeFaces.isSelected());
		displayPanel.ShowHelix(controlsPanel.helix.isSelected());
		displayPanel.ShowMazeGrid(controlsPanel.mazeGrid.isSelected());
		displayPanel.ShowArrows(controlsPanel.arrows.isSelected());

		setGridLinesVisible(true);

		setOnKeyPressed(new javafx.event.EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
//				System.out.println("GridPane: OnKeyPressed");
				displayPanel.OnKeyPressed(event);
			}
		});

	}
}
