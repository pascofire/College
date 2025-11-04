import java.util.*;
class Edge implements Comparable<Edge>{
    int u,v,w;
    Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;}
    public int compareTo(Edge e){return this.w - e.w;}
}
public class Pract2{
    static int find(int[] p,int x){return p[x]==x?x:(p[x]=find(p,p[x]));}
    static void union(int[] p,int[] r,int a,int b){
        a=find(p,a); b=find(p,b);
        if(a==b) return;
        if(r[a]<r[b]) p[a]=b;
        else if(r[b]<r[a]) p[b]=a;
        else {p[b]=a; r[a]++;}
    }
    public static void main(String[] args)throws Exception{
        int n=5;
        int[][] g={
            {0,2,0,6,0},
            {2,0,3,8,5},
            {0,3,0,0,7},
            {6,8,0,0,9},
            {0,5,7,9,0}
        };
        // Kruskal
        ArrayList<Edge> edges=new ArrayList<>();
        for(int i=0;i<n;i++) for(int j=i+1;j<n;j++) if(g[i][j]>0) edges.add(new Edge(i,j,g[i][j]));
        Collections.sort(edges);
        int[] p=new int[n], r=new int[n];
        for(int i=0;i<n;i++) p[i]=i;
        int costK=0;
        System.out.println("Kruskal MST edges:");
        for(Edge e: edges){
            if(find(p,e.u)!=find(p,e.v)){
                union(p,r,e.u,e.v);
                costK+=e.w;
                System.out.println(e.u+" - "+e.v+" : "+e.w);
            }
        }
        System.out.println("Total cost (Kruskal): "+costK);
        // Prim's
        boolean[] used=new boolean[n];
        int[] key=new int[n];
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0;
        int[] parent=new int[n];
        parent[0]=-1;
        int costP=0;
        for(int cnt=0;cnt<n-1;cnt++){
            int u=-1,min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++) if(!used[i] && key[i]<min){min=key[i]; u=i;}
            used[u]=true;
            if(parent[u]!=-1){ System.out.println(parent[u]+" - "+u+" : "+g[parent[u]][u]); costP+=g[parent[u]][u]; }
            for(int v=0;v<n;v++) if(g[u][v]>0 && !used[v] && g[u][v]<key[v]){ key[v]=g[u][v]; parent[v]=u; }
        }
        System.out.println("Total cost (Prim): "+costP);
    }
}