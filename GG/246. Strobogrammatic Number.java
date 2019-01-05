class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        for (int i = 0; i < (num.length() + 1) / 2; i++) {
            Character cur = map.get(num.charAt(i));
            if (cur == null) {
                return false;
            }
            if (cur != num.charAt(num.length() - 1- i)) {
                return false;
            }
        }
        return true;
    }
}
