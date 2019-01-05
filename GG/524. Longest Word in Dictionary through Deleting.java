k is the number of Dictionary and n is the length of every string
time: O(nklogk)
sort first and use two pointer to judge

class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
           public int compare(String o1, String o2) {
               if (o1.length() > o2.length()) {
                   return -1;
               } else if (o1.length() < o2.length()) {
                   return 1;
               } else {
                   return o1.compareTo(o2);
               }
           }
        });
        for (String str : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (c == str.charAt(i)) {
                    i++;
                }
                if (i == str.length()) {
                    return str;
                }
            }
        }
        return "";
    }
}
