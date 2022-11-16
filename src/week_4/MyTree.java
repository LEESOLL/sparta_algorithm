package week_4;

public class MyTree { //배열을 이진 검색 트리로 만들기
    class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
            this.data = data;
        }
    }
    Node root; //트리가 시작되는 노드

    public void makeTree(int[] a) { //배열 정보를 받아서 트리를 만드는 일을 시작해주는 함수
        root = makeTreeR(a, 0, a.length -1); //재귀 호출를 반복적으로 실행하기에 앞서서 재귀호출에 필요한 데이터를 처음으로 던져주는 일을 함
        //재귀 호출이 끝나면 가장 꼭대기에 있는 루트노드의 주소를 받아서 멤버변수에 저장
    }
    public Node makeTreeR(int[] a, int start, int end) { //재귀함수
        if (start > end) return null; //재귀호출에서 무한루프에 빠지지 않을 조건문
        int mid = (start + end) / 2; //받은 시작지점과 끝지점으로 중간지점 계산
        Node node = new Node(a[mid]); //그 중간지점에 저장된 값으로 노드를 생성
        node.left = makeTreeR(a, start, mid - 1); //a배열의 시작지점부터 중간값 바로 앞까지의 서브트리를 현재 노드의 왼쪽에 저장
        node.right = makeTreeR(a, mid + 1, end); //중간값 바로 다음 방부터 end지점까지의 데이터로 만든 서브트리는 오른쪽에 저장
        return node;
    }
    public void searchBTree (Node n, int find) {
        if (find < n.data) {
            System.out.println("Data is smaller than " + n.data);
            searchBTree(n.left, find);
        }
        else if (find > n.data) {
            System.out.println("Data is bigger than " + n.data);
            searchBTree(n.right, find);
        }
        else System.out.println("Data found!");
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        MyTree t = new MyTree();
        t.makeTree(a);
        t.searchBTree(t.root, 2);
    }
}
