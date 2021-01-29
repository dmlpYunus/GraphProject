/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

/**
 *
 * @author btek
 */
public class ConnectedComponents {
    private boolean marked[];
    private int count;
    private int[] id;
    
    public ConnectedComponents(ListGraph g){
        marked = new boolean[g.getNumV()];
        count = 0; 
        id  = new int[g.getNumV()];
        for(int v = 0; v < g.getNumV(); v++){
            if(!marked[v]){
                dfs(g,v);
                count++;
            }             
        }
    }
    
    public void dfs(ListGraph g, int v){
        marked[v] = true;
        id[v] = count;
        Integer[] a = (Integer[]) g.neighborsArray(v);
        for(int i = 0; i < a.length; i++){
            if(!marked[v]){
                dfs(g,v);
            }
        }

    }

    public void setMarked(boolean[] marked) {
        this.marked = marked;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    public boolean[] getMarked() {
        return marked;
    }

    public int getCount() {
        return count;
    }

    public int[] getId() {
        return id;
    }
    
    
           
}
