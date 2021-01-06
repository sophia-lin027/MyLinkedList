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
}
