/*
Написать свой класс MyLinkedList как аналог классу LinkedList.
Нельзя использовать массив. Каждый элемент должен быть отдельным объектом-посредником(Node - нода) который хранит ссылку
на предыдущий и следующий элемент коллекции (двусвязный список).
Методы
+ add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
+ clear() очищает коллекцию
+ size() возвращает размер коллекции
+ get(int index) возвращает элемент под индексом
 */

public class MyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public MyLinkedList() {
        head = new Node<T>(null);
        tail = new Node<T>(null,head);
    }

    //clear() очищает коллекцию
    public MyLinkedList<T> clear(){
        return new MyLinkedList<>();
    }

    //get(int index) возвращает элемент под индексом
    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head.next;
        int count = 0;
        while(node != tail && count < index) {
            node = node.next;
            count++;
        }
        return node.data;
    }

    //size() возвращает размер коллекции
    public int size() {
        return size;
    }

    public void add(int index, T element ) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(element == null) {
            throw new NullPointerException();
        }
        Node<T> curr = getNode(index);
        new Node<T>(element, curr.prev);
        size++;
    }
    //add(Object value) добавляет элемент в конец
    public void add(T element) {
        this.add(this.size(), element);
    }
   // remove(int index) удаляет элемент под индексом
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is invalid. List size is " + size);
        }
        Node<T> node = getNode(index);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;

    }
    private Node<T> getNode(int index) {
        Node<T> node = head.next;
        int count = 0;
        while(node != tail && count < index) {
            node = node.next;
            count++;
        }
        return node;
    }
    class Node<T> {
        Node<T> prev;
        Node<T> next;
        T data;

        public Node(T e, Node<T> prevNode) {
            this(e);
            if(prevNode != null)
            {
                this.next = prevNode.next;
                if(this.next!=null) {
                    (this.next).prev = this;
                }
                prevNode.next = this;
                this.prev = prevNode;
            }
        }

        public Node(T e) {
            this.data = e;
            this.prev = null;
            this.next = null;
        }

    }
}

