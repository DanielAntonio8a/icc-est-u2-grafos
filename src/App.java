public class App {
    public static void main(String[] args) throws Exception {
        Graph grafo = new Graph();
        System.out.println("Nombre: Daniel Duran");

        Node nodo5 = grafo.addNode(5);
        Node nodo8 = grafo.addNode(8);
        Node nodo0 = grafo.addNode(0);
        Node nodo1 = grafo.addNode(1);
        Node nodo9 = grafo.addNode(9);
        Node nodo2 = grafo.addNode(2);
        Node nodo3 = grafo.addNode(3);
        Node nodo4 = grafo.addNode(4);
        Node nodo7 = grafo.addNode(7);

        grafo.addEdge(nodo0, nodo5);
        grafo.addEdge(nodo0, nodo3);
        grafo.addEdge(nodo0, nodo1);
        grafo.addEdge(nodo1, nodo2);
        grafo.addEdge(nodo1, nodo4);
        grafo.addEdge(nodo1, nodo8);
        grafo.addEdge(nodo3, nodo2);
        grafo.addEdge(nodo3, nodo4);
        grafo.addEdge(nodo3, nodo7);
        grafo.addEdge(nodo3, nodo9);
        grafo.addEdge(nodo7, nodo8);

        grafo.printGraph();
    }
}

