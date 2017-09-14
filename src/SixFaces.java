import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

public class SixFaces extends Xform {

	public SixFaces() {
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

		final PhongMaterial purpleMaterial = new PhongMaterial();
		purpleMaterial.setDiffuseColor(Color.DARKMAGENTA);
		purpleMaterial.setSpecularColor(Color.PURPLE);

		final PhongMaterial orangeMaterial = new PhongMaterial();
		orangeMaterial.setDiffuseColor(Color.DARKORANGE);
		orangeMaterial.setSpecularColor(Color.ORANGE);

		final PhongMaterial whiteMaterial = new PhongMaterial();
		whiteMaterial.setDiffuseColor(Color.LIGHTGRAY);
		whiteMaterial.setSpecularColor(Color.DARKGRAY);

		Xform modelXform = new Xform();

		Xform frontCylinderXform = new Xform();
		Xform leftCylinderXform = new Xform();
		Xform backCylinderXform = new Xform();
		Xform rightCylinderXform = new Xform();
		Xform topCylinderXform = new Xform();
		Xform bottomCylinderXform = new Xform();

		modelXform.getChildren().add(frontCylinderXform);
		modelXform.getChildren().add(leftCylinderXform);
		modelXform.getChildren().add(backCylinderXform);
		modelXform.getChildren().add(rightCylinderXform);
		modelXform.getChildren().add(topCylinderXform);
		modelXform.getChildren().add(bottomCylinderXform);

		Cylinder frontCylinder = new Cylinder(5, 100);
		frontCylinder.setMaterial(blueMaterial);
		frontCylinder.setTranslateX(50.0);
		frontCylinder.setRotationAxis(Rotate.Z_AXIS);
		frontCylinder.setRotate(90.0);
		
		frontCylinderXform.getChildren().add(frontCylinder);

		Cylinder leftCylinder = new Cylinder(5, 100);
		leftCylinder.setMaterial(greenMaterial);
		leftCylinder.setTranslateY(50.0);
		leftCylinder.setRotationAxis(Rotate.Z_AXIS);
		leftCylinder.setRotate(0.0);

		leftCylinderXform.getChildren().add(leftCylinder);

		Cylinder backCylinder = new Cylinder(5, 100);
		backCylinder.setMaterial(redMaterial);
		backCylinder.setTranslateX(-50.0);
		backCylinder.setRotationAxis(Rotate.Z_AXIS);
		backCylinder.setRotate(90.0);

		backCylinderXform.getChildren().add(backCylinder);

		Cylinder rightCylinder = new Cylinder(5, 100);
		rightCylinder.setMaterial(yellowMaterial);
		rightCylinder.setTranslateY(-50.0);
		rightCylinder.setRotationAxis(Rotate.Z_AXIS);
		rightCylinder.setRotate(180.0);

		rightCylinderXform.getChildren().add(rightCylinder);

		Cylinder topCylinder = new Cylinder(5, 100);
		topCylinder.setMaterial(purpleMaterial);
		topCylinder.setTranslateZ(50.0);
		topCylinder.setRotationAxis(Rotate.X_AXIS);
		topCylinder.setRotate(90.0);

		topCylinderXform.getChildren().add(topCylinder);

		Cylinder bottomCylinder = new Cylinder(5, 100);
		bottomCylinder.setMaterial(orangeMaterial);
		bottomCylinder.setTranslateZ(-50.0);
		bottomCylinder.setRotationAxis(Rotate.X_AXIS);
		bottomCylinder.setRotate(90.0);

		bottomCylinderXform.getChildren().add(bottomCylinder);

		Xform frontSphereXform = new Xform();
		Xform backSphereXform = new Xform();
		Xform leftSphereXform = new Xform();
		Xform rightSphereXform = new Xform();
		Xform topSphereXform = new Xform();
		Xform bottomSphereXform = new Xform();

		modelXform.getChildren().add(frontSphereXform);
		modelXform.getChildren().add(backSphereXform);
		modelXform.getChildren().add(leftSphereXform);
		modelXform.getChildren().add(rightSphereXform);
		modelXform.getChildren().add(topSphereXform);
		modelXform.getChildren().add(bottomSphereXform);

		Sphere frontSphere = new Sphere(30.0);
		frontSphere.setMaterial(blueMaterial);
		frontSphere.setTranslateX(100.0);

		frontSphereXform.getChildren().add(frontSphere);

		Sphere backSphere = new Sphere(30.0);
		backSphere.setMaterial(redMaterial);
		backSphere.setTranslateX(-100.0);

		backSphereXform.getChildren().add(backSphere);

		Sphere leftSphere = new Sphere(30.0);
		leftSphere.setMaterial(greenMaterial);
		leftSphere.setTranslateY(100.0);

		backSphereXform.getChildren().add(leftSphere);

		Sphere rightSphere = new Sphere(30.0);
		rightSphere.setMaterial(yellowMaterial);
		rightSphere.setTranslateY(-100.0);

		backSphereXform.getChildren().add(rightSphere);

		Sphere topSphere = new Sphere(30.0);
		topSphere.setMaterial(purpleMaterial);
		topSphere.setTranslateZ(100.0);

		backSphereXform.getChildren().add(topSphere);

		Sphere bottomSphere = new Sphere(30.0);
		bottomSphere.setMaterial(orangeMaterial);
		bottomSphere.setTranslateZ(-100.0);

		backSphereXform.getChildren().add(bottomSphere);

		Xform boxXform = new Xform();

		modelXform.getChildren().add(boxXform);

		Box box = new Box(50, 50, 50);
		box.setMaterial(whiteMaterial);
		box.setTranslateX(0.0);

		boxXform.getChildren().add(box);

		this.getChildren().add(modelXform);
	}
}
