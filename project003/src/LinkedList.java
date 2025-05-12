

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(TreeNode data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void remove(TreeNode data) {
        if (this.head == null) {
            return;
        }

        if (this.head.data.equals(data)) {
            this.head = this.head.next;
            return;
        }

        Node currentNode = this.head;
        while (currentNode.next != null) {
            if (currentNode.next.data.equals(data)) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public void printList() {
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    @Override
    public String toString() {
        String ret = "{";
        Node currentNode = this.head;
        while (currentNode != null) {
           ret += currentNode.data.data.toString() + " , ";
           currentNode = currentNode.next;
        }
        ret+="}";
        return ret;
    }
//    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.remove(2);
//        list.printList();
//    }
}
