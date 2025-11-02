import java.util.List;
import java.util.NoSuchElementException;

public class MyListIterator <T> implements Iterator <T> {
    private List<T> list;
    private int index = 0;

    public MyListIterator(List <T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() throws NoSuchElementException {
        if (!hasNext()) throw new NoSuchElementException("No next element found");
        return list.get(index++);
    }
}
