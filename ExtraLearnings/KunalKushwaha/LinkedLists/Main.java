public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        list.insertLast(2);
        list.insertLast(1);

        list.insert(0, 5);
        list.display();

        System.out.println(list.deleteFirst());


        list.display();

        System.out.println(list.deleteLast());
        list.display();

        System.out.println(list.delete(2));
        list.display();
    }
}