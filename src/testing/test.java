package testing;
import junit.framework.TestCase;
import models.Graph;


public class test extends TestCase {
	
	public void testAddVertex() {
		
		//Incersión de datos
		Graph graph = new Graph(3);
		graph.addVertex("Buenos Aires");
		graph.addVertex("Sao Paulo");
		graph.addVertex("Lima");

		graph.addEdge(0, 1, 10); // Buenos Aires a Sao Paulo toma 10 horas
		graph.addEdge(1, 2, 12); // Sao Paulo a Lima  toma 12 horas
        
		assertEquals(3, graph.getNumVertices());
		assertEquals("Buenos Aires", graph.getCityName(0));
 
	}
	
}
