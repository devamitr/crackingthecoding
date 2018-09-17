import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Set;

public class stack_3_3 {
    ArrayList<stack> SetOfStacks;
    int threshold;

    public stack_3_3(int thres){
        threshold = thres;
        SetOfStacks = new ArrayList<stack>();
    }
    public void push(int val){
        linked_list.Node new_node = new linked_list().new Node(val);
        stack last_stack= getLastStack();
        if(last_stack.size>=threshold) {
            last_stack = new stack();
            SetOfStacks.add(last_stack);
        }
        last_stack.push(val);
    }

    public int pop(){
        if(SetOfStacks.size()!=0)
        {
            //get last stack
            stack last_stack = getLastStack();
            int res = last_stack.pop();
            if(last_stack.size==0) SetOfStacks.remove(last_stack);
            return res;
        }
        else {
            System.out.println("Empty Stack");
            return Integer.MIN_VALUE;
        }
    }

    public int peek(){
        if(SetOfStacks.size()!=0)
        {
            //get last stack
            stack last_stack = getLastStack();
            return last_stack.peek();
        }
        else {
            System.out.println("Empty Stack");
            return Integer.MIN_VALUE;
        }
    }

    public void show(){
        int i=0;
        for(stack stk:SetOfStacks){
            System.out.println();
            System.out.println("Stack no." + Integer.toString(i));
            stk.show();
            i++;
        }
    }

    private stack getLastStack(){
        if(SetOfStacks.size()==0)
        {
            stack new_stack = new stack();
            SetOfStacks.add(new_stack);
            return new_stack;
        }
        else return SetOfStacks.get(SetOfStacks.size()-1);
    }

    public class stack{
        linked_list values;
        int size;
        linked_list.Node bottom;

        public stack(){
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
}
