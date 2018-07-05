import java.util.HashMap;

public class string_1_1 {
    public static void string_1_1_with_data_struct(String input){
        /*
    solution in book
    sol1: bitwise
    1 public static boolean isUniqueChars(String str) {
        2 int checker = 0;
        3 for (int i = 0; i < str.length(); ++i) {
        4 int val = str.charAt(i) - ‘a’;
        5 if ((checker & (1 << val)) > 0) return false;
        6 checker |= (1 << val);
        7 }
        8 return true;
    9 }

    sol2: focus on this one
    1 public static boolean isUniqueChars2(String str) {
        2 boolean[] char_set = new boolean[256];
        3 for (int i = 0; i < str.length(); i++) {
        4 int val = str.charAt(i);
        5 if (char_set[val]) return false;
        6 char_set[val] = true;
        7 }
        8 return true;
    9 }
    */
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        for(char ch : input.toCharArray()){
            if(hmap.get(ch)==null)
            {
                hmap.put(ch,1);
            }
            else{
                System.out.println("repeated character found: " + ch);
                return;
            }
        }
        System.out.println("no repeating string found");
        return;
    }

    public static void string_1_1_without_data_structure(String input){
        for(char ch : input.toCharArray()){
            int temp_count = 0;
            for (char ch1 : input.toCharArray()){
                if(ch1 == ch)
                {
                    temp_count++;
                }
                if(temp_count>1)
                {
                    System.out.println("repeated character found :" + ch);
                    return;
                }
            }
        }
        System.out.println("no repeating string found");
    }

    public static void string_1_2_cstyle_reverse(String input){
        //Write code to reverse a C-Style String. (C-String means that “abcd” is
        // represented as five characters, including the null character.)
        int len = input.length();
        StringBuilder res_str = new StringBuilder();
        for(int i=len-1; i>=0; i--)
        {
            res_str.append(input.charAt(i));
        }
        System.out.println(res_str);
    }

    public static void string_1_3_duplicate_char(char[] input){
        //Design an algorithm and write code to remove the duplicate characters in a string
        // without using any additional buffer. NOTE: One or two additional variables are fine.
        // An extra copy of the array is not.
        // Solution: it will be an O(n^2), as we are not allowed to use any other memory to store the characters
        // So it will be a simple nested for loop on the string
        for(int i=0;i<input.length;i++)
        {
            int temp_count = 0;
            for(int j=0;j<input.length;j++)
            {
                if(input[i]==input[j])
                {
                    temp_count++;
                    if(temp_count>1) {
                        System.out.println("Match found " + input[i]);
                        return;
                    }
                }
            }
        }
        System.out.println("Match not found!");
    }

    public static void string_1_4_string_anagram(String s1, String s2){
        // Write a method to decide if two strings are anagrams or not.
        // An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
        // typically using all the original letters exactly once.
        // assuming all the characters are small
        // Another method is that you sort the two strings and equate them
        int[] char_arr = new int[26];
        if(s1.length() == s2.length() && s1.length()>0)
        {
            for(int i=0;i<s1.length();i++)
            {
                char_arr[s1.charAt(i)-'a']++;
                char_arr[s2.charAt(i)-'a']--;
            }
            for(int i=0;i<26;i++)
            {
                if(char_arr[i]!=0)
                {
                    System.out.println("Not an anagram");
                    return;
                }
            }
            System.out.println("They are anagrams");
        }
        else
        {
            System.out.println("Not anagrams");
        }
    }

    public static void string_1_5_space_replace(String s1){
        //1.5 Write a method to replace all spaces in a string with ‘%20’.
        // The thought process should be that we need to replace one characters with three so we will need to increase
        // the size of the array accordingly
        //Algo: 1. count number of spaces in first parsing
        // 2. start from back, replace space with %20, keep rest of characters as it is
        int len = s1.length();
        int space_count = 0;
        for(int i=0;i<len;i++)
            if(s1.charAt(i)==' ') space_count++;
        int new_len = len + 2*space_count;
        char[] new_str = new char[new_len];
        int j=len-1;
        for(int i=new_len-1;i>=0 && j>=0;i--, j--)
        {
            if(s1.charAt(j)==' '){
                new_str[i--] ='0';
                new_str[i--] ='2';
                new_str[i] ='%';
            }
            else {
                new_str[i] = s1.charAt(j);
            }
        }
        System.out.println("input: " + s1);
        for(int i=0;i<new_len;i++)
        {
            System.out.print(new_str[i]);
        }
    }
}

