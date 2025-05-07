import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenNestedListIterator implements Iterator<Integer> {


    public Queue<Integer> queue;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        for (NestedInteger integer: nestedList) {
            buildQueue(integer);
        }
    }

    @Override
    public Integer next() {
       return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }


    private void buildQueue(NestedInteger nestedList){
        if(nestedList.isInteger()){
            queue.add(nestedList.getInteger());
        }else {
            for (NestedInteger integer: nestedList.getList()) {
                buildQueue(integer);
            }
        }

    }


    public interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

}
