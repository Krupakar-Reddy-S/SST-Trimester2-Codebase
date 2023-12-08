public class MergeSortLL {

    // TC = O(NlogN), SC = O(1)
    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = sortedMerge(left, right);

        return sortedList;
    }

    public static Node getMiddle(Node head){
        if(head == null){
            return head;
        }

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node sortedMerge(Node a, Node b){
        Node result = null;

        if(a == null){
            return b;
        }

        if(b == null){
            return a;
        }

        if(a.val <= b.val){
            result = a;
            result.next = sortedMerge(a.next, b);
        }else{
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.insertAtEnd(node, 7);
        node.insertAtEnd(node, 0);
        node.insertAtEnd(node, 4);
        node.insertAtEnd(node, 3);
        node.insertAtEnd(node, 5);
        node.printList();

        Node sorted = mergeSort(node);
        sorted.printList();
    }
}
