public class  MyArrayList <T> {
    private final int INIT = 10;
    private final int TRIM = 5;
    private Object[] array = new Object[INIT];
    private int counter = 0;

    // add(Object value) дописує елемент в кінець масива. Якщо масив заповнений, то ми його збільшуємо на половину
    public void add(T value) {
        if(counter == array.length - 1)
            resize(array.length + (array.length/2)); // збільшуємо на половину, як що заповнили масив
        array[counter++] = value;
    }

    //get(int index) повертаємо елемент по індексу
    public T get(int index) {
        if (index < 0 || index >= counter) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    //remove(int index) видаляємо елемент по індексу. Переміщаємо всі елементи справа.
        public void remove(int index) {
        if (index < 0 || index >= counter) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < counter; i++)
            array[i] = array[i+1];
        array[counter] = null;
        counter --;
        if (array.length > INIT && counter < array.length / TRIM)
            resize(array.length / 2); // якщо єлнментів в TRIM раз меньше чим
        // довжина масива, то зменшуємо його в два рази
    }
    //size() повертаємо розмір
    public int size() {
        return counter;
    }

    //Допоміжний метод для оптимізації
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, counter);
        array = newArray;
    }
    //clear() чистимо колекцію
    public void clear() {
        for (int i = 0; i< counter; i++)
            array[i] = null;
    }
}
