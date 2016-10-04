package org.mp.sesion03;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class LinkedList<E> extends AbstractList<E> {

	//Properties
	protected Node<E> head = null;
	protected Node<E> tail = null;

	/** Create a default list */
	public LinkedList() {

	}

	/** Create a list from an array of objects */
	public LinkedList(E[] objects) {
		for (int i=0; i<objects.length; i++)
			add (objects[i]);
	}

	/** Return the head element in the list */
	public E getFirst() {
		if (head == null)
			return null;
		return head.element;
	}

	/** Return the last element in the list */
	public E getLast() {
		if (tail == null)
			return null;
		return tail.element;
	}

	/** Add an element to the beginning of the list */
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // the new node is the only node in list
			tail = head;
	}

	/** Add an element to the end of the list */
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new for element e

		if (tail == null) {
			head = tail = newNode; // The new node is the only node in list
		} else {
			tail.next = newNode; // Link the new with the last node
			tail = tail.next; // tail now points to the last node
		}

		size++; // Increase size
	}

	/**
	 * Add a new element at the specified index in this list The index of the
	 * head element is 0
	 */
	public void add(int index, E e) {
		if (index <= 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}

	/**
	 * Remove the head node and return the object that is contained in the
	 * removed node.
	 */
	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp.element;
		}
	}

	/**
	 * Remove the last node and return the object that is contained in the
	 * removed node.
	 */
	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	/**
	 * Remove the element at the specified position in this list. Return the
	 * element that was removed from the list.
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	@Override /** Override toString() to return elements in the list */
	public String toString() {

		String cadena = "[";
		Node<E> aux = head;
		while (aux != null) {
			cadena = cadena + aux.element;
			if (aux.next != null)
				cadena = cadena + ", ";
			aux = aux.next;
		}
		cadena = cadena + "]";
		return cadena;
	}

	/** Clear the list */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	/** Return true if this list contains the element o */
	public boolean contains(E e) {

		Node aux = head;
		while (aux != null) {
			if (aux.element.equals(e))
				return true;
			aux = aux.next;
		}
		return false;
	}

	/** Return the element from this list at the specified index */
	public E get(int index) {

		if (index < 0)
			return null;
		if (index >= size)
			return null;
		Node<E> aux = head;
		for (int i=0; i<index; i++)
			aux = aux.next;
		return (E)aux.element;
	}

	/**
	 * Return the index of the head matching element in this list. Return -1 if
	 * no match.
	 */
	public int indexOf(E e) {
		Node<E> aux = head;
		int i = 0;
		while (aux != null) {
			if (aux.element.equals(e))
				return i;
			aux = aux.next;
			i++;
		}
		return -1;

	}

	/**
	 * Return the index of the last matching element in this list Return -1 if
	 * no match.
	 */
	public int lastIndexOf(E e) {
		int pos = -1;
		Node<E> aux = head;
		int i = 0;
		while (aux != null) {
			if (aux.element.equals(e))
				pos = i;
			aux = aux.next;
			i++;
		}
		return pos;

	}

	/**
	 * Replace the element at the specified position in this list with the
	 * specified element.
	 */
	public E set(int index, E e) {
		if (index < 0 || index >= size)
			return null;
		int i = 0;
		Node<E> aux = head;
		while (i < index) {
			i++;
			aux = aux.next;
		}
		E elemento = aux.element;
		aux.element = e;
		return elemento;
	}

	@Override
	/** Override iterator() defined in Iterable */
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<E> {
		private Node<E> current = head; // Current index

		@Override
		public boolean hasNext() {
			if (current == null)
				return false;
			return true;
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
			if (current == null)
				return;
			if (current == head) {
				head = head.next;
				if (current == tail)
					tail = null;
			}
			else {
				Node<E> aux = head;
				while (aux.next != current) {
					aux = aux.next;
				}
				aux.next = current.next;
				if (current == tail)
					tail = aux;
			}
			size--;
		}
	}

	// This class is only used in LinkedList, so it is private.
	// This class does not need to access any
	// instance members of LinkedList, so it is defined static.
	public static class Node<E> {
		// Properties
				public E element;
				public Node next;

				public Node(E element) {
					this.element = element;
					next = null;
				}
	}
}
