public class Pract7{
    static int V=5;
    static boolean isSafe(int v,int[][] graph,int[] path,int pos){
        if(graph[path[pos-1]][v]==0) return false;
        for(int i=0;i<pos;i++) if(path[i]==v) return false;
        return true;
    }
    static boolean hamCycleUtil(int[][] graph,int[] path,int pos){
        if(pos==V){
            if(graph[path[pos-1]][path[0]]==1) return true;
            else return false;
        }
        for(int v=1;v<V;v++){
            if(isSafe(v,graph,path,pos)){
                path[pos]=v;
                if(hamCycleUtil(graph,path,pos+1)) return true;
                path[pos]=-1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] graph={
            {0,1,1,0,1},
            {1,0,1,1,0},
            {1,1,0,1,0},
            {0,1,1,0,1},
            {1,0,0,1,0}
        };
        int[] path=new int[V];
        for(int i=0;i<V;i++) path[i]=-1;
        path[0]=0;
        if(hamCycleUtil(graph,path,1)){
            System.out.println("Hamiltonian Cycle found:");
            for(int i=0;i<V;i++) System.out.print(path[i] + " ");
            System.out.println(path[0]);
        } else System.out.println("No Hamiltonian Cycle");
    }
}