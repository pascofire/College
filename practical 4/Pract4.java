public class Pract4{
    static int maxCrossing(int[] a,int l,int m,int r){
        int sum=0,left=Integer.MIN_VALUE;
        for(int i=m;i>=l;i--){ sum+=a[i]; if(sum>left) left=sum; }
        sum=0; int right=Integer.MIN_VALUE;
        for(int i=m+1;i<=r;i++){ sum+=a[i]; if(sum>right) right=sum; }
        return left+right;
    }
    static int maxSub(int[] a,int l,int r){
        if(l==r) return a[l];
        int m=(l+r)/2;
        int left=maxSub(a,l,m);
        int right=maxSub(a,m+1,r);
        int cross=maxCrossing(a,l,m,r);
        return Math.max(Math.max(left,right),cross);
    }
    public static void main(String[] args){
        int[] resources={2,1,3,4};
        System.out.println("Max subarray sum: " + maxSub(resources,0,resources.length-1));
    }
}