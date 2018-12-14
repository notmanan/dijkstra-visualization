package DijkstraVisualization;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class edge {
	Line l;
	vertex a, b;
	double weight;

	// TODO Add a label to mark the weight of the line
	
	public edge(vertex u, vertex v) {
		l = new Line(u.x, u.y, v.x, v.y);
		weight = Math.sqrt(Math.pow(u.x - v.x, 2) + Math.pow(u.y - v.y, 2));
//		System.out.println(weight);
	}

	public void showEdge(Group g) {
		g.getChildren().add(l);
	}

	public void addToMinSpanTree() {
		if(l.getStroke() == Color.BLACK) {
			l.setStroke(Color.RED);			
		}else {
			l.setStroke(Color.BLACK);			
		}
	}
}
