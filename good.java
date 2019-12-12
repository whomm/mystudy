import java.util.*;

public class good {


    public static class Node {
        public int val;
        public Node next;
    }


    public static Node mergeList(Node a, Node b) {

        Node head = null;
        Node now = null;

        while (a != null || b != null) {
            if ((a != null && b != null && a.val < b.val) || (a != null && b == null)) {
                if (now == null) {
                    now = a;
                    head = now;
                } else {
                    now.next = a;
                    now = now.next;
                }

                a = a.next;

            } else if ((a != null && b != null && a.val >= b.val) || (a == null && b != null)) {
                if (now == null) {
                    now = b;
                    head = now;
                } else {
                    now.next = b;
                    now = now.next;
                }

                b = b.next;
            }
        }
        return head;

    }

    public static class Demo {


        //静态方法定义泛型
        public static <A, B, C> B xmethod(C t) {
            return (B) t;
        }

        public static <W> void method2(W t) {
            System.out.println("method: " + t);
        }

        public static <T> T test2(Object str, Class<T> obj) {
            return (T) str;
        }

        public static <W> void method(W t) {
            System.out.println("method: " + t);
        }

        public static <M> M test5(Object str, Class<M> obj) {
            return (M) str;
        }
    }

    public static void main(String[] args) {
        //Object x = Demo.xmethod(9);


        Node[] array = new Node[11];
        for (int i = 0; i < 11; i++) {
            array[i] = new Node();
            array[i].val = i;
        }
        for (int i = 8; i >= 0; i--) {
            array[i].next = array[i + 2];
        }


        Node head = good.mergeList(array[0], array[1]);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }

}
