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
      this.start = new_node;
      this.end = new_node;
    }

    size++;
    new_node.setPrev(this.end);
    (this.end).setNext(new_node);
    this.end = new_node;
    return true;
  }

  public void add(int index, String value) {
    if (index < 0.0 || index > size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    Node current = this.start;
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
    if (index < 0.0 || index >= this.size()) {
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
    if (index < 0.0 || index >= size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    Node current = this.start;
    int counter = 0;

    while (counter < index) {
      current = current.getNext();
      counter++;
    }
    return current.setData(value);
  }

  private Node move(int index) {
    if (index < 0.0 || index >= size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }

    if (index == 0.0) {
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
    if(size()==0){
      return "[]";
    }
    Node current = start;
    while(current.getNext() != null){
      output += current.getData() + ", ";
      current = current.getNext();
    }
    output += current.getData();
    return "[" + output + "]";
  }
}
