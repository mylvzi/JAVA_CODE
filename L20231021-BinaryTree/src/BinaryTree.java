import java.util.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉树的链式实现
 * User: 绿字
 * Date: 2023-10-21
 * Time: 19:10
 */
public class BinaryTree {

    static class TreeNode {
        public int val;
        public TreeNode lChild;// 左孩子
        public TreeNode rChild;// 右孩子

        public TreeNode(char val) {
            this.val = val;
        }
    }



    public TreeNode create() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.lChild = B;
        A.rChild = C;

        B.lChild = D;
        B.rChild = E;

        C.lChild = F;
        C.rChild = G;

        E.rChild = H;

        return A;
    }

    // 前序
    public void preOrder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val+" ");

        preOrder(root.lChild);
        preOrder(root.rChild);
    }


    // 中序
    public void inOrder(TreeNode root) {
        if(root == null) return;

        inOrder(root.lChild);
        System.out.print(root.val+" ");
        inOrder(root.rChild);
    }

    public void postOrder(TreeNode root) {
        if(root == null) return;

        postOrder(root.lChild);
        postOrder(root.rChild);
        System.out.print(root.val+" ");
    }

    public List<TreeNode> preOrder2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        if(root == null) return list;
        list.add(root);

        List<TreeNode> leftTree = preOrder2(root.lChild);
        list.addAll(leftTree);

        List<TreeNode> rightTree = preOrder2(root.rChild);
        list.addAll(rightTree);

        return list;
    }

