class Solution832 {
    class Solution {
        /**
         * 832. Flipping an image https://leetcode.com/problems/flipping-an-image/description/
         * This solution does it in place. It flips the bits while reversing a row.
         *
         * @param A int[][]
         *          The image in matrix representation (only 0s and 1s)
         * @return Flipped and inverted image
         * @timeComplexity O(m * n) if the image matrix has m rows and n cols
         * @spaceComplexity O(1)
         */
        public int[][] flipAndInvertImage(int[][] A) {
            for (int i = 0; i < A.length; i++) {
                int rowSize = A[i].length;
                // For even rows we process the reversal till (rowSize / 2 - 1 index) inclusive. For odd, rowSize / 2 inclusive
                int half = ((rowSize & 1) == 0 ? rowSize / 2 - 1 : rowSize / 2);
                for (int j = 0; j <= half; j++) {
                    // Find the index for swap
                    int complement = rowSize - j - 1;
                    int temp = A[i][complement];
                    // XORing with 1 flips the 1 to 0 and vice versa
                    A[i][complement] = A[i][j] ^ 1;
                    A[i][j] = temp ^ 1;
                }
            }
            return A;
        }
    }
}