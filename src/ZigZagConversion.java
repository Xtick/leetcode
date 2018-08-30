import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }
        char[] chars = s.toCharArray();
        int row = 0;
        boolean down = false;
        for (char c : chars) {
            list.get(row).append(c);
            if (row == 0 || row == numRows - 1) {
                down = !down;
            }
            row += down ? 1 : -1;
        }
        StringBuilder re = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            re.append(list.get(j));
        }
        return re.toString();
    }

    public static String func2(String s, int numRows) {
        StringBuilder re = new StringBuilder();
        int cycleLen = numRows - 1 + numRows - 2 + 1;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += cycleLen) {
                if (i == 0 || i == numRows - 1) {
                    re.append(s.charAt(j));
                } else {
                    int largeStep=cycleLen-2*i;
                    re.append(s.charAt(j));
                    if(j+largeStep<s.length()){
                        re.append(s.charAt(j+largeStep));
                    }
                }
            }
        }
        return re.toString();
    }

    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        String result="PINALSIGYAHRPI";
        System.out.println(func2(s,4));
        System.out.println(func2(s, 4).equals(result));
    }
}
