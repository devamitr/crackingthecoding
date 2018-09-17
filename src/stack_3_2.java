public class stack_3_2 {
    linked_list values;
    linked_list min_values;

    public stack_3_2(){
        values = new linked_list();
        min_values = new linked_list();
    }

    public void push(int val){
        linked_list.Node new_val = new linked_list().new Node(val);
        if(values.head==null){
            values.head = new_val;
        }
        else{
            new_val.next = values.head;
            values.head = new_val;
        }
        if (val<=get_min()) {
            linked_list.Node new_min_val = new linked_list().new Node(val);
            new_min_val.next = min_values.head;
            min_values.head = new_min_val;
        }
    }

    public int pop(){
        if(values.head==null)
            return Integer.MIN_VALUE;
        else{
            int res = values.head.data;
            values.head = values.head.next;
            if(res == get_min())
            {
                min_values.head = min_values.head.next;
            }
            return res;
        }

    }
    public int peek(){
        return (values.head==null)?null:values.head.data;
    }

    public int get_min(){
        return (min_values.head==null)?Integer.MAX_VALUE:min_values.head.data;
    }

    public void show(){
        linked_list.Node curr = values.head;
        System.out.println();
        System.out.println("------------------------------------------------");
        while(curr!=null){
            System.out.print(curr.data);
            System.out.print('-');
            curr = curr.next;
        }
    }
}
