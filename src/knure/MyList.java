package knure;

import java.util.Iterator;


public interface MyList {
	void add(Transport t);
	int getSize();
	String toString();
	Object[] toArray();
	boolean contains(Transport t);
	boolean removeByItem(Transport t);
	boolean removeByIndex(int index);
	void clear();
	Transport getByIndex(int index);
	Iterator <Transport> iterator();
}
