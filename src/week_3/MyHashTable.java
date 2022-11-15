package week_3;
import java.util.LinkedList;

class MyHashTable { //해쉬테이블 구현하기
    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String getValue() {
            return value;
        }

        void setValue(String value) {
            this.value = value;
        }
    }

    LinkedList<Node>[] data; //(Node(key와 value를 가지는 객체)를 원소로 가지는 LinkedList형) 배열 data 생성

    MyHashTable(int size) { //생성자
        this.data = new LinkedList[size]; //생성과 동시에 크기가 size인 linkedlist형 배열 data 생성(= 리스트를 담는 배열)
    }

    int getHashCode(String key) {
        int hashcode = 0;
        for (char c : key.toCharArray()) {
            hashcode += c; //key의 각 문자를 아스키코드로 변환 후 다 더해줌
        }
        return hashcode;
    }

    int convertToIndex(int hashcode) {
        return hashcode % data.length; //hashcode를 data배열의 길이만큼 나눠서 인덱스값 구함
    }

    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) return null;
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    void put(String key, String value) {
        int hashcode = getHashCode(key); //해쉬코드 생성
        int index = convertToIndex(hashcode); //해쉬코드로 인덱스 생성
        System.out.println("key : " + key + ", hashcode : " + hashcode + ", index : " + index); //키, 해쉬코드, 인덱스 값 보여줌
        LinkedList<Node> list = data[index]; //기존 배열방의 index에 해당하는 값(리스트)을 가져와서 list변수에 넣어줌

        if (list == null) {
            list = new LinkedList<Node>(); //배열방이 비었다면 Linkedlist 생성
            data[index] = list; //해당 리스트를 배열방에 넣어줌
        }

        Node node = searchKey(list, key); //list에서 key값을 가진 노드 검색해서 가져옴
        if (node == null) {
            list.addLast(new Node(key, value)); //해당 key값을 가진 노드가 없다면 새로 만들어서 넣어줌
        } else {
            node.setValue(value); //해당 key값을 가진 노드가 있다면 기존의 노드를 대체해 주는 걸로 중복키 처리
        }
    }
    String get(String key) {
        int hashcode = getHashCode(key); //key값으로 hashcode 만들어줌
        int index = convertToIndex(hashcode); //hashcode를 인덱스로 만들어줌
        LinkedList<Node> list = data[index]; //data 배열의 index에 해당하는 리스트 가져옴
        Node node = searchKey(list, key); //linkedlist안에서 해당 키를 가지는 노드 검색해옴
        return node == null ? "Not found" : node.getValue(); //노드가 없으면 not found, 있으면 노드의 밸류값 return
    }

    public static void main(String[] args) {
        MyHashTable h = new MyHashTable(3);
        h.put("사과", "apple");
        h.put("바나나", "banana");
        h.put("딸기", "strawberry");
        h.put("포도", "grape");
        h.put("사과", "APPLE");

        System.out.println(h.get("사과"));
        System.out.println(h.get("바나나"));
        System.out.println(h.get("딸기"));
        System.out.println(h.get("포도"));
        System.out.println(h.get("키위"));

    }
}
