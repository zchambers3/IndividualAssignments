/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

/**
 *
 * @author zcham
 */
class DoubleLinkedListNode {
	public int data;
	public DoubleLinkedListNode previous;
	public DoubleLinkedListNode next;
	public boolean visited;
	
	public DoubleLinkedListNode(int _data){
		this.data = _data;
		this.previous = null;
		this.next = null;
		this.visited = false;
	}
	
	public int getData(){
		return this.data;
	}
	
	public DoubleLinkedListNode addTail(DoubleLinkedListNode head, int data){
		DoubleLinkedListNode point = head;
		while(point.next != null){
			point = point.next;
		}
		DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
		point.next = newNode;
		newNode.next = null;
		newNode.previous = point;
		return head;
	}
	
	public DoubleLinkedListNode addHead(DoubleLinkedListNode head, int data){
		DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
		newNode.next = head;
		head.previous = newNode;
		head = newNode;
		return head;
	}
	
	public DoubleLinkedListNode getTail(DoubleLinkedListNode head){
		DoubleLinkedListNode point = head;
		while(point.next != null){
			point = point.next;
		}
		return point;
	}
	
	public int getLehgth(DoubleLinkedListNode head){
		DoubleLinkedListNode point = head;
		int length = 0;
		while (point != null){
			length ++;
			point = point.next;
		}
		return length;
	}
	
	public static void main(String [] args){
		DoubleLinkedListNode head = new DoubleLinkedListNode(1);
		head = head.addTail(head, 2);
		head = head.addTail(head, 3);
		head = head.addHead(head, 0);
		
		DoubleLinkedListNode point = head;
		while(point != null){
			System.out.println(point.getData());
			point = point.next;
		}
		
		System.out.println(head.getLehgth(head));
		
		
		
		
		
	}
}