import javafx.scene.Group;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class MainFrm extends GridPane {
	public MainFrm()
	{
		System.out.println("MainFrm");

		ColumnConstraints col1 = new ColumnConstraints();
		ColumnConstraints col2 = new ColumnConstraints();
		col1.setPrefWidth(300);
		col2.setPercentWidth(70);
		getColumnConstraints().addAll(col1, col2);

		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(100);
		getRowConstraints().addAll(row1);

		ControlsPanel controlsPanel = new ControlsPanel();
		add(controlsPanel, 0, 0);

		HBox a = new HBox();
		DisplayPanel displayPanel = new DisplayPanel();
		SubScene subScene = new SubScene(displayPanel, 800, 800, true, SceneAntialiasing.BALANCED);
		subScene.setFill(Color.DARKGRAY);
		displayPanel.handleKeyboard(subScene, displayPanel.World());
		displayPanel.handleMouse(subScene, displayPanel.World());
		subScene.setCamera(displayPanel.Camera());

		subScene.heightProperty().bind(a.heightProperty());
		subScene.widthProperty().bind(a.widthProperty());
		a.getChildren().add(subScene);

		add(a, 1, 0);


		setGridLinesVisible(true);

	}
}
