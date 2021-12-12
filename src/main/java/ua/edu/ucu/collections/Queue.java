package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue = new ImmutableLinkedList();

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object object = queue.getFirst();
        this.queue = queue.removeFirst();
        return object;
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }
}
