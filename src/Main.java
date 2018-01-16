public class Main {

    public static void main(String[] args) {
        testLinkedListFIFO();
        System.out.println();
        testArrayFIFO();
        System.out.println();
        testDoubleLinkedList();
        System.out.println();

        String[] testText = new String[]{"Es war einmal", "ein armer Student", "..."};
        Text text = new Text(new Cursor(), testText);
        System.out.println(text);
        text.removeCurrentChar();
        System.out.println("Ersten Buchstaben gelöscht: " + text);
    }

    private static void testDoubleLinkedList() {
        System.out.println("===========TEST DoubleLinkedList============");
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            String data = Integer.toString(i+1);
            list.add(data);
        }
        System.out.println("Initial: " + list);

        list.replace(9, "Zehn");
        System.out.println("10 mit Zehn ersetzt: " + list);

        list.remove(2);
        System.out.println("3 gelöscht: " + list);

        list.remove(0);
        System.out.println("1 gelöscht: " + list);
        System.out.println("=========================================");
    }

    private static void testLinkedListFIFO() {
        System.out.println("===========TEST LinkedListFIFO============");
        ListQueue list = new ListQueue();
        for (int i = 0; i < 10; i++) {
            String data = Integer.toString(i+1);
            list.enqueue(data);
        }
        System.out.println("Initial: " + list);

        for (int i = 0; i < 10; i++) {
            System.out.println(list.dequeue() + "\tNow: " + list);
        }

        System.out.println("=========================================");
    }

    private static void testArrayFIFO() {
        System.out.println("===========TEST ArrayQueueFIFO============");
        ArrayQueue list = new ArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            String data = Integer.toString(i+1);
            list.enqueue(data);
        }
        System.out.println("Initial: " + list);

        for (int i = 0; i < 10; i++) {
            System.out.println(list.dequeue() + "\tNow: " + list);
        }
        System.out.println("=========================================");
    }

}
