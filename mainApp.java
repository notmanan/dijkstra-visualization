package DijkstraVisualization;

import java.util.LinkedList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainApp extends Application {
	Scene mainScene;
	Group vertexGroup, edgeGroup;
	Pane pane;
	LinkedList<vertex> vertices = new LinkedList<>();
	LinkedList<edge> edges = new LinkedList<>();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		pane = new Pane();
		mainScene = new Scene(pane, 1000, 800);
		vertexGroup = new Group();
		edgeGroup = new Group();
		pane.getChildren().addAll(edgeGroup, vertexGroup);

		mainScene.setOnMouseDragged(e -> {
			System.out.println("dragged");
//			 
		});

		mainScene.setOnMouseClicked(e -> {
			addVertex(e);
		});

		mainScene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.SPACE) {
				showMinimumSpanningTree();
			} else if (e.getCode() == KeyCode.UP) {
				for (vertex v : vertices) {
					v.updateY(v.y * 0.9);
				}
			} else if (e.getCode() == KeyCode.DOWN) {
				for (vertex v : vertices) {
					v.updateY(v.y * 1.1);
				}
			} else if (e.getCode() == KeyCode.LEFT) {
				for (vertex v : vertices) {
					v.updateX(v.x * 0.9);
				}
			} else if (e.getCode() == KeyCode.RIGHT) {
				for (vertex v : vertices) {
					v.updateX(v.x * 1.1);
				}
			} else if (e.getCode() == KeyCode.R) {
				Random rand = new Random();
				for (vertex v : vertices) {
					double r = rand.nextDouble() - 0.5;
					System.out.println(r);
					v.updateX(v.x + r * 4);
					r = rand.nextDouble() - 0.5;
					v.updateY(v.y + r * 4);

				}
			} else if (e.getCode() == KeyCode.BACK_SPACE) {
				if (vertices.size() != 0) {
					removeVertex(vertices.getLast());
				} else {
					System.out.println("no vertex");
				}
			}
		});

		primaryStage.setScene(mainScene);
		primaryStage.show();

	}

	private void removeVertex(vertex last) {
		System.out.println("removing last");
		while (last.adjEdges.size() != 0) {
			edge e = last.adjEdges.getLast();
			edgeGroup.getChildren().remove(e.l);
			edges.remove(e);
			last.adjEdges.remove(e);
		}
		vertexGroup.getChildren().remove(last.c);
		vertices.remove(last);
	}

	private void showMinimumSpanningTree() {
		System.out.println("MST FUNC");
		// TODO Figure out the implementation of the MST
	}

	private void addVertex(MouseEvent e) {
		createVertex(e.getX(), e.getY());
	}

	private void createVertex(double x, double y) {
		vertex v = new vertex(x, y);
		v.showVertex(vertexGroup);
		vertices.add(v);
		updateEdges(v);
		System.out.println("Number Of Vertices : " + vertices.size());
	}

	private void updateEdges(vertex v) {
		for (vertex u : vertices) {
			if (u != v) {
				addEdge(u, v);
			}
		}
		System.out.println("Total number of edges: " + edges.size());
	}

	private void addEdge(vertex u, vertex v) {
		edge e = new edge(u, v);
		edges.add(e);
		e.showEdge(edgeGroup);
		u.addEdge(e);
		v.addEdge(e);
	}
}
