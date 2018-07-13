import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Iterator;

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

    public static void string_1_4_string_palindrome_permutation(String s1){
        //Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
        //A palindrome is a word or phrase that is the same forwards and backwards. A permutation
        //is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
        //CTCI version 5
        char[] char_arr;
        s1 = String.join("",s1.split(" "));
        char_arr = s1.toCharArray();
        HashMap<Character, Integer> hmap = new HashMap<>();
        int temp_val = 0;
        for(char ch:char_arr){
            temp_val = 0;
            if(hmap.containsKey(ch))
            {
                temp_val = hmap.get(ch)+1;
                hmap.put(ch, temp_val);
            }
            else
            {
                hmap.put(ch,1);
            }
        }
        int odd_count = 0;
        for(char key: hmap.keySet())
        {
            if(hmap.get(key)%2 == 1)
                odd_count++;
            if (odd_count>1)
            {
                System.out.println("Not a palin permutation");
                return;
            }
        }
        System.out.println("Palin permu");

    }

    public static void string_1_5_string_one_away(String s1, String s2){
        //One Away: There are three types of edits that can be performed on strings: insert a character,
        //remove a character, or replace a character. Given two strings, write a function to check if they are
        //one edit (or zero edits) away.
        //EXAMPLE
        //pale, ple -> true
        //pales, pale -> true
        //pale, bale -> true
        //pale, bae -> false
        if(s1.length()==s2.length()) {
            //check for replace character
            char[] char_arr_s1 = s1.toCharArray();
            char[] char_arr_s2 = s2.toCharArray();
            boolean one_diff_found = false;
            for(int i=0,j=0; i<s1.length()&&j<s2.length();j++, i++) {
                if(char_arr_s1[i]!=char_arr_s2[j]) {
                    if(!one_diff_found)
                        one_diff_found=true;
                    else{
                        System.out.println("not one away!");
                        return;
                    }
                }
            }
            System.out.println("one away");
        }
        else if(Math.abs(s1.length()-s2.length())==1) {
            if (s2.length() > s1.length()) {
                String temp = s2;
                s2 = s1;
                s1 = temp;
            }
            char[] char_arr_s1 = s1.toCharArray();
            char[] char_arr_s2 = s2.toCharArray();

            boolean one_diff_found = false;
            for (int i = 0, j = 0; i < s1.length() && j < s2.length(); j++, i++) {
                if (char_arr_s1[i] != char_arr_s2[j]) {
                    if (!one_diff_found)
                        one_diff_found = true;
                    else {
                        System.out.println("not one away");
                        return;
                    }
                    if(i+1<s1.length() && char_arr_s1[i+1]==char_arr_s2[j])
                        i++;
                    else {
                        System.out.println("not one away!");
                        return;
                    }
                }
            }
            System.out.println("Exactly 1 away");
        }
        else {
            System.out.println("not one away");
            return;
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

    public static String string_1_6_string_compression(String s1){
        char[] s1_arr = s1.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        char curr_char = s1_arr[0];
        int curr_count = 1;
        int i=0;
        for(int j=1;j<s1.length();j++)
        {
            if(s1_arr[j]==curr_char)
            {
                curr_count++;
            }
            else {
                sb1.append(curr_char);
                sb1.append(curr_count);
                i += 2;
                curr_char = s1_arr[j];
                curr_count = 1;
            }
        }
        sb1.append(curr_char);
        sb1.append(curr_count);

        System.out.println(sb1);
        System.out.println(String.copyValueOf(s1_arr));
        if(sb1.length()<s1.length())
            return sb1.toString();
        else
            return s1;
    }

    public static void string_1_7_matrix_rotation(int[][] mat){
        //Given an image represented by an NxN matrix, where each pixel in the image is 4
        //bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
        if(mat.length>0) {
            if (mat.length != mat[0].length) {
                System.out.println("not a square matrix");
                return;
            } else {

                for(int i=0;i<mat.length;i++)
                {
                    for(int j=0;j<mat[0].length;j++)
                    {
                        System.out.print(" " + mat[i][j]);
                    }
                    System.out.print("\n");
                }

                int temp = 0;
                int layer_max = mat.length-1;
                for(int i=0;i<mat.length/2;i++)
                {
                    for(int j=i;j<layer_max-i;j++) {
                        temp = mat[i][j];
                        mat[i][j] = mat[layer_max-j][i];
                        mat[layer_max-j][i] = mat[layer_max-i][layer_max-j];
                        mat[layer_max-i][layer_max-j] = mat[j][layer_max-i];
                        mat[j][layer_max-i] = temp;
                    }
                }

                for(int i=0;i<mat.length;i++)
                {
                    for(int j=0;j<mat[0].length;j++)
                    {
                        System.out.print(mat[i][j]);
                    }
                    System.out.print("\n");
                }
            }
        }
        else{
            System.out.println("empty matrix");
        }

    }

    public static void string_1_8_zero_matrix(int[][] mat){
        //Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
        //column are set to 0.
        boolean[] row = new boolean[mat.length];
        boolean[] col = new boolean[mat[0].length];

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    row[i] = true;
                    col[j] = true;
                }
            }
            if(row[i]){
                for(int k=0;k<mat[0].length;k++)
                    mat[i][k]=0;
            }
        }

        for(int j=0;j<mat[0].length;j++)
        {
            if(col[j])
                for(int i=0;i<mat.length;i++)
                    mat[i][j] = 0;
        }

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println("\n");
        }
    }

    public static void string_1_9_string_rotation(String s1, String s2)
    {

        //check solution in book, its very good, its not about code, its about the concept.
    }
}

