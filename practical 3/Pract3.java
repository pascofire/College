import java.util.*;
class Item{int w; int v; Item(int w,int v){this.w=w;this.v=v;}}
public class Pract3{
    public static void fractionalKnapsack(int[] w,int[] v,int capacity){
        int n=w.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++) idx[i]=i;
        Arrays.sort(idx,(a,b)-> Double.compare((double)v[b]/w[b],(double)v[a]/w[a]));
        double total=0; int cap=capacity;
        System.out.println("Fractional Knapsack selection:"); 
        for(int i: idx){
            if(cap==0) break;
            if(w[i]<=cap){ cap-=w[i]; total+=v[i]; System.out.println("Take full item " + i); }
            else { double frac=(double)cap/w[i]; total+=v[i]*frac; System.out.println("Take fraction " + frac + " of item " + i); cap=0; }
        }
        System.out.println("Total profit: " + total);
    }
    public static void activitySelection(int[] s,int[] f){
        int n=s.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++) idx[i]=i;
        Arrays.sort(idx, (a,b)-> Integer.compare(f[a], f[b]));
        System.out.println("Selected activities:"); int last=-1;
        for(int i: idx){
            if(s[i]>last){ System.out.println("Activity " + i + " ("+s[i]+","+f[i]+")"); last=f[i]; }
        }
    }
    public static void main(String[] args)throws Exception{
        int[] weights={7,30,22,80,94};
        int[] profits={360,59,130,431,67};
        fractionalKnapsack(weights,profits,850);
        int[] s={1,3,0,5,3,5,6,8,8,2,12};
        int[] f={4,5,6,7,9,9,10,11,12,14,16};
        activitySelection(s,f);
    }
}