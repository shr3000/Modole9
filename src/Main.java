import javax.swing.plaf.multi.MultiTableHeaderUI;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(10);
        myArrayList.add(25);
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 12; i ++) {
            queue.add(i);
        }
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());

        MyLinkedList <String> linkedList = new MyLinkedList<>();
        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        linkedList.remove(0);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "Onew");
        map.put(1, "2new");
        map.put(1, "3new");
        map.put(2, "new");
        System.out.println(map.size());
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        map.put(3, "4new");
        map.put(4, "5new");
        map.put(5, "6new");
        System.out.println(map.size());
        System.out.println(map.get(4));
        Map<String, String> map1 = new HashMap<>();
        map1.hashCode();


    }
}