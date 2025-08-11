class Solution {
    
    // Iterative method - using tail - needed for * and /
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num = 0;
        int calc = 0;
        int tail = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } 

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) { 
                if (lastSign == '+') {
                    calc = calc + num;
                    tail = num;
                } else if (lastSign == '-') {
                    calc = calc - num;
                    tail = -num;
                } else if (lastSign == '*') {
                    calc = (calc - tail) + (tail * num);
                    tail = tail * num;
                } else if (lastSign == '/') {
                    calc = (calc - tail) + (tail / num);
                    tail = tail / num;
                }
                num = 0;
                lastSign = c;
            }

        }

        return calc;
        
    
    }

    // stack method
    public int calculateStack(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } 
            
            // operator or if last char enter. is not digit is important because otherwise for every digit, this loop is executed.
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) { 
                if (lastSign == '+') {
                    stack.push(num);
                } else if (lastSign == '-') {
                    stack.push(-num);
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (lastSign == '/') {
                    stack.push(stack.pop() / num);
                } else {
                    stack.push(lastSign * num);
                }
                num = 0;
                lastSign = c;
            }
        }

        int answer = 0;
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
        
        
    }
    
}