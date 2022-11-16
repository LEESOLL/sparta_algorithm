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
            throw new EmptyStackException(); //스택이 비어있을 경우 예외 처리
        }
        T item = top.data; //item변수에 기존 제일 위에 있던 노드의 데이터를 넣어줌
        top = top.next; //제일 위에 있는 노드 다음노드를 제일 위에 있는 노드로 변경 -> 기존의 제일 위에 있던 노드 삭제
        return item;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item); //매개변수로 받은 item을 새로운 노드로 만들어줌
        newNode.next = top; //기존의 제일 위에 있던 노드를 새로운 노드의 다음노드로 변경
        top = newNode; //새로운 노드를 제일 위의 노드로 변경
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException(); //스택이 비어있는 경우 예외 처리
        }
        return top.data; //제일 위에 있는 노드의 데이터를 보여줌
    }

    public boolean isEmpty() {
        return top == null;
    } //스택이 비었으면 true; 아니면 false를 리턴
}
