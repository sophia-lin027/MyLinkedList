public class Node {
  private String data;
  private Node next;
  private Node prev;

  public Node(String value) {
    String data = value;
  }

  private String getData() {
    return data;
  }

  private Node getNext() {
    return next;
  }

  private Node getPrev() {
    return prev;
  }

  private void setData(String new_value) {
    data = new_value;
  }

  private void setNext(Node new_value) {
    next = new_value;
  }

  private void setPrev(Node new_value) {
    prev = new_value;
  }
}
