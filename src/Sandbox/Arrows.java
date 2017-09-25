package Sandbox;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
		purpleMaterial.setDiffuseColor(Color.DARKMAGENTA);
		purpleMaterial.setSpecularColor(Color.PURPLE);

		final PhongMaterial orangeMaterial = new PhongMaterial();
		orangeMaterial.setDiffuseColor(Color.DARKORANGE);
		orangeMaterial.setSpecularColor(Color.ORANGE);

		final PhongMaterial cyanMaterial = new PhongMaterial();
		cyanMaterial.setDiffuseColor(Color.DARKCYAN);
		cyanMaterial.setSpecularColor(Color.CYAN);

		float verticesA[] = {
				0f, -4f, 4f,
				-4f, 0f, 4f,
				-2f, 0f, 4f,
				-2f, 4f, 4f,
				2f, 4f, 4f,
				2f, 0f, 4f,
				4f, 0f, 4f
		};

		float verticesB[] = {
				0f, -4f, -4f,
				-4f, 0f, -4f,
				-2f, 0f, -4f,
				-2f, 4f, -4f,
				2f, 4f, -4f,
				2f, 0f, -4f,
				4f, 0f, -4f
		};

		float verticesC[] = {
				4f, -4f, 0f,
				4f, 0f, -4f,
				4f, 0f, -2f,
				4f, 4f, -2f,
				4f, 4f, 2f,
				4f, 0f, 2f,
				4f, 0f, 4f
		};

		float verticesD[] = {
				-4f, -4f, 0f,
				-4f, 0f, -4f,
				-4f, 0f, -2f,
				-4f, 4f, -2f,
				-4f, 4f, 2f,
				-4f, 0f, 2f,
				-4f, 0f, 4f
		};

		float verticesE[] = {
				0f, -4f, -4f,
				-4f, -4f, 0f,
				4f, -4f, 0f
		};

		float verticesF[] = {
				0f, 4f, -4f,
				-4f, 4f, 0f,
				4f, 4f, 0f
		};

		float verticesG[] = {
				0f, -4f, 4f,
				-4f, -4f, 0f,
				4f, -4f, 0f
		};

		float verticesH[] = {
				0f, 4f, 4f,
				-4f, 4f, 0f,
				4f, 4f, 0f
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

		int facesTop[] = {
				0, 0, 1, 0, 2, 0
		};

		int facesBottom[] = {
				0, 0, 2, 0, 1, 0
		};

		getChildren().add(createMeshView(verticesA, facesFront, blueMaterial));
		getChildren().add(createMeshView(verticesA, facesBack, redMaterial));
		getChildren().add(createMeshView(verticesB, facesFront, greenMaterial));
		getChildren().add(createMeshView(verticesB, facesBack, yellowMaterial));
		getChildren().add(createMeshView(verticesC, facesFront, purpleMaterial));
		getChildren().add(createMeshView(verticesC, facesBack, whiteMaterial));
		getChildren().add(createMeshView(verticesD, facesFront, orangeMaterial));
		getChildren().add(createMeshView(verticesD, facesBack, cyanMaterial));

		getChildren().add(createMeshView(verticesE, facesTop, blueMaterial));
		getChildren().add(createMeshView(verticesE, facesBottom, greenMaterial));
		getChildren().add(createMeshView(verticesF, facesTop, cyanMaterial));
		getChildren().add(createMeshView(verticesF, facesBottom, redMaterial));
		getChildren().add(createMeshView(verticesG, facesTop, purpleMaterial));
		getChildren().add(createMeshView(verticesG, facesBottom, whiteMaterial));
		getChildren().add(createMeshView(verticesH, facesTop, yellowMaterial));
		getChildren().add(createMeshView(verticesH, facesBottom, orangeMaterial));

		{
			Xform textForm = new Xform();
			Text t = new Text();
			t.setText("Back");
			Font f = new Font("Ariel", 12);
			t.setFont(f);
			textForm.getChildren().add(t);
			textForm.setScale(.1);
			textForm.setRotateY(180);
			textForm.setTranslateZ(4.1);
			getChildren().add(textForm);
		}
		{
			Xform textForm = new Xform();
			Text t = new Text();
			t.setText("Front");
			Font f = new Font("Ariel", 12);
			t.setFont(f);
			textForm.getChildren().add(t);
			textForm.setScale(.1);
			textForm.setTranslateZ(-4.1);
			getChildren().add(textForm);
		}
		{
			Xform textForm = new Xform();
			Text t = new Text();
			t.setText("Left");
			Font f = new Font("Ariel", 12);
			t.setFont(f);
			textForm.getChildren().add(t);
			textForm.setScale(.1);
			textForm.setRotateY(270);
			textForm.setTranslateX(4.1);
			getChildren().add(textForm);
		}
		{
			Xform textForm = new Xform();
			Text t = new Text();
			t.setText("Right");
			Font f = new Font("Ariel", 12);
			t.setFont(f);
			textForm.getChildren().add(t);
			textForm.setScale(.1);
			textForm.setRotateY(90);
			textForm.setTranslateX(-4.1);
			getChildren().add(textForm);
		}
		{
			Xform textForm = new Xform();
			Text t = new Text();
			t.setText("Bottom");
			Font f = new Font("Ariel", 12);
			t.setFont(f);
			textForm.getChildren().add(t);
			textForm.setScale(.1);
			textForm.setRotateX(90);
			textForm.setTranslateY(4.1);
			getChildren().add(textForm);
		}
		{
			Xform textForm = new Xform();
			Text t = new Text();
			t.setText("Top");
			Font f = new Font("Ariel", 12);
			t.setFont(f);
			textForm.getChildren().add(t);
			textForm.setScale(.1);
			textForm.setRotateY(180);
			textForm.setRotateX(270);
			textForm.setTranslateY(-4.1);
			getChildren().add(textForm);
		}
		this.setScale(10.0);
	}
}
