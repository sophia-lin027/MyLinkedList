public class MyLinkedList{
  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = 0;
    start = new Node(null);
    end = new Node(null);
  }

  public int size() {
    return size;
  }

  public boolean add(String value) {
    Node new_node = new Node(value);
    Node current = start;

    if (size() == 1) {
      start = new_node;
      end = new_node;
    }
    else {
      while (current != null) {
        current = current.getNext();
      }
    current.setNext(new_node);
    }
    size++;
    return true;
  }

  public void add(int index, String value) {
    if (index < 0.0 || index > size()) {
      throw new IndexOutOfBoundsException("The index " + index + " cannot be negative or greater than the size");
    }
  }

  public String get(int index) {
    return "test";
  }

  public String set(int index, String value) {
    return "test";
  }

  public String toString() {
    return "test";
  }
}
