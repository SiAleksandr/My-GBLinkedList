import gb_collections.GbList;
import gb_collections.lists.GbArrayList;
import gb_collections.lists.GbLinkedList;
import gb_collections.lists.util.GbLinkedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        GbLinkedList<String> ll = new GbLinkedList<>();
        ll.add("Index = 0");
        ll.add("Index = 1");
        ll.add("Index = 2");
        ll.add("Index = 3");
        ll.add("Index = 4");
        System.out.println(ll.toString());
    }
}