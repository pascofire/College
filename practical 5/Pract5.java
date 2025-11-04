import java.util.*;
public class Pract5{
    static String lcs(String X,String Y){
        int m=X.length(), n=Y.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++) for(int j=1;j<=n;j++)
            if(X.charAt(i-1)==Y.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
            else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        StringBuilder sb=new StringBuilder();
        int i=m,j=n;
        while(i>0 && j>0){
            if(X.charAt(i-1)==Y.charAt(j-1)){ sb.append(X.charAt(i-1)); i--; j--; }
            else if(dp[i-1][j]>dp[i][j-1]) i--; else j--;
        }
        return sb.reverse().toString();
    }
    static String lrs(String s){
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++) for(int j=1;j<=n;j++)
            if(s.charAt(i-1)==s.charAt(j-1) && i!=j) dp[i][j]=dp[i-1][j-1]+1;
            else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        StringBuilder sb=new StringBuilder();
        int i=n,j=n;
        while(i>0 && j>0){
            if(s.charAt(i-1)==s.charAt(j-1) && i!=j){ sb.append(s.charAt(i-1)); i--; j--; }
            else if(dp[i-1][j]>dp[i][j-1]) i--; else j--;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        String X="AGCCCTAAGGGCTACCTAGCTT";
        String Y="GACAGCCTACAAGCGTTAGCTTG";
        System.out.println("LCS: " + lcs(X,Y));
        String S="AABCBDC";
        System.out.println("LRS: " + lrs(S));
    }
}