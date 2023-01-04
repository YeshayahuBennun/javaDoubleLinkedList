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
    public DoublyNode createDLL(int value) {
        head = new DoublyNode();//------------------------------------------------------------------------O(1)
        DoublyNode newNode = new DoublyNode();//----------------------------------------------------------O(1)
        newNode.setValue(value);//------------------------------------------------------------------------O(1)
        newNode.setNext(null);//--------------------------------------------------------------------------O(1)
        newNode.setPrev(null);//--------------------------------------------------------------------------O(1)
        head = newNode;//---------------------------------------------------------------------------------O(1)
        tail = newNode;//---------------------------------------------------------------------------------O(1)
        size = 1;//---------------------------------------------------------------------------------------O(1)

        return head;
    }

    //Insertion Method
    public void insertDLL(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();//--------------------------------------------------------O(1)
        newNode.setValue(nodeValue);//------------------------------------------------------------------O(1)
        if (head == null) {//---------------------------------------------------------------------------O(1)
            createDLL(nodeValue);//---------------------------------------------------------------------O(1)
            return;//-----------------------------------------------------------------------------------O(1)
        } else if (location == 0) {//-------------------------------------------------------------------O(1)
            newNode.setNext(head);//--------------------------------------------------------------------O(1)
            newNode.setPrev(null);//--------------------------------------------------------------------O(1)
            head.setPrev(newNode);//--------------------------------------------------------------------O(1)
            head = newNode;//---------------------------------------------------------------------------O(1)
        } else if (location >= size) {//----------------------------------------------------------------O(1)
            newNode.setNext(null);//--------------------------------------------------------------------O(1)
            tail.setNext(newNode);//--------------------------------------------------------------------O(1)
            newNode.setPrev(tail);//--------------------------------------------------------------------O(1)
            tail = newNode;//---------------------------------------------------------------------------O(1)
        } else {
            DoublyNode tempNode = head;//---------------------------------------------------------------O(1)
            int index = 0;//----------------------------------------------------------------------------O(1)
            while (index < location - 1) {//To find the previous node of the given position-------------O(n)
                tempNode = tempNode.getNext();//--------------------------------------------------------O(1)
                index++;//------------------------------------------------------------------------------O(1)
            }
            //tempNode is set into newNode as a previous node.
            newNode.setPrev(tempNode);//----------------------------------------------------------------O(1)
            //tempNode next is set into new node as a next node;
            newNode.setNext(tempNode.getNext());//------------------------------------------------------O(1)
            //newNode is set into tempNode as a next node
            tempNode.setNext(newNode);//----------------------------------------------------------------O(1)
            //newNode is set into newNode next as a previous node
            newNode.getNext().setPrev(newNode);//-------------------------------------------------------O(1)
        }
        size++;//---------------------------------------------------------------------------------------O(1)
    }

    //Traversal Doubly Linked List
    public void traversalDLL() {
        if (head != null) {//----------------------------------------------------------------------------O(1)
            DoublyNode tempNode = head;//----------------------------------------------------------------O(1)
            for (int i = 0; i < size; i++) {//-----------------------------------------------------------O(n)
                System.out.print(tempNode.getValue());//-------------------------------------------------O(1)
                if (i < size - 1) {//--------------------------------------------------------------------O(1)
                    System.out.print(" -> ");//----------------------------------------------------------O(1)
                }
                tempNode = tempNode.getNext();//---------------------------------------------------------O(1)
            }

        } else {
            System.out.println("The DLL does not exist!");//---------------------------------------------O(1)
        }
        System.out.println("\n");//----------------------------------------------------------------------O(1)
    }

    //Reverse Traversal - Doubly Linked List
    public void reverseTraversalDLL() {
        if (head != null) {//----------------------------------------------------------------------------O(1)
            DoublyNode tempNode = tail;//----------------------------------------------------------------O(1)
            for (int i = 0; i < size; i++) {//-----------------------------------------------------------O(n)
                System.out.print(tempNode.getValue());//-------------------------------------------------O(1)
                if (i < size - 1) {//--------------------------------------------------------------------O(1)
                    System.out.print(" <- ");//----------------------------------------------------------O(1)
                }
                tempNode = tempNode.getPrev();//---------------------------------------------------------O(1)
            }
        } else {
            System.out.println("The DLL does not exist");//----------------------------------------------O(1)
        }
        System.out.print("\n");//------------------------------------------------------------------------O(1)
    }

    //Searching - Doubly Linked List
    public boolean searchDLL(int nodeValue) {
        if (head != null) {//----------------------------------------------------------------------------O(1)
            DoublyNode tempNode = head;//----------------------------------------------------------------O(1)
            for (int i = 0; i < size; i++) {//-----------------------------------------------------------O(n)
                if (tempNode.getValue() == nodeValue) {//------------------------------------------------O(1)
                    System.out.println("The node is found at position " + i);//--------------------------O(1)
                    return true;//-----------------------------------------------------------------------O(1)
                }
                tempNode = tempNode.getNext();//---------------------------------------------------------O(1)
            }
        }
        System.out.println("Node not found!");//---------------------------------------------------------O(1)
        return false;//----------------------------------------------------------------------------------O(1)
    }

    //Deletion - Doubly Linked List
    public void deletionDLL(int location) {
        if (head == null) {//----------------------------------------------------------------------------O(1)
            System.out.println("The DLL does not exist!");//---------------------------------------------O(1)
        } else if (location == 0) {//--------------------------------------------------------------------O(1)
            if (size == 1) {//---------------------------------------------------------------------------O(1)
                head = null;//---------------------------------------------------------------------------O(1)
                tail = null;//---------------------------------------------------------------------------O(1)
                size--;//--------------------------------------------------------------------------------O(1)
                return;//--------------------------------------------------------------------------------O(1)
            } else {
                head = head.getNext();//-----------------------------------------------------------------O(1)
                head.setPrev(null);//--------------------------------------------------------------------O(1)
                size--;//--------------------------------------------------------------------------------O(1)
            }
        } else if (location >= size) {//-----------------------------------------------------------------O(1)
            DoublyNode tempNode = tail.getPrev();//------------------------------------------------------O(1)
            if (size == 1) {//---------------------------------------------------------------------------O(1)
                head = null;//---------------------------------------------------------------------------O(1)
                tail = null;//---------------------------------------------------------------------------O(1)
                size--;//--------------------------------------------------------------------------------O(1)
                return;//--------------------------------------------------------------------------------O(1)
            } else {
                tempNode.setNext(null);//----------------------------------------------------------------O(1)
                tail = tempNode;//-----------------------------------------------------------------------O(1)
                size--;//--------------------------------------------------------------------------------O(1)
            }
        } else {
            DoublyNode tempNode = head;//----------------------------------------------------------------O(1)
            for (int i = 0; i < location - 1; i++) {//---------------------------------------------------O(n)
                tempNode = tempNode.getNext();//---------------------------------------------------------O(1)
            }
            tempNode.setNext(tempNode.getNext().getNext());//--------------------------------------------O(1)
            tempNode.getNext().setNext(tempNode);//------------------------------------------------------O(1)
            size--;//------------------------------------------------------------------------------------O(1)
        }
    }

    //Delete Entire Doubly Linked List
    public void deleteDLL() {//--------------------------------------------------------------------------O(1)
        DoublyNode temNode = head;//---------------------------------------------------------------------O(1)
        for (int i = 0; i < size; i++) {//---------------------------------------------------------------O(n)
            temNode.setPrev(null);//---------------------------------------------------------------------O(1)
            temNode = temNode.getNext();//---------------------------------------------------------------O(1)
        }
        head = null;//-----------------------------------------------------------------------------------O(1)
        tail = null;//-----------------------------------------------------------------------------------O(1)
        System.out.println("The DLL has been deleted");
    }
}
