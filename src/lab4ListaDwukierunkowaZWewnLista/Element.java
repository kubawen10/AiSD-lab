package lab4ListaDwukierunkowaZWewnLista;

public class Element<E> {
    private int used = 0;
    private E[] array;
    private Element next;
    private Element prev;

    @SuppressWarnings("unchecked")
    public Element(int n) {
        array = (E[]) (new Object[n]);
        next = null;
        prev = null;
    }


    public void addLast(E value) {
        if (next != null) {
            next.addLast(value);
        } else {
            if (isFull()) {
                addNextElement().addLast(value);
            } else {
                array[used] = value;
                used++;
            }
        }
    }

    public boolean addInner(int index, E value) {
        E moveRight = shiftRight(index);
        array[index] = value;

        if (used==array.length) {
            addNextElement();
            next.addInner(0, moveRight);

//            if (next != null) {
//                // czy dodac nowa tablice z jednym elementem a nie przesuwac?
//                next.addInner(0, moveRight);
//            } else {
//                addNextElement().addLast(moveRight);
//            }
        } else {
            used++;
        }
        return true;
    }

    public boolean addInnerLast(E value){
        if(used==array.length){
            return false;
        }
        array[used] = value;
        used++;
        return true;
    }

    public E shiftRight(int fromIndex) {
        E lastValue = array[array.length - 1];
        for (int i = array.length - 1; i > fromIndex; i--) {
            array[i] = array[i - 1];
        }
        return lastValue;
    }

    public E shiftLeft(int fromIndex) {
        E firstValue = array[fromIndex];

        used--;
        for (int i = fromIndex; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        return firstValue;
    }

    public boolean isFull() {
        return used == array.length;
    }

    public void remove() {
        if (prev != null) {
            prev.setNext(next);
        }

        if (next != null) {
            next.setPrev(prev);
        }
    }

    public E remove(int index) {
        E returnValue = shiftLeft(index);
        if (used == 0) {
            remove();
        }
        return returnValue;
    }

    public Element addNextElement() {
        Element newElement = new Element(array.length);

        if(next!=null){
            next.setPrev(newElement);
        }

        newElement.setNext(next);
        newElement.setPrev(this);
        next = newElement;

        return next;
    }

    public boolean contains(E value) {
        for (int i = 0; i < used; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E value) {
        for (int i = 0; i < used; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public E getValue(int index) {
        return array[index];
    }

    public void setValue(int index, E value) {
        array[index] = value;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Element getPrev() {
        return prev;
    }

    public void setPrev(Element prev) {
        this.prev = prev;
    }

    public boolean equals(Element e) {
        if (used == e.used && next == e.next && prev == e.prev) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        return equals((Element) o);
    }

    public int getFreeSpace(){
        return array.length - used;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < array.length; i++) {
            if(i<used){
                s += array[i];
            }
            if (i != array.length - 1) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}
