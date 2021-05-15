package algoexpert.graphs.normal;

/**
 * You're given three inputs, all of which are instances of an AncestralTree class that have an ancestor property pointing
 * to their youngest ancestor. The first input is the top ancestor in an ancestral tree (i.e. the only instance that has
 * no ancestor -- its ancestor property points to its null and the other two inputs are descendants in the ancestral tree.
 *
 * Write a function that returns the youngest common ancestor to the two descendants.
 *
 * Note that a descendant is considered its own ancestor.
 */
public class YoungestCommonAncestor {

    public static void main(String[] args) {

    }

    // Time Complexity - O(d) | Space Complexity - O(1), where d is the depth of the tree.
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDepth(descendantOne, topAncestor);
        int depthTwo = getDepth(descendantTwo, topAncestor);
        if (depthOne > depthTwo) {
            return getYoungestCommonAncestor(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return getYoungestCommonAncestor(descendantTwo, descendantOne, depthTwo - depthOne);
        }
    }

    private static int getDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;
        while (descendant != topAncestor) {
            depth++;
            descendant = descendant.ancestor;
        }
        return depth;
    }

    private static AncestralTree getYoungestCommonAncestor(AncestralTree lowerDescendant, AncestralTree higherDescendant, int depth) {

        while (depth > 0) {
            lowerDescendant = lowerDescendant.ancestor;
            depth--;
        }

        while (lowerDescendant != higherDescendant) {
            lowerDescendant = lowerDescendant.ancestor;
            higherDescendant = higherDescendant.ancestor;
        }
        return lowerDescendant;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
