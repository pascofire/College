public class Pract8{
    static boolean isSafe(int v,int[][] graph,int[] color,int c){
        for(int i=0;i<graph.length;i++) if(graph[v][i]==1 && color[i]==c) return false;
        return true;
    }
    static boolean graphColorUtil(int[][] graph,int m,int[] color,int v){
        if(v==graph.length) return true;
        for(int c=1;c<=m;c++){
            if(isSafe(v,graph,color,c)){
                color[v]=c;
                if(graphColorUtil(graph,m,color,v+1)) return true;
                color[v]=0;
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
        int m=3;
        int[] color=new int[graph.length];
        if(graphColorUtil(graph,m,color,0)){
            for(int i=0;i<color.length;i++) System.out.println("Vertex " + i + " --->  Color " + color[i]);
        } else System.out.println("No coloring possible with " + m + " colors");
    }
}