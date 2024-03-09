package gb_collections.lists.util;
import gb_collections.lists.GbLinkedList;

import java.util.Iterator;

public class GbLinkedListIterator<E> implements Iterator<E>, LinkedListHelp {
    private GbLinkedList<E> target;
    private int index;
    public GbLinkedListIterator(GbLinkedList<E> target){
        this.target = target;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < target.size()) return true;
        else return false;
    }

    @Override
    public E next() {
        return target.get(index++);
    }
}
