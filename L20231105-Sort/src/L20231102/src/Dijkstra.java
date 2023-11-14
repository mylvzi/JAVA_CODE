/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-02
 * Time: 11:17
 */
import java.util.*;

import java.util.*;

class Node {
    String name;
    List<Edge> edges;
    int distance;
    Node previousNode;
    boolean visited;

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.distance = Integer.MAX_VALUE;
        this.visited = false;
    }
}

class Edge {
    Node targetNode;
    int weight;

    public Edge(Node targetNode, int weight) {
        this.targetNode = targetNode;
        this.weight = weight;
    }
}

class DijkstraExample {
    public static void main(String[] args) {
        // 创建节点
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        // 创建边
        nodeA.edges.add(new Edge(nodeB, 2));
        nodeA.edges.add(new Edge(nodeC, 4));
        nodeB.edges.add(new Edge(nodeD, 7));
        nodeC.edges.add(new Edge(nodeD, 1));
        nodeC.edges.add(new Edge(nodeE, 3));
        nodeD.edges.add(new Edge(nodeE, 5));

        // 设置起点和终点
        Node startNode = nodeA;
        Node endNode = nodeE;

        // 使用Dijkstra算法找到最短路径
        calculateShortestPath(startNode);

        // 打印最短路径和距离
        List<String> shortestPath = getShortestPath(endNode);
        int distance = endNode.distance;
        System.out.println("最短路径：" + shortestPath);
        System.out.println("最短距离：" + distance);
    }

    public static void calculateShortestPath(Node startNode) {
        startNode.distance = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            currentNode.visited = true;

            for (Edge edge : currentNode.edges) {
                Node targetNode = edge.targetNode;
                if (!targetNode.visited) {
                    int calculatedDistance = currentNode.distance + edge.weight;
                    if (calculatedDistance < targetNode.distance) {
                        targetNode.distance = calculatedDistance;
                        targetNode.previousNode = currentNode;
                        queue.add(targetNode);
                    }
                }
            }
        }
    }

    public static List<String> getShortestPath(Node endNode) {
        List<String> path = new ArrayList<>();
        for (Node node = endNode; node != null; node = node.previousNode) {
            path.add(node.name);
        }
        Collections.reverse(path);
        return path;
    }
}


