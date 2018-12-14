package DijkstraVisualization;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class edge {
	Line l;
	vertex a, b;
	double weight;
	Label text;

	// TODO Add a label to mark the weight of the line
	
	public edge(vertex u, vertex v) {
		l = new Line(u.x, u.y, v.x, v.y);
		double xcenter = u.x/2 + v.x/2;
		double ycenter = u.y/2 + v.y/2;
		
		weight = Math.sqrt(Math.pow(u.x - v.x, 2) + Math.pow(u.y - v.y, 2));
		
		text = new Label(String.format("%.2f", weight));
		text.setTranslateX(xcenter-45);
		text.setTranslateY(ycenter-30);
		
//		System.out.println(weight);
	}

	public void showEdge(Group g) {
		g.getChildren().add(l);
		g.getChildren().add(text);
	}

	public void addToMinSpanTree() {
		if(l.getStroke() == Color.BLACK) {
			l.setStroke(Color.RED);			
		}else {
			l.setStroke(Color.BLACK);			
		}
	}
}
