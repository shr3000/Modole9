/*
Написать свой класс MyStack как аналог классу Stack, который работает по принципу LIFO (last-in-first-out).
Можно делать либо с помощью Node либо с помощью массива.
Методы
        push(Object value) добавляет элемент в конец
        remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        size() возвращает размер коллекции
        peek() возвращает первый элемент в стеке (LIFO)
        pop() возвращает первый элемент в стеке и удаляет его из коллекции
 */
public class MyStack<T> {
    private Object[] elements = new Object[10];
    private int length = 0;
    public void push(Object value){
        if (length == elements.length){
            Object[] tmp = new Object[elements.length + elements.length/2];
            System.arraycopy(elements, 0, tmp, 0, length);
            elements = new Object[tmp.length];
            elements = tmp;
        }
        elements[length] = value;
        length++;
    }
    public void remove(int index) {
        for (int i = index; i < length; i++)
            elements[i] = elements[i+1];
        elements[length] = null;
        length --;
    }
    public void clear() {
        elements = new Object[10];
        length = 0;
    }

    public int size() {
        return length;
    }

    public Object peek() {
        return elements[length];
    }

    public Object pop() {
        Object obj = elements[0];
        length--;
        Object[] tmp = new Object[length];
        System.arraycopy(elements, 0, tmp, 0, length);
        elements = tmp;
        return obj;
    }
}
