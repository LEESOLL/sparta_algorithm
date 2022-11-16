package week_3;

import java.util.NoSuchElementException;

class MyQueue<T> { //큐 구현하기
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) { //생성자
            this.data = data;
        } //생성자
    }

    private Node<T> first; //큐의 첫번째 노드
    private Node<T> last; //큐의 마지막 노드

    public void add(T item){
        Node<T> newNode = new Node<>(item);

        if(last != null) { //큐에 데이터가 있는 경우
            last.next = newNode;
        }
        last = newNode;
        if(first == null) { //큐에 데이터가 없는 경우
            first = last;
        }
    }

    public T remove() {
        if(first == null) { //큐가 비어있을 때 예외처리
            throw new NoSuchElementException();
        }
        T data = first.data; //삭제 전, T형 data 변수에 기존의 first 데이터 미리 저장
        first = first.next; //첫번째 노드에 기존 첫번째의 다음노드를 배정 -> 기존의 첫번째 노드 삭제 

        if(first == null) //큐가 비게되면 last = null 맞춰줌
            last = null; 

        return data;
    }

    public T peek() {
        if(first == null) { //큐가 비어있을 때 예외 처리
            throw new NoSuchElementException();
        }
        return first.data; //첫번째 노드의 데이터를 반환
    }

    public boolean isEmpty() {
        return first == null;
    } //큐가 비면 true, 아니면 false 반환
}
