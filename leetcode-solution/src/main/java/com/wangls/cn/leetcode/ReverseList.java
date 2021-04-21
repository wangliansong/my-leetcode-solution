package com.wangls.cn.leetcode;


/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4,a);
        ListNode c = new ListNode(3,b);
        ListNode d = new ListNode(2,c);
        ListNode e = new ListNode(1,d);
        ListNode reverseE = reverseList2(e);
        System.out.println(e);
        System.out.println(reverseE);

    }


    /**
     * 迭代解法：
     * 1、head就是链表的头，知道了头，就可以遍历这个链表
     * 2、反转思路：把指针反过来就行了，也就是说，当前节点的指针(正常是指向下一个节点，一般用next表示)
     *            指向前一个节点，而不是后一个了。然后同时往前移动current和prev这2个指针
     * NOTE：1、把当前节点的next指针指向前一个节点的时候，需要先把当前节点的next指针存到临时变量，不然就丢了
     *      2、拿到链表的头，就拿到了整个链表，这也是为什么我们可以往前移动2个指针，
     *          往前移动，那么prev永远都是前面这个链表的头节点
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        while (current != null ){
            //先把current的next指针保持在临时变量里，不然这个指针就丢失了
            ListNode next = current.next;
            //反转：把当前节点的next指针，指向前一个节点
            current.next = prev;
            //移动2个指针
            prev = current;
            current = next;
        }

        return prev;
    }

    /**
     * 递归法：我们可以把链表拆成一个头结点和一个子链表问题，也就是递归的基本思路
     * NOTE：递归问题，切记脑回路递归，可以把问题理解为，最后一次递归要干什么。
     *  递归结束条件，head为null
     *  思路：我们只需要把head的下一个结点的指针指向head，head指向null就可以了
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode r = reverseList2(head.next);
        //把head的下一个结点的指针指向head
        head.next.next = head;
        //head的next指向指向null
        head.next = null;

        return r;
    }

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            if(next !=null){
                return "val="+this.val + "next="+next.val;
            }else {
                return "val="+this.val;
            }
        }
    }
}
