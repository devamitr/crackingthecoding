public class stack_3_4 {
    int_stack stack1;
    int_stack stack2;

    public stack_3_4(){
        stack1 = new int_stack();
        stack2 = new int_stack();
    }

    public void enqueue(int val){
        stack1.push(val);
    }

    public int dequeue(){
        int temp = 0;
        while (stack1.size>0)
        {
            temp = stack1.pop();
            stack2.push(temp);
        }
        int res = stack2.pop();
        while(stack2.size>0)
        {
            temp = stack2.pop();
            stack1.push(temp);
        }
        return stack2.pop();
    }
}
