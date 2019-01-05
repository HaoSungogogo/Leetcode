class Solution {
    private String[] lessThan20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                                              "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                                              "Eighteen", "Nineteen"};
    private String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                                         "Ninety"};
    private String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String word = "";
        int i = 0;
        while(num > 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + thousands[i] + " " + word;
            }
            num = num / 1000;
            i++;
        }
        return word.trim();
    }
    private String helper(int n) {
        if (n == 0) {
            return "";
        }
        if (n < 20) {
            return lessThan20[n] + " ";
        }
        if (n < 100) {
            return tens[n / 10] + " " + helper(n % 10);
        }
        return lessThan20[n / 100] + " Hundred " + helper(n % 100);
    }
}
