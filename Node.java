class Node {
  String data;
  Node link;
  Node(String data, Node link) {
    this.data = data;
    this.link = link;
  }
  public void setData(String data) {
    this.data = data;
  }
  public void setLink(Node link) {
    this.link = link;
  }
  public String getData() {
    return data;
  }
  public Node getLink() {
    return link;
  }
}
