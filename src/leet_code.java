import java.util.*;

public class leet_code {
    public class TreeNode{
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public static String countAndSay(int n) {
        int start_int = 1;
        int new_int = 0;
        int curr_int = -1, curr_count = 0;
        int temp_res = 1;
        int multiplier = 1;

        for(int i=1;i<n;i++){
            curr_int = start_int%10;
            curr_count = 1;
            temp_res = 0;
            multiplier =1;
            while(start_int%10 > 0){
                start_int = start_int/10;
                new_int = start_int%10;
                if(new_int == curr_int){
                    curr_count++;
                }
                else{
                    curr_int+= curr_count*10;
                    temp_res+= curr_int*multiplier;
                    multiplier*=100;
                    curr_int = new_int;
                    curr_count = 1;
                }
            }
            start_int = temp_res;
        }
        return Integer.toString(temp_res);
    }

    static HashMap<Integer, ArrayList<Integer>> com_map = new HashMap<Integer, ArrayList<Integer>>();
    public static  List<List<Integer>> verticalOrder(TreeNode root) {
        helper(root,0);
        Set<Integer> indexes = com_map.keySet();
        int[] indexes_int = new int[indexes.size()];
        int i=0;
        for(Integer key: indexes){
            indexes_int[i] = key;
            i++;
        }
        Arrays.sort(indexes_int);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int key: indexes_int){
            res.add(com_map.get(key));
        }
        return res;
    }
    public static void helper(TreeNode root,int col){
        if(root==null)
            return;
        ArrayList<Integer> temp;
        if(com_map.containsKey(col))
            temp = com_map.get(col);
        else
            temp = new ArrayList<Integer>();
        temp.add(root.val);
        com_map.put(col,temp);
        helper(root.left,col-1);
        helper(root.right,col+1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length)
            return null;
        if(preorder.length==0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        int root_index = search(inorder,preorder[0]);
        int in_s=-1, in_e=-1, pre_s=-1, pre_e=-1;
        if(root_index>0)//left exists
        {
            in_s=0;
            in_e=root_index-1;
            pre_s = 1;
            pre_e = Arrays.binarySearch(preorder,inorder[root_index-1]);
            root.left = helper(preorder, pre_s, pre_e, inorder, in_s, in_e);
        }
        if(root_index<(inorder.length-1))//right exists
        {
            in_s=root_index+1;
            in_e=inorder.length-1;
            pre_s = Arrays.binarySearch(preorder,inorder[root_index-1])+1;
            pre_e = preorder.length-1;
            root.right = helper(preorder, pre_s, pre_e, inorder, in_s, in_e);
        }
        return root;
    }
    public TreeNode  helper(int[] preorder, int pre_s,int pre_e,int[] inorder,int in_s,int in_e){
        TreeNode root = new TreeNode(preorder[pre_s]);
        int root_index = search(inorder,preorder[pre_s]);
        int ins=-1,ine=-1, pres=-1, pree=-1;
        if(root_index>in_s)//left exists
        {
            ins = in_s;
            ine = root_index-1;
            pres = pre_s+1;
            pree = search(preorder,inorder[root_index-1]);
            root.left = helper(preorder, pres, pree, inorder, ins, ine);
        }
        if((in_e-root_index)>0)//right exists
        {
            ins=root_index + 1;
            ine = in_e;
            pres = search(preorder,inorder[root_index-1])+1;
            pree = pre_e;
            root.right = helper(preorder, pres, pree, inorder, ins, ine);
        }
        return root;
    }

    public int search(int[] inp, int key){
        for(int i=0;i<inp.length;i++){
            if(inp[i]==key)
                return i;
        }
        return -1;
    }

//    public Node BST_to_DLL(Node root){
//        Node head=null;
//
//        return head;
//    }


}
