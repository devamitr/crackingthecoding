public class linked_list {
    Node head;
    public linked_list(){
        head = null;
    }
    public void add(int d){
        if(head==null)
            head = new Node(d);
        else
        {
            Node curr = head;
            while(curr.next!=null)
                curr = curr.next;
            curr.next = new Node(d);
        }
    }

    public void add_front(int d){
        if(head==null)
            head = new Node(d);
        else
        {
            Node curr = new Node(d);
            curr.next = head;
            head = curr;
        }
    }
    public void print(){
        Node curr = head;
        System.out.println(" ");
        while(curr!=null)
        {
            System.out.print("  " + curr.data);
            curr = curr.next;
        }
    }
    public class Node{
        int data;
        Node next;

        public Node(int i){
            data = i;
            next = null;
        }
    }
}
