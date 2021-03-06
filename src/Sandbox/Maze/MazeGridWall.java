package Sandbox.Maze;

import Sandbox.Xform;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class MazeGridWall extends Xform {
	private int xOrigin = 0;
	private int yOrigin = 0;
	private int zOrigin = 0;
	private boolean horizonal = false;
	private Box box = null;

	public static int whiteWall = 0;
	public static int blueWall = 1;
	public static int greenWall = 2;
	public static int redWall = 3;
	public static int yellowWall = 4;

	public MazeGridWall(int _xOrigin, int _yOrigin, int _zOrigin, boolean _horizonal, int color)
	{
		xOrigin = _xOrigin;
		yOrigin = _yOrigin;
		zOrigin = _zOrigin;
		horizonal = _horizonal;

		final PhongMaterial blueMaterial = new PhongMaterial();
		blueMaterial.setDiffuseColor(Color.DARKBLUE);
		blueMaterial.setSpecularColor(Color.BLUE);

		final PhongMaterial greenMaterial = new PhongMaterial();
		greenMaterial.setDiffuseColor(Color.DARKGREEN);
		greenMaterial.setSpecularColor(Color.GREEN);

		final PhongMaterial redMaterial = new PhongMaterial();
		redMaterial.setDiffuseColor(Color.DARKRED);
		redMaterial.setSpecularColor(Color.RED);

		final PhongMaterial yellowMaterial = new PhongMaterial();
		yellowMaterial.setDiffuseColor(Color.DARKGOLDENROD);
		yellowMaterial.setSpecularColor(Color.YELLOW);

		final PhongMaterial whiteMaterial = new PhongMaterial();
		whiteMaterial.setDiffuseColor(Color.LIGHTGRAY);
		whiteMaterial.setSpecularColor(Color.DARKGRAY);

		if(horizonal)
		{
			box = new Box(10, 10, .5);
		}
		else
		{
			box = new Box(.5, 10, 10);
		}

		setTx(xOrigin*10 + (horizonal ? 5 : 0));
		setTz(zOrigin*10 + (horizonal ? 0 : 5));

		if(color == 0)	box.setMaterial(whiteMaterial);
		if(color == 1)	box.setMaterial(blueMaterial);
		if(color == 2)	box.setMaterial(greenMaterial);
		if(color == 3)	box.setMaterial(redMaterial);
		if(color == 4)	box.setMaterial(yellowMaterial);

		getChildren().add(box);
	}

	private boolean open = false;
	public void Open(boolean _open)
	{
		open = _open;
		box.setVisible(!_open);
	}

	public boolean Open()
	{
		return open;
	}

	public Integer ID()
	{
		return MazeGlobal.ID(xOrigin, yOrigin, zOrigin, horizonal);
	}
}
