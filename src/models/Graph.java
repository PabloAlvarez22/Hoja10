package models;
//Con un poco de ayuda de chat gpt ;) y https://www.ciberaula.com/cursos/java/grafos_java.php
import java.util.Arrays;

public class Graph {
    private int[][] adjacencyMatrix;
    private String[] cities;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        this.cities = new String[numVertices];
    }

    public void addEdge(int source, int destination, int travelTime) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjacencyMatrix[source][destination] = travelTime;
        } else {
            throw new IndexOutOfBoundsException("Invalid vertex index");
        }
    }

    public void addVertex(String city) {
        if (numVertices < adjacencyMatrix.length) {
            cities[numVertices] = city;
            numVertices++;
        } else {
            throw new IllegalStateException("Graph is already at maximum capacity");
        }
    }

    public void removeEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjacencyMatrix[source][destination] = 0;
        } else {
            throw new IndexOutOfBoundsException("Invalid vertex index");
        }
    }

    public boolean hasEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            return adjacencyMatrix[source][destination] != 0;
        } else {
            throw new IndexOutOfBoundsException("Invalid vertex index");
        }
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(cities[i] + ": ");
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    System.out.print(cities[j] + "(" + adjacencyMatrix[i][j] + " mins) ");
                }
            }
            System.out.println();
        }
    }

    
    public int calculateCenter() {
        int[] eccentricities = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            eccentricities[i] = calculateEccentricity(i);
        }
        int minEccentricity = Arrays.stream(eccentricities).min().getAsInt();
        for (int i = 0; i < numVertices; i++) {
            if (eccentricities[i] == minEccentricity) {
                return i;
            }
        }
        return -1; // Return -1 if the graph is empty
    }

    private int calculateEccentricity(int vertex) {
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[vertex] = 0;
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices - 1; i++) {
            int minDistanceVertex = getMinDistanceVertex(distances, visited);
            visited[minDistanceVertex] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && adjacencyMatrix[minDistanceVertex][j] != 0
                        && distances[minDistanceVertex] != Integer.MAX_VALUE
                        && distances[minDistanceVertex] + adjacencyMatrix[minDistanceVertex][j] < distances[j]) {
                    distances[j] = distances[minDistanceVertex] + adjacencyMatrix[minDistanceVertex][j];
                }
            }
        }

        int maxDistance = Arrays.stream(distances).max().getAsInt();
        return maxDistance != Integer.MAX_VALUE ? maxDistance : -1; // Return -1 if vertex is disconnected
    }

    private int getMinDistanceVertex(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && distances[i] <= minDistance) {
                minDistance = distances[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

	
	
}
