import java.sql.SQLOutput;
import java.util.LinkedList;

public class implementation {
    public static void main(String[] args) {
        stack3_3_implementation();
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

}
