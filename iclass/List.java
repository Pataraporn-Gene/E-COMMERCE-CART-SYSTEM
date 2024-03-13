package iclass;

public interface List<E> {
	
	public int size();
	
	public boolean isEmpty();
	public boolean contains(Object o);
	
	public Object[] toArray();	
	public void add(Object e);
	public void add(int index , Object e);
	public void remove(Object o);
	
	public void clear();
	public Object get(int index);

	public void remove(int index);
	public int indexOf(Object o);
	public int lastIndexOf(Object o);

	public void set(int index, E element);

	
	
}
