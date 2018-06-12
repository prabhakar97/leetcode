class Solution765 {
    /**
     * 765. Couples Holding Hands https://leetcode.com/problems/couples-holding-hands/description/
     * @timeComplexity O(n) The total number of people
     * @spaceComplexity O(n) For holding the position map
     * @param row Array of person IDs
     * @return Min swaps needed to make all partners sit together
     */
    public int minSwapsCouples(int[] row) {
        int swaps = 0;
        // Reverse mapping of people to their sitting position
        int[] posMap = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            posMap[row[i]] = i;
        }
        for (int i = 0; i < row.length; i += 2) {
            int partner = getPartner(row[i]);
            if (partner != row[i + 1]) {
                int partnerIndex = posMap[partner];
                int swappedPerson = row[i + 1];
                // Swap the person at i + 1 with actual partner
                row[partnerIndex] = row[i + 1];
                row[i + 1] = partner;
                // Update position maps
                posMap[swappedPerson] = partnerIndex;
                posMap[partner] = i + 1;
                swaps++;
            }
        }
        return swaps;
    }

    private int getPartner(int i) {
        if ((i & 1) == 1) {
            return i - 1;
        } else {
            return i + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution765().minSwapsCouples(new int[] { 0,2,4,6,7,1,3,5 }));
    }
}