//        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> list = new ArrayList<>();
//
//            if(root == null) return list;
//
//            List<Integer> leftTree = inorderTraversal(root.left);
//            list.addAll(leftTree);
//
//            list.add(root.val);
//
//            List<Integer> rightTree = inorderTraversal(root.right);
//            list.addAll(rightTree);
//
//            return list;
//        }

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//
//        if(root == null) return list;
//
//        List<Integer> leftTree = postorderTraversal(root.left);
//        list.addAll(leftTree);
//
//        List<Integer> rightTree = postorderTraversal(root.right);
//        list.addAll(rightTree);
//
//        list.add(root.val);
//
//        return list;
//    }


    /**
     * 求size  遍历每一个结点 设置一个计数器
     */

    public int size = 0;

    public int getSize(TreeNode root) {
        if(root == null) return 0;
        size++;

        getSize(root.lChild);
        getSize(root.rChild);

        return size;
    }

    // 子问题思路：结点的个数 == 左子树的节点个数+右子树的结点个数+根节点
    public int getSize2(TreeNode root) {
        if(root == null) return 0;

        return getSize2(root.lChild) +
                getSize2(root.rChild) + 1;
    }

    /**
     * 求叶子节点的个数
     * 1.遍历实现  满足左右节点都为空  ++
     * 2.子问题思路：root叶子节点的个数 == 左子树叶子节点的个数+右子树叶子节点的个数
     */

    public int leafSize = 0;

    public int getLeafSize(TreeNode root) {
        // 递归结束条件
        if(root == null) return 0;

        if (root.lChild == null && root.rChild == null) {
            leafSize++;
        }

        getLeafSize(root.lChild);
        getLeafSize(root.rChild);

        return leafSize;
    }

    public int getLeafSize2(TreeNode root) {
        // 子问题思路
        // root叶子节点的个数 == 左子树叶子节点的个数+右子树叶子节点的个数
        if(root == null) return 0;
        if(root.lChild == null && root.rChild == null) return 1;

        return getLeafSize2(root.lChild) + getLeafSize2(root.rChild);
    }

    /**
     * 获取第k层结点的个数
     * 子问题思路：等价于左树第k-1层和右树第k-1层结点的个数
     * 一直走到第k层
     * @param root
     * @param k
     * @return
     */
    public int getKLevelNodeConut(TreeNode root,int k) {
        if(root == null) return 0;
        // 等于1  证明走到了第k层  现在就是第k层的某一个节点
        if(k == 1) return 1;

        return getKLevelNodeConut(root.lChild,k-1) +
                getKLevelNodeConut(root.rChild,k-1);

    }


    /**
     * 求高度
     * 高度 = 左树和右树高度的最大值 + 1
     * 子问题思路：root这棵树的高度 = root左树和root右树高度的最大值+1；
     * @param root
     */

    // 1. 这种方法在力扣上通过不了  因为递归重复进行了
    public int getHeight2(TreeNode root) {
        // 想好递归条件  最后一定是走到null结点  其高度为0  往回归
        if(root == null) return 0;

        return getHeight2(root.lChild) > getHeight2(root.rChild) ?
                (getHeight2(root.lChild)+1) : (getHeight2(root.rChild) + 1);

    }

    // 这种方法可以通过  递归只计算了一次
    public int getHeight(TreeNode root) {
        // 想好递归条件  最后一定是走到null结点  其高度为0  往回归
        if(root == null) return 0;
        int leftHeight = getHeight(root.lChild);
        int rightHeight = getHeight(root.rChild);

        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;

    }


    /**
     * 判断是否含有某个值的结点
     */

    public boolean find(TreeNode root,char val) {
        // 为空  直接返回
        if(root == null) return false;
        // 先判断根节点
        if(root.val == val) return true;

        // 遍历左子树  如果找到，则flg1为true  直接返回即可  不需要再去遍历右子树
        boolean flg1 = find(root.lChild,val);
        if(flg1) return true;

        // 遍历右子树
        boolean flg2 = find(root.rChild,val);
        if(flg2) return true;

        return false;
    }

    /**
     * 层序遍历  一层一层的遍历  打印
     * 先遇到  先打印  fifo  先进先出  使用队列存储遍历的结点
     * @param root
     */

    // 层序遍历
    public void levelOrder(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val+" ");

            if (cur.lChild != null) {
                queue.offer(cur.lChild);
            }

            if (cur.rChild != null) {
                queue.offer(cur.rChild);
            }
        }
    }

    // 层序遍历
    public List<List<TreeNode>> levelOrder2(TreeNode root) {
        List<List<TreeNode>> ret = new ArrayList<>();
        int i = 0;// list的下标
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 求当前队列的size  有几个出几个
            int size = queue.size();

            // tmp用于存储当前所在层的所有值
            List<TreeNode> tmp = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                TreeNode cur = queue.poll();
                tmp.add(cur);
                System.out.print(cur.val+" ");

                if (cur.lChild != null) {
                    queue.offer(cur.lChild);
                }

                if (cur.rChild != null) {
                    queue.offer(cur.rChild);
                }
            }
            ret.add(tmp);

        }

        return ret;
    }

    /**
     * 判断是否是完全二叉树
     * @param root
     * @return
     */
    public boolean iscompleteTree(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 如果queue中存储的是null 它会被存储到queue中  但却不算有效数据个数
            if (cur == null) {
                if(queue.size() != 0) {
                    return false;
                }
            }

            queue.offer(cur.lChild);
            queue.offer(cur.rChild);
        }

        return true;
    }

    /**
     * 找最近的公共祖先  三种情况
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)  return null;

        if(root == p || root == q) return root;

        // 判断是在同一边还是两侧
        TreeNode leftTree = lowestCommonAncestor(root.lChild,p,q);
        TreeNode rightTree = lowestCommonAncestor(root.rChild,p,q);

        if(leftTree != null && rightTree != null) {
            // 都不为空 证明p，q在根节点的左右两侧  公共祖先只能是root
            return root;
        } else if (leftTree == null) {
            return rightTree;
        }else {
            return leftTree;
        }

    }


    /**
     * 第二种方法  存储p，q路径上的所有节点  转变为求公共结点的问题
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        getPath(root, p, stack1);
        getPath(root, q, stack2);

        int sizeP = stack1.size();
        int sizeQ = stack2.size();

        if (sizeP > sizeQ) {
            int size = sizeP - sizeQ;
            while (size != 0) {
                stack1.pop();
                size--;
            }
        } else {
            int size = sizeQ - sizeP;
            while (size != 0) {
                stack2.pop();
                size--;
            }
        }

        // 此时两个栈的长度一致
        while(!stack1.peek().equals(stack2.peek())) {
            stack1.pop();
            stack2.pop();
        }

        return stack1.peek();
    }

    /**
     * 难点在于如何获得p，q路径上的所有节点
     * 利用栈存放通过前序遍历遇到的每一个节点  判断结点的左右子树是否包含要寻找的结点
     */

    private boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if(root == null || node == null) return false;
        stack.push(root);
        if(root == node) return true;

        boolean flg1 = getPath(root.lChild,node,stack);
        if(flg1) {
            return true;
        }
        boolean flg2 = getPath(root.rChild,node,stack);
        if (flg2) {
            return true;
        }

        stack.pop();
        return false;
    }


    /**
     * 根据前序+中序遍历创建二叉树
     */
