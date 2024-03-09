package gb_collections.lists.util;

public interface LinkedListHelp<E> {
    default Node<E> getElem (Node<E> current, int index){
        if (index == 0) return current;
        else return getElem(current.next, index - 1);
    }
}
