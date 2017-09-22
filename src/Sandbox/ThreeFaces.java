package Sandbox;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

/**
 * Created by Mike on 9/15/2017.
 */
public class ThreeFaces extends Xform {
	public ThreeFaces() {
		TriangleMesh m = new TriangleMesh();

		// POINTS
		m.getPoints().addAll(
				-1f, -1f, -1f,
				1f, -1f, -1f,
				-1f, 1f, -1f,
				1f, 1f, -1f,
				-1f, -1f, 1f,
				1f, -1f, 1f,
				-1f, 1f, 1f,
				1f, 1f, 1f
		);

		// TEXTURES
		m.getTexCoords().addAll(
				1f, 1f
		);

		// FACES
		m.getFaces().addAll(
				0, 0, 1, 0, 2, 0,
				3, 0, 2, 0, 1, 0,
				2, 0, 1, 0, 0, 0,
				1, 0, 2, 0, 3, 0,

				4, 0, 5, 0, 6, 0,
				7, 0, 6, 0, 5, 0,
				6, 0, 5, 0, 4, 0,
				5, 0, 6, 0, 7, 0,

				0, 0, 4, 0, 2, 0,
				2, 0, 4, 0, 0, 0,
				2, 0, 4, 0, 6, 0,
				6, 0, 4, 0, 2, 0
		);

		MeshView mv = new MeshView();
		mv.setMesh(m);

		PhongMaterial mat = new PhongMaterial();
		mat.setDiffuseColor(Color.GREEN);
		mat.setSpecularColor(Color.WHITE);
		mv.setMaterial(mat);

		getChildren().add(mv);
		this.setScale(50.0);
	}
}
