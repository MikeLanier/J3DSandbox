package Sandbox;

import Sandbox.Maze.MazeGrid;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class DisplayPanel extends HBox {

	Group root = new Group();
	Xform triadGroup = null;
	Xform moleculeGroup = null;
	Xform sixFacesGroup = null;
	Xform triMeshGroup = null;
	Xform teapotGroup = null;
	Xform threeFacesGroup = null;
	Xform helixGroup = null;
	MazeGrid mazeGridGroup = null;
	Xform arrowsGroup = null;
	final Xform world = new Xform();
	final PerspectiveCamera camera = new PerspectiveCamera(true);
	final Xform cameraXform = new Xform();
	final Xform cameraXform2 = new Xform();
	final Xform cameraXform3 = new Xform();
	private static final double CAMERA_INITIAL_DISTANCE = -450; //-450;
	private static final double CAMERA_INITIAL_X_ANGLE = 0; //70.0;
	private static final double CAMERA_INITIAL_Y_ANGLE = 0; //320.0;
	private static final double CAMERA_NEAR_CLIP = 0.1;
	private static final double CAMERA_FAR_CLIP = 10000.0;
	private static final double CONTROL_MULTIPLIER = 0.1;
	private static final double SHIFT_MULTIPLIER = 10.0;
	private static final double MOUSE_SPEED = 0.1;
	private static final double ROTATION_SPEED = 2.0;
	private static final double TRACK_SPEED = 0.3;

	double mousePosX;
	double mousePosY;
	double mouseOldX;
	double mouseOldY;
	double mouseDeltaX;
	double mouseDeltaY;

	public DisplayPanel()
	{
		root.getChildren().add(world);
		root.setDepthTest(DepthTest.ENABLE);

		// buildScene();
		buildCamera();
		buildAxes();
		buildMolecule();
		buildSixFaces();
		buildTriMesh();
		buildTeapot();
		buildThreeFaces();
		buildHelix();
		buildMazeGrid();
		buildArrows();

		SubScene subScene = new SubScene(root, 800, 800, true, SceneAntialiasing.BALANCED);
		subScene.setFill(Color.GREY);
		handleMouse(subScene);

		subScene.setCamera(camera);

		subScene.heightProperty().bind(this.heightProperty());
		subScene.widthProperty().bind(this.widthProperty());
		this.getChildren().add(subScene);

		Polygon p = new Polygon();
	}

	private void buildCamera() {
		System.out.println("buildCamera()");
		root.getChildren().add(cameraXform);
		cameraXform.getChildren().add(cameraXform2);
		cameraXform2.getChildren().add(cameraXform3);
		cameraXform3.getChildren().add(camera);
//		cameraXform3.setRotateZ(180.0);

		camera.setNearClip(CAMERA_NEAR_CLIP);
		camera.setFarClip(CAMERA_FAR_CLIP);
		camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
		cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
		cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
	}

	private void buildAxes() {
		triadGroup = new Triad();
		triadGroup.setVisible(false);
		world.getChildren().addAll(triadGroup);
	}

	private void buildSixFaces() {
		sixFacesGroup = new SixFaces();
		sixFacesGroup.setVisible(false);
		world.getChildren().addAll(sixFacesGroup);
	}

	private void buildMolecule() {
		moleculeGroup = new Molecule();
		moleculeGroup.setVisible(false);
		world.getChildren().addAll(moleculeGroup);
	}

	private void buildTriMesh() {
		triMeshGroup = new TriMesh();
		triMeshGroup.setVisible(false);
		world.getChildren().addAll(triMeshGroup);
	}

	private void buildTeapot() {
		teapotGroup = new Teapot();
		teapotGroup.setVisible(false);
		world.getChildren().addAll(teapotGroup);
	}

	private void buildThreeFaces() {
		threeFacesGroup = new ThreeFaces();
		threeFacesGroup.setVisible(false);
		world.getChildren().addAll(threeFacesGroup);
	}

	private void buildHelix() {
		helixGroup = new Helix();
		helixGroup.setVisible(false);
		world.getChildren().addAll(helixGroup);
	}

	private void buildMazeGrid() {
		mazeGridGroup = new MazeGrid();
		mazeGridGroup.setVisible(false);
		world.getChildren().addAll(mazeGridGroup);
	}

	private void buildArrows() {
		arrowsGroup = new Arrows();
		arrowsGroup.setVisible(false);
		world.getChildren().addAll(arrowsGroup);
	}

	public void handleMouse(SubScene subScene) {
		System.out.println("handleMouse");
		subScene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent me) {
				System.out.println("handleMouse: onMousePressed");
				mousePosX = me.getSceneX();
				mousePosY = me.getSceneY();
				mouseOldX = me.getSceneX();
				mouseOldY = me.getSceneY();
			}
		});
		subScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent me) {
				mouseOldX = mousePosX;
				mouseOldY = mousePosY;
				mousePosX = me.getSceneX();
				mousePosY = me.getSceneY();
				mouseDeltaX = (mousePosX - mouseOldX);
				mouseDeltaY = (mousePosY - mouseOldY);

				double modifier = 1.0;

				if (me.isControlDown()) {
					modifier = CONTROL_MULTIPLIER;
				}
				if (me.isShiftDown()) {
					modifier = SHIFT_MULTIPLIER;
				}
				if (me.isPrimaryButtonDown()) {
					cameraXform.ry.setAngle(cameraXform.ry.getAngle() - mouseDeltaX*MOUSE_SPEED*modifier*ROTATION_SPEED);
					cameraXform.rx.setAngle(cameraXform.rx.getAngle() + mouseDeltaY*MOUSE_SPEED*modifier*ROTATION_SPEED);
				}
				else if (me.isSecondaryButtonDown()) {
					double z = camera.getTranslateZ();
					double newZ = z + mouseDeltaX*MOUSE_SPEED*modifier;
					camera.setTranslateZ(newZ);
				}
				else if (me.isMiddleButtonDown()) {
					cameraXform2.t.setX(cameraXform2.t.getX() + mouseDeltaX*MOUSE_SPEED*modifier*TRACK_SPEED);
					cameraXform2.t.setY(cameraXform2.t.getY() + mouseDeltaY*MOUSE_SPEED*modifier*TRACK_SPEED);
				}
			}
		});
	}

	public void ShowTriad(boolean _show)
	{
		triadGroup.setVisible(_show);
	}

	public void ShowSixFaces(boolean _show)
	{
		sixFacesGroup.setVisible(_show);
	}

	public void ShowMolecule(boolean _show)
	{
		moleculeGroup.setVisible(_show);
	}

	public void ShowTriMesh(boolean _show)
	{
		triMeshGroup.setVisible(_show);
	}

	public void ShowTeapot(boolean _show)
	{
		teapotGroup.setVisible(_show);
	}

	public void ShowThreeFaces(boolean _show)
	{
		threeFacesGroup.setVisible(_show);
	}

	public void ShowHelix(boolean _show)
	{
		helixGroup.setVisible(_show);
	}

	public void ShowMazeGrid(boolean _show)
	{
		mazeGridGroup.setVisible(_show);
	}

	public void ShowArrows(boolean _show)
	{
		arrowsGroup.setVisible(_show);
	}

	private double	dXRotationDelta = 0.0;
	private double	dYRotationDelta = 0.0;
	private double	dZRotationDelta = 1.0;

	public void SetXRotationDelta(double _delta)
	{
		dXRotationDelta = _delta;
	}

	public void SetYRotationDelta(double _delta)
	{
		dYRotationDelta = _delta;
	}
	public void SetZRotationDelta(double _delta)
	{
		dZRotationDelta = _delta;
	}

	private void doSomething()
	{
		cameraXform.rx.setAngle(cameraXform.rx.getAngle() + dXRotationDelta);
		cameraXform.ry.setAngle(cameraXform.ry.getAngle() + dYRotationDelta);
		cameraXform.rz.setAngle(cameraXform.rz.getAngle() + dZRotationDelta);
	}

	private Timeline timeline = new Timeline(new KeyFrame(
			Duration.millis(25),
			ae -> doSomething()));

	public void StartRotation(boolean _startRotation)
	{
		System.out.println("RotationStarted: " + _startRotation);

		if(_startRotation) {
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
		}
		else {
			timeline.stop();
		}
	}

	private double scale = 1;
	public void OnKeyPressed(KeyEvent event)
	{
//		System.out.println("Sandbox.DisplayPanel: OnKeyPressed: " + event.getText());

		switch (event.getText()) {
			case "Z":
			case "z":
				cameraXform2.t.setX(0.0);
				cameraXform2.t.setY(0.0);
				camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
				cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
				cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
				break;
			case "T":
			case "t":
				System.out.println("T is pressed");
				cameraXform2.t.setX(0.0);
				cameraXform2.t.setY(0.0);
				camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
				cameraXform.ry.setAngle(0);
				cameraXform.rx.setAngle(90);
				cameraXform.rz.setAngle(180);
				break;
			case "B":
			case "b":
				System.out.println("T is pressed");
				cameraXform2.t.setX(0.0);
				cameraXform2.t.setY(0.0);
				camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
				cameraXform.ry.setAngle(0);
				cameraXform.rx.setAngle(90);
				cameraXform.rz.setAngle(0);
				break;
			case "F":
			case "f":
				System.out.println("T is pressed");
				cameraXform2.t.setX(0.0);
				cameraXform2.t.setY(0.0);
				camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
				cameraXform.ry.setAngle(0);
				cameraXform.rx.setAngle(0);
				cameraXform.rz.setAngle(0);
				break;
			case "K":
			case "k":
				System.out.println("T is pressed");
				cameraXform2.t.setX(0.0);
				cameraXform2.t.setY(0.0);
				camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
				cameraXform.ry.setAngle(180);
				cameraXform.rx.setAngle(0);
				cameraXform.rz.setAngle(0);
				break;
			case "L":
			case "l":
				System.out.println("T is pressed");
				cameraXform2.t.setX(0.0);
				cameraXform2.t.setY(0.0);
				camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
				cameraXform.ry.setAngle(270);
				cameraXform.rx.setAngle(0);
				cameraXform.rz.setAngle(0);
				break;
			case "R":
			case "r":
				System.out.println("T is pressed");
				cameraXform2.t.setX(0.0);
				cameraXform2.t.setY(0.0);
				camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
				cameraXform.ry.setAngle(90);
				cameraXform.rx.setAngle(0);
				cameraXform.rz.setAngle(0);
				break;
			case "-": 	// zoom out
				double d = camera.getTranslateZ();
//				System.out.println(d);
				camera.setTranslateZ(d-10);
				break;
			case "=":	// zoom in
				if(event.isShiftDown()) {
					d = camera.getTranslateZ();
//					System.out.println(d);
					camera.setTranslateZ(d+10);
				}
				break;
//			case X:
//				triadGroup.setVisible(!triadGroup.isVisible());
//				break;
//			case C:
//				sixFacesGroup.setVisible(!sixFacesGroup.isVisible());
//				break;
//			case V:
//				moleculeGroup.setVisible(!moleculeGroup.isVisible());
//				break;
		}
	}
}
