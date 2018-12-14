package DijkstraVisualization;

import java.util.LinkedList;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class vertex {
	Circle c;
	double x;
	double y;
	LinkedList<edge> adjEdges = new LinkedList<>();

	// TODO Add a label to mark the weight of the vertex
	
	public vertex(double x2, double y2) {
		x = x2;
		y = y2;
		c = new Circle(x, y, 3);
		c.setId("manan");
		System.out.println(c.getId());
	}

	public void showVertex(Group g) {
		g.getChildren().add(c);
	}

	public void addEdge(edge e) {
		adjEdges.add(e);
	}
	
	public void updateX(double x2) {
		c.setCenterX(x2);
		for(edge e: adjEdges) {
			if(e.l.getStartX() == x) {
				e.l.setStartX(x2);
			}else {
				e.l.setEndX(x2);
			}
		}
		x = x2;
	}
	
	public void updateY(double y2) {
		c.setCenterY(y2);
		for(edge e: adjEdges) {
			if(e.l.getStartY() == y) {
				e.l.setStartY(y2);
			}else {
				e.l.setEndY(y2);
			}
		}
		y = y2;
	}
}
