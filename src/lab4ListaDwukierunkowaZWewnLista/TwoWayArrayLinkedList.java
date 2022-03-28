package lab4ListaDwukierunkowaZWewnLista;

import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayArrayLinkedList<E> implements IList<E> {
    private Element head = null;
    private int n;

    public TwoWayArrayLinkedList(int n) {
        this.n = n;
    }

    @Override
    public boolean add(E e) {
        if (head == null) {
            head = new Element(n);
        }
        head.addLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (head == null) {
            head = new Element(n);
        }
        Element actElement = head;
        while (actElement != null) {
            if (index < n) {
                actElement.addInner(index, element);
                return;
            } else {
                if (actElement.getNext() == null) {
                    actElement.addLast(element);
                    return;
                }
                index -= actElement.getUsed();
                actElement = actElement.getNext();
            }
        }
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean contains(E element) {
        Element actElement = head;
        while (actElement != null) {
            if (actElement.contains(element)) {
                return true;
            }
            actElement = actElement.getNext();
        }

        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Element actElement = head;
        while (actElement != null) {
            if (index < actElement.getUsed()) {
                return (E) actElement.getValue(index);
            }
            index -= actElement.getUsed();
            actElement = actElement.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Element actElement = head;
        while (actElement != null) {
            if (index < actElement.getUsed()) {
                E returnValue = (E) actElement.getValue(index);
                actElement.setValue(index, element);
                return returnValue;
            }
            index -= actElement.getUsed();
            actElement = actElement.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(E element) {
        Element actElement = head;
        int indexSum = 0;
        while (actElement != null) {
            int index = actElement.indexOf(element);
            if (index != -1) {
                return indexSum + index;
            } else {
                indexSum += actElement.getUsed();
            }
            actElement = actElement.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Element actElement = head;
        while (actElement != null) {
            if (index < actElement.getUsed()) {
                E returnValue = (E) actElement.remove(index);

                removeIfFirst(actElement);

                return returnValue;
            }
            index -= actElement.getUsed();
            actElement = actElement.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    private void removeIfFirst(Element actElement) {
        if (actElement == head && actElement.getUsed() == 0) {
            head = actElement.getNext();
        }
    }

    @Override
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean remove(Element e) {
        Element actElement = head;
        while (actElement != null) {
            if (actElement.equals(e)) {
                actElement.remove();
                removeIfFirst(actElement);
            }
        }
        return false;
    }

    @Override
    public int size() {
        int sum = 0;
        Element actElement = head;

        while (actElement != null) {
            sum += actElement.getUsed();
            actElement = actElement.getNext();
        }
        return sum;
    }

    @Override
    public String toString() {
        String s = "{\n";
        Element actElement = head;
        while (actElement != null) {
            s += actElement + " \n";
            actElement = actElement.getNext();
        }
        s += "}";
        return s;

    }
}
