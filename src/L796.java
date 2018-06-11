class Solution796 {
    /**
     * 796. Rotate String https://leetcode.com/problems/rotate-string/description/
     * @timeComplexity O(n) Where n is the length of input string
     * @spaceComplexity O(1)
     * @param A
     * @param B
     * @return Whether A can be rotated to get B
     */
    public boolean rotateString(String A, String B) {
        // Concatenate first string and see if second is contained in it
        return (A.length() == B.length()) && (A + A).indexOf(B) > -1;
    }

}
