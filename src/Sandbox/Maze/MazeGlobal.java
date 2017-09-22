package Sandbox.Maze;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MazeGlobal {
	public static int	mazeSizeX = 10;
	public static int	mazeSizeY = 10;

	public static Map<Integer, MazeGridCell> cells = new HashMap<Integer, MazeGridCell>();
	public static Map<Integer, MazeGridWall> walls = new HashMap<Integer, MazeGridWall>();

	public static MazeGridCell currentMazeCell = null;
	public static MazeGridCell entranceMazeCell = null;
	public static MazeGridCell exitMazeCell = null;

	public MazeGlobal() {}

	public static Random rand = new Random(System.currentTimeMillis());


	public static Integer ID(int xOrigin, int yOrigin, int zOrigin, boolean horizontal)
	{
		int h = (horizontal) ? 0x40000000 : 0;

		return (xOrigin & 0x3ff) |
				(yOrigin & 0x3ff) << 10 |
				(zOrigin & 0x3ff) << 20 |
				h;
	}
}
