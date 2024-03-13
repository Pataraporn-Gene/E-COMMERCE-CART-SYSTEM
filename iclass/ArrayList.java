package iclass;

public class ArrayList<E> implements List<Object> {
	
	//Class attribute
	private Object[] list;
	private int size ;
	private int i ;
	private int capacity = 10;
	
	//constructor 
	public ArrayList(){
		list = new Object [capacity];
		size = 0;
		i = -1;
	}
	
	//to add by get object
	public void add(Object e) {
		if(this.isFull()) { this.stretchedArray(); }
			list[++i] = e;
			size++;	
	}
	
	//to add in that object and the rest will move
	public void add(int index , Object e) {
		this.rangeCheck(index);
		if(isFull()) { this.stretchedArray();}
		Object[] newarr = new Object[capacity];
		size++;
		for(int i = 0; i<size;i++) {
			if(i == index) {
				newarr[i] = e;
			}else if (i > index) {
				newarr[i] = list[i-1];
			}else {
				newarr[i] = list[i];	
			}
		}
		list = newarr;
		i++;
	}
	
	// get object inside List by index
	public Object get(int index) {
		if(this.isEmpty()||index == size) {
			return null;
		}
		rangeCheck(index);
		return list[index];
	}
	
	// to clear all of the items in list
	public void clear() {
		list = null;
		size = 0;
		i = -1;
		capacity = 10;
	}
	
	public boolean contains(Object e) {
		return indexOf(e) >= 0;
	}
	
	
	//If it is full we will set new array to make the capacity larger
	private void stretchedArray() {
		Object[] newarr = new Object[capacity+=10];
		for(int i = 0; i<size;i++) {
			newarr[i] = list[i];
		}
		list = newarr;
	}
	
	// return all arraylist to String
	public String toString() {
		String l = "";
		for (int i =0; i<size;i++) {
			l+=list[i];
			if(i != size-1) {
				l+=", ";
			}
		}
		return l + "";
	}
	
	//check whether it is Empty
	public boolean isEmpty() {
		return size == 0;
	}
	
	//check whether it out of capacity
	private boolean isFull() {
		return size == capacity;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	//to check if they add out of size or less than 0 or not
	private void rangeCheck(int index) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException("Index out of bounds");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return list;
	}


	@Override
	public void remove(Object o) {
		// TODO Auto-generated method stub
		Object[] nlist = new Object[capacity];
		int k = 0;
		for(int i = 0; i<size-1;i++) {
			if(list[i].equals(o)) {
				k++;
			}
			nlist[i] = list[k];
			k++;
		}
		list = nlist;
		size--;
		i--;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		this.rangeCheck(index);
		Object[] nlist = new Object[capacity];
		for(int i=0; i<size;i++) {
			if(i == index) {
				nlist[i] = element;
				continue;
			}
			nlist[i] = list[i];
		}
		list = nlist;
		
	}

	@Override
	public void remove(int index) {
		Object[] nlist = new Object[capacity];
		int k = 0;
		for(int i = 0; i<size-1;i++) {
			if(i == index) {
				k++;
			}
			nlist[i] = list[k];
			k++;
		}
		list = nlist;
		size--;
		i--;
	}

	@Override
	public int indexOf(Object o) {
		for(int i =0;i<size;i++) {
			if(o.equals(list[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		for(int i=0; i< size;i++) {
			if(list[i].equals(o)) {
				index = i;
			}
		}
		return index;
	}
	

}

