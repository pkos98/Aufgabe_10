public class ArrayQueue {
    private String[] _array;
    private int _height = 0;
    private int _deletionCounter = 0;

    public ArrayQueue(int capacity) {
        _array = new String[capacity];
    }

    public void enqueue(String data) {
        if (_height == _array.length) {
            System.out.println("Overflow");
            return;
        }
        _array[_height++] = data;
    }

    public String dequeue() {
        String firstElement = _array[_deletionCounter++];
        return firstElement;
    }


    public String toString() {
        String buffer = "";
        for (int i = _deletionCounter; i < _height; i++) {
            buffer += _array[i];
            if (i < _height -1)
                buffer += ", ";
        }
        return buffer;
    }
}
