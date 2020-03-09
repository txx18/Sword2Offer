package graph;

import zhelper.GraphUtils.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-05 20:46
 */
public class BFS {
    /**
     *
     * @param node 从某个节点出发
     */
    public void bfs(GraphNode node) {
        if (node == null) {
            return;
        }
        // 准备一个Queue用来遍历，准备一个Set用来避开重复的节点
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> set = new HashSet<>();
        // 起点先进queue和set
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            // 出队列
            GraphNode cur = queue.poll();
            // 处理
            System.out.println(cur.value);
            // 遍历邻居节点
            for (GraphNode next : cur.nextNodeList) {
                // 如果不重复，加入queue和set
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
