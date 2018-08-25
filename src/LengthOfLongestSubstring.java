import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength=0,pointer=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                pointer=Math.max(pointer,map.get(s.charAt(i))+1);
            }
            maxLength=Math.max(maxLength,i-pointer+1);
            map.put(s.charAt(i),i);//如果不存在重复元素，则放入map中进行记录
        }
        return maxLength;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        System.out.println("输入字符串为:"+s);
        System.out.println(lengthOfLongestSubstring(s));

    }
}
