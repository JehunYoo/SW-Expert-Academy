import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0; i<N; i++)
                list.add(Integer.parseInt(in[i]));
            int C = Integer.parseInt(br.readLine());
            in = br.readLine().split(" ");

            int i = 0;
            int x = -1, y = -1;
            while(i < in.length) {
                if(in[i].equals("I")) {
                    x = Integer.parseInt(in[++i]);
                    y = Integer.parseInt(in[++i]);
                    while(y > 0) {
                        list.insert(x++, Integer.parseInt(in[++i]));
                        y--;
                    }
                }
                i++;
            }

            bw.write("#" + t);
            for(int j=0; j<10; j++) {
                bw.write(" " + list.get(j));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}

class LinkedList<T> {
    private class LinkedListNode {
        T value;
        LinkedListNode next;

        LinkedListNode() {}
        LinkedListNode(T value, LinkedListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    private LinkedListNode head;
    private int size;

    LinkedList() {}
    LinkedList(T value) {
        head = new LinkedListNode(value, null);
        size++;
    }

    private LinkedListNode getNode(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds.", index));

        LinkedListNode node = head;
        for(int i=0; i<index; i++)
            node = node.next;

        return node;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public int size() {
        return size;
    }

    public boolean insert(int index, T value) {
        if(index == 0)
            return addFirst(value);

        LinkedListNode node = getNode(index - 1);

        try {
            node.next = new LinkedListNode(value, node.next);
            size++;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addFirst(T value) {
        try {
            head = new LinkedListNode(value, head);
            size++;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean add(T value) {
        try {
            if(size == 0)
                head = new LinkedListNode(value, null);
            else
                getNode(size - 1).next = new LinkedListNode(value, null);
            size++;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public T remove() {
        try {
            T value;
            if(size > 1) {
                LinkedListNode node = getNode(size - 2);
                value = node.next.value;
                node.next = null;
                size--;
            } else if(size == 1) {
                value = head.value;
                head = null;
                size--;
            } else {
                value = null;
            }
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}