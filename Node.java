public class Node {
  private String data;
  private Node next;
  private Node prev;

  public Node(String value) {
    String data = value;
  }

  public String getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  public Node getPrev() {
    return prev;
  }

  public void setData(String new_value) {
    data = new_value;
  }

  public void setNext(Node new_value) {
    next = new_value;
  }

  public void setPrev(Node new_value) {
    prev = new_value;
  }
}
