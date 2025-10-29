/*
Given a sorted linked list, delete all nodes that have duplicate
numbers, leaving only distinct numbers from the original list.In this 
program, you need to 
(1) read 5 numbers and set them in a linkedlist in order
(2) delete duplicate

Example 1:
input: 1,2,3,3,5
output: head-->1-->2-->3-->5-->null

Example 2:
input: 1,1,1,2,3
output: head-->1-->2-->3-->null

Please complete the following program to fullfil the function.
*/
import java.util.Scanner;

public class homework20_1 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      LinkedList llist = new LinkedList();

      ListNode prev = null;
      for (int i = 0; i < 5; i++) {
         int num = sc.nextInt();
         ListNode newNode = new ListNode(num);
         if (llist.head == null)
            llist.head = newNode;
         else
            prev.next = newNode;
         prev = newNode;
      }

      deleteDuplicates(llist);

      System.out.println(llist);

      sc.close();
   }

   public static void deleteDuplicates(LinkedList llist) {
      if (llist.head == null) return;

      ListNode current = llist.head;
      while (current != null && current.next != null) {
         if (current.value == current.next.value) {
            current.next = current.next.next;
         } else {
            current = current.next;
         }
      }
   }
}

class ListNode {
   int value;
   ListNode next;
   ListNode(int v) { value = v; }
}

class LinkedList {
   ListNode head;
   public String toString() {
      String nodeData = "";
      ListNode ref = head;
      while (ref != null) {
         nodeData += ref.value + "-->";
         ref = ref.next;
      }
      return "head-->" + nodeData + "null";
   }
}
