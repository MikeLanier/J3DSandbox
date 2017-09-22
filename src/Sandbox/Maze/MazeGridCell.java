package Sandbox.Maze;

import Sandbox.Xform;

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

	private CellType type = CellType.eNormal;

	public MazeGridCell(int _xOrigin, int _yOrigin, int _zOrigin, MazeGridWall west, MazeGridWall north, MazeGridWall east, MazeGridWall south)
	{
		xOrigin = _xOrigin;
		yOrigin = _yOrigin;
		zOrigin = _zOrigin;

		mazeWalls[0] = west;
		mazeWalls[1] = north;
		mazeWalls[2] = east;
		mazeWalls[3] = south;
	}

	public Integer ID()
	{
		return MazeGlobal.ID(xOrigin, yOrigin, zOrigin, false);
	}
}
