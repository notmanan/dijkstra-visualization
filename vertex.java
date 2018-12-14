package DijkstraVisualization;

import java.util.LinkedList;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class vertex {
	static char alphabet = 'A';
	Circle c;
	double x;
	double y;
	LinkedList<edge> adjEdges = new LinkedList<>();
	Label text;
	
	public vertex(double x2, double y2) {
		x = x2;
		y = y2;
		c = new Circle(x, y, 3);
		c.setId(Character.toString(alphabet));
		text = new Label(c.getId() + " [ "+x+", "+y+"]");
		text.setTranslateX(x-45);
		text.setTranslateY(y-30);
		System.out.println(c.getId());
		alphabet++;
	}

	public void showVertex(Group g) {
		g.getChildren().add(c);
		g.getChildren().add(text);
	}

	public void addEdge(edge e) {
		adjEdges.add(e);
	}
	
	public void deleteVertex(mainApp p) {
		while (adjEdges.size() != 0) {
			edge e = adjEdges.getLast();
			e.removeEdge(p);
			p.edges.remove(e);
			adjEdges.remove(e);
		}
		p.vertexGroup.getChildren().remove(c);
		p.vertexGroup.getChildren().remove(text);
		
	}
}
