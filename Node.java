public class Node {
  private String data;
  private Node next;
  private Node prev;

  public Node(String value) {
    this.data = value;
    this.next = null;
    this.prev = null;
  }

  public String getData() {
    return this.data;
  }

  public Node getNext() {
    return this.next;
  }

  public Node getPrev() {
    return this.prev;
  }

  public String setData(String new_value) {
    this.data = new_value;
    return new_value;
  }

  public boolean setNext(Node new_value) {
    this.next = new_value;
    return true;
  }

  public boolean setPrev(Node new_value) {
    this.prev = new_value;
    return true;
  }
}
