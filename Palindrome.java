/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import java.util.Stack;

public class Palindrome {
	public DoubleLinkedListNode reverse(DoubleLinkedListNode head){
		DoubleLinkedListNode fromTail = head.getTail(head);
		DoubleLinkedListNode fromHead = head;

		
		while(fromHead!=fromTail){
			if(fromHead.visited == true || fromTail.visited == true){
				break;
			}
			int tmp = fromHead.data;
			fromHead.data = fromTail.data;
			fromTail.data = tmp;
			fromHead.visited = true;
			fromTail.visited = true;
			fromTail = fromTail.previous;
			fromHead = fromHead.next;
		}
		
		return head;
	}
	
	public boolean palindromeReverse(DoubleLinkedListNode head, DoubleLinkedListNode head2){
		DoubleLinkedListNode point = head;
		DoubleLinkedListNode headReverse = this.reverse(head2);
		DoubleLinkedListNode reversePoint = headReverse;
		while(reversePoint != null || point != null){
			if(reversePoint.getData() != point.getData()){
				return false;
			}
			reversePoint = reversePoint.next;
			point = point.next;
		}
		return true;
	}
	
	public boolean palindromeStack(DoubleLinkedListNode head){
		boolean isEven = false;
		int listLength = head.getLehgth(head);
		if(listLength%2 == 0){
			isEven = true;
		}
		int half = listLength/2;
		int index = 0;
		Stack <Integer> stack = new Stack<Integer>();
		DoubleLinkedListNode point = head;
		while(index < half){
			stack.push(point.getData());
			point = point.next;
			index++;
		}
		if(isEven == false){
			point = point.next;
		}
		while(point != null){
			if(point.getData()!=stack.pop()){
				return false;
			}
			point = point.next;
		}
		return true;
	}
	
	public PaliRecurseHelper palindromeRecursive(DoubleLinkedListNode head, int length){
		if(head == null||length == 0){
			return new PaliRecurseHelper(null, true);
		}else if(length == 1){
			return new PaliRecurseHelper(head.next, true);
		}else if(length == 2){
			return new PaliRecurseHelper(head.next.next, head.getData()==head.next.getData());
		}
		
		PaliRecurseHelper res = palindromeRecursive(head.next, length-2);
		if(res.result == false || res.node == null){
			return res;
		}else{
			res.result = head.getData() == res.node.getData();
			res.node = res.node.next;
			return res;
		}
		
	}
	
	public boolean palindromeRecursive(DoubleLinkedListNode head){
		PaliRecurseHelper isPali = palindromeRecursive(head, head.getLehgth(head));
		return isPali.result;
	}
		
	
	
	public static void main(String [] args){
		DoubleLinkedListNode head = new DoubleLinkedListNode(0);
		head = head.addTail(head, 1);
		head = head.addTail(head, 2);
		head = head.addTail(head, 3);
		head = head.addTail(head, 2);
		head = head.addTail(head, 1);
		head = head.addTail(head, 0);
		Palindrome pali = new Palindrome();
		
//		#############First Method
//		DoubleLinkedListNode head2 = new DoubleLinkedListNode(0);
//		head2 = head2.addTail(head2, 1);
//		head2 = head2.addTail(head2, 2);
//		head2 = head2.addTail(head2, 3);
//		head2 = head2.addTail(head2, 2);
//		head2 = head2.addTail(head2, 1);
//		head2 = head2.addTail(head2, 0);
//		
//		

//		if(pali.palindromeReverse(head, head2)==true){
//			System.out.println("The input list is palindrome");
//		}else{
//			System.out.println("The input list is not palindrome");
//		}
		
		
//		############Second Method		
//		if(pali.palindromeStack(head) == true){
//			System.out.println("Yes! The input list is palindrome");
//		}else{
//			System.out.println("No! The input list is not palindrome");
//		}
		

		int length = head.getLehgth(head);
		if(pali.palindromeRecursive(head) == true){
			System.out.println("Yes! The input list is palindrome");
		}else{
			System.out.println("No! The input list is not palindrome");
		}
		
		
	}
}