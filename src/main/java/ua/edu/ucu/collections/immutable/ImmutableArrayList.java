package ua.edu.ucu.collections.immutable;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] array;

    public ImmutableArrayList(Object[] elements) {
        this.array = elements;
    }

    public ImmutableArrayList() {
    }

    @Override
    public ImmutableList add(Object e) {
        return add(array.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newArray = new Object[array.length+1];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = e;
        System.arraycopy(array, index, newArray, index+1, array.length-index);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(array.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArray = new Object[array.length+c.length];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        System.arraycopy(array, index, newArray,
                index+c.length, array.length-index);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newArray = new Object[array.length-1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index+1, newArray, index, array.length-index-1);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newArray = new Object[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        if (array != null) {
            return array.length;
        }
        return 0;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public Object[] toArray() {
        return array;
    }
}
