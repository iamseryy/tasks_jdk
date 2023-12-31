package collection.impl;

import collection.MyList;

import java.util.*;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public MyArrayList(T[] array){
        if (array == null){
            size = 0;
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            size = array.length;
            elements = Arrays.copyOf(array, this.size);
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T element) {
        if(size == elements.length){
            elements = grow(size + 1);
        }
        elements[size++] = element;
        size = size;
        elements = elements;

        return true;
    }

    @Override
    public boolean add(int index, T t) {
        if(index < 0) return false;

        if(size + 1 >= elements.length){
            elements = grow(size + 1);
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = t;
        size++;

        return true;
    }

    private Object[] grow(int minCapacity){
        return Arrays.copyOf(elements, newCapacity(minCapacity));
    }

    private int newCapacity(int oldCapacity){
        return (oldCapacity * 3) / 2 + 1;
    }

    @Override
    public Optional<T> get(int index) {
        if (index >= 0 && index < size) {
            return Optional.ofNullable((T) elements[index]);
        }
        return Optional.empty();
    }

    @Override
    public Optional<T> remove(int index) {
        if (index >= 0 && index < size) {
            Object obj = get(index);
            shiftToLeft(index);
            return Optional.ofNullable((T) obj);
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(T t) {
        if (size == 0) return false;

        boolean removingSuccessful = false;
        for (int i = 0; i < size; i++){
            if ((elements[i] != null && elements[i].equals(t) || (elements[i] == null && t == null))){
                shiftToLeft(i);
                removingSuccessful = true;
            }
        }

        return removingSuccessful;
    }

    private void shiftToLeft(int indexStart) {
        size--;
        if (size <= 0) {
            return;
        }

        if (size != indexStart) {
            System.arraycopy(elements, indexStart + 1, elements, indexStart, size - indexStart);
        }

        elements[size] = null;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public int indexOf(Object object) {
        return indexOfRange(object, 0, size);
    }

    private int indexOfRange(Object object, int start, int end) {
        Object[] es = elements;
        if (object == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (object.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Optional<T> set(int index, T element) {
        if ((index < size) && (index >= 0)) {
            Object oldElement = elements[index];
            elements[index] = element;
            return Optional.ofNullable((T) oldElement);
        }
        return Optional.empty();
    }

    @Override
    public boolean compareList(MyList<T> list) {
        if(size != list.size()) {
            return false;
        }

        for(int i = 0; i < size; i++) {
            if (!elements[i].equals(list.get(i).orElse(null))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[" + (size > 0 ? elements[0].toString() : ""));
        for(int i = 1; i < size; i++){
            str.append(", " + (elements[i] != null ? elements[i].toString() : "null"));
        }
        str.append("]");
        return str.toString();
    }

    private class MyArrayListIterator implements Iterator<T> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return (T) elements[cursor++];
        }
    }
}
