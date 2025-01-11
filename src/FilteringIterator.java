import java.util.Iterator;
import java.util.function.Predicate;

public class FilteringIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator;
    private final Predicate<T> predicate;
    private T nextElement;
    private boolean hasNextElement;

    public FilteringIterator(Iterator<T> iterator, Predicate<T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        advance();
    }

    private void advance() {
        hasNextElement = false;
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (predicate.test(element)) {
                nextElement = element;
                hasNextElement = true;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return hasNextElement;
    }

    @Override
    public T next() {
        if (!hasNextElement) {
            throw new IllegalStateException("No more elements");
        }
        T result = nextElement;
        advance();
        return result;
    }
}
