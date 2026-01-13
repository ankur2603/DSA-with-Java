Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

class Solution {

    // stores path from root to target node
    public boolean getPath(TreeNode root, TreeNode n, ArrayList<TreeNode> path){

        if(root == null) return false;

        path.add(root);

        // target found
        if(root.val == n.val) return true;

        // search in left or right subtree
        if(getPath(root.left, n, path) || getPath(root.right, n, path)) {
            return true;
        }

        // backtrack if not on correct path
        path.remove(path.size() - 1);

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        // build paths from root to p and q
        getPath(root, p, path1);
        getPath(root, q, path2);

        int i = 0;

        // find last common node in both paths
        for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)) break;
        }

        return path1.get(i - 1);
    }
}
