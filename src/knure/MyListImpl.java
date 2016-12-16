package knure;
import java.util.Arrays;
import java.util.Iterator;

public class MyListImpl implements MyList, Iterable <Transport> {

	class Node{
		Node next = null;
		Node previous = null;
		Transport item;
	}
	
	Node first;
	Node last;
	private int size = 0;

	public void add(Transport t) {
		Node node = new Node();
		if(first == null){
			first = node;
			last = node;
			first.item = t;
			size++;
		}
		else{
			last.next = node;
			node.previous = last;
			last = node;
			last.item = t;
			size++;
		}
		
	}
	
	public void addByIndex(Transport t, int index){
		Node node = new Node();
		if(index == 1){
			first.previous = node;
			node.next = first;
			first = node;
			first.item = t;
			size++;
		}
		if(index == size + 1){
			add(t);
		}
		if(index == size){
			Node temp = new Node();
			last.previous.next = temp;
			temp.previous = last.previous;
			temp.next = last;
			last.previous = temp;
			last = temp.next;
			temp.item = t;
			size++;
		}
		else{
			node = first;
			for(int i = 0; i < index - 1; i++){
				node = node.next;
			}
			Node temp = new Node();
			node.previous.next = temp;
			temp.previous = node.previous;
			node.next.previous = temp;
			temp.next = node;
			node = node.next;
			temp.item = t;
			size++;
		}
			
	}
	
	public Transport getByIndex(int index) {
		if (first == null || index < 1 || index > size){
			System.out.println("List is empty!");
			return null;
		}
		Node node = new Node();
		node = first;
		for(int i = 0; i < index - 1; i++){
			node = node.next;
		}
		return node.item;
	}

	public void clear() {
		if (first == null){
			System.out.println("List is empty!");
		}
		for(int i = 0; i < size; i++){
			removeByIndex(i + 1);
			size --;
		}
		first = null;
		last = null;
	}

	public boolean removeByIndex(int index) {
		if (first == null){
			System.out.println("List is empty!");
			return false;
		}
		if( index > size || index < 1){
			System.out.println("Wrong index!");
			return false;
		}
		Node node = new Node();
		node = first;
		for(int i = 0; i < size; i++){
			if(i == index - 1){
				if(node == first && node == last){
					first = null;
					last = null;
					node.item = null;
					size = 0;
					return true;
				}
				if(node == first){
					first = node.next;
					node.next = null;
					node.item = null;
					size--;
					return true;
				}
				if(node == last){
					last = node.previous;
					node.next = null;
					node.previous = null;
					node.item = null;
					size--;
					return true;
				}
				else{
					node.next.previous = node.previous;
					node.previous.next = node.next;
					node.next = null;
					node.previous = null;
					node.item = null;
					size--;
					return true;
				}
			}
			node = node.next;
		}
		return false;
	}
	
	public boolean removeByItem(Transport t) {
		if (first == null){
			System.out.println("List is empty!");
			return false;
		}
		Node node = new Node();
		node = first;
		int index = -1;
		for(int i = 0; i < size; i++){
			if(node.item.equals(t)){
				index = i;
				removeByIndex(index + 1);
				return true;
			}
			node = node.next;
		}
		if(index == -1){
			System.out.println("Item is absent in list!");
			return false;
		}
		return false;
	}

	public Object[] toArray() {
		if (first == null){
			System.out.println("List is empty!");
			return null;
		}
		Object t[] = new Object[size];
		Node node = new Node();
		node = first;
		for(int i = 0; i < size; i++){
			t[i] = node.item;
			node = node.next;
		}
		return t;
	}

	public int getSize() {
		return size;
	}

	public boolean contains(Transport t) {
		if (first == null){
			System.out.println("List is empty!");
			return false;
		}
		Node node = new Node();
		node = first;
		for(int i = 0; i < size; i++){
			if(node.item.equals(t)){
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public String toString(){
		if (first == null){
			return "Elements list: list is empty!";
		}
		String s[] = new String[size];
		for(int i = 0; i < size; i++){
			s[i] = getByIndex(i + 1).toString() +'\n';
		}
		return "Elements list:" + '\n' + Arrays.toString(s) ;
	}
	
	class TransportIterator implements Iterator<Transport>{

		Node node = new Node();
		int current;
		boolean calledNext = false;
		boolean removed = false;
		
		TransportIterator(){
			current = 0;
		}
		
		public boolean hasNext() {
			if(first == null) return false;
			else return current < size;
		}

		public Transport next() {
			if(hasNext() && current == 0){
				removed = false;
				calledNext = true;
				current++;
				node = first;
				return node.item; 
			}
			if(hasNext()){
				removed = false;
				calledNext = true;
				node = node.next;
				current++;
				return node.item; 
			}
			return null;
		}
		
		public void remove() {
			if(current == 0 || removed || !calledNext){
				System.out.println("Error! List is empty or method 'remove' was called!");
				return;
			}
			if(current >= 1 && current <= size){
				removeByIndex(current);
				node = node.next;
				current --;
				removed = true;
			}
		}
		
	}
	
	public Iterator<Transport> iterator() {
		return new TransportIterator();
	}

}
