package week_4;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;


class Queue<T> { //큐 구현하기
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

class Graph {
    class Node {
        int data;

        LinkedList<Node> adjacent; //인접한 노드들과의 관계는 linkedlist로 표현해줌, 그래프에서는 인접한 노드가 뭐가 있는지 linkedlist로 쭉 나열함
        boolean marked; //방문한 노드인지 알려주는 flag 선언

        Node (int data) { //노드의 생성자
            this.data = data; //파라미터로 입력받은 데이터로 초기화
            this.marked = false; //방문하지 않은거로 초기화
            adjacent = new LinkedList<Node>(); //인접한 노드를 저장하는 LinkedList를 준비시킴
        }
    }
    Node[] nodes; //그래프엔 노드들을 저장할 배열이 필요

    //그래프 생성자
    Graph(int size) { //간단하게 구현하기 위해 그래프의 노드 개수는 고정
       nodes = new Node[size]; //노드 갯수를 받아서 그 갯수만큼 배열방을 만들어줌
       for(int i = 0; i < size; i++) {
           nodes[i] = new Node(i); //배열의 인덱스와 같은 데이터로 배열 만들어줌, 0~n-1까지 데이터 들어감
       }
    }
    void addEdge(int i1, int i2) { //두 노드의 관계를 저장하는 함수
        Node n1 = nodes[i1]; //데이터가 인덱스와 같으니까 파라미터로 받은 숫자를 인덱스로 사용 가능
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)) { //n1, n2노드의 인접한 노드를 저장하는 adjacent LinkedList에 상대방 노드가 있는지 확인하고
            n1.adjacent.add(n2); //없으면 서로를 넣어줌
        }
        if(!n2.adjacent.contains(n1)) {
            n1.adjacent.add(n1);
        }
    }
    void dfs() { //매개변수 없이 dfs를 호출하면 0번부터 탐색 시작
        dfs(0);
    }
    void dfs(int index) { //시작 인덱스를 받아서 dfs 순회 결과를 출력하는 함수
        Node root = nodes[index]; //해당 인덱스로 노드를 가져와서 시작노드로 정해줌
        Stack<Node> stack = new Stack<>(); //스택을 하나 생성함
        stack.push(root); //현재 노드를 스택에 추가함
        root.marked = true; //스택에 들어갔다고 표시
        while (!stack.isEmpty()) {
            Node r = stack.pop(); //스택에서 노드 하나 가져오고
            for (Node n : r.adjacent) { //가져온 노드의 자식들을 스택에 추가
                if (n.marked == false) { //이때 스택에 추가되지 않은 노드들만 스택에 추가함
                    n.marked = true; //스택에 추가하니까 true로 바꿔줌
                    stack.push(n); //스택에 추가함
                }
            }
            visit(r); //방문하면 출력해주는 함수
        }
    }
    void bfs() { //bfs가 파라미터 없이 호출되면 0번 인덱스부터 탐색 시작
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index]; //파라미터로 받은 인덱스에 해당하는 노드를 받아옴
        Queue<Node> queue = new Queue<>();
        queue.add(root); //데이터를 큐에 추가
        root.marked = true; //추가했다고 마킹해줌
        while(!queue.isEmpty()) { //큐에 데이터가 하나도 없을 때 까지 반복
            Node r = queue.remove(); //큐에서 데이터를 한개 가져오고
            for(Node n : r.adjacent) { //큐에서 꺼낸 데이터의 인접한 노드들을 큐에 추가할건데
                if (n.marked == false) { //이미 큐에 들어갔던 건 빼고 큐에 안들어갔던 애들만 넣어줌
                    n.marked = true; //큐에 넣었으니 마킹을 true로 바꿔주고
                    queue.add(n); //큐에 추가해줌
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r) { //재귀호출을 이용한 dfs 구현, 재귀호출을 할 때는 linkedlist가 노드의 주소를 갖고 있기 때문에 재귀함수는 노드를 받는 형태가 되어야 함
        if (r == null) return; //받은 노드가 null 일때는 그냥 나감
        r.marked = true; //호출이 되었다고 노드에 마킹함
        visit(r); //인접노드를 호출하기 전에 데이터를 먼저 출력하고
        for (Node n : r.adjacent) { //호출이 되지 않은 인접노드를 호출해줌
            if(n.marked == false) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) { //배열방의 인덱스를 받는 형태
        Node r = nodes[index];
        dfsR(r); //해당 노드를 시작으로 재귀호출을 시작
    }

    void dfsR() { //아무것도 넘기지 않았을 때는 0번 데이터부터 시작
        dfsR(0);
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }

}

public class Test { //dfs(스택, 재귀함수), bfs 구현
    public static void main(String[] args) {
        Graph g = new Graph(9); //그래프를 생성하고 9개의 노드를 생성시에 만든다
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);
//        g.dfs();
//        g.bfs();
//        g.dfsR();
//        g.dfs(3);
//        g.bfs(3);
//        g.dfsR(3);
    }
}
