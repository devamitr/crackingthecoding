import java.time.chrono.MinguoChronology;

public class int_tree {
    Node root;
    public int_tree(int d){
        root = new Node(d);
    }
    public int_tree(){

    }
    public class Node{
        int data;
        Node left,right;
        Node parent;
        public Node(int d)
        {
            data = d;
            left=null;
            right = null;
            parent = null;
        }

        public void insert(int val){
            if(val>data){
                if(right!=null)
                {
                    right.insert(val);
                }
                else{
                    right = new Node(val);
                    right.parent = this;
                }
            }else{
                if(left!=null)
                {
                    left.insert(val);
                }
                else{
                    left = new Node(val);
                    left.parent = this;
                }
            }
        }

        public boolean contains(int val){
            if(data==val)
                return true;
            else if(val>data){
                if(right!=null) return right.contains(val);
                else return false;
            } else{
                if(left!=null) return left.contains(val);
                else return false;
            }
        }

        public void inOrderTrav(){
            if(left!=null) left.inOrderTrav();
            System.out.println(data);
            if(right!=null) right.inOrderTrav();
        }

        public void preOrderTrav(){
            System.out.println(data);
            if(left!=null) left.preOrderTrav();
            if(right!=null) right.preOrderTrav();
        }

        public void postOrderTrav(){
            if(left!=null) left.postOrderTrav();
            if(right!=null) right.postOrderTrav();
            System.out.println(data);
        }

        public int floor(int val) {
            if (val == data) {
                return data;
            } else if (val < data) {
                return left.floor(val);
            } else {
                if (right.data > val)
                    return data;
                else
                    return right.floor(val);
            }
        }

        public Node delete(int val){
            if(data==val) {
                if(left!=null) {
                    Node curr = left;
                    if(right!=null) {
                        while (curr.right != null)
                            curr = curr.right;
                        data = curr.data;
                        curr = null;
                        return this;
                    }
                    else{
                        curr.right = right;
                        return curr;
                    }
                }
                else{
                    return right;
                }
            }
            else if(val>data){
                if(right!=null){ right = right.delete(val);
                return right;
                }
                else return null;
            } else{
                if(left!=null) { left = left.delete(val);
                return left;
                }
                else return null;
            }
        }
    }
     public int max(){
        if(root!=null){
            Node curr = root;
            while(curr.right!=null)
                curr = curr.right;
            return curr.data;
        }
        else
            return Integer.MIN_VALUE;
     }

     public int min(){
         if(root!=null){
             Node curr = root;
             while(curr.left!=null)
                 curr = curr.right;
             return curr.data;
         }
         else
             return Integer.MAX_VALUE;
     }
}
