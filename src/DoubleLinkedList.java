public class DoubleLinkedList<T> {
    private Node head; // Zeigt auf length-1
    private Node tail; // Zeigt auf index 0
    private int length = 0;

    public DoubleLinkedList() {}
    public DoubleLinkedList(T[] elements) {
        for (int i = 0; i < elements.length; i++)
            add(elements[i]);
    }

    public int getLength() {
        return length;
    }

    public void add(T content) {
        Node newElement = new Node(head, null, content);
        if (head == null) {
            tail = newElement;
            head = newElement;
            return;
        }
        head.next = newElement;
        head = newElement;
        length++;
    }

    public void remove(int index) {
        if (index < 0 || index > length)
            return;
        Node toDelete = getNode(index);
        Node nextNode = toDelete.next;
        Node previousNode = toDelete.previous;
        if (nextNode != null)
            nextNode.previous = previousNode;
        if (previousNode != null)
            previousNode.next = nextNode;
        if (toDelete == tail)
            tail = tail.next;
        if (toDelete == head)
            head = head.previous;
        toDelete = null;
        length--;
    }

    public void replace(int index, String newContent) {
        if (index < 0 || index > length)
            return;
        getNode(index).content = newContent;
    }

    public T get(int index) {
        if (index < 0 || index > length)
            return null;
        Node node = getNode(index);
        return (T)node.content;
    }

    public String toString() {
        String buffer = "";
        for (int i = 0; i <= length; i++) {
            buffer += get(i);
            if (i + 1 <= length)
                buffer += ", ";
        }

        return buffer;
    }

    private Node getNode (int index) {
        if (index < 0 || index > length)
            return null;

        Node iterElement = tail;
        for (int i = 0; i < index; i++) {
            iterElement = iterElement.next;
        }
        return iterElement;
    }

}

class Node<T> {
    public Node next;
    public Node previous;
    public T content;

    Node(Node previous, Node next, T content) {
        this.previous = previous;
        this.next = next;
        this.content = content;
    }

    public String toString() {

        String previousContent = (previous == null ? "null" : previous.content) +
                                                     " <-- ";
        String nextContent = " --> " + (next == null ? "null" : next.content);
        return previousContent + content + nextContent;
    }

}