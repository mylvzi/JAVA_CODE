/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-16
 * Time: 20:29
 */
public class BinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root = null;

    // search
    public boolean search(int val) {
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            }else {
                return true;
            }
        }

        return false;
    }

    // insert
    public boolean insert(int val) {
        TreeNode newNode = new TreeNode(val);

        // 空树直接插入
        if (root == null) {
            root = newNode;
            return true;
        }

        // 保留cur的根节点
        TreeNode parent = null;
        TreeNode cur = root;

        while(cur != null) {
            parent = cur;

            if(cur.val < val) {
                cur = cur.right;
            } else if(cur.val > val){
                cur = cur.left;
            }else {
                // 二叉搜索树中不能存在两个相同的数字
                return false;
            }
        }

        // 此时cur就是要插入的位置
        if(parent.val < val) {
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }

        return true;
    }

    public void remove(int val) {
        TreeNode parent = null;
        TreeNode cur = root;

        while(cur != null) {
            parent = cur;

            if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            }else {
                removeNode(parent,cur);
                return;
            }
        }
    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        // 注意此时cur就是我要删除的数据
        if(cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }

        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }

        }else {// 都不等于Null
            // 找右树的最小值
            // 使用替罪羊法
/*            TreeNode targetParent = cur;
            TreeNode target = cur.right;

            // 找右树的最小值  知道某个结点的left为null  则此节点就是右树最左边的结点  也就是右树的最小值
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }

            cur.val = target.val;

            if (target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;

            }*/


            // 求左树的最大值
            TreeNode tp = cur;
            TreeNode t = cur.left;

            while (t.right != null) {
                tp = t;
                t = t.right;
            }

            // 此时t就是左树的最大值
            cur.val = t.val;

            // 重写链接
            if (t == tp.left) {
                tp.left = t.left;
            }else {
                tp.right = t.left;
            }
        }

    }

}
