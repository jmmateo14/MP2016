package org.mp.sesion03;


public class ArrayList<E> extends AbstractList<E> {

  private static final int CAPACIDAD_INICIAL = 16;
  private E[] data = (E[])new Object[CAPACIDAD_INICIAL];

  /** Create a default list */
  public ArrayList() {
  }

  /** Create a list from an array of objects */
  public ArrayList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]); // Warning: don’t use super(objects)!
  }

  @Override /** Add a new element at the specified index */
  public void add(int index, E e) {
	  if(data.length == size())
	  ensureCapacity(size() * 2 + 1);

    // Move the elements to the right after the specified index
    for (int i = size - 1; i >= index; i--)
      data[i + 1] = data[i];

    // Insert new element to data[index]
    data[index] = e;

    // Increase size by 1
    size++;
  }

  /** Create a new larger array, double the current size + 1 */
  private void ensureCapacity(int nuevaCapacidad) {
	  if(nuevaCapacidad < size) return;
	  E[] temp = data;
	  data = (E []) new Object[nuevaCapacidad];
	  for(int i = 0; i < size(); i++)
		  data[i] = temp[i];
  }

  @Override /** Clear the list */
  public void clear() {
	  size = 0;
	  ensureCapacity(CAPACIDAD_INICIAL);
  }

  @Override /** Return true if this list contains the element */
  public boolean contains(Object o) {
	  for (int i=0; i<size(); i++) {
	      E e = data[i];
	      if ( (o==null) ? e==null : o.equals(e) )
		return true;
	    }
	    return false;
  }

  @Override /** Return the element at the specified index */
  public E get(int index) {
    checkIndex(index);
    return data[index];
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Indice: " + index + ", Tamaño: " + size);
  }

  @Override /** Return the index of the first matching element
   *  in this list. Return -1 if no match. */
  public int indexOf(E e) {
	  for (int i = 0; i < size; i++)
	      if (e.equals(data[i])) return i;

	    return -1;
  }

  @Override /** Return the index of the last matching element
   *  in this list. Return -1 if no match. */
  public int lastIndexOf(E e) {
	  for (int i = size - 1; i >= 0; i--)
	      if (e.equals(data[i])) return i;

	    return -1;
  }

  @Override /** Remove the element at the specified position
   *  in this list. Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index) {
	  if(index >= size || index < 0)
		  throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
	  E removeElement = data[index];
	  for(int i = index; i < size()-1; i++)
		  data[i] = data[i+1];
	  size--;
    return removeElement;
  }

  @Override /** Replace the element at the specified position
   *  in this list with the specified element. */
  public E set(int index, E e) {
    checkIndex(index);
    E antiguo = data[index];
    data[index] = e;
    return antiguo;
  }

  @Override
  public String toString() {
    StringBuilder resultado = new StringBuilder("[");

    for (int i = 0; i < size; i++) {
      resultado.append(data[i]);
      if (i < size - 1) resultado.append(", ");
    }

    return resultado.toString() + "]";
  }

  /** Trims the capacity to current size */
  public void trimToSize() {

  }

  @Override /** Override iterator() defined in Iterable */
  public java.util.Iterator<E> iterator() {
	  return new ArrayListIterator();  }

	private class ArrayListIterator implements java.util.Iterator<E> {
		private int current = 0;
		@Override
		public boolean hasNext() {
			return (current < size);
		}

		@Override
		public E next() {
			 return data[current++];
		}

		@Override
		public void remove() {
			ArrayList.this.remove(current);
		}

	}


}