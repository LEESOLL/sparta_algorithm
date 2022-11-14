package week_2;
//단일연결리스트 구현하기
public class MySingleLinkedList<T> {

    public Node<T> head; //첫 번째 노드의 주소
    public int size;

    public MySingleLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(item);
        newNode.next = head; //새로운 노드에 원래 head가 가리키던 주소를 넣어줘야 함(그래야 자기가 헤드가 되고, 원래 헤드 노드였던 것을 가리킬 수 있음)
        head = newNode;
        size++;
    }

    public void addAfter(Node<T> before, T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = before.next;
        before.next = newNode;
        size++;
    }

    public void add(int index, T item) { //index 위치에 새로운 노드 추가
        if(index < 0 || index > size)
            return;
        if(index == 0)
            addFirst(item);
        else {
            Node<T> q = getNode(index - 1);
            addAfter(q, item);
        }
    }

    public T removeFirst() {
        if (head == null)
            return null;
        T temp = head.data;
        head = head.next; //원래 head가 가리키고 있던 노드를 넣어줌 -> 원래 head 삭제
        size--;
        return temp;
    }

    public T removeAfter(Node<T> before) { //before 노드의 다음노드를 삭제
        if(before.next == null)
            return null;
        T temp = before.next.data;
        before.next = before.next.next;
        size--;
        return temp;
    }

    public T remove(int index) { //index에 해당하는 노드 삭제하고, 그 노드에 저장된 데이터를 반환
        if(index < 0 || index >= size)
            return null;
        if(index == 0)
            return removeFirst();
        Node<T> prev = getNode(index - 1);
        return removeAfter(prev);
    }

    public T remove(T item) { //item에 해당하는 노드를 찾아서 제거. -> 탐색도 해야함
        Node<T> p = head;
        Node<T> q = null; //p의 한칸 전의 노드를 가리킴
        while(p != null && !p.data.equals(item)) {
            q = p;
            p = p.next;
        }
        if(p == null)
            return null; //삭제할 노드가 존재하지 않을 때
        if(q == null)
            return removeFirst(); //삭제할 노드 전의 노드가 존재하지 않을 때 -> 노드가 하나밖에 없다는 뜻
        else
            return removeAfter(q);
    }

    public int indexOf(T item) { //item에 해당하는 노드의 index값 반환
        Node<T> p = head;
        int index = 0;
        while(p != null) {
            if(p.data.equals(item))
                return index;
            else {
                p = p.next;
                index++;
            }
        }
        return -1;
    }

    public Node<T> getNode(int index) { //연결리스트의 index번째 노드의 주소를 반환한다.
        if(index < 0 || index >=size)
            return null;
        Node<T> p = head;
        for(int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }


    public T get(int index) { //index번째 노드에 저장된 데이터를 반환한다
        if(index < 0 || index >= size)
            return null;
//        Node<T> p = head;
//        for(int i = 0; i < index; i++)
//            p = p.next;
//        return p.data;
        return getNode(index).data;
    }

    public T getFromLast(int index) { //뒤에서부터 index번째 노드에 저장된 데이터를 반환한다
        if(index < 0 || index >= size)
            return null;
        return getNode(size - index).data;
    }
}
