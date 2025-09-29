import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (o1, o2) -> o2.compareTo(o1));
        HashSet<String> set = new HashSet<>();
        for (String str : phone_book) {
            if (set.contains(str)) return false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                set.add(sb.toString());
            }
        }
        return true;
        
        // Arrays.sort(phoneBook);
        // boolean result = true;
        // for (int i=0; i<phoneBook.length-1; i++) {
        //     if (phoneBook[i+1].contains(phoneBook[i])) {
        //         result = false;
        //         break;
        //     }
        // }
        // return result;
    }
}