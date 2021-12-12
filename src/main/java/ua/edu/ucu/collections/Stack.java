package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public void push(Object e) {
        this.stack = (ImmutableLinkedList) this.stack.add(e);
    }

    public Object pop() {
        Object object = stack.getLast();
        this.stack = this.stack.removeLast();
        return object;
    }

    public Object peek() {
        return stack.getLast();
    }
}
