package lab3ListyJednokierunkowe;

public class Element <E>{
    private E value;
    private Element next;

    public Element(E data){
        value = data;
    }

    public Element(){
        value = null;
        next = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj instanceof Element<?>){
            return value.equals(((Element<?>) obj).getValue());
        }
        return false;
    }
}
