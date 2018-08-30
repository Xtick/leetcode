import java.util.OptionalInt;
import java.util.Stack;

public class ReverseInteger {
    public static int reverse(int x){
        String s=String.valueOf(x);
        boolean isNegative=false;
        if(s.charAt(0)=='-'){
            isNegative=true;
            s=s.substring(1);
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }
        StringBuilder re=new StringBuilder();
        while(!stack.isEmpty()){
            re.append(stack.pop());
        }
        long reInt=Long.valueOf(re.toString());
        if(isNegative){
            reInt=-reInt;
        }
        if(reInt>Integer.MAX_VALUE||reInt<Integer.MIN_VALUE){
            return 0;
        }
        return (int)reInt;
    }
    public static void main(String[] args){
        int x=-1234556546;
        System.out.println(reverse(x));
    }
}
