public class tree_4_8 {
    // this is the CTCI implementation
    public static int ancestor_without_parent_links(int_tree.Node root, int_tree.Node p, int_tree.Node q){
    if(!covers(root,p)||!covers(root,q))
        return Integer.MIN_VALUE;
    else if(covers(p,q))
        return p.data;
    else if(covers(q,p))
        return q.data;

    //check if p and q are on left or right side
        boolean p_side = covers(root.left,p);
        boolean q_side = covers(root.left,q);
        if(p_side==q_side) {
            int_tree.Node child_side = (p_side) ? root.left : root.right;
            return ancestor_without_parent_links(child_side, p, q);
        }
        else
            return root.data;
    }

    public static int ancestor_with_parent_links(int_tree.Node root, int_tree.Node p, int_tree.Node q) {
        if(root == null)
            return Integer.MIN_VALUE;
        if(covers(p,q))
            return p.data;
        if(covers(q,p))
            return q.data;
        // check if the sibling covers the q node
        int_tree.Node sibling= getsibling(p);
        int_tree.Node parent = p.parent;
        while(!covers(sibling,q)){
            sibling = getsibling(parent);
            parent = parent.parent;
        }
        return parent.data;
    }

    private static int_tree.Node getsibling(int_tree.Node p) {
        return p.parent.left == p? p.parent.right:p.parent.left;
    }
    private static boolean covers(int_tree.Node root,int_tree.Node p){
      if(root == null) return false;
      if(root==p) return true;
      return covers(root.left, p)||covers(root.right,p);
    }
}
