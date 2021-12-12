package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int numberOfElements = 0;

    public ImmutableLinkedList(Object[] elements) {
        if (elements.length != 0) {
            head = new Node();
            head.setValue(elements[0]);
            numberOfElements = 1;
            Node current = head;
            for (int i = 1; i < elements.length; i++) {
                Node next = new Node();
                next.setValue(elements[i]);
                next.setPrevious(current);
                current.setNext(next);
                current = next;
                numberOfElements += 1;
            }
            tail = current;
        }
    }

    public ImmutableLinkedList() {

    }

    @Override
    public ImmutableList add(Object e) {
        return this.add(numberOfElements, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        ImmutableLinkedList newList;
        Object[] elements = new Object[numberOfElements+1];
        for (int i = 0; i < index; i++) {
            elements[i] = this.get(i);
        }
        elements[index] = e;
        for (int i = index+1; i < numberOfElements+1; i++) {
            elements[i] = this.get(i-1);
        }
        newList = new ImmutableLinkedList(elements);
        return newList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(numberOfElements, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        ImmutableLinkedList newList;
        Object[] elements = new Object[numberOfElements+c.length];
        for (int i = 0; i < index; i++) {
            elements[i] = this.get(i);
        }
        for (int i = index; i < c.length+index; i++) {
            elements[i] = c[i-index];
        }
        for (int i = index+c.length; i < numberOfElements+c.length; i++) {
            elements[i] = this.get(i-c.length);
        }
        newList = new ImmutableLinkedList(elements);
        return newList;
    }

    @Override
    public Object get(int index) {
        if (index == 0) {
            return head.getValue();
        } else {
            Node current = head;
            for (int i = 1; i <= index; i++) {
                current = current.getNext();
            }
            return current.getValue();
        }
    }

    @Override
    public ImmutableList remove(int index) {
        ImmutableLinkedList newList;
        Object[] elements = new Object[numberOfElements-1];
        for (int i = 0; i < index; i++) {
            elements[i] = this.get(i);
        }
        for (int i = index+1; i < numberOfElements; i++) {
            elements[i-1] = this.get(i);
        }
        newList = new ImmutableLinkedList(elements);
        return newList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index == 0) {
            head.setValue(e);
        } else {
            Node current = head;
            for (int i = 1; i <= index; i++) {
                current = current.getNext();
            }
            current.setValue(e);
        }
        return this;
    }

    @Override
    public int indexOf(Object e) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.getValue() == e) {
                return index;
            }
            index += 1;
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            arr[i] = this.get(i);
        }
        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) this.add(e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) this.remove(numberOfElements-1);
    }
}
