// TC: Definite number of digits in nums.we divide by 1000 each step. So it will be constant overall.
// SC: Using String array of definite length. So constant as well.

class Solution {
    String[] below20 = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
    String[] below100 = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] suffix = new String[] {"", " Thousand", " Million", " Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        int suffixIndex = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int r = num % 1000;
            if (r != 0) {
                String converted = convert(r).trim() + suffix[suffixIndex];
                // only if there is already some string exists in sb, add space to end of this string and insert at start of sb.
                if (sb.length() != 0) {
                   converted += " ";
                }
                sb.insert(0, converted);
            }
            suffixIndex++;
            num /= 1000;
        }

        return sb.toString();
    }

    private String convert(int r) {
        if (r == 0) {
            return "";
        }
        if (r < 20) {
            return below20[r];
        }
        if (r < 100) {
            return below100[r / 10] + ((r % 10 == 0) ? "" : " " + below20[r % 10]);
        }
        return below20[r / 100] + " Hundred " + convert(r % 100);
    }

}