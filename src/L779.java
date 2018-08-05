class Solution779 {
    class Solution {
        /**
         * 779. K-th Symbol in Grammar https://leetcode.com/problems/k-th-symbol-in-grammar/description/
         *
         * @param N Row number (index from 1)
         * @param K Column number (indexed from 1)
         * @return Character that the grammar contains at Kth position in Nth row
         * @timeComplexity O(N) where N is the number of rows
         * @spaceComplexity O(1)
         */
        public int kthGrammar(int N, int K) {
            // Base cases
            if (N == 1 || N == 2 && K == 1) {
                return 0;
            } else if (N == 2 && K == 2) {
                return 1;
            } else {
                // Previous row's K/2 or (K/2 + 1)th character determines the current row's Kth character
                boolean even = ((K % 2) == 0);
                int prevIndex = even ? K / 2 : K / 2 + 1;
                int prev = kthGrammar(N - 1, prevIndex);
                if (prev == 0) {
                    return even ? 1 : 0;
                } else {
                    return even ? 0 : 1;
                }
            }
        }
    }
}
