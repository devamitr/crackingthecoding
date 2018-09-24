import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class dynamic_prog {
    // problem 1
    public static int child_123(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return child_123_helper(n, memo);
    }

    public static int child_123_helper(int n, int[] memo) {
        if (n == 0) return 1;
        int n1 = 0, n2 = 0, n3 = 0;
        if (n >= 1) {
            if (memo[n - 1] != 0)
                n1 = memo[n - 1];
            else {
                memo[n - 1] = child_123_helper(n - 1, memo);
                n1 = memo[n - 1];
            }
        }
        if (n >= 2) {
            if (memo[n - 2] != 0)
                n2 = memo[n - 2];
            else {
                memo[n - 2] = child_123_helper(n - 2, memo);
                n2 = memo[n - 2];
            }
        }
        if (n >= 3) {
            if (memo[n - 3] != 0)
                n3 = memo[n - 3];
            else {
                memo[n - 3] = child_123_helper(n - 3, memo);
                n3 = memo[n - 3];
            }
        }
        return n1 + n2 + n3;
    }

    // problem 2

    public static ArrayList<Point> getPath(boolean[][] maze) {
        HashMap<Point, Boolean> cache = new HashMap<>();
        ArrayList<Point> path = new ArrayList<>();
        if (getPath_help(maze.length - 1, maze[0].length - 1, cache, path, maze))
            return path;
        return null;
    }

    public static boolean getPath_help(int row, int col, HashMap<Point, Boolean> cache, ArrayList<Point> path, boolean[][] maze) {
        if (row < 0 || col < 0 || !maze[row][col])
            return false;
        Point p = new Point(row, col);
        if (cache.containsKey(p))
            return cache.get(p);

        boolean isAtOrigin = (row == 0) && (col == 0);
        boolean success = false;

        if (isAtOrigin || getPath_help(row, col - 1, cache, path, maze) || getPath_help(row - 1, col, cache, path, maze)) {
            path.add(p);
            success = true;
        }
        cache.put(p, success);
        return success;
    }

    //problem 3
    public static int magic_index(int[] ary, int strt, int end) {
        if (end < strt)
            return -1;
        int mid = (end + strt) / 2;
        int mid_value = ary[mid];
        if (mid_value == mid)
            return mid;
        int leftvalue = Math.min(mid, mid_value);
        int left = magic_index(ary, strt, leftvalue);
        if (left >= 0) {
            return left;
        }
        int rightvalue = Math.max(mid, mid_value);
        int right = magic_index(ary, mid + 1, end);
        if (right >= 0) {
            return right;
        }
        return -1;
    }

    public void flatten(int_tree.Node root) {
        if (root == null)
            return;
        if (root.left != null)
            flatten(root.left);
        if (root.right != null)
            flatten(root.right);
        if (root.left != null) {
            int_tree.Node left_run = root.left;
            while (left_run.right != null)
                left_run = left_run.right;
            left_run.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
