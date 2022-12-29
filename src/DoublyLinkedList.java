public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
        //Empty
    }

    public DoublyNode getHead() {
        return head;
    }

    public void setHead(DoublyNode head) {
        this.head = head;
    }

    public DoublyNode getTail() {
        return tail;
    }

    public void setTail(DoublyNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Create a Doubly Linked list
    public DoublyNode createDLL(int value){
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.setValue(value);
        newNode.setNext(null);
        newNode.setPrev(null);
        head = newNode;
        tail = newNode;
        size=1;

        return head;

    }
}
