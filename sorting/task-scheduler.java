class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26]; 
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        int maxFrequency = 0;
        for (int freq : frequencies) {
            maxFrequency = Math.max(maxFrequency, freq);
        }

        int maxCount = 0;
        for (int freq : frequencies) {
            if (freq == maxFrequency) {
                maxCount++;
            }
        }

        int partitions = maxFrequency - 1; 
        int emptySlots = partitions * (n - (maxCount - 1));  
        int availableTasks = tasks.length - (maxFrequency * maxCount); 
        int idles = Math.max(0, emptySlots - availableTasks); 

        return tasks.length + idles;
    }
}