public class int_stack {
    linked_list values;
    int size;
    linked_list.Node bottom;

    public int_stack(){
        values = new linked_list();
        size = 0;
        bottom = null;
    }

    public void push(int val){
        linked_list.Node new_val = new linked_list().new Node(val);
        if(values.head == null){
            values.head = new_val;
            bottom = new_val;
        }
        else{
            new_val.next = values.head;
            values.head = new_val;
        }
        size++;
    }

    public int pop(){
        if(values.head!=null) {
            int res = values.head.data;
            values.head = values.head.next;
            size--;
            return res;
        }
        else{
            System.out.println("Stack Empty");
            return Integer.MIN_VALUE;
        }
    }

    public int peek(){
        return (values.head!=null)?values.head.data:Integer.MIN_VALUE;
    }

    public void show(){
        linked_list.Node curr = values.head;
        while(curr!=null){
            System.out.print(curr.data);
            System.out.print("--");
            curr = curr.next;
        }
        System.out.println();
    }
}
