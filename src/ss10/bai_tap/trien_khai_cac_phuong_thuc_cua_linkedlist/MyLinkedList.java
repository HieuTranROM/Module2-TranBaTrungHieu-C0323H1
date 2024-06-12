package ss10.bai_tap.trien_khai_cac_phuong_thuc_cua_linkedlist;

public class MyLinkedList<E> {

        Node head;
        int numNodes = 0;

        public MyLinkedList() {
        }

        public MyLinkedList(E data) {
            head = new Node(data);
        }

        public void addFirst(E e) {
            Node temp = head;
            head = new Node(e);
            head.next = temp;
            numNodes++;
        }

        public void addLast(E e) {
            Node temp = head;
            for (int i = 0; i < numNodes - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(e);
            numNodes++;
        }

        public void add(int index, E element) {
            if (head == null || index <= 0) {
                addFirst(element);
                return;
            }
            Node temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            Node holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }

        public E get(int index) {
            Node temp = head;
            for (int i = 0; i < index && temp.next != null; i++) {
                temp = temp.next;
            }
            return temp.getData();
        }

        public E getFirst() {
            return head.getData();
        }

        public E getLast() {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            return temp.getData();
        }

        public E remove(int index) {
            if (index < 0 || index >= numNodes) {
                throw new IllegalArgumentException("Index: " + index);
            }
            E data;
            if (index == 0) {
                data = head.getData();
                head = head.next;
            } else {
                Node temp = head;
                for (int i = 0; i < index - 1 && temp.next != null; i++) {
                    temp = temp.next;
                }
                data = temp.next.getData();
                temp.next = temp.next.next;
            }
            numNodes--;
            return data;
        }

        public boolean remove(E e) {
            if (head.getData() == e) {
                head = head.next;
                numNodes--;
                return true;
            } else {
                Node temp = head;
                for (int i = 0; i < numNodes && temp.next != null; i++) {
                    if (temp.next.getData() == e) {
                        temp.next = temp.next.next;
                        numNodes--;
                        return true;
                    }
                    temp = temp.next;
                }
            }
            return false;
        }

        public int size() {
            return numNodes;
        }

        public MyLinkedList<E> clone() {
            if (numNodes == 0) {
                throw new NullPointerException("NumNodes = " + numNodes);
            }
            MyLinkedList<E> temp = new MyLinkedList<>();
            Node tempNode = head;
            temp.addFirst(tempNode.data);
            tempNode = tempNode.next;
            while (tempNode != null) {
                temp.addLast(tempNode.getData());
                tempNode = tempNode.next;
            }
            return temp;
        }

        public boolean contains(E o) {
            Node temp = head;
            while (temp.next != null) {
                if (temp.getData() == o) {
                    return true;
                }
                temp = temp.next;
            }
            if (temp.getData() == o) {
                return true;
            }
            return false;
        }

        public int indexOf(E o) {
            Node temp = head;
            for (int i = 0; i < numNodes - 1; i++) {
                if (temp.getData() == o) {
                    return i;
                }
                temp = temp.next;
            }
            if (temp.getData() == o) {
                return (numNodes - 1);
            }
            return -1;
        }

        public void clear() {
            head = null;
            numNodes = 0;
        }

        public class Node {
            Node next;
            private E data;

            public Node(E data) {
                this.data = data;
            }
            public E getData() {
                return data;
            }
        }
    }
