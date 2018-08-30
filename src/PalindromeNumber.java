import java.util.Stack;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        if(s.charAt(0)=='-'){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        long l=Long.valueOf(sb.toString());
        return l==x;
    }

    public static void main(String[] args){
        int a=1221;
        System.out.println(isPalindrome(a));
    }
}
