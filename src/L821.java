class Solution821 {
    /**
     * 821. Shortest Distance to a Character https://leetcode.com/problems/shortest-distance-to-a-character/description/
     * @timeComplexity O(n) where n is the length of string
     * @spaceComplexity O(1)
     * @param S String
     *          String to be searched in.
     * @param C char
     *          Character to find minimum distance to
     * @return int[] containing distances
     */
    public int[] shortestToChar(String S, char C) {
        char[] chars = S.toCharArray();
        int[] result = new int[S.length()];

        // We maintain three pointers and linearly scan the string
        int prevPtr1 = -1;  // Previous occurence of C
        int ptr1 = -1;  // Current occurence of C
        int ptr2 = 0;   // Scan and reach till ptr1 updating the result array
        while(ptr1 < S.length() - 1 && ptr2 < S.length()) {
            // Check whether ptr1 has already hit the end of String
            if (ptr1 > S.length() - 1) {
                while(ptr2 < S.length()) {
                    result[ptr2] = ptr2 - prevPtr1;
                }
                return result;
            }
            // Update prevPointer before finding the next C, but only after first C was found
            if (ptr1 >= 0) {
                prevPtr1 = ptr1;
            }
            // Move the ptr1 to nearest C
            do {
                ptr1++;
            } while (ptr1 < S.length() && chars[ptr1] != C);

            // Move ptr2 and keep updating result
            while (ptr2 < ptr1 && ptr2 < S.length()) {
                // If prevPtr isn't yet set, the distance is difference from ptr1
                // If ptr1 is outside the string, distance is difference from prevPtr1
                // Else the distance is min of those two
                result[ptr2] = prevPtr1 < 0 ? (ptr1 - ptr2) : ptr1 >= S.length() ? ptr2 - prevPtr1 : Math.min(ptr1 - ptr2, ptr2 - prevPtr1);
                ptr2++;
            }
        }
        return result;
    }
}