
package p3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;



public class ListGraph {

    

    LinkedList<Integer>[] edges;
    private int numV;
    private int numE;

    /**
     * @param V
     */
    public ListGraph(int V) {
        this.numV = V;
        edges = (LinkedList<Integer>[]) new LinkedList[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Integer>();
        }
    }
    
    public int getNumE() {
        return numE;
    }

    public int getNumV() {
        return numV;
    }

    public void addEdge(int from, int to, int distance) {
        if (from >= 0 && from < numV && to >= 0 && to < numV) {
            edges[from].add(to);
            edges[from].add(distance);
            edges[to].add(from);
            
            edges[to].add(distance);
            numE++;
        } else {
            System.out.println("Vertex out of bounds!");

        }
    }

		public void removeEdge(int from, int to) {
        if (edges[from].contains(to)) {
            edges[from].remove(to);
			edges[to].remove(from);

        } else {
            System.out.println("Edge not found!");
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < numV; i++) {
            sb.append("City" + i + " " + edges[i].toString() + "\n");
        }

        return sb.toString();
    }

    public boolean isAdjacent(int from, int to) {
        return edges[from].contains(to);
    }

    public LinkedList<Integer> neighborsList(int from) {
        return (LinkedList<Integer>) edges[from].clone();
    }
    
    public Integer[] neighborsArray (int from) {
        Integer[] ar = new Integer[edges[from].size()];
        edges[from].toArray(ar);
        return ar;    
    }

    public int degree(int from) {
        return edges[from].size();
    }
    
    

    public static void main(String[] args) {
        // TODO code application logic here
        ListGraph g1 = new ListGraph(9);
        g1.addEdge(0, 1,500);
        g1.addEdge(0, 2,250);   
        g1.addEdge(2, 3,400);
        g1.addEdge(2, 4,500);
        g1.addEdge(4, 5,240);
        g1.addEdge(3, 6,96);
        g1.addEdge(4, 6,561);
        g1.addEdge(7, 8,253);
        System.out.println("Printing graph");
        System.out.println(g1);
    }

    public static ListGraph readfromFile(String f) {
        // TODO code application logic here

        try {
            Scanner sc = new Scanner(new File(f));
            int v = sc.nextInt();
            int e = sc.nextInt();
            System.out.println("constructing a graph of " + v + " vertices and "
                    + "" + e + " edges ");
            ListGraph g1 = new ListGraph(v);
            for (int i = 0; i < e; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int v3 = sc.nextInt();
                g1.addEdge(v1, v2 ,v3);
            }
            System.out.println("Loaded " + e + " edges ");
            return g1;

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
