public class Tester {

    public static void main(String[] args) {
        testManualGraph();
        testGraphFromFile("Graph.txt"); 
    }

    private static void testManualGraph() {
    	testFirstGraph();
        testSecondGraph();
    }

    private static void testFirstGraph() {
        try {
            System.out.println("First Testing Manual Graph: ");
            Graph g1 = new Graph();
            buildLinearSampleGraph(g1);
            g1.print();
            performGraphTests(g1);
        } catch (Exception e) {
            System.err.println("Error in graph test: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void testSecondGraph() {
        try {
            System.out.println("Second Testing Manual Graph: ");
            Graph g3 = new Graph();
            buildCustomSampleGraph(g3);
            g3.print();
            performGraphTests(g3);
        } catch (Exception e) {
            System.err.println("Error in graph test: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void testGraphFromFile(String filePath) {
        try {
            System.out.println("\nTesting Graph Creation from File...");
            Graph g2 = new Graph(filePath);
            g2.print();
            performGraphTests(g2);
        } catch (Exception e) {
            System.err.println("Error in file graph test: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void buildLinearSampleGraph(Graph g) {
        for (int i = 0; i < 5; i++) {
            g.addVertex();
        }
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
    }

    private static void buildCustomSampleGraph(Graph g) {
        for (int i = 0; i < 8; i++) {
            g.addVertex();
        }
        g.addEdge(2, 3);
        g.addEdge(4, 2);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
    }

    private static void performGraphTests(Graph g) {
        System.out.println("Is the graph connected: " + g.isConnected());
        System.out.println("Testing components:");
        g.components().forEach(component -> System.out.println(component));
        System.out.println("Maximal Independent Set: " + g.findMaximalIndependentSet());
    }
}
