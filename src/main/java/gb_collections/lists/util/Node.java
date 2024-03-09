package gb_collections.lists.util;

public class Node<E> {
    public E value;
    public Node<E> next;
    public Node(E valie, Node next) {
        this.value = valie;
        this.next = next;
    }
}
