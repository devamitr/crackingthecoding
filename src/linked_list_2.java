import java.util.*;

public class linked_list_2 {
    public static LinkedList<Integer> linkedlist_remove_duplicates_2_1_buffer(LinkedList<Integer> l1){
        HashMap<Integer, Boolean> temp_buffer = new HashMap<>();
        // in for each the collection is read and modified simultaneously, which is not allowed
        // so the below code although makes sense but cannot be use. so use an iterator to solve the problem.
//        for(int i : l1){
//            if(!temp_buffer.containsKey(i)){
//                temp_buffer.put(i,true);
//            }
//            else {
//                l1.remove(i);
//            }
//        }
        Iterator<Integer> it1 = l1.iterator();
        while(it1.hasNext()){
            int i = it1.next();
            if(!temp_buffer.containsKey(i)){
                temp_buffer.put(i,true);
            }
            else {
                it1.remove();
            }
        }
        return l1;
    }
    public static LinkedList<Integer> linkedlist_remove_duplicates_2_1_wo_buffer(LinkedList<Integer> l1){

        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2;
        int temp_count = 0;
        System.out.println(l1);
        while(it1.hasNext())
        {
            int i = it1.next();
            it2 = l1.iterator();
            temp_count = 0;
            while(it2.hasNext()){
                int j = it2.next();
                if(i==j)
                {
                    temp_count++;
                    if (temp_count>1)
                        it2.remove();
                }
            }
        }
        System.out.println(l1);
        return l1;
    }

    public static int linkedlist_kth_last_2_2_iterative(LinkedList<Integer> l1, int k){
        int i=0,j=0;
        Iterator<Integer> it1 = l1.iterator();
        if(l1.size()>k) {
            System.out.println(l1);
            while (it1.hasNext()) {
                j++;
                if (j > k)
                    i++;
                it1.next();
            }

            return l1.get(i);
        }
        else {
            System.out.println("Invalid k value");
            return -1;
        }
    }

    public static int linkedlist_kth_last_2_2_recursive(Iterator l1, int k){
        // books method
        if (l1.hasNext()) {
            l1.next();
            int ret_val = linkedlist_kth_last_2_2_recursive(l1, k);
            if(ret_val==k)
                return ret_val;
            else
                return ret_val+1;
        }
        else {
            return 0;
        }
    }

    public static void linkedlist_delete_middle_node_2_3(linked_list.Node head){
        linked_list.Node curr = head;
        linked_list.Node curr_2 = head;
        while(curr_2!=null && curr_2.next!=null){
            curr = curr.next;
            curr_2 = curr_2.next.next;
        }
        curr.data = curr.next.data;
        curr.next = curr.next.next;
    }
    public static void linkedlist_partition_2_4(linked_list.Node head, int x){
        linked_list.Node curr = head;
        linked_list l1 = new linked_list();
        linked_list l2 = new linked_list();

        while(curr!=null)
        {
            if(curr.data<x)
            {
                l1.add(curr.data);
            }
            else {
                l2.add(curr.data);
            }
            curr = curr.next;
        }
        curr = l1.head;
        while(curr.next!=null)
            curr = curr.next;
        curr.next = l2.head;
        l1.print();
    }

