package code;

public class Node<T> {

    public T data;
    public Node next;
    public Node prev;

    public Node(T i) {
        this.data = i;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}