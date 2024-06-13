class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        long sumShift = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sumShift += shifts[i];
            chars[i] = (char) ((chars[i] - 'a' + sumShift) % 26 + 'a');
        }
        return new String(chars);
    }
}