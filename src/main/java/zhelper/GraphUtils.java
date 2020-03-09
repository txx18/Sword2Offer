package zhelper;



import java.util.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-05 10:15
 */
public class GraphUtils {

    /**
     * 接口函数，把某种数据结构转成此数据结构
     * @param matrix 二维数组表示图
     * @return
     */
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            // 解析二维数组
            Integer fromKey = matrix[i][0];
            Integer toKey = matrix[i][1];
            Integer weight = matrix[i][2];
            // 封装Graph的nodeMap
            if (!graph.nodeMap.containsKey(fromKey)) {
                graph.nodeMap.put(fromKey, new GraphNode(fromKey));
            }
            if (!graph.nodeMap.containsKey(toKey)) {
                graph.nodeMap.put(toKey, new GraphNode(toKey));
            }
            // 从nodeMap中获取fromNode和toNode
            GraphNode fromNode = graph.nodeMap.get(fromKey);
            GraphNode toNode = graph.nodeMap.get(toKey);
            // 封装Edge
            Edge newEdge = new Edge(weight, fromNode, toNode);
            // 封装GraphNode
            fromNode.nextNodeList.add(toNode);
            fromNode.out++;
            fromNode.in++;
            fromNode.edgeList.add(newEdge);
            graph.edgeSet.add(newEdge);
        }
        return graph;
    }

    public static class Graph {
        /**
         * 点集
         */
        public HashMap<Integer, GraphNode> nodeMap;
        /**
         * 边集
         */
        public HashSet<Edge> edgeSet;

        public Graph() {
            this.nodeMap = new HashMap<>();
            this.edgeSet = new HashSet<>();
        }
    }

    public static class GraphNode {
        /**
         * 值
         */
        public int value;
        /**
         * 入度
         */
        public int in;
        /**
         * 出度
         */
        public int out;
        /**
         * 指向的节点
         */
        public List<GraphNode> nextNodeList;
        /**
         * 出度的边
         */
        public List<Edge> edgeList;

        public GraphNode(int value) {
            this.value = value;
            this.in = 0;
            this.out = 0;
            this.nextNodeList = new ArrayList<>();
            this.edgeList = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GraphNode graphNode = (GraphNode) o;
            return value == graphNode.value &&
                    in == graphNode.in &&
                    out == graphNode.out &&
                    Objects.equals(nextNodeList, graphNode.nextNodeList) &&
                    Objects.equals(edgeList, graphNode.edgeList);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, in, out, nextNodeList, edgeList);
        }
    }

    public static class Edge {
        /**
         * 权值
         */
        public int weight;
        /**
         * 起点
         */
        public GraphNode fromNode;
        /**
         * 终点
         */
        public GraphNode toNode;

        public Edge(int weight, GraphNode fromNode, GraphNode toNode) {
            this.weight = weight;
            this.fromNode = fromNode;
            this.toNode = toNode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return weight == edge.weight &&
                    Objects.equals(fromNode, edge.fromNode) &&
                    Objects.equals(toNode, edge.toNode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(weight, fromNode, toNode);
        }
    }
}
