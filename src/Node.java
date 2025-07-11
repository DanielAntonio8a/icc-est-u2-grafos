import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class Node {
    private int valor;
    private Set<Node> neighbors;

    public Node(int valor) {
        this.valor = valor;
        this.neighbors = new HashSet<>();
    }

    public int getValor() {
        return valor;
    }

    public Set<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Node)) return false;
        Node other = (Node) obj;
        return this.valor == other.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
