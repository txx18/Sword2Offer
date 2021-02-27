package tree.dfs.inorder;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 *  
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * <p>
 *  
 * <p>
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * <p>
 * 注意：此题对比原题有改动。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-15 17:08
 */
public class TreeToLinkedList {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        TreeToLinkedList obj = new TreeToLinkedList();
        Node listHead = obj.solutionInorder(root);
        Node cur = listHead;
        do {
            System.out.print(cur.val + " ");
            cur = cur.right;
        } while (cur != listHead);
    }

    private Node pre;
    private Node head;

    private Node solutionInorder(Node pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inorder(pRootOfTree);
        // 如果题目要求循环链表，最后设置一下循环链表，两句不分先后
        // 此时 root回到root，而pre遍历到最后一个节点（最大值）
/*        pre.right = head;
        head.left = pre;*/
        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        // 来到root节点，先设置left指针
        root.left = pre;
        // pre初始为null，设置head
        if (pre != null) {
            pre.right = root;
        }
        // pre不为null，设置right指针
        else {
            head = root;
        }
        // 移动pre指针
        pre = root;
        inorder(root.right);
    }

    /*    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inorder(root.right);
    }*/

    private Node solutionZS(Node root) {
        if (root == null) {
            return null;
        }
        // 最后处理双向链表的头尾节点
        Node listEnd = recurZS(root);

        Node listBegin = root;
        while (listBegin.left != null) {
            listBegin = listBegin.left;
        }
        listEnd.right = listBegin;
        listBegin.left = listEnd;
        return listBegin;
    }

    private Node recurZS(Node root) {
        if (root == null) {
            return null;
        }
        // 左子树右子树End
        Node leftEnd = recurZS(root.left);
        Node rightEnd = recurZS(root.right);
        // 左子树右子树begin
        Node leftBegin = leftEnd != null ? leftEnd.right : null;
        Node rightBegin = rightEnd != null ? rightEnd.right : null;
        // 具体子树的改造过程
        if (leftEnd != null && rightEnd != null) {
            // 处理leftEnd--root--rightBegin, rightEnd--leftBegin
            // 此情况尾节点是rE，头结点是lB
            leftEnd.right = root;
            root.left = leftEnd;
            root.right = rightBegin;
            rightBegin.left = root;
            rightEnd.right = leftBegin;
            return rightEnd;
        } else if (leftEnd != null) {
            // 处理leftEnd--root--leftBegin
            // 此情况尾节点是root，头结点是lB
            leftEnd.right = root;
            root.left = leftEnd;
            root.right = leftBegin;
            return root;
        } else if (rightEnd != null) {
            // 处理rightEnd--root--rightBegin，
            // 此情况尾节点是rightEnd，头结点是root
            root.right = rightBegin;
            rightBegin.left = root;
            rightEnd.right = root;
            return rightEnd;
        } else {
            // 处理自己
            // 此情况尾节点是root，头结点是root
            root.right = root;
            return root;
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
