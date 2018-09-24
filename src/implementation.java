import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class implementation {
    public static void main(String[] args) {
        //String[] strary = {"tik", "sex","race", "god", "tip", "pit", "dog", "care","kit",  "exs", "acer"};

        search_sort ss = new search_sort();
        //ss.sort_anagram(strary);
        int[] inp = new int[100];
        int[] col = {4,5,7,9,10,12};
        for(int i=0;i<col.length;i++){
            inp[i] = col[i];
        }
        for(int i=col.length;i<100;i++){
            inp[i] = -1;
        }
        int res = ss.search_nosize(inp,12,0);
        System.out.println(res);
//        int[] col = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
//        int_tree my_tree = new int_tree(col[0]);
//        for(int i=1;i<col.length;i++){
//            my_tree.root.insert(col[i]);
//        }

//        dynamic_prog dp = new dynamic_prog();
//
//        dp.flatten(my_tree.root);
//        my_tree.root.inOrderTrav();
        //System.out.println(dp.child_123(36));

        // ques 2
//        boolean[][] inp = new boolean[10][12];
//        for(int i=0;i<10;i++){
//            for(int j=0;j<12;j++){
//                inp[i][j] = true;
//            }
//        }
//        inp[2][7] = false;
//        inp[3][9] = false;
//        inp[5][8] = false;
//        inp[9][9] = false;
//        inp[8][7] = false;
//        ArrayList<Point> res = dp.getPath(inp);
//        for(int i=0;i<res.size();i++){
//            Point p = res.get(i);
//            System.out.println("row:" + Integer.toString(p.row));
//            System.out.println("col:" + Integer.toString(p.col));
//        }

        //que 3 DP
        //int[] inp = {-50,-40,1,2,3,5,7,8};
        //System.out.println(dp.magic_index(inp,0,inp.length));
    }

    public static void string_implementation(){
        //string_1_1.string_1_1_without_data_structure("integer");
        //string_1_1.string_1_2_cstyle_reverse("integer");
        //string_1_1.string_1_3_duplicate_char("integer".toCharArray());
        //string_1_1.string_1_4_string_anagram("integer", "regtein");
        //string_1_1.string_1_5_space_replace("int eg er ");
        //string_1_1.string_1_4_string_palindrome_permutation("aabbccdddf");
        //string_1_1.string_1_5_string_one_away("pale","palee");
        //System.out.println(string_1_1.string_1_6_string_compression("AAaabccddeef"));
        //int[][] mat = {{1,2,0,4},{5,6,7,8},{9,10,11,12},{0,14,15,16}};
        // string_1_1.string_1_7_matrix_rotation(mat);
        //string_1_1.string_1_8_zero_matrix(mat);
    }

    public static void linkedlist_implementation(){
        // Linkedlist implementation
        int[] col = {1,2,3,4,7,2,3,9,7,10,12,52,37,5};
        LinkedList<Integer> l1 = new LinkedList<>();
        for(int i : col){
            l1.addLast(i);
        }
        linked_list l2 = new linked_list();
        for(int i : col){
            l2.add(i);
        }
        //System.out.println(l1);
        //System.out.println(linked_list_2.linkedlist_remove_duplicates_2_1_buffer(l1));
        //System.out.println(linked_list_2.linkedlist_remove_duplicates_2_1_wo_buffer(l1));
        //System.out.println(linked_list_2.linkedlist_kth_last_2_2_iterative(l1,3));
        //l2.print();
        //linked_list_2.linkedlist_delete_middle_node_2_3(l2.head);
        //linked_list_2.linkedlist_partition_2_4(l2.head,7);
        //l2.print();
        int[] col1 = {1,2,3,4};
        int[] col2 = {5,6,7,8,9,10, 11,12 ,13};
        linked_list l3 = new linked_list();
        for(int i : col1){
            l3.add(i);
        }
        linked_list l4 = new linked_list();
        for(int i : col2){
            l4.add(i);
        }
        int i=0;
        linked_list l5 = new linked_list();
        linked_list.Node curr = l3.head;
        linked_list.Node curr2 = null;
        for(i=0;i<4;i++){
            if(l5.head==null) {
                l5.head = curr;
                curr2 = curr;
            }
            else{
                curr2.next = curr;
                curr2 = curr2.next;
            }
            if(i==2){
                curr = l4.head.next;
            }
            else {
                curr = curr.next;
            }
        }
        l4.print();
        l5.print();
//        linked_list_2.linkedlist_sum_lists_2_5(l3.head,l4.head);
//        linked_list.Node res = linked_list_2.linkedlist_sum_lists_2_5_rescursive(l3.head, l4.head, 0);
//        while(res!=null){
//            System.out.print(" - "+ res.data);
//            res = res.next;
//        }
//        linked_list.Node res = linked_list_2.linkedlist_sum_lists_2_5_reverse(l3.head, l4.head);
//        while(res!=null){
//            System.out.print(" - "+ res.data);
//            res = res.next;
//        }
        //linked_list_2.linkedlist_palindrome_2_6_reverse_first_compare(l4.head);
//        linked_list.Node x = linked_list_2.linkedlist_intersection_2_7(l4.head, l5.head);
//        System.out.println(x.data);
        linked_list.Node temp_node = l4.head.next.next.next.next, temp = l4.head;
        System.out.println("The circular node is : " + temp_node.data);
        while(temp.next!=null)
            temp = temp.next;
        temp.next = temp_node;
        linked_list.Node op = linked_list_2.linkedlist_circulatr_2_8(l4.head);
        System.out.println(op.data);
    }

    public static void stack3_1_implementation(){
        stack_3_1 stack_3 = new stack_3_1(10);

        for(int i=1;i<11;i++)
        {
            stack_3.push(i,0);
        }

        for(int i=11;i<21;i++)
        {
            stack_3.push(i,1);
        }

        for(int i=21;i<31;i++)
        {
            stack_3.push(i,2);
        }
        stack_3.show(2);

        System.out.println(stack_3.pop(2));
        stack_3.show(2);
    }

    public static void stack3_2_implementation(){
        stack_3_2 stack_3 = new stack_3_2();
        int[] inp = {5,6,3,7,2,8};

        for(int i=0;i<inp.length;i++)
        {
            stack_3.push(inp[i]);
        }
        stack_3.show();
        System.out.println();
        for(int i=0;i<inp.length;i++)
        {
            System.out.print("POP value: ");
            System.out.println(stack_3.pop());
            System.out.print("min value: ");
            System.out.println(stack_3.get_min());
        }
    }

    public static void stack3_3_implementation(){
        stack_3_3 stack33 = new stack_3_3(10);
        for(int i=0;i<25;i++)
        {
            stack33.push(i);
        }
        stack33.show();
        System.out.println("-------------Popping begins-----------");
        for(int i=0;i<20;i++)
        {
            System.out.println(stack33.pop());
        }
        stack33.show();
    }

    public static void stack_3_5_implementation(){
        int_stack stack33 = new int_stack();
        int[] col = {5,8,4,7,10,12,25,2,6,1,35};
        for(int i=0;i<col.length;i++)
        {
            stack33.push(col[i]);
        }
        stack33.show();
        System.out.println("-------------Popping begins-----------");
        stack33 = stack_3_5_1.sort_stack(stack33);
        stack33.show();
    }

    public static void stack_3_6_implementation(){
        int[] col = {1,2,1,2,1,2,2,2,2,1,1,1,2};
        stack_3_6 stack36 = new stack_3_6();
        for(int i=0;i<col.length;i++){
            stack36.enqueue(col[i]);
        }
        for(int i=0;i<4;i++){
            System.out.println(stack36.dogDequeue());
        }
        stack36.show();
    }

    public static void int_tree_implementation(){
        int[] col = {5,8,4,7,10,12,25,2,6,1,35};
        int_tree my_tree = new int_tree(col[0]);
        for(int i=1;i<col.length;i++){
            my_tree.root.insert(col[i]);
        }
        my_tree.root.inOrderTrav();

    }

    public static void trees_6_2_create_bst(){
        int[] col = {1,2,3,4,5,6,7,8,9,10};
        int_tree.Node res = trees_6_2_create_bst_recur(col,0,col.length-1);
        inOrderTrav(res);
    }
    public static int_tree.Node trees_6_2_create_bst_recur(int[] col, int s, int e)
    {
        if(e>s) {
            int mid = (s+e)/2;
            int_tree tree = new int_tree(col[mid]);
            System.out.println(col[mid]);
            tree.root.left = trees_6_2_create_bst_recur(col,s,(mid-1));

            tree.root.right = trees_6_2_create_bst_recur(col,(mid+1),e);
            return tree.root;
        }
        if(e-s ==0)
        {
            int_tree tree = new int_tree(col[e]);
            System.out.println(col[e]);
            return tree.root;
        }
        else {
            return null;
        }
    }
    public static void inOrderTrav(int_tree.Node x){
        System.out.println();
        if(x.left!=null) inOrderTrav(x.left);
        System.out.print(" - ");
        System.out.print(x.data);
        if(x.right!=null) inOrderTrav(x.right);
    }

    public static ArrayList<linked_list> trees_6_3_depth_list(int_tree.Node currNode, int level, ArrayList<linked_list> list){
        if(currNode!=null) {
            linked_list curr_list;
            if (level>=list.size()) {
                curr_list = new linked_list();
                curr_list.add(currNode.data);
                list.add(level, curr_list);
            }
            else{
                curr_list = list.get(level);
                curr_list.add(currNode.data);
                list.set(level, curr_list);
            }
            level++;
            list = trees_6_3_depth_list(currNode.left, level, list);
            list = trees_6_3_depth_list(currNode.right, level, list);
        }
        return list;
    }

    public static int getHeight(int_tree.Node curr){
        if(curr==null) return -1;
        else return Math.max(getHeight(curr.left), getHeight(curr.right))+1;
    }

    public static boolean trees_6_4_balanced_tree(int_tree.Node curr){
        if(curr==null)
            return true;
        if(Math.abs(getHeight(curr.left)-getHeight(curr.right))>1)
            return false;
        else {
            return (trees_6_4_balanced_tree(curr.right) && trees_6_4_balanced_tree(curr.left));
        }
    }

    public static boolean trees_6_5_bt_bst(int_tree.Node curr, Integer min, Integer max){
        if(curr==null){
            return true;
        }
        else {
            if(curr.left!=null && curr.data<=curr.left.data)
                return false;
            if(curr.right!=null && curr.data>curr.right.data)
                return false;
            return (trees_6_5_bt_bst(curr.left, min, curr.data)&& trees_6_5_bt_bst(curr.right, curr.data, max));
        }
    }

    public static int trees_6_6_bst_sucessor(int_tree.Node curr){
        // check if curr is leaf
        System.out.println("inp:");
        System.out.println(curr.data);

            if(curr.right!=null) {
                int_tree.Node succ = curr.right;
                while(succ.left!=null) {
                    succ = succ.left;
                }
                return succ.data;
            }
            else{
                if(curr.parent!=null && curr.parent.left==curr)
                    return curr.parent.data;
                else {
                    int_tree.Node succ = curr;
                    while (succ.parent.right == succ)
                        succ = succ.parent;
                    succ = succ.parent;
                    return (succ != null ? succ.data : Integer.MIN_VALUE);
                }
            }


    }

    public static int trees_6_8_common_ancestor(int_tree.Node curr1, int_tree.Node curr2){
        System.out.println(curr1.data);
        System.out.println(curr2.data);
        HashSet<Integer> parent1_hash = new HashSet<Integer>();
        int_tree.Node runner = curr1;
        while(runner.parent!=null){
            runner = runner.parent;
            parent1_hash.add(runner.data);
        }
        runner = curr2;
        while(!parent1_hash.contains(runner.parent.data))
            runner = runner.parent;
        return (runner.parent!=null)? runner.parent.data:Integer.MIN_VALUE;
    }
}
