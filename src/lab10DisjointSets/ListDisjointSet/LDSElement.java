package lab10DisjointSets.ListDisjointSet;

import lab10DisjointSets.SetElement;

import java.util.Objects;

public class LDSElement extends SetElement {
    private LDSElement representative;
    private LDSElement next;
    private LDSElement last;
    private int length = 1;

    public LDSElement() {
        representative = this;
        next = null;
        last = this;
    }

    public LDSElement getRepresentative() {
        return representative;
    }

    public void setRepresentative(LDSElement representative) {
        this.representative = representative;
    }

    public LDSElement getNext() {
        return next;
    }

    public void setNext(LDSElement next) {
        this.next = next;
    }

    public LDSElement getLast() {
        return last;
    }

    public void setLast(LDSElement last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "LDSElement{" +
                "length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LDSElement that = (LDSElement) o;
        return length == that.length && Objects.equals(representative, that.representative) && Objects.equals(next, that.next) && Objects.equals(last, that.last);
    }
}
