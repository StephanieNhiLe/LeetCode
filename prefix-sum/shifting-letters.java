class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        long totalShifts = 0; 
        for (int i = shifts.length - 1; i >= 0; i--) {
            totalShifts += shifts[i];
            totalShifts %= 26; 
            int index = chars[i] - 'a';
            chars[i] = (char) ((index + totalShifts) % 26 + 'a');
        }
        return new String(chars);
    }
}