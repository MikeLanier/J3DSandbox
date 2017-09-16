import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

import java.util.ArrayList;
import java.util.List;

public class Helix extends Xform {
	public Helix() {
		double d = Math.PI / 20;
		double stop = 60 * Math.PI;
		double radiusOuter = 1;
		double radiusInner = .75;
		double slope = .1;

		TriangleMesh m = new TriangleMesh();

		// POINTS
//		m.getPoints().addAll(
//				-1f, -1f, -1f,
//				1f, -1f, -1f,
//				-1f, 1f, -1f,
//				1f, 1f, -1f,
//				-1f, -1f, 1f,
//				1f, -1f, 1f,
//				-1f, 1f, 1f,
//				1f, 1f, 1f
//		);

		for (double a = 0; a <= stop; a += d) {
			Float x = (float) (radiusOuter * Math.cos(a));
			Float y = (float) (radiusOuter * Math.sin(a));
			Float z = (float) (slope * a);

			m.getPoints().addAll(x);
			m.getPoints().addAll(y);
			m.getPoints().addAll(z);

			System.out.println(x + ", " + y + ", " + z);

			x = (float) (radiusInner * Math.cos(a));
			y = (float) (radiusInner * Math.sin(a));
			z = (float) (slope * a);

			m.getPoints().addAll(x);
			m.getPoints().addAll(y);
			m.getPoints().addAll(z);

			System.out.println(x + ", " + y + ", " + z);
		}

		int n = m.getPoints().size() / 6;
		System.out.println(n);

		// TEXTURES
		m.getTexCoords().addAll(
				1f, 1f
		);

		// FACES
		for(int i=0; i<n; i+=2)
		m.getFaces().addAll(
				i, 0, i+1, 0, i+2, 0,
				i+3, 0, i+2, 0, i+1, 0,
				i+2, 0, i+1, 0, i, 0,
				i+1, 0, i+2, 0, i+3, 0
		);

		MeshView mv = new MeshView();
		mv.setMesh(m);

		PhongMaterial mat = new PhongMaterial();
		mat.setDiffuseColor(Color.GREEN);
		mat.setSpecularColor(Color.WHITE);
		mv.setMaterial(mat);

		getChildren().add(mv);
		this.setScale(25.0);
	}
}
