
/*
Написать свой класс MyHashMap как аналог классу HashMap.
Нужно делать с помощью односвязной Node.
Не может хранить две ноды с одинаковых ключами одновременно.
Методы
+put(Object key, Object value) добавляет пару ключ + значение
+remove(Object key) удаляет пару по ключу
+clear() очищает коллекцию
+size() возвращает размер коллекции
+ get(Object key) возвращает значение(Object value) по ключу
 */
public class MyHashMap<K, V>{
    private static final int DEFAULT_CAPACITY = 3; //начальна емність
    private int size = 0;

    Node[] table = new Node[DEFAULT_CAPACITY]; //створюю масив з 10 вузлів
//size() возвращает размер коллекции
    public int size() {
        return size;
    }
    //get(Object key) возвращает значение(Object value) по ключу
    public Object get(Object key) {
        int hashValue = hash(key);

        int i = indexFor(hashValue, table.length);
        for (Node node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key) && hashValue == node.hash) {
                return node.value;
            }
        }
        return null;
    }
//put(Object key, Object value)
    public Object put(Object key, Object value) {
        int hashValue = hash(key);

        int i = indexFor(hashValue, table.length);
        // если в i есть данные и ключ тот же, перезаписать
        for (Node node = table[i]; node != null; node = node.next) {
            Object k;
            if (node.hash == hashValue && ((k = node.key) == key || key.equals(k))) {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }

        addEntry(key, value, hashValue, i);
        return null;

    }
//remove(Object key) удаляет пару по ключу
    public Object remove(Object key) {
        int hashValue = hash(key);

        int i = indexFor(hashValue, table.length);
        for (Node node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key) && hashValue == node.hash) {
                size--;
                return node = null;
            }
        }
        return null;
    }
//clear() очищает коллекцию
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    public void addEntry(Object key, Object value, int hashValue, int i) {
        //розширення ємності, як що треба
        size++;
        if (size >= table.length * 0.5) {
            Node[] newTable = new Node[table.length * 2]; // збільшення довжини масиву
            System.arraycopy(table, 0, newTable, 0, size); // копіювання в новий масив
            table = newTable; //заміна посиляння
        }
        //отримати дані в i
        Node eNode = table[i];
        // Додати вузол, вказати вузол поруч з попереднім вузлом
        table[i] = new Node(hashValue, key, value, eNode);
    }

    //отримати позицію вставки
    private int indexFor(int hashValue, int length) {
        return hashValue % length;
    }
    //не моє але мені сподобалось як написаний, і як працює цей метод
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h/16);
    }

    static class Node{
        int hash; //хеш
        Object key;
        Object value;
        Node next; //наступний вузол
        Node(int hash, Object key, Object value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Object getKey() {
            return key;
        }
        public Object getValue() {
            return value;
        }
    }

}

