package org.example;

import java.util.Comparator;

public class LCode295 {

}

class HeapNode {
    int val;
    HeapNode left;
    HeapNode right;

    public HeapNode(int val) {
        this.val = val;
    }
}

class Heap {

    HeapNode head;
    int size = 0;

    Comparator<HeapNode> heapNodeComparator;

    public Heap(Comparator<HeapNode> heapNodeComparator) {
        this.heapNodeComparator = heapNodeComparator;
    }

    public void add(int val) {
        HeapNode newHeapNode = new HeapNode(val);
        this.head = merge(this.head, newHeapNode);
        this.size++;
//        System.out.println("added " + val);
    }

    public int peek() {
        return this.head.val;
    }

    public int poll() {
        HeapNode top = this.head;
        this.head = merge(head.left, head.right);
        this.size--;
//        System.out.println("removed " + top.val);
        return top.val;
    }

    private HeapNode merge(HeapNode heapNode1, HeapNode heapNode2) {
        if (heapNode1 == null) {
            return heapNode2;
        }
        if (heapNode2 == null) {
            return heapNode1;
        }

        if (heapNodeComparator.compare(heapNode1, heapNode2) > 0) {
            HeapNode temp = heapNode1;
            heapNode1 = heapNode2;
            heapNode2 = temp;
        }

        if (Math.random() < 0.5) {
            HeapNode temp = heapNode1.left;
            heapNode1.left = heapNode1.right;
            heapNode1.right = temp;
        }

        heapNode1.left = merge(heapNode1.left, heapNode2);

        return heapNode1;
    }

}

class MedianFinder {

    final private Heap leftMaxHeap;
    final private Heap rightMinHeap;

    public MedianFinder() {
        this.leftMaxHeap = new Heap(Comparator.comparingInt(o -> o.val));
        this.rightMinHeap = new Heap(Comparator.comparingInt(o -> -o.val));
    }

    public void addNum(int num) {
        if (leftMaxHeap.size == 0 || num <= leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        if (leftMaxHeap.size > rightMinHeap.size + 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (rightMinHeap.size > leftMaxHeap.size) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size > 0 && leftMaxHeap.size == rightMinHeap.size) {
            double left  = leftMaxHeap.peek();
            double right = rightMinHeap.peek();
            return (left + right)/2;
        } else {
            return leftMaxHeap.peek();
        }
    }
}
