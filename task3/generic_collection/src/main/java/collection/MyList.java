package collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;


public interface MyList<T> extends Iterable<T>{
    boolean add(T object);
    boolean add(int index, T object);
    Optional<T> get(int index);
    Optional<T> remove(int index);
    boolean remove(T object);
    int size();
    int indexOf(T object);
    boolean contains(T object);
    Optional<T> set(int index, T object);
    boolean compareList(MyList<T> list);

    @Override
    Iterator<T> iterator();
}
