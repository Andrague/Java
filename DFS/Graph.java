import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Graph {
	
	
	private ArrayList<ArrayList<Integer>> adjLists = new ArrayList<>();

	public int addVertex() {
		adjLists.add(new ArrayList<>());
		return adjLists.size() - 1;
	}

	public int order() {
		return adjLists.size();
	}

	public int degree(int v) {
		if (v >= order())
			throw new IllegalArgumentException("No such vertex");
		return adjLists.get(v).size();
	}

	public ArrayList<Integer> getNeighboursOf(int v) {
		if (v >= order())
			throw new IllegalArgumentException("No such vertex");
		return new ArrayList<Integer>(adjLists.get(v));
	}

	public boolean isEdge(int v, int w) {
		if (v >= order() || w >= order())
			throw new IllegalArgumentException("No such vertex");
		if (this.degree(w) < this.degree(v))
			for (int x : this.getNeighboursOf(w)) {
				if (x == v)
					return true;
			}
		else
			for (int x : this.getNeighboursOf(v)) {
				if (x == w)
					return true;
			}

		return false;

	}
	public  Graph() {
		
	}

	public void addEdge(int v, int w) {
		if (this.isEdge(v, w))
			throw new IllegalArgumentException("Such edge already exists!");
		else {
			adjLists.get(v).add(w);
			adjLists.get(w).add(v);
		}
	}

	public void print() {
		System.out.println(adjLists);
	}

	public boolean isConnected() {
		// using BSF for checking whether the graph is connected
		if (this.order() == 0)
			return false;
		// order>0
		// we are starting from first vertex which has index 0
		int s = 0;
		
		boolean[] visited = new boolean[this.order()];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.addLast(s);
		visited[s] = true;
		int numberOfVisited = 1;
		while (!queue.isEmpty()) {
			// Removing that vertex from queue,whose neighbour will be visited now
			int v = queue.poll();
			// processing all the neighbours of v
			for (int w : this.getNeighboursOf(v))
				if (!visited[w]) {
					visited[w] = true;
					numberOfVisited++;
					queue.addLast(w);
				}
		}
		if(numberOfVisited==this.order()) return true;
		else return false;

	}
	public boolean isConnectedV2() {
		// using BSF for checking whether the graph is connected
		if (this.order() == 0)
			return false;
		// order>0
		// we are starting from first vertex which has index 0
		int s = 0;
		HashSet<Integer> visited=new HashSet<>();
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.addLast(s);
		visited.add(s);
		while (!queue.isEmpty()) {
			// Removing that vertex from queue,whose neighbour will be visited now
			int v = queue.poll();
			// processing all the neighbours of v
			for (int w : this.getNeighboursOf(v))
				if (!visited.contains(w)) {
					visited.add(w);
					queue.addLast(w);
				}
		}
		if(visited.size()==this.order()) return true;
		else return false;
	}
	private void DFScontinue(int v, boolean[] visited, List<Integer> component) {
        visited[v] = true;
        component.add(v);
        for (int neighbor : adjLists.get(v)) {
            if (!visited[neighbor]) {
                DFScontinue(neighbor, visited, component);
            }
        }
    }
	 public List<List<Integer>> components() {
	        boolean[] visited = new boolean[order()];
	        List<List<Integer>> components = new ArrayList<>();
	      
	        for (int ver = 0; ver < adjLists.size(); ver++) { 
	            if (!visited[ver]) {
	                List<Integer> component = new ArrayList<>();
	                DFScontinue(ver, visited, component);
	                components.add(component);
	            }
	        }
	        return components;
	    }


	public Graph(String path) throws GraphException  {
		 
        try(BufferedReader reader=new BufferedReader(new FileReader(path));){
          String line=null;
          line=reader.readLine();
          int n=Integer.parseInt(line);
          for(int i=0;i<n;i++) {
              this.addVertex();
          }
         
          while((line=reader.readLine())!=null) {
              String[] data=line.split(" ");
              int v=Integer.parseInt(data[0]);
              int w=Integer.parseInt(data[1]);
              this.addEdge(v, w);
          }
           
        }catch(IOException e) {
            throw new GraphException("Could not create a graph!");
        }
       
    }
	public Set<Integer> findMaximalIndependentSet() {
		    Set<Integer> independentSet = new HashSet<>();
		 // list of vertices sorted by degree
		    List<Integer> vertices = new ArrayList<>();
		    for (int i = 0; i < order(); i++) {
		        vertices.add(i);
		    }
		    Collections.sort(vertices, Comparator.comparingInt(this::degree));
		    for (int v : vertices) {
		        boolean isIndependent = true;
		        for (int neighbor : getNeighboursOf(v)) {
		            if (independentSet.contains(neighbor)) {
		                isIndependent = false;
		                break;
		            }
		        }
		        if (isIndependent) {
		            independentSet.add(v);
		        }
			
		    
	}
		    return independentSet;
}
}