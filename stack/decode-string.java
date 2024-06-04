class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();
        StringBuilder current = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') {
                result.push(current);
                current = new StringBuilder();
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = current;
                current = result.pop();
                int repeatTimes = counts.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    current.append(temp);
                }
                index++;
            } else {
                current.append(s.charAt(index));
                index++;
            }
        }

        return current.toString();
    }
}