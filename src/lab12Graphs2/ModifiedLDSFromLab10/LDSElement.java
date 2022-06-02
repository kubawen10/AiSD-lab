package lab12Graphs2.ModifiedLDSFromLab10;

import java.util.Objects;

public class LDSElement<T> {
    private LDSElement<T> representative;
    private LDSElement<T> next;
    private LDSElement<T> last;
    private T value;
    private int length = 1;

    public LDSElement(T value) {
        this.value = value;
        representative = this;
        next = null;
        last = this;
    }

    public LDSElement<T> getRepresentative() {
        return representative;
    }

    public void setRepresentative(LDSElement<T> representative) {
        this.representative = representative;
    }

    public LDSElement<T> getNext() {
        return next;
    }

    public void setNext(LDSElement<T> next) {
        this.next = next;
    }

    public LDSElement<T> getLast() {
        return last;
    }

    public void setLast(LDSElement<T> last) {
        this.last = last;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LDSElement<?> that = (LDSElement<?>) o;
        return length == that.length && Objects.equals(value, that.value);
    }

    @Override
    public String toString() {
        return "LDSElement{" +
                "value=" + value +
                " representative="+ representative.value +
                '}';
    }
}
