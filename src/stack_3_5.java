public class stack_3_5 {
    // sorted stack with smallest elements on top
    // this implmentation is totally different, the sort function is in 3_5_1
    // here we sorted the stack everytime when an element is added
    int_stack values, temp_stack;

    public stack_3_5(){
        values = new int_stack();
        temp_stack = new int_stack();
    }

    public void push(int val){
        if(values.size==0){
            values.push(val);
        }
        else{
            // pop all the values to temporary stack till the new value is smaller that the top of stack
            while(val>values.peek() && values.size>0){
                temp_stack.push(values.pop());
            }
            values.push(val);
            while(temp_stack.size>0){
                values.push(temp_stack.pop());
            }
        }
    }

    public int pop(){
        return values.pop();
    }

    public int peek(){
        return values.peek();
    }

    public boolean isEmpty(){
        return (values.size>0);
    }

    public void show(){
        values.show();
    }
}
