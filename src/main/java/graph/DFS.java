package graph;

import zhelper.GraphUtils.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-05 20:56
 */
public class DFS {

    public void dfs(GraphNode node) {
        if (node == null) {
            return;
        }
        // 准备一个stack用来遍历，一个set用来记录处理过的节点
        Stack<GraphNode> stack = new Stack<>();
        Set<GraphNode> set = new HashSet<>();
        // 起点进stack和set
        stack.add(node);
        set.add(node);
        // 先处理起点
        System.out.println(node.value);
        while (!stack.isEmpty()){
            // 出栈
            GraphNode cur = stack.pop();
            // 遍历邻居
            for (GraphNode next : cur.nextNodeList) {
                // 如果邻居没遇到过
                if (!set.contains(next)) {
                    // 把当前节点和它邻居重新压栈
                    stack.push(cur);
                    stack.push(next);
                    // 加入set
                    set.add(next);
                    // 处理这个邻居
                    System.out.println(next.value);
                }
            }
        }
    }

}
