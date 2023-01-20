
/*
Написать свой класс MyQueue как аналог классу Queue, который будет работать по принципу FIFO (first-in-first-out).

Можно делать либо с помощью Node либо с помощью массива.

Методы

add(Object value) добавляет элемент в конец
clear() очищает коллекцию
size() возвращает размер коллекции
peek() возвращает первый элемент в очереди (FIFO)
poll() возвращает первый элемент в очереди и удаляет его из коллекции
 */
public class MyQueue<T> {
    private Object[] elements = new Object[10];
    private int length = 0;
    public void add(Object value){
        if (length == elements.length){
            Object[] tmp = new Object[elements.length + elements.length/2];
            System.arraycopy(elements, 0, tmp, 0, length);
            elements = new Object[tmp.length];
            elements = tmp;
        }
        elements[length] = value;
        length++;
    }

    public void clear(){
        elements = new Object[10];
        length = 0;
    }

    public int size() {
        return length;
    }

    public Object peek() {
        return elements[0];
    }

    public Object poll() {
        Object obj = elements[0];
        Object[] tmp = new Object[length];
        System.arraycopy(elements, 1, tmp, 0, length);
        elements = tmp;
        length--;
        return obj;
    }
}
