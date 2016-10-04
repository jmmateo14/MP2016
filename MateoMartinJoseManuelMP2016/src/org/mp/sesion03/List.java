package org.mp.sesion03;

public interface List<E> extends Iterable<E>{

  /** A�ade un nuevo elemento al final de la lista */
  public void add(E e);

  /** A�ade un nuevo elemento en la posici�n especificiada por index en la lista */
  public void add(int index, E e);

  /** Borra todos los elementos de la lista */
  public void clear();

  /** Devuelve true si la lista contiene el elemento e*/
  public boolean contains(E e);

  /** Devuelve el elemento de la lista que est� en la posici�n especificada por index */
  public E get(int index);

  /** Devuelve el �ndice de la primera ocurrencia del elemento e en la lista.
   *  Devuelve -1 si no est�. */
  public int indexOf(E e);

  /** Devuelve true si la lista no tiene elementos */
  public boolean isEmpty();

  /** Devuelve el �ndice de la �ltima ocurrencia del elemento e en la lista.
   *  Devuelve -1 si no est�. */
  public int lastIndexOf(E e);

  /** Borra la primera ocurrencia del elemento e en la lista.
   *  Desplaza la subsecuencia de elementos a la izquierda.
   *  Devuelve true si el elemento se ha borrado. */
  public boolean remove(E e);

  /** Borra el elemento de la posici�n especificada por index de la lista.
   *  Desplaza la subsecuencia de elementos a la izquierda.
   *  Devuelve el elemento que ha sido borrado de la lista. */
  public E remove(int index);

  /** Sustituye el elemento de la posici�n especificada por index en la lista
   *  por el elemento e y devuelve el elemento antiguo */
  public Object set(int index, E e);

  /** Devuelve el n�mero de elementos de la lista */
  public int size();
}
