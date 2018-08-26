import java.util.Stack;

public class LongestPalindrome {
    private static String longestPalindrome(String s){
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1=centerAround(s,i,i);//回文的中心是一个字符
            int len2=centerAround(s,i,i+1);//回文的中心是两个字符
            int len=Math.max(len1,len2);
            if(len>(end-start+1)){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    private static int centerAround(String s, int L, int R){
        while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;R++;
        }
        return R-1-(L+1)+1;
    }

    public static void main(String[] args){
        String s="babad";
        int j=2;int start1=j-3/2;
        String s2="pabccbamn";
        int i=3;int start=i-6/2-1;
        System.out.println(longestPalindrome(s));
    }
    
}
