import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class DisplayPanel extends HBox {

	Group root = new Group();
	Xform axisGroup = null; //new Xform();
	Xform modelGroup = null; //new Molecule();
	final Xform world = new Xform();
	final PerspectiveCamera camera = new PerspectiveCamera(true);
	final Xform cameraXform = new Xform();
	final Xform cameraXform2 = new Xform();
	final Xform cameraXform3 = new Xform();
	private static final double CAMERA_INITIAL_DISTANCE = -450;
	private static final double CAMERA_INITIAL_X_ANGLE = 70.0;
	private static final double CAMERA_INITIAL_Y_ANGLE = 320.0;
	private static final double CAMERA_NEAR_CLIP = 0.1;
	private static final double CAMERA_FAR_CLIP = 10000.0;
	private static final double CONTROL_MULTIPLIER = 0.1;
	private static final double SHIFT_MULTIPLIER = 10.0;
	private static final double MOUSE_SPEED = 0.1;
	private static final double ROTATION_SPEED = 2.0;
	private static final double TRACK_SPEED = 0.3;

//	public PerspectiveCamera Camera() { return camera; }
//	public Xform World() { return world; }

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

		SubScene subScene = new SubScene(root, 800, 800, true, SceneAntialiasing.BALANCED);
		subScene.setFill(Color.GREY);
		handleMouse(subScene);

		subScene.setCamera(camera);

		subScene.heightProperty().bind(this.heightProperty());
		subScene.widthProperty().bind(this.widthProperty());
		this.getChildren().add(subScene);
	}

	private void buildCamera() {
		System.out.println("buildCamera()");
		root.getChildren().add(cameraXform);
		cameraXform.getChildren().add(cameraXform2);
		cameraXform2.getChildren().add(cameraXform3);
		cameraXform3.getChildren().add(camera);
		cameraXform3.setRotateZ(180.0);

		camera.setNearClip(CAMERA_NEAR_CLIP);
		camera.setFarClip(CAMERA_FAR_CLIP);
		camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
		cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
		cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
	}

	private void buildAxes() {
		axisGroup = new Triad();
		world.getChildren().addAll(axisGroup);
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

	public void OnKeyPressed(KeyEvent event)
	{
		System.out.println("DisplayPanel: OnKeyPressed");
		switch (event.getCode()) {
			case Z:
				cameraXform2.t.setX(0.0);
				cameraXform2.t.setY(0.0);
				camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
				cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
				cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
				break;
			case X:
				axisGroup.setVisible(!axisGroup.isVisible());
				break;
			case V:
				modelGroup.setVisible(!modelGroup.isVisible());
				break;
		}
	}

	private void buildMolecule() {
		modelGroup = new Molecule();
		world.getChildren().addAll(modelGroup);
	}
}
