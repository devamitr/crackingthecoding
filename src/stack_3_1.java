public class stack_3_1 {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public stack_3_1(int stack_size){
        stackCapacity = stack_size;
        values = new int[stack_size * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public boolean push(int val, int stacknum){
        if(isStackFull(stacknum)){
            return false;
        }
        else {
            int offset = stackCapacity * stacknum;
            values[offset + sizes[stacknum]] = val;
            sizes[stacknum]++;
            return true;
        }
    }

    public int pop(int stacknum){
            if(isStackEmpty(stacknum)){
                return -1;
            }
            else{
                int offset = stackCapacity * stacknum;
                sizes[stacknum]--;
                int res = values[sizes[stacknum]];
                return res;
            }
    }

    public int peek(int stacknum){
        return (isStackEmpty(stacknum))? -1: values[sizes[stacknum]];
    }

    public void show(int stacknum){
        int offset = stacknum*stackCapacity;
        for (int i=0;i<sizes[stacknum];i++)
            System.out.println(values[offset+i]);
    }

    private boolean isStackFull(int stacknum){
        return (sizes[stacknum]>=stackCapacity)? true:false;
    }

    private boolean isStackEmpty(int stacknum){
        return (sizes[stacknum]<=0)? true:false;
    }

}
