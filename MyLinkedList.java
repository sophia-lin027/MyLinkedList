public class MyLinkedList{
  private int size;
  private Node start, end;

  public MyLinkedList() {
    this.size = 0;
    this.start = null;
    this.end = null;
  }

  public int size() {
    return size;
  }

  public boolean add(String value) {
    Node new_node = new Node(value);

    if (size == 0) {
      start = new_node;
      end = new_node;
    }

    else {
      end.setNext(new_node);
      new_node.setPrev(end);
      end = new_node;
    }

    size++;
    return true;
  }

  public void add(int index, String value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    Node new_node = new Node(value);
    if (size == 0) {
      start = new_node;
      end = new_node;
    }

    else if (index == 0){
      start.setPrev(new_node);
      new_node.setNext(start);
      start = new_node;
    }

    else if (size == index) {
      end.setNext(new_node);
      new_node.setPrev(end);
      end = new_node;
    }

    else {
      Node new_prev = move(index - 1);
      Node new_next = move(index);
      new_node.setPrev(new_prev);
      new_node.setNext(new_next);
      new_prev.setNext(new_node);
      new_next.setPrev(new_node);
    }

    size++;
  }

  public String get(int index) {
    if (index < 0.0 || index >= this.size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    Node new_node = move(index);
    return new_node.getData();
  }

  public String set(int index, String value) {
    if (index < 0.0 || index >= size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    Node new_node = move(index);
    String original = new_node.getData();
    new_node.setData(value);

    return original;
  }

  public String remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    String original = "";
    if (size() == 1) {
      original = start.getData();
      start = null;
      end = null;
    }

    else if (index == 0) {
      Node next_start = start.getNext();
      original = start.getData();
      next_start.setPrev(null);
      start.setNext(null);
      start = next_start;
    }

    else if (index == size() - 1) {
      original = end.getData();
      Node end_value = end.getPrev();
      end_value.setNext(null);
      end.setPrev(null);
      end = end_value;
    }

    else {
      Node old_node = move(index);
      original = old_node.getData();
      old_node.getPrev().setNext(old_node.getNext());
      old_node.getNext().setPrev(old_node.getPrev());
      old_node.setNext(null);
      old_node.setPrev(null);
    }

    size--;
    return original;
  }

  public void extend(MyLinkedList other) {
    end.setNext(other.start);
    other.start.setPrev(end);
    size = size + other.size();
    other.start = null;
    other.end = null;
    other.size = 0;
  }

  public String toString() {
    String output = "";
    if (size == 0){
      return "[]";
    }

    Node current = start;
    while (current.getNext() != null){
      output = output + current.getData() + ", ";
      current = current.getNext();
    }

    output = output + current.getData();
    return "[" + output + "]";
  }

  public String toStringReversed() {
    String output = "";
    if (size == 0){
      return "[]";
    }

    Node current = end;
    while (current.getPrev() != null) {
      output = output + current.getData() + ", ";
      current = current.getPrev();
    }

    output = output + current.getData();
    return "[" + output + "]";
  }

  private Node move(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    if (index == 0) {
      return start;
    }

    if (index == size() - 1) {
      return end;
    }

    Node current = start;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }

}
