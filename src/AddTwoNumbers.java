/**
 * @author niujiaxing
 * @date 2018/8/25 20:20
 * -------------------------------
 * Desc: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * @since 1.0
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * <p>
     * 不合适，因为输入的链表值很可能接近无穷大，会导致溢出问题
     * <p>
     *
     * @author niujiaxing
     * @date 2018/8/25 20:20
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum1 = 0, sum2 = 0;
        int i = 0, j = 0;
        ListNode p = l1;
        while (p != null) {
            sum1 += p.val * (Math.pow(10, i++));
            p = p.next;
        }
        p = l2;
        while (p != null) {
            sum2 += p.val * (Math.pow(10, j++));
            p = p.next;
        }
        long sum = sum1 + sum2;
        p = new ListNode(-1);
        int length = String.valueOf(sum).length();
        ListNode point = p;
        for (int m = 0; m < length; m++) {
            p.next = new ListNode((int) (sum % 10));
            sum = sum / 10;
            p = p.next;
        }
        return point.next;
    }

    /**
     * <p>
     * 写的有点sb
     * <p>
     *
     * @author niujiaxing
     * @date 2018/8/25 20:21
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode point = temp;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            int t = l1.val + l2.val;
            if (flag) {
                t += 1;
                flag = false;
            }
            int target = t / 10;
            if (target != 0) {
                t = t % 10;
                flag = true;
            }
            temp.next = new ListNode(t);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int t = l1.val;
            if (flag) {
                t += 1;
                flag = false;
            }
            int target = t / 10;
            if (target != 0) {
                t = t % 10;
                flag = true;
            }
            temp.next = new ListNode(t);
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            int t = l2.val;
            if (flag) {
                t += 1;
                flag = false;
            }
            int target = t / 10;
            if (target != 0) {
                t = t % 10;
                flag = true;
            }
            temp.next = new ListNode(t);
            l2 = l2.next;
            temp = temp.next;
        }
        if (flag) {
            temp.next = new ListNode(1);
        }
        return point.next;
    }

    /**
     * @date 2018/8/25
     * @description 查看答案后写的
     */
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        int step = 0;
        ListNode temp = new ListNode(-1);
        ListNode p = temp;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y;
            sum += step;
            step = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if(step!=0){
                temp.next=new ListNode(step);
            }

        }
        return p.next;
    }

    public static void main(String[] args) {
       /* ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);*/
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode p = l2;
        for (int i = 0; i < 9; i++) {
            l2.next = new ListNode(9);
            l2 = l2.next;
        }
        // System.out.println(addTwoNumbers(l1, p));
        addTwoNumbers2(l1, p);
        //System.out.println(1/10);
    }
}
