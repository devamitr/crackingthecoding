public class stack_3_5_1 {
    public static int_stack sort_stack(int_stack inp){
        int_stack temp = new int_stack();
        int temp_val, temp_stack_val;
        while(inp.size!=0){
            temp_val = inp.pop();
            while(temp.peek()!=Integer.MIN_VALUE && temp_val>temp.peek()){
                inp.push(temp.pop());
            }
            temp.push(temp_val);
        }
        return temp;
    }

}
