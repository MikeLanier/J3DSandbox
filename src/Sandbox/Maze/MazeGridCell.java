package Sandbox.Maze;

import Sandbox.Xform;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class MazeGridCell extends Xform {
	private int	xOrigin = 0;
	private int yOrigin = 0;
	private int zOrigin = 0;

	public int X() { return xOrigin; }
	public int Y() { return yOrigin; }
	public int Z() { return zOrigin; }

	private MazeGridWall[] mazeWalls = new MazeGridWall[4];
	private boolean visited = false;

	public boolean Visited() { return visited; }
	public void Visited(boolean _visited) { visited = _visited; }

	public static int	west = 0;
	public static int	north = 1;
	public static int	east = 2;
	public static int	south = 3;

	public MazeGridWall W(int which)
	{
		return mazeWalls[which];
	}

	public static enum CellType
	{
		eNormal,
		eCellTypeStart,
		eCellTypeEntrance,
		eCellTypeExit
	}

	final PhongMaterial greenMaterial = new PhongMaterial();
	final PhongMaterial redMaterial = new PhongMaterial();
	final PhongMaterial blueMaterial = new PhongMaterial();

	private Box box = null;

	private CellType type = CellType.eNormal;
	public void SetType( CellType _type )
	{
		type = _type;

		if(type == CellType.eCellTypeStart) {
			setVisible(true);
			box.setMaterial(redMaterial);
		}
		else if(type == CellType.eCellTypeEntrance) {
			setVisible(true);
			box.setMaterial(greenMaterial);
		}
		else if(type == CellType.eCellTypeExit) {
			setVisible(true);
			box.setMaterial(blueMaterial);
		}
		else {
			setVisible(false);
		}
	}

	public MazeGridCell(int _xOrigin, int _yOrigin, int _zOrigin, MazeGridWall west, MazeGridWall north, MazeGridWall east, MazeGridWall south)
	{
		xOrigin = _xOrigin;
		yOrigin = _yOrigin;
		zOrigin = _zOrigin;

		mazeWalls[0] = west;
		mazeWalls[1] = north;
		mazeWalls[2] = east;
		mazeWalls[3] = south;

		greenMaterial.setDiffuseColor(Color.DARKGREEN);
		greenMaterial.setSpecularColor(Color.GREEN);

		redMaterial.setDiffuseColor(Color.DARKRED);
		redMaterial.setSpecularColor(Color.RED);

		blueMaterial.setDiffuseColor(Color.DARKBLUE);
		blueMaterial.setSpecularColor(Color.LIGHTBLUE);

		box = new Box(10, .5, 10);

		setTx(xOrigin*10 + 5);
		setTz(zOrigin*10 + 5);

		box.setMaterial(greenMaterial);
		setVisible(false);
		getChildren().add(box);
	}

	public Integer ID()
	{
		return MazeGlobal.ID(xOrigin, yOrigin, zOrigin, false);
	}
}
