package Sandbox.Maze;

import Sandbox.Xform;

public class MazeGrid extends Xform {
	public MazeGrid()
	{
		int color = 4;
		int startX = -(MazeGlobal.mazeSizeX*MazeGlobal.mazeCellSize/2);
		int endX = (MazeGlobal.mazeSizeX*MazeGlobal.mazeCellSize) + startX;
		int startZ = -(MazeGlobal.mazeSizeY*MazeGlobal.mazeCellSize)/2;
		int endZ = (MazeGlobal.mazeSizeY*MazeGlobal.mazeCellSize) + startZ;

		for(int x=startX; x<=endX; x+=MazeGlobal.mazeCellSize) {
			for(int z=startZ; z<=endZ; z+=MazeGlobal.mazeCellSize) {
				if(x!=endX) getChildren().add(new MazeGridWall(x, 0, z, true, color));
				if(z!=endZ) getChildren().add(new MazeGridWall(x, 0, z, false, color));
//				color++;
//				if(color>=5) color = 0;
			}
		}
	}
}
