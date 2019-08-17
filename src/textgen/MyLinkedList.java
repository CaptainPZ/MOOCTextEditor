package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}
		LLNode<E> newElm = new LLNode<E>(element, tail.prev);
		size++;
		return false;
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.
		if(index < 0 || index > this.size-1){
			throw new IndexOutOfBoundsException();
			//return null;
		}
		LLNode<E> curr = head;
		int counter = 0;
		while(curr.next != tail){
			if(counter == index){
				E elm = curr.next.data;
				return elm;
			}
			curr = curr.next;
			counter++;
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element )
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}

		if(index < 0 || (index > this.size)  ){
			throw new IndexOutOfBoundsException();
		}
		
		// still applicable to add new element
//		if(index == this.size){
//			this.add(element);
//			return;
//		}

		LLNode<E> curr = head;
		int counter = 0;
		// super important, cant say curr.next != tail
		while(curr.next != null){
			if(counter == index){
				LLNode<E> newElm = new LLNode<E>(element, curr);
			}
			curr = curr.next;
			counter++;
		}
		size++;

	}


	/** Return the size of the list */
	public int size()
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	public E remove(int index)
	{
		// TODO: Implement this method
		if(index < 0 || index > this.size-1){
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> curr = head;
		int counter = 0;
		// super important, cant say curr.next != tail
		while(curr.next != null){
			if(counter == index){
				E returnValue = curr.next.data;
				curr.next.next.prev = curr;
				curr.next = curr.next.next;
				size--;
				return returnValue;
			}
			curr = curr.next;
			counter++;
		}
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		// TODO: Implement this method

		if(element == null) {
			throw new NullPointerException();
		}		
		
		if(index < 0 || index > this.size-1){
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> curr = head;
		E returnResult;
		int counter = 0;
		// super important, cant say curr.next != tail
		while(curr.next != null){
			if(counter == index){
				returnResult = curr.next.data;
				curr.next.data = element;
				return returnResult;
			}
			curr = curr.next;
			counter++;
		}
		return null;
	}


	public String toString() {

		LLNode<E> curr = head;
		StringBuilder results = new StringBuilder("{");
		while(curr.next != tail) {
			results.append(curr.next.data + ", ");
		curr = curr.next;
		}

		results.delete(results.length()-2, results.length());
		results.append("}");
		return results.toString();
	}

	public String toStringReverse() {

		LLNode<E> curr = tail;
		StringBuilder results = new StringBuilder("{");
		while(curr.prev != head) {
			results.append(curr.prev.data + ", ");
		curr = curr.prev;
		}

		results.delete(results.length()-2, results.length());
		results.append("}");
		return results.toString();
	}


}

class LLNode<E>
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode(){
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E theData)
	{
		this.data = theData;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E theData, LLNode<E> prevNode) {
		this(theData);
		this.next = prevNode.next;
		this.prev = this.next.prev;
		this.next.prev = this;
		this.prev.next = this;
	}

}
