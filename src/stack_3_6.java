public class stack_3_6 {
    //1 = Dog
    //2 = cat
    linked_list values;
    linked_list.Node bottom;

    public stack_3_6(){
        values = new linked_list();
        bottom=null;
    }

    public void enqueue(int val){
        values.add(val);
    }

    public int anyDequeue(){
        int res = Integer.MIN_VALUE;
        if(values.head!=null)
        {
            res = values.head.data;
            values.head = values.head.next;
        }
        else{
            System.out.println("No Animals to adopt, empty queue");
        }
        return res;
    }

    public int dogDequeue(){
        int_stack temp_stack = new int_stack();
        int res;
        while(values.head!=null && values.head.data!=1){
            temp_stack.push(values.head.data);
            values.head = values.head.next;
        }
        if(values.head!=null) {
            res = values.head.data;
            values.head = values.head.next;
        }
        else{
            System.out.println("No dogs found");
            res = Integer.MIN_VALUE;
        }
        while (temp_stack.size != 0) {
            values.add_front(temp_stack.pop());
        }
        return res;
    }

    public int catDequeue(){
        int_stack temp_stack = new int_stack();
        int res;
        while(values.head.data!=2){
            temp_stack.push(values.head.data);
            values.head = values.head.next;
        }
        if(values.head!=null) {
            res = values.head.data;
            values.head = values.head.next;
        }
        else{
            System.out.println("No dogs found");
            res = Integer.MIN_VALUE;
        }
        while (temp_stack.size != 0) {
            values.add_front(temp_stack.pop());
        }
        return res;
    }

    public void show(){
        linked_list.Node curr = values.head;
        System.out.println("Current status:");
        while(curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