    public static void linkedlist_sum_lists_2_5(linked_list.Node h1, linked_list.Node h2) {
        linked_list.Node curr1 = h1;
        linked_list.Node curr2 = h2;
        linked_list res = new linked_list();
        int carry = 0;
        while(curr1!=null && curr2!=null){
            int temp_res = curr1.data + curr2.data + carry;
            if(temp_res>9) {
                carry = 1;
                temp_res = temp_res%10;
            }
            else
                carry = 0;
            res.add(temp_res);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        if(curr1!=null) {
            while (curr1 != null) {
                if (carry == 1) {
                    int temp_res = curr1.data + carry;
                    if (temp_res > 10) {
                        carry = 1;
                        res.add(temp_res % 10);
                    } else {
                        carry = 0;
                        res.add(temp_res);
                    }
                } else {
                    res.add(curr1.data);
                }
                curr1 = curr1.next;
            }
        }
        if(curr2!=null) {
            while (curr2 != null) {
                if (carry == 1) {
                    int temp_res = curr2.data + carry;
                    if (temp_res > 10) {
                        carry = 1;
                        res.add(temp_res % 10);
                    } else {
                        carry = 0;
                        res.add(temp_res);
                    }
                } else {
                    res.add(curr2.data);
                }
                curr2=curr2.next;
            }
        }
        if(carry==1){
            res.add(carry);
        }
        res.print();
    }
    public static linked_list res = new linked_list();
    public static linked_list.Node linkedlist_sum_lists_2_5_rescursive(linked_list.Node h1, linked_list.Node h2, int carry){
        int val = carry;
        if(h1!=null){
            val += h1.data;
        }
        if(h2!=null){
            val+=h2.data;
        }
        linked_list.Node res = new linked_list().new Node(val%10);
        carry=0;
        if(val>9)
            carry=1;
        h1 = h1!=null?h1.next:h1;
        h2 = h2!=null?h2.next:h2;
        if(h1!=null || h2!=null || carry !=0) {
            res.next = linkedlist_sum_lists_2_5_rescursive(h1, h2, carry);
        }
        return res;
    }

    public static linked_list.Node linkedlist_sum_lists_2_5_reverse(linked_list.Node h1, linked_list.Node h2) {
        // the lists can be uneven, so first find length of each list ad pad zeros in front of shorted lists
        int len1 = 0;
        linked_list.Node runner = h1;
        while(runner!=null)
        {
            len1++;
            runner = runner.next;
        }
        int len2 = 0;
        runner = h2;
        while(runner!=null)
        {
            len2++;
            runner = runner.next;
        }
        if(len1!=len2)
        {
            // padding zeros
            if(len1>len2){
                for(int i=0;i<(len1-len2);i++){
                    linked_list.Node temp = new linked_list().new Node(0);
                    temp.next = h2;
                    h2 = temp;
                }
            }
            else{
                for(int i=0;i<(len2-len1);i++){
                    linked_list.Node temp = new linked_list().new Node(0);
                    temp.next = h1;
                    h1 = temp;
                }
            }
        }
        return linkedlist_sum_lists_2_5_reverse_recursive(h1,h2);
    }
    public static linked_list.Node linkedlist_sum_lists_2_5_reverse_recursive(linked_list.Node h1, linked_list.Node h2) {

        if(h1.next!=null && h2.next!=null) {
            linked_list.Node  res = linkedlist_sum_lists_2_5_reverse_recursive(h1.next, h2.next);
            int carry = res.data>9?1:0;
            res.data = res.data%10;
            int val = carry;
            val+=h1.data;
            val+=h2.data;
            linked_list.Node new_node = new linked_list().new Node(val);
            new_node.next=res;
            return new_node;
        }
        else{
            return new linked_list().new Node(h1.data+h2.data);
        }


    }

    public static void linkelist_palindrome_2_6_reverse_and_compare(linked_list.Node h1){
        // there are two methods, 1. reverse and compare, 2. reverse 1st part of the LL and compare with second
        // Method 1
        // Reverse the LL
        linked_list.Node rev = null;
        linked_list.Node cur = h1;
        while(cur!=null){
            linked_list.Node new_node = new linked_list().new Node(cur.data);
            if(rev==null)
                rev = new_node;
            else {
                new_node.next = rev;
                rev = new_node;
            }
            cur = cur.next;
        }
        cur = rev;
        // print reversed LL
        while(cur!=null){
            System.out.println(cur.data);
            cur = cur.next;
        }

        // compare reversed array
        linked_list.Node cur2 = h1;
        cur = rev;
        while(cur!=null && cur2!=null){
            if(cur.data!=cur2.data){
                System.out.println("LL not a palindrome");
                return;
            }
            cur = cur.next;
            cur2 = cur2.next;
        }
        if(cur!=null || cur2!=null){
            System.out.println("LL not a palindrome return");
        }
        else
            System.out.println("LL is a palindrome!");

    }

    public static void linkedlist_palindrome_2_6_reverse_first_compare(linked_list.Node h1){
        // in this method we will reverse the first part of the LL and compare to second part
        //first we need to find the middle point as the lenght is not given,  we will use slow,fast runner algorithm
        Stack<Integer> stck = new Stack<>();
        linked_list.Node curr_slow=h1, curr_fast = h1;
        int rev_len = 0;
        while(curr_fast!=null && curr_fast.next !=null){
            stck.push(curr_slow.data);
            curr_slow = curr_slow.next;
            curr_fast = curr_fast.next.next;
        }
        if(curr_fast !=null){
            // for odd num of items
            curr_slow = curr_slow.next;
        }
        while(!stck.isEmpty()){
            int pop_val = stck.pop().intValue();
            if(curr_slow.data != pop_val) {
                System.out.println("LL is not a palindrome!!!");
                return;
            }
            curr_slow = curr_slow.next;
        }
        if(curr_slow==null)
        System.out.println("LL is a palindrome");
        else
            System.out.println("not palin");
    }

    public static void linkedlist_palindrome_2_6_recursive(linked_list.Node h1){
        int len =0;
        linked_list.Node curr = h1;
        while(curr!=null){
            len++;
        }
        linkedlist_palindrome_2_6_recursive_ispalindrome(h1, len);
    }
    public static linked_list.Node linkedlist_palindrome_2_6_recursive_ispalindrome(linked_list.Node h1, int len){
        // ignore this method, if you want to see it, check out the book page 220
        if(len==0){
            return h1;
        }
        if(len==1){
            return h1.next;
        }
        else {
            linked_list.Node comp_val =  linkedlist_palindrome_2_6_recursive_ispalindrome(h1.next, len-2);
            if(comp_val!=null) {
                if (h1.data != comp_val.data) {
                    System.out.println("Not a palindrome");
                    return null;
                } else {
                    return comp_val.next;
                }
            }
            else
            {
                return null;
            }
        }
    }

    public static linked_list.Node linkedlist_intersection_2_7(linked_list.Node h1, linked_list.Node h2){
        // this is a brute force solution, look in book for a better solution
        linked_list.Node curr1,curr2;
        curr1 = h1; curr2 = h2;
        while(curr1!=null){
            curr2 = h2;
            while(curr2!=null){
                if(curr1==curr2){
                    System.out.println("Intersection found!");
                    return curr1;
                }
                curr2 = curr2.next;
            }
            curr1 = curr1.next;
        }
        System.out.println("No intersection found");
        return null;
    }

    public static linked_list.Node linkedlist_circulatr_2_8(linked_list.Node h1){
        HashMap<Integer, linked_list.Node> hmap = new HashMap<Integer, linked_list.Node>();
        while(h1!=null){
            if(!hmap.containsKey(h1.data)){
                hmap.put(h1.data, h1);
                h1 = h1.next;
                continue;
            }
            if(h1 == hmap.get(h1.data)){
                System.out.println("loop found");
                return h1;
            }
        }
        return null;
    }
}
