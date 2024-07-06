class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2]; 
        for (int student : students) {
            count[student]++;
        }
        int index = 0; 
        while (index < sandwiches.length && count[sandwiches[index]] > 0) {
            count[sandwiches[index]]--;
            index++;
        }
        return students.length - index;
    }
}