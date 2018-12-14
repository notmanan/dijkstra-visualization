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
	// TODO Add a label to mark the weight of the vertex
	
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
		text.setText("[ "+x+", "+y+"]");
		text.setTranslateX(x-45);
		text.setTranslateY(y-30);
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

		text.setText("[ "+x+", "+y+"]");
		text.setTranslateX(x-45);
		text.setTranslateY(y-30);
	}
}
