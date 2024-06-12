package ss10.bai_tap.trien_khai_cac_phuong_thuc_cua_arraylist;

import java.util.Arrays;

public class MyList<E> {


    int size = 0;
    static final int DEFAULT_CAPACITY = 1;
    E[] elements;

    public MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            elements = (E[]) new Object[capacity];
        } else {
            throw new IndexOutOfBoundsException("capacity: " + capacity);
        }
    }

    public boolean add(E o) {
        if (size == elements.length) {
            ensureCapacity(DEFAULT_CAPACITY);
        }
        elements[size] = o;
        size++;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        } else if (size == elements.length) {
            ensureCapacity(DEFAULT_CAPACITY);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > 0) {
            int newSize = elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacitty: " + minCapacity);
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index: " + index);
        } else if (index == size - 1) {
            E temp = elements[index];
            elements[index] = null;
            size--;
            return temp;
        } else {
            E temp = elements[index];
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
            return temp;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (o == elements[i]) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o == elements[i]) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index: " + index);
        } else {
            return elements[index];
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public MyList<E> clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(elements, size);
        v.size = size;
        return v;
    }
}

