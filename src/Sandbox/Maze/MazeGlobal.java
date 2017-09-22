package Sandbox.Maze;

import java.util.Random;

public class MazeGlobal {
	public static int	mazeSizeX = 10;
	public static int	mazeSizeY = 10;
	public static int	mazeCellSize = 10;

	public MazeGlobal()
	{

	}

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
