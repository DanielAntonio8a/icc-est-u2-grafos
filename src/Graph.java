import java.util.*;

public class Graph {
    private Set<Node> nodes;

    public Graph() {
        this.nodes = new HashSet<>();
    }

    public Node addNode(int value) {
        Node node = new Node(value);
        nodes.add(node);
        return node;
    }

    public void addEdge(Node src, Node dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    public void addEdgeUni(Node src, Node dest) {
        src.addNeighbor(dest);
    }

    public void printGraph() {
        List<Node> nodeList = new ArrayList<>(nodes);
        nodeList.sort(Comparator.comparingInt(Node::getValor)); // Ordenar los nodos por valor
    
        for (Node node : nodeList) {
            System.out.print("Vertex " + node.getValor() + ":");
            // Ordenar los vecinos también
            List<Node> neighbors = new ArrayList<>(node.getNeighbors());
            neighbors.sort(Comparator.comparingInt(Node::getValor));
        
            for (Node vecino : neighbors) {
                System.out.print(" -> " + vecino.getValor());
            }
            System.out.println();
        }
    }

    public void getDFS(Node startNode) {
        Set<Node> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsUtil(startNode, visited);
        System.out.println();
    }

    private void dfsUtil(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        System.out.print(node.getValor() + " ");
        for (Node neighbor : node.getNeighbors()) {
            dfsUtil(neighbor, visited);
        }
    }

    public void getBFS(Node startNode) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        System.out.print("BFS: ");
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.getValor() + " ");
            for (Node neighbor : current.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public int[][] getAdjacencyMatrix() {
        List<Node> nodeList = new ArrayList<>(nodes);
        int n = nodeList.size();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Node node = nodeList.get(i);
            for (Node neighbor : node.getNeighbors()) {
                int j = nodeList.indexOf(neighbor);
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    public void printAdjacencyMatrix() {
        int[][] matrix = getAdjacencyMatrix();
        System.out.println("Matriz de Adyacencia:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
