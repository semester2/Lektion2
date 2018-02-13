package dk.dtu.compute.se.pisd.list;

/**
 * A template for implementing a {@see dk.dtu.compute.se.pisd.list.List}
 * by using arrays. This is supposed to be implemented by
 * the students as a task of assignment 2 of the course. Note that
 * since Java arrays cannot be extended dynamically, the array must
 * be replaced at some points by a larger array. The {@see #sort()} method
 * can be implemented by using the bubble sort algorithm.
 * 
 * @author Ekkart Kindler, ekki@dtu.dk
 *
 */
public class ArrayList implements List {
	
	Integer[] array = new Integer[10];
	int size = 0;
	
	@Override
	public void clear() {
		Integer[] tempArray = new Integer[10];
		array = tempArray;
	}

	@Override
	public void add(int pos, Integer value) {
		
		if(pos > size) {
			pos = size;
		} else if(pos < 0) {
			pos = 0;
		}
		
		//If array is full, we make it twice the size
		if(size >= array.length) {
			Integer[] tempArray = new Integer[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				tempArray[i] = array[i];
			}
			array = tempArray;
		}
		
		for(int i = size; i > pos; i--) {
			array[i] = array[i - 1];
		}
		size++;
		array[pos] = value;
	}

	@Override
	public Integer get(int pos) {
		if(pos >= 0 && pos < size) {
			return array[pos];
		} else {
			return null;
		}
	}

	@Override
	public Integer remove(int pos) {
		if(pos < 0) {
			pos = 0;
		} else if(pos >= size-1) {
			pos = size -1;
		}
		
		Integer result = array[pos];
		
		for (int i = pos +1; i < size; i++) {
			array[i - 1] = array[i];
		}
		array[size] = null;
		size--;
		
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void sort() {
		boolean swapped;
		for (int i = 0; i < size; i++) {
			swapped = false;
			for (int j = 0; j < size - 1 - i; j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
				if(swapped == false) {
					return;
				}
			}
		}
	}

}
