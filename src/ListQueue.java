public class ListQueue {

    private ListElement head; // points to n-1
    private ListElement tail; // points to 0

    public void enqueue(String data) {
        ListElement newElement = new ListElement(data, null);
        if (head == null) {
            head = newElement;
            tail = newElement;
            return;
        }
        head.next = newElement;
        head = newElement;
    }

    public String dequeue() {
        String result = tail.data;
        tail = tail.next;
        return result;
    }


    public String toString() {
        ListElement iterElement = tail;
        String buffer = "";
        while (iterElement != null) {
            buffer += iterElement.data == null ?
                      "null" : iterElement.data;
            iterElement = iterElement.next;
            if (iterElement != null)
                buffer += ", ";
        }
        return buffer;
    }


}

class ListElement {

    public String data;
    public ListElement next;

    public ListElement(String data, ListElement next) {
        this.data = data;
        this.next = next;
    }

}