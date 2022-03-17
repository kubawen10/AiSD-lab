package lab3ListyJednokierunkowe;

import java.util.Iterator;
import java.util.ListIterator;

public class OneWayLinkedListWithSentinel<E> implements IList<E> {
    private Element head;

    public OneWayLinkedListWithSentinel() {
        head = new Element<E>();
    }

    @Override
    public boolean add(E e) {
        Element tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(new Element<>(e));
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Element<E> newElement = new Element<>(element);
        Element actElement = head;
        while (index > 0 && actElement.getNext() != null) {
            actElement = actElement.getNext();
            index--;
        }
        newElement.setNext(actElement.getNext());
        actElement.setNext(newElement);
    }

    @Override
    public void clear() {
        //take sentinel and set its next node to null
        head.setNext(null);
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    private Element getElement(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Element actElement = head;
        while (index >= 0 && actElement != null) {
            index--;
            actElement = actElement.getNext();
        }
        if (actElement == null) {
            throw new IndexOutOfBoundsException();
        }
        return actElement;
    }

    @Override
    public E get(int index) {
        Element<E> actElement = getElement(index);
        return actElement.getValue();
    }

    @Override
    public E set(int index, E element) {
        Element actElement = head;
        while (index > 0 && actElement.getNext() != null) {
            actElement = actElement.getNext();
            index--;
        }
        if (actElement.getNext() == null) {
            actElement.setNext(new Element<E>(element));
            return null;
        }
        E value = (E) actElement.getNext().getValue();
        Element newElement = new Element(element);
        newElement.setNext(actElement.getNext().getNext());
        actElement.setNext(newElement);

        return value;
    }

    @Override
    public int indexOf(E data) {
        int pos = 0;
        Element actElem = head.getNext();
        while (actElem != null) {
            if (actElem.getValue().equals(data))
                return pos;
            pos++;
            actElem = actElem.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
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
    public E remove(int index){
        Element actElement = head;
        while (index > 0 && actElement.getNext() != null) {
            actElement = actElement.getNext();
            index--;
        }
        if (actElement.getNext() == null) {
            throw new IndexOutOfBoundsException();
        }
        E value = (E) actElement.getNext().getValue();
        actElement.setNext(actElement.getNext().getNext());

        return value;
    }

    @Override
    public boolean remove(Element element) {
        try{
            remove(indexOf((E) element.getValue()));
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public int size() {
        int i = 0;
        Element actElement = head.getNext();
        while (actElement != null) {
            i++;
            actElement = actElement.getNext();
        }
        return i;
    }

    @Override
    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("[");
        Element actElement = head;
        while(actElement.getNext()!=null){
            actElement=actElement.getNext();
            b.append(actElement.getValue()).append(", ");
        }
        if(b.length()>2){
            b.setLength(b.length()-2);
        }
        b.append("]");
        return b.toString();
    }
}
