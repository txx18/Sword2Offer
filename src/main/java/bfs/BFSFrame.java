package bfs;

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.*;

/**
 * @author ShaneTang
 * @create 2021-01-25 9:35
 */
public class BFSFrame {

    public static void main(String[] args) {
        NTreeNode root = new NTreeNode(1, new int[]{3, 2, 4});
        root.adj()[0] = new NTreeNode(3, new int[] {5, 6});
        List<Integer> preorderNTree = TreeUtils.preorderNTree(root);
//        System.out.println("preorderNTree = " + preorderNTree);
        BFSFrame obj = new BFSFrame();
//        NTreeNode res = obj.bfs(root, root.adj()[0]/*.adj()[0]*/);
        int res = obj.bfs(root, root.adj()[0]);
        System.out.println("res = " + res);

    }

    public int bfs(NTreeNode start, NTreeNode target) {
        Queue<NTreeNode> queue = new LinkedList<>();
        Set<NTreeNode> visited = new HashSet<>();
        int step = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NTreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                if (target.equals(cur)) {
                    return step;
                }
                for (NTreeNode adj: cur.adj()) {
                    if (visited.contains(cur)) {
                        continue;
                    }
                    queue.offer(adj);
                    visited.add(adj);
                }
            }
            step++;
        }
        return step;
    }
}