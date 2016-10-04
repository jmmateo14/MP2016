package org.mp.sesion04;

import org.mp.sesion03.LinkedList;


public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E> {
	public SortedLinkedList() {
		super();
	}

	public SortedLinkedList(Comparable<E>[] objects) {
		super();
		for (int i = 0; i < objects.length; i++) {
			addSorted(objects[i]);
		}
	}


	public void addFirst(E o) {
		throw new UnsupportedOperationException("No garantiza orden");
	}

	public void addLast(E o) {
		throw new UnsupportedOperationException("No garantiza orden");
	}

	public E set(int index, E o) {
		throw new UnsupportedOperationException("No garantiza orden");
	}

	public void addSorted(Comparable<E> e) {
		Node<E> aux, current, nuevo;
		boolean encon;

		current = head;
		aux = null;
		encon = false;
		while (current != null && !encon) {
			if (e.compareTo(current.element) < 0)
				encon = true;
			else {
				aux = current;
				current = current.next;
			}
		}
		nuevo = new Node<E>((E)e);
		nuevo.next = current;
		if (current == head)
			head = nuevo;
		else
			aux.next = nuevo;
		if (tail == null)
			tail = nuevo;
		size++;
	}



	public String toString() {
		return "Lista ordenada: " + super.toString();
	}
}
