package week_3;

import java.util.NoSuchElementException;

class MyQueue<T> { //큐 구현하기
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) { //생성자
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

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
        if(first == null) { //큐가 비어있을 때
            throw new NoSuchElementException();
        }
        T data = first.data; //삭제 전, T형 data 변수에 기존의 first 데이터 미리 저장
        first = first.next;

        if(first == null)
            last = null;

        return data;
    }

    public T peek() {
        if(first == null) { //큐가 비어있을 때
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
