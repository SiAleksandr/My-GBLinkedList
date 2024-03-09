package gb_collections.lists;

import gb_collections.GbList;
import gb_collections.lists.util.GbLinkedListIterator;
import gb_collections.lists.util.Node;
import gb_collections.lists.util.LinkedListHelp;

import java.util.Iterator;

public class GbLinkedList<E> implements GbList<E>, LinkedListHelp {
    private int size;
    private Node<E> head;

    public GbLinkedList() {
        size = 0;
        head = new Node<>(null, null);
    }

    public Node<E> getLast(Node<E> current) {
        if (current.next == null) return current;
        else return getLast(current.next);
    }

    @Override
    public void add(E value) {
        if (size == 0) head.value = value;
        else {
            Node<E> addition = new Node<>(value, null);
            getLast(head).next = addition;
        }
        size++;
    }

    @Override
    public void add(int index, E value) {
        Node<E> elem = new Node<E>(value, getElem(head, index));
        if (index != 0) getElem(head, index - 1).next = elem;
        else head = elem;
        size += 1;
    }

    @Override
    public E get(int index) {
        if (size == 0) {
            System.out.println("В списке ещё нет ни одного элемента");
            return null;
        } else {
            Node<E> res = getElem(head, index);
            return res.value;
        }
    }

    private void remove(Node<E> current, E value) {
        if (current.value == value) {
            head = current.next;
            size -= 1;
            return;
        }
        if (current.next.value == value) {
            current.next = (current.next).next;
            size -= 1;
            return;
        }
        if ((current.next).next == null) {
            System.out.println("Нет элемента с таким значением");
            return;
        }
        remove(current.next, value);
    }

    @Override
    public void remove(E value) {
        remove(head, value);
    }

    private void removeByIndex(Node<E> current, int index) {
        if (index == 0) {
            head = current.next;
            size -= 1;
            return;
        }
        if (index == 1) {
            current.next = (current.next).next;
            size -= 1;
            return;
        }
        removeByIndex(current.next, index - 1);
    }

    @Override
    public void removeByIndex(int index) {
        removeByIndex(head, index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new GbLinkedListIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        GbLinkedListIterator<E> iterator = new GbLinkedListIterator<E>(this);
        while (iterator.hasNext())
            builder.append(iterator.next()).append(", ");
        if (builder.length() == 1) return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
