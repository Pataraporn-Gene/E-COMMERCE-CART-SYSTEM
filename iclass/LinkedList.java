
package iclass;

public class LinkedList<E> implements List<Object> {
	
	private ListNode<E> front;
	
	public LinkedList() {
		front = null;
	}
	
	public LinkedList(ListNode<E> e) {
		front = e;
	}
	
	public LinkedList(E e) {
		front = new ListNode<E>(e);
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int t = 0;
		for(ListNode<E> node = front; node!=null; node = node.getNext()) {
			t++;
		}
		return t;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front==null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for(ListNode<E> node =front ; node!=null;node =node.getNext() ) {
			if(node.getItem()==o) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] arr = new Object[this.size()];
		int i =0;
		for(ListNode<E> node = front; node != null;node = node.getNext()) {
			arr[i++] = node.getItem();
		}
		return arr;
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public void add(Object e) {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			front = new ListNode<E>((E) e);
		}else {
			ListNode<E> last = front;
			while(last.getNext()!=null) {
				last = last.getNext();
			}
			last.setNext(new ListNode<E>((E)e));
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, Object e) {
		// TODO Auto-generated method stub
		this.rangeCheck(index);
		ListNode<E> node = front;
		for(int i=0; i<index-1;i++) {
			node = node.getNext();
		}
		ListNode<E> n = new ListNode<E>((E)e);
		n.setNext(node.getNext());
		node.setNext(n);
	}

	@Override
	public void remove(Object o) {
		// TODO Auto-generated method stub
		if(!this.isEmpty()) {
			int n =0;
			boolean found = false;
			for(ListNode<E> node = front; node != null; node = node.getNext()) {
				n++;
				if(node.getItem().equals(o)&&node != null) {
					found = true;
					break;
				}
			}
			if(found) {
				if(n >1 &&  n<= this.size()) {
					ListNode<E> node = front;
					for(int i =0; i<n-2;i++) {
						node = node.getNext();
					}
					node.setNext(node.getNext().getNext());					
				}else if (n == 1) {
					front = front.getNext();
				}
			}	
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.front = null;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		ListNode<E> node = front;
		for(int i=0; i<index;i++) {
			node = node.getNext();
		}
		return node.getItem();
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		this.rangeCheck(index);
		ListNode<E> node = front;
		for(int i=0; i<index-1;i++) {
			node = node.getNext();
		}
		if(node.getNext()==null) {
			front = null;
		}else {
			node.setNext(node.getNext().getNext());

		}
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		
		ListNode<E> node  = front;
		for(int i =0; i< this.size();i++) {
			if(node.getItem().equals(o)) {
				return i;
			}
			node = node.getNext();
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		int index = -1;
		ListNode<E> node  = front;
		for(int i =0; i< this.size();i++) {
			if(node.getItem().equals(o)) {
				index = i;
			}
			node = node.getNext();
		}
		return index;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		ListNode<E> node = front;
		for(int i=0; i<index;i++) {
			node = node.getNext();
		}
		node.setItem((E) element);
	}
	
	private void rangeCheck(int index) {
		if (index > this.size() || index < 0)
			throw new IndexOutOfBoundsException("Index out of bounds");
	}
	
	public String toString() {
		String l = "";
		for(ListNode<E> node = front; node != null; node = node.getNext()) {
			l+=node.getItem() +"\n";
		}
		return l;
		
	}

}