//    class Solution {
//        public TreeNode buildTree(int[] preorder, int[] inorder) {
//            return buildChildTree(preorder,inorder,0,inorder.length-1);
//        }
//
//        public int pi;
//
//        public TreeNode buildChildTree(int[] preorder,int[] inorder,int beginIndex,int endIndex) {
//            if(beginIndex > endIndex) {
//                return null;
//            }
//            TreeNode root = new TreeNode(preorder[pi]);
//            int rootIndex = find(inorder,beginIndex,endIndex,preorder[pi]);
//            if(rootIndex == -1) return null;
//            pi++;
//
//            // 创建左子树
//            root.left = buildChildTree(preorder,inorder,beginIndex,rootIndex-1);
//
//            // 创建右子树
//            root.right = buildChildTree(preorder,inorder,rootIndex+1,endIndex);
//
//            return root;
//
//        }
//
//        private int find(int[] inorder,int beginIndex,int endIndex,int key) {
//            for(int i = beginIndex; i <= endIndex; i++) {
//                if(inorder[i] == key) {
//                    return i;
//                }
//            }
//
//            // 没找到  返回-1
//            return -1;
//
//        }
//    }
//
//
//    // 根据中序+后序创建二叉树
//    class Solution {
//        public int pi;
//        public TreeNode buildTree(int[] inorder,int[] postorder) {
//            pi = postorder.length-1;
//            return buildChildTree(postorder,inorder,0,inorder.length-1);
//        }
//
//
//        public TreeNode buildChildTree(int[] postorder,int[] inorder,int beginIndex,int endIndex) {
//            if(beginIndex > endIndex) {
//                return null;
//            }
//            TreeNode root = new TreeNode(postorder[pi]);
//            int rootIndex = find(inorder,beginIndex,endIndex,postorder[pi]);
//            if(rootIndex == -1) return null;
//            pi--;
//
//            // 创建右子树
//            root.right = buildChildTree(postorder,inorder,rootIndex+1,endIndex);
//
//            // 创建左子树
//            root.left = buildChildTree(postorder,inorder,beginIndex,rootIndex-1);
//
//            return root;
//
//        }
//
//        private int find(int[] inorder,int beginIndex,int endIndex,int key) {
//            for(int i = beginIndex; i <= endIndex; i++) {
//                if(inorder[i] == key) {
//                    return i;
//                }
//            }
//
//            // 没找到  返回-1
//            return -1;
//
//        }
//    }


    /**
     * 根据二叉树创建字符串
     */


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
//    class Solution {
//        public String tree2str(TreeNode root) {
//            StringBuilder stringBuilder = new StringBuilder();
//            tree2strChild(root,stringBuilder);
//            return stringBuilder.toString();
//        }
//
//        public void tree2strChild(TreeNode root,StringBuilder stringBuilder) {
//            if(root == null) return;
//            stringBuilder.append(root.val);
//
//            if(root.left != null) {
//                stringBuilder.append("(");
//                tree2strChild(root.left,stringBuilder);
//                stringBuilder.append(")");
//            }else {
//                if(root.right == null) {
//                    return;
//                }else {
//                    stringBuilder.append("()");
//                }
//            }
//
//            if(root.right != null) {
//                stringBuilder.append("(");
//                tree2strChild(root.right,stringBuilder);
//                stringBuilder.append(")");
//            }else {
//                return;
//            }
//        }
//    }

    /**
     * 前序，中序，后序的非递归实现
     */

    public void preOrderNor(TreeNode root) {
        if(root == null) return;

        // 使用栈来存放上一级的元素
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;

        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 一直走到左子树为空
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.lChild;
            }

            // 左子树为空  遍历右子树  如何获得右子树？上一级结点的右孩子  top获得栈顶元素
            top = stack.pop();
            cur = top.rChild;

        }
    }

    public void inOrderNor(TreeNode root) {
        if(root == null) return;

        // 使用栈来存放上一级的元素
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;

        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 一直走到左子树为空
                stack.push(cur);
                cur = cur.lChild;
            }

            // 左子树为空
            top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.rChild;

        }
    }


    public void postOrderNor(TreeNode root) {
        if(root == null) return;

        // 使用栈来存放上一级的元素
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        TreeNode prev = null;

        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 一直走到左子树为空
                stack.push(cur);
                cur = cur.lChild;
            }

            top = stack.peek();
            // 右边已经被打印过了  打印当前的根节点
            if (top.rChild == null || top.rChild == prev) {
                stack.pop();
                System.out.println(top.val);
                prev = top;// 标记此结点已经被打印过了
            }else {
                cur = top.rChild;
            }

        }
    }

    /**
     * 为什么多了一步标记呢？  左右根   先存放根结点  右边为空  打印根节点
     * 栈内存放的是上一级的根节点  还是会先判断右边孩子  死循环
     */


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();


            List<Integer> tmp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (cur.rChild != null) {
                    queue.offer(cur.rChild);
                }

                if (cur.lChild != null) {
                    queue.offer(cur.lChild);
                }

                tmp.add(cur.val);
            }

            ret.add(tmp);
        }

        // 倒着打印
        Collections.reverse(ret);
        for (List<Integer> innerList : ret) {
            Collections.reverse(innerList);
        }

        return ret;
    }

    public void createStack(TreeNode root,Stack<TreeNode> stack) {
        if(root == null) return;
        stack.push(root);

        Stack<TreeNode> rightstack = new Stack<>();
        createStack(root.rChild,rightstack);

        Stack<TreeNode> leftstack = new Stack<>();
        createStack(root.lChild,leftstack);

        for (int i = 0; i < rightstack.size(); i++) {
            stack.push(rightstack.pop());
        }

        for (int i = 0; i < leftstack.size(); i++) {
            stack.push(leftstack.pop());
        }
    }









}
