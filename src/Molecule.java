import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

public class Molecule extends Xform {
	private static final double HYDROGEN_ANGLE = 104.5;
	private static final double HYDROGEN3_ANGLE = 194.5;
	public Molecule()
	{
		//======================================================================
		// THIS IS THE IMPORTANT MATERIAL FOR THE TUTORIAL
		//======================================================================

		final PhongMaterial redMaterial = new PhongMaterial();
		redMaterial.setDiffuseColor(Color.DARKRED);
		redMaterial.setSpecularColor(Color.RED);

		final PhongMaterial whiteMaterial = new PhongMaterial();
		whiteMaterial.setDiffuseColor(Color.WHITE);
		whiteMaterial.setSpecularColor(Color.LIGHTBLUE);

		final PhongMaterial greyMaterial = new PhongMaterial();
		greyMaterial.setDiffuseColor(Color.DARKGREY);
		greyMaterial.setSpecularColor(Color.GREY);

		// Molecule Hierarchy
		// [*] moleculeXform
		//     [*] oxygenXform
		//         [*] oxygenSphere
		//     [*] hydrogen1SideXform
		//         [*] hydrogen1Xform
		//             [*] hydrogen1Sphere
		//         [*] bond1Cylinder
		//     [*] hydrogen2SideXform
		//         [*] hydrogen2Xform
		//             [*] hydrogen2Sphere
		//         [*] bond2Cylinder
		Xform moleculeXform = new Xform();
		Xform oxygenXform = new Xform();
		Xform hydrogen1SideXform = new Xform();
		Xform hydrogen1Xform = new Xform();
		Xform hydrogen2SideXform = new Xform();
		Xform hydrogen2Xform = new Xform();
		Xform hydrogen3SideXform = new Xform();
		Xform hydrogen3Xform = new Xform();

		Sphere oxygenSphere = new Sphere(40.0);
		oxygenSphere.setMaterial(redMaterial);

		Sphere hydrogen1Sphere = new Sphere(30.0);
		hydrogen1Sphere.setMaterial(whiteMaterial);
		hydrogen1Sphere.setTranslateX(0.0);

		Sphere hydrogen2Sphere = new Sphere(30.0);
		hydrogen2Sphere.setMaterial(whiteMaterial);
		hydrogen2Sphere.setTranslateZ(0.0);

		Sphere hydrogen3Sphere = new Sphere(30.0);
		hydrogen3Sphere.setMaterial(whiteMaterial);
		hydrogen3Sphere.setTranslateY(0.0);

		Cylinder bond1Cylinder = new Cylinder(5, 100);
		bond1Cylinder.setMaterial(greyMaterial);
		bond1Cylinder.setTranslateX(50.0);
		bond1Cylinder.setRotationAxis(Rotate.Z_AXIS);
		bond1Cylinder.setRotate(90.0);

		Cylinder bond2Cylinder = new Cylinder(5, 100);
		bond2Cylinder.setMaterial(greyMaterial);
		bond2Cylinder.setTranslateX(50.0);
		bond2Cylinder.setRotationAxis(Rotate.Z_AXIS);
		bond2Cylinder.setRotate(90.0);

		moleculeXform.getChildren().add(oxygenXform);
		moleculeXform.getChildren().add(hydrogen1SideXform);
		moleculeXform.getChildren().add(hydrogen2SideXform);
		moleculeXform.getChildren().add(hydrogen3SideXform);
		oxygenXform.getChildren().add(oxygenSphere);
		hydrogen1SideXform.getChildren().add(hydrogen1Xform);
		hydrogen2SideXform.getChildren().add(hydrogen2Xform);
		hydrogen3SideXform.getChildren().add(hydrogen3Xform);
		hydrogen1Xform.getChildren().add(hydrogen1Sphere);
		hydrogen2Xform.getChildren().add(hydrogen2Sphere);
		hydrogen3Xform.getChildren().add(hydrogen3Sphere);
		hydrogen1SideXform.getChildren().add(bond1Cylinder);
		hydrogen2SideXform.getChildren().add(bond2Cylinder);

		hydrogen1Xform.setTx(100.0);
		hydrogen2Xform.setTx(100.0);
		hydrogen2SideXform.setRotateY(HYDROGEN_ANGLE);
		hydrogen3Xform.setTx(100.0);
		hydrogen3SideXform.setRotateY(HYDROGEN3_ANGLE);

		this.getChildren().add(moleculeXform);
	}
}
