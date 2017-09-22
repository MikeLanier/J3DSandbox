package Sandbox;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class TriMesh extends Xform {

	public TriMesh() {
		TriangleMesh m = new TriangleMesh();

		// POINTS
		m.getPoints().addAll(
			0f, 0f, -0.951057f,
			0f, 0f, 0.951057f,
			-0.850651f, 0f, -0.425325f,
			0.850651f, 0f, 0.425325f,
			0.688191f, -0.5f, -0.425325f,
			0.688191f, 0.5f, -0.425325f,
			-0.688191f, -0.5f, 0.425325f,
			-0.688191f, 0.5f, 0.425325f,
			-0.262866f, -0.809017f, -0.425325f,
			-0.262866f, 0.809017f, -0.425325f,
			0.262866f, -0.809017f, 0.425325f,
			0.262866f, 0.809017f, 0.425325f
		);

		// TEXTURES
		m.getTexCoords().addAll(
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 1f
		);

		// FACES
		m.getFaces().addAll(
				1, 6, 11, 5, 7, 0,
				1, 12, 7, 11, 6, 5,
				1, 7, 6, 6, 10, 1,
				1, 13, 10, 12, 3, 6,
				1, 8, 3, 7, 11, 2,
				4, 14, 8, 13, 0, 7,
				5, 9, 4, 8, 0, 3,
				9, 15, 5, 14, 0, 8,
				2, 10, 9, 9, 0, 4,
				8, 16, 2, 15, 0, 9,
				11, 5, 9, 6, 7, 12,
				7, 11, 2, 12, 6, 17,
				6, 6, 8, 7, 10, 13,
				10, 12, 4, 13, 3, 18,
				3, 7, 5, 8, 11, 14,
				4, 13, 10, 14, 8, 19,
				5, 8, 3, 9, 4, 15,
				9, 14, 11, 15, 5, 20,
				2, 9, 7, 10, 9, 16,
				8, 15, 6, 16, 2, 21
		);

		MeshView mv = new MeshView();
		mv.setMesh(m);

		PhongMaterial mat = new PhongMaterial();
		mat.setDiffuseColor(Color.RED);
		mat.setSpecularColor(Color.WHITE);
		mv.setMaterial(mat);

		getChildren().add(mv);
		this.setScale(100.0);
	}
}
