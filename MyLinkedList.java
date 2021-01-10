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
}
