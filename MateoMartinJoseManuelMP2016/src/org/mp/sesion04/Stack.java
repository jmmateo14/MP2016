package org.mp.sesion04;
public class Stack<E> {
  private org.mp.sesion03.ArrayList<E>
     lista = new org.mp.sesion03.ArrayList<E>();

  public int getSize() {
    return lista.size();
  }

  public E peek() {
    return lista.get(getSize() - 1);
  }

  public void push(E o) {
    lista.add(o);
  }

  public E pop() {
    E o = lista.get(getSize() - 1);
    lista.remove(getSize() - 1);
    return o;
  }

  public boolean isEmpty() {
    return lista.isEmpty();
  }

  @Override
  public String toString() {
	return "Pila: " + lista.toString();
  }
}
