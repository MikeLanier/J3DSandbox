package Sandbox;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class Arrows extends Xform {

	private MeshView createMeshView(float[] vertices, int faces[], PhongMaterial material) {
		TriangleMesh m = new TriangleMesh();

		// POINTS
		m.getPoints().addAll(vertices);

		// TEXTURES
		m.getTexCoords().addAll(
				1f, 1f
		);

		// FACES
		m.getFaces().addAll(faces);

		MeshView mv = new MeshView();
		mv.setMesh(m);

		mv.setMaterial(material);
		return mv;
	}

	public Arrows()
	{
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

		final PhongMaterial whiteMaterial = new PhongMaterial();
		whiteMaterial.setDiffuseColor(Color.LIGHTGRAY);
		whiteMaterial.setSpecularColor(Color.DARKGRAY);

		final PhongMaterial purpleMaterial = new PhongMaterial();
		purpleMaterial.setDiffuseColor(Color.PURPLE);
		purpleMaterial.setSpecularColor(Color.WHITE);

		final PhongMaterial orangeMaterial = new PhongMaterial();
		orangeMaterial.setDiffuseColor(Color.DARKORANGE);
		orangeMaterial.setSpecularColor(Color.ORANGE);

		final PhongMaterial cyanMaterial = new PhongMaterial();
		cyanMaterial.setDiffuseColor(Color.DARKCYAN);
		cyanMaterial.setSpecularColor(Color.CYAN);

		float verticesA[] = {
				0f, 4f, 4f,
				-4f, 0f, 4f,
				-2f, 0f, 4f,
				-2f, -4f, 4f,
				2f, -4f, 4f,
				2f, 0f, 4f,
				4f, 0f, 4f
		};

		float verticesB[] = {
				0f, 4f, -4f,
				-4f, 0f, -4f,
				-2f, 0f, -4f,
				-2f, -4f, -4f,
				2f, -4f, -4f,
				2f, 0f, -4f,
				4f, 0f, -4f
		};

		float verticesC[] = {
				4f, 4f, 0f,
				4f, 0f, -4f,
				4f, 0f, -2f,
				4f, -4f, -2f,
				4f, -4f, 2f,
				4f, 0f, 2f,
				4f, 0f, 4f
		};

		float verticesD[] = {
				-4f, 4f, 0f,
				-4f, 0f, -4f,
				-4f, 0f, -2f,
				-4f, -4f, -2f,
				-4f, -4f, 2f,
				-4f, 0f, 2f,
				-4f, 0f, 4f
		};

		int facesFront[] = {
				1, 0, 0, 0, 6, 0,
				3, 0, 2, 0, 5, 0,
				3, 0, 5, 0, 4, 0
		};

		int facesBack[] = {
				1, 0, 6, 0, 0, 0,
				3, 0, 5, 0, 2, 0,
				3, 0, 4, 0, 5, 0
		};

		getChildren().add(createMeshView(verticesA, facesFront, blueMaterial));
		getChildren().add(createMeshView(verticesA, facesBack, redMaterial));
		getChildren().add(createMeshView(verticesB, facesFront, greenMaterial));
		getChildren().add(createMeshView(verticesB, facesBack, yellowMaterial));
		getChildren().add(createMeshView(verticesC, facesFront, purpleMaterial));
		getChildren().add(createMeshView(verticesC, facesBack, whiteMaterial));
		getChildren().add(createMeshView(verticesD, facesFront, orangeMaterial));
		getChildren().add(createMeshView(verticesD, facesBack, cyanMaterial));

		this.setScale(10.0);
	}
}
