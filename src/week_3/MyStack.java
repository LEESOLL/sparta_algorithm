package week_3;
import java.util.EmptyStackException;

class MyStack<T> { //스택 구현하기
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) { //생성자
            this.data = data;
        }
    }

    private Node<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
