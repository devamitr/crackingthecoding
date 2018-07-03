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
}

