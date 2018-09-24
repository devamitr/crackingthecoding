import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class search_sort {
    //Question 2 : group anagrams together;
    public static String[] sort_anagram(String[] inp){
        HashMap<String,ArrayList<String>> string_map = new HashMap<>();
        for(int i=0;i<inp.length;i++){
            String sort_str= sort_string(inp[i]);
            if(string_map.containsKey(sort_str)){
                ArrayList<String> temp = string_map.get(sort_str);
                temp.add(inp[i]);
                string_map.put(sort_str,temp);
            }
            else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(inp[i]);
                string_map.put(sort_str,temp);
            }
        }
        int j=0;
        for(String key: string_map.keySet()){
            ArrayList<String> temp = string_map.get(key);
            for(int i=0;i<temp.size();i++,j++){
                inp[j] = temp.get(i);
            }
        }
        for(int i=0;i<inp.length;i++){
            System.out.println(inp[i]);
        }
        return inp;
    }

    private static String sort_string(String inp){
        char[] inp_chars = inp.toCharArray();
        Arrays.sort(inp_chars);
        return new String(inp_chars);
    }

    //Ques 3.
    public static int search_rotated(int[] inp, int x){
        int split_index = find_split(inp, 0, inp.length-1);
        if(split_index!=-1){
            if(x>=inp[split_index] && x<= inp[inp.length-1])
                return binary_search(inp,split_index,inp.length-1,x);
            else
                return binary_search(inp,0,split_index-1,x);
        }

        return -1;
    }

    private static int find_split(int[] inp, int str, int end){
        if(str<end){
            int mid = (end+str)/2;
            if(inp[mid]>inp[end]){
                return find_split(inp,mid+1,end);
            }
            else if(inp[mid]<inp[str]){
                return find_split(inp,str,mid-1);
            }
            else
                return mid;
        }
        else if(end==str)
            return end;
        else
            return -1;
    }

    private static int binary_search(int[] inp, int strt, int end, int x){
        if(strt<=end) {
            int mid = (strt + end) / 2;
            if (inp[mid] == x)
                return mid;
            else if (inp[mid] < x)
                return binary_search(inp, mid + 1, end, x);
            else
                return binary_search(inp, strt, mid - 1, x);
        }
        return -1;
    }

    //Ques 4.
    public static int search_nosize(int[] inp, int x, int str){
        // you do not have to use the size of the array
        if(inp[0]!=-1) {
            int diff = x - inp[str];
            if(diff==0)
                return str;
            else if(diff>=0) {
                if(inp[diff]!=-1)
                    return binary_search(inp,str,str+diff,x);
                else{
                    while(inp[diff]==-1 && diff>0)
                        diff = diff/2;
                    if(inp[diff]>x)
                        return binary_search(inp,0,diff,x);
                    else
                        return search_nosize(inp,x,diff);
                }
            }else{
                return -1;
            }
        }
        else return -1;
    }
}
