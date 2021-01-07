public class MyLinkedList{
  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = size;
    start = start;
    end = end;
  }

  public int size() {
    return size;
  }

  public boolean add(String value) {
    Node x = new Node(value);
    if (size() == 1) {
      x = start;
      x = end;
    }
    else {
      x.setPrev(end);
      end.setNext(x);
      end = x;
    }
    size++;
    return true;
  }

  public void add(int index, String value) {
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
