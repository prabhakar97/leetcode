import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Solution811 {
    class Solution {
        /**
         * 811. Subdomain Visit Count https://leetcode.com/problems/subdomain-visit-count/description/
         *
         * @param cpdomains String[]
         *                  Array of counts and domains.
         * @return List of domains and their visit counts
         * @timeComplexity O(n * k) where n is the number of domains and k is the depth of a domain at any level
         * @spaceComplexity O(n) space for building tree. n is the number of domains.
         */
        public List<String> subdomainVisits(String[] cpdomains) {
            Node root = new Node();
            // Add all the domains to a tree and update the hitcounts
            for (String domain : cpdomains) {
                String[] countSplit = domain.split(" ");
                String[] domainParts = countSplit[1].split("\\.");
                addDomain(root, domainParts, domainParts.length - 1, Integer.parseInt(countSplit[0]));
            }

            // Enumerate all paths in the tree from root to leaf (including internal nodes)
            List<String> resultList = new ArrayList<>();
            traverseTree(root, resultList, "", 0);
            return resultList;
        }

        // Structure for tree
        class Node {
            int count;
            String domain;
            List<Node> children;

            public Node(String domain, int count) {
                this.domain = domain;
                this.count = count;
                this.children = new ArrayList<>();
            }

            public Node() {
                // Root node has blank domain and count as -1 as demarker
                this("", -1);
            }
        }

        // Traverse the tree finding all the counts and updating result list
        private void traverseTree(Node root, List<String> resultList, String currentDomain, int currentCount) {
            if (root != null) {
                String updatedDomain = "";
                if (root.count != -1) {
                    updatedDomain = root.domain + (currentDomain.length() == 0 ? "" : "." + currentDomain);
                    resultList.add(currentCount + root.count + " " + updatedDomain);
                }
                for (Node child : root.children) {
                    traverseTree(child, resultList, updatedDomain, currentCount);
                }
            }

        }

        // Add a domain to the tree
        private void addDomain(Node root, String[] domainParts, int index, int hitCount) {
            if (index >= 0) {
                String currentDomain = domainParts[index];
                // Find the current node
                Node child;
                Optional<Node> childOpt = root.children.stream().filter(n -> n.domain.equalsIgnoreCase(currentDomain)).findFirst();
                if (childOpt.isPresent()) {
                    child = childOpt.get();
                    child.count += hitCount;
                } else {
                    child = new Node(currentDomain, hitCount);
                    root.children.add(child);
                }
                addDomain(child, domainParts, index - 1, hitCount);
            }
        }
    }
}
