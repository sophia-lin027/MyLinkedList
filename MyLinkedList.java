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
    Node new_value = new Node(value);
    if (size == 0) {
      this.start = new_value;
      this.end = new_value;
    }

    (this.end).setNext(new_value);
    this.end = new_value;
    size++;
    return true;
  }

  public void add(int index, String value) {
    if (index < 0.0 || index > size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    Node current = start;
    Node placeholder = new Node(value);
    if (current != null) {
      for (int i = 0; i < index && current.getNext() != null; i++) {
        current = current.getNext();
      }
    }
    placeholder.setNext(current.getNext());
    current.setNext(placeholder);
    size++;
  }

  public String get(int index) {
    if (index < 0.0 || index > this.size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    Node current = this.start;
    int counter = 0;
    while (counter < index) {
      current = current.getNext();
      counter++;
    }
    return current.getData();
  }

  public String set(int index, String value) {
    if (index < 0.0 || index > size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    Node current = start;
    Node placeholder = new Node(value);
    if (current != null) {
      for (int i = 0; i < index && current.getNext() != null; i++) {
        current = current.getNext();
      }
    }
    return current.getData();
  }

  public String toString() {
    String output = "";
    if (start != null) {
      Node current = start.getNext();
      while (current != null) {
        output = output + current.getData().toString();
        if (current.getNext() != null) {
          output = output + ", ";
        }
        current = current.getNext();
      }
    }
    return "[" + output + "]";
  }
}
