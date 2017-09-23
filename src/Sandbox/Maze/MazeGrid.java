package Sandbox.Maze;

import Sandbox.Xform;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MazeGrid extends Xform {
	private int color = 4;
	public MazeGrid()
	{
		int xStart = -MazeGlobal.mazeSizeX / 2;
		int xEnd = MazeGlobal.mazeSizeX + xStart;
		int yStart = -MazeGlobal.mazeSizeY / 2;
		int yEnd = MazeGlobal.mazeSizeY + yStart;

		for(int x=xStart; x<=xEnd; x++) {
			for(int z=yStart; z<=yEnd; z++) {
				MazeGridCell c = createCell(x, 0, z);
			}
		}

//		createMaze(false);
	}

	private MazeGridCell createCell(int x, int y, int z)
	{
		if( x<0 && z<0 ) color = MazeGridWall.blueWall;
		if( x>0 && z<0 ) color = MazeGridWall.greenWall;
		if( x<0 && z>0 ) color = MazeGridWall.redWall;
		if( x>0 && z>0 ) color = MazeGridWall.yellowWall;
		if( x==0 && z==0 ) color = MazeGridWall.whiteWall;

		MazeGridWall west = MazeGlobal.walls.get(MazeGlobal.ID(x, y, z, false));
		if(west == null)
		{
			west = new MazeGridWall(x, y, z, false, color);
			MazeGlobal.walls.put(west.ID(), west);
			getChildren().add(west);
		}

		MazeGridWall north = MazeGlobal.walls.get(MazeGlobal.ID(x, y, z, true));
		if(north == null)
		{
			north = new MazeGridWall(x, y, z, true, color);
			MazeGlobal.walls.put(north.ID(), north);
			getChildren().add(north);
		}

		MazeGridWall east = MazeGlobal.walls.get(MazeGlobal.ID(x+1, y, z, false));
		if(east == null)
		{
			east = new MazeGridWall(x+1, y, z, false, color);
			MazeGlobal.walls.put(east.ID(), east);
			getChildren().add(east);
		}

		MazeGridWall south = MazeGlobal.walls.get(MazeGlobal.ID(x, y, z+1, true));
		if(south == null)
		{
			south = new MazeGridWall(x, y, z+1, true, color);
			MazeGlobal.walls.put(south.ID(), south);
			getChildren().add(south);
		}

		MazeGridCell mazeCell = new MazeGridCell(x, y, z, west, north, east, south);
		MazeGlobal.cells.put(mazeCell.ID(), mazeCell);
		getChildren().add(mazeCell);

		return mazeCell;
	}

	private Stack<MazeGridCell> stack = null;

	public void createMaze(boolean animate)
	{
		System.out.println("createMaze");

		Integer x = -MazeGlobal.mazeSizeY/2-1;
		Integer z = 0;
		MazeGlobal.entranceMazeCell = createCell(x,0,z);

		x = MazeGlobal.mazeSizeX/2+1;
		z = MazeGlobal.mazeSizeY/3;
		MazeGlobal.exitMazeCell = createCell(x,0, z);

		int startCellX = 1; //Integer.parseInt(controlPanel.startCellControl.tfStartCellX.getText());
		int startCellY = -1; //Integer.parseInt(controlPanel.startCellControl.tfStartCellY.getText());
		MazeGlobal.currentMazeCell = MazeGlobal.cells.get(MazeGlobal.ID(startCellX, 0, startCellY, false));
		if(MazeGlobal.currentMazeCell != null)
		{
			MazeGlobal.currentMazeCell.SetType(MazeGridCell.CellType.eCellTypeStart);
		}

		MazeGlobal.entranceMazeCell.SetType(MazeGridCell.CellType.eCellTypeEntrance);
		MazeGlobal.exitMazeCell.SetType(MazeGridCell.CellType.eCellTypeExit);

		MazeGlobal.entranceMazeCell.Visited(true);
		MazeGlobal.exitMazeCell.Visited(true);

		if(MazeGlobal.entranceMazeCell.W(MazeGridCell.west) != null)	MazeGlobal.entranceMazeCell.W(MazeGridCell.west).Open(true);
		if(MazeGlobal.entranceMazeCell.W(MazeGridCell.north) != null)	MazeGlobal.entranceMazeCell.W(MazeGridCell.north).Open(true);
		if(MazeGlobal.entranceMazeCell.W(MazeGridCell.east) != null)	MazeGlobal.entranceMazeCell.W(MazeGridCell.east).Open(true);
		if(MazeGlobal.entranceMazeCell.W(MazeGridCell.south) != null)	MazeGlobal.entranceMazeCell.W(MazeGridCell.south).Open(true);

		if(MazeGlobal.exitMazeCell.W(MazeGridCell.west) != null)	MazeGlobal.exitMazeCell.W(MazeGridCell.west).Open(true);
		if(MazeGlobal.exitMazeCell.W(MazeGridCell.north) != null)	MazeGlobal.exitMazeCell.W(MazeGridCell.north).Open(true);
		if(MazeGlobal.exitMazeCell.W(MazeGridCell.east) != null)	MazeGlobal.exitMazeCell.W(MazeGridCell.east).Open(true);
		if(MazeGlobal.exitMazeCell.W(MazeGridCell.south) != null)	MazeGlobal.exitMazeCell.W(MazeGridCell.south).Open(true);

		stack = new Stack<MazeGridCell>();
		stack.push(MazeGlobal.currentMazeCell);

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	private Timeline timeline = new Timeline(new KeyFrame(
		Duration.millis(30),
		ae -> createMazeStep()));

	public void createMazeStep()
	{
//		System.out.println("createMazeStep");

		int x = MazeGlobal.currentMazeCell.X();
		int y = MazeGlobal.currentMazeCell.Z();
//		System.out.println(x + ", " + y);

		MazeGlobal.currentMazeCell.Visited(true);

		MazeGridCell westMazeCell = MazeGlobal.cells.get(MazeGlobal.ID(x - 1, 0, y, false));
		MazeGridCell northMazeCell = MazeGlobal.cells.get(MazeGlobal.ID(x, 0, y - 1, false));
		MazeGridCell eastMazeCell = MazeGlobal.cells.get(MazeGlobal.ID(x + 1, 0, y, false));
		MazeGridCell southMazeCell = MazeGlobal.cells.get(MazeGlobal.ID(x, 0, y + 1, false));

		class Group3 {
			private MazeGridCell cell;
			private MazeGridWall wall;

			private Group3(MazeGridCell _cell, MazeGridWall _wall) {
				cell = _cell;
				wall = _wall;
			}
		}

		List<Group3> cells = new ArrayList<Group3>();

		if (westMazeCell != null && !westMazeCell.Visited())
			cells.add(new Group3(westMazeCell, MazeGlobal.currentMazeCell.W(MazeGridCell.west)));
		if (northMazeCell != null && !northMazeCell.Visited())
			cells.add(new Group3(northMazeCell, MazeGlobal.currentMazeCell.W(MazeGridCell.north)));
		if (eastMazeCell != null && !eastMazeCell.Visited())
			cells.add(new Group3(eastMazeCell, MazeGlobal.currentMazeCell.W(MazeGridCell.east)));
		if (southMazeCell != null && !southMazeCell.Visited())
			cells.add(new Group3(southMazeCell, MazeGlobal.currentMazeCell.W(MazeGridCell.south)));
		if (cells.size() > 0) {
			int r = MazeGlobal.rand.nextInt(cells.size());

			cells.get(r).wall.Open(true);
			cells.get(r).wall.setVisible(false);
			MazeGlobal.currentMazeCell.SetType(MazeGridCell.CellType.eNormal);
			MazeGlobal.currentMazeCell = cells.get(r).cell;
			MazeGlobal.currentMazeCell.SetType(MazeGridCell.CellType.eCellTypeStart);
			MazeGlobal.currentMazeCell.Visited(true);
			stack.push(MazeGlobal.currentMazeCell);
		} else {
			MazeGlobal.currentMazeCell.SetType(MazeGridCell.CellType.eNormal);
			MazeGlobal.currentMazeCell = stack.pop();

			if (stack.size() > 0)
				MazeGlobal.currentMazeCell.SetType(MazeGridCell.CellType.eCellTypeStart);
			else
				MazeGlobal.currentMazeCell.SetType(MazeGridCell.CellType.eNormal);
		}

		if(stack.size() == 0) timeline.stop();
	}
}
