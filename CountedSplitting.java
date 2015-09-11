import java.util.*;

class CountedSplitting {
  int size1;
  int size2;
  Node start1;
  Node end1;
  Node start2;
  Node end2;
  int n;
  CountedSplitting(int n) {
    this.n = n;
    size1 = 0;
    size2 = 0;
    start1 = null;
    start2 = null;
    end1 = null;
    end2 = null;
  }
  public void insertInFirst(String data) {
    Node element = new Node(data, null);
    if (start1 == null) {
      start1 = element;
      end1 = element;
      end1.setLink(start1);
    } else {
      end1.setLink(element);
      end1 = element;
      end1.setLink(start1);
    }
    size1++;
  }
  public void insertInSecond(String data) {
    Node newelement = new Node(data, null);
    StringTokenizer st = new StringTokenizer(newelement.getData(), ",");
    String firstname = st.nextToken();
    String lastname = st.nextToken();
    int i = 1;
    if (start2 == null) {
      start2 = newelement;
      end2 = newelement;
    } else if (size2 == 1) {
      st = new StringTokenizer(start2.getData(), ",");
      String firststart = st.nextToken();
      String laststart = st.nextToken();
      if (laststart.compareTo(lastname) < 0) {
        newelement.setLink(start2);
        end2 = start2;
        start2 = newelement;
      } else {
        start2.setLink(newelement);
        end2 = newelement;
      }
    } else {
      int flag = 0;
      Node element = start2;
      Node temp = start2;
      while (element.getLink() != null) {
        st = new StringTokenizer(element.getData(), ",");
        String first = st.nextToken();
        String last = st.nextToken();
        if (last.compareTo(lastname) < 0) {
          if (element == start2) {
            newelement.setLink(start2);
            end2 = element;
            start2 = newelement;
            break;
          } else {
            newelement.setLink(element);
            temp.setLink(newelement);
            break;
          }
        }
        temp = element;
        element = element.getLink();
        if (element.getLink() == null) {
          st = new StringTokenizer(element.getData(), ",");
          String firstend = st.nextToken();
          String lastend = st.nextToken();
          if (lastend.compareTo(lastname) < 0) {
            newelement.setLink(element);
            temp.setLink(newelement);
            break;
          } else {
            element.setLink(newelement);
            end2 = newelement;
            break;
          }
        }
      }
    }
    size2++;
  }
  public void move(int k, int n) {
    while (n != 1) {
      int i = 1;
      Node middle = start1;
      Node before = start1;
      Node move = start1;
      if (n % 2 == 0) {
        Node element = start1;
        while (i != n/2) {
          element = element.getLink();
          middle = element;
          i++;
        }
        i = 1;
        while (i != k) {
          before = middle;
          middle = middle.getLink();
          move = middle;
          i++;
        }
        if (move == start1) {
          start1 = move.getLink();
        }
        insertInSecond(move.getData());
        before.setLink(move.getLink());
        size1--;
        n--;
        continue;
      }
      if (n % 2 != 0) {
        Node element = start1;
        while (i != (n+1)/2) {
          element = element.getLink();
          middle = element;
          i++;
        }
        i = 1;
        while (i != k) {
          before = middle;
          middle = middle.getLink();
          move = middle;
          i++;
        }
        if (move == start1) {
          start1 = move.getLink();
        }
        insertInSecond(move.getData());
        before.setLink(move.getLink());
        size1--;
        n--;
        continue;
      }
    }
  }
  public void displayFirst() {
    if (size1 == 1) {
      System.out.println("[ " + start1.getData() + " ]");
    } else {
      Node element = start1;
      while (element.getLink() != start1) {
        System.out.print("[ " + element.getData() + " ], ");
        element = element.getLink();
      }
      System.out.println("[ " + element.getData() + " ]");
    }
  }
  public void displaySecond() {
    if (size2 == 1) {
      System.out.println("[ " + start2.getData() + " ]");
    } else {
      Node element = start2;
      while (element.getLink() != null) {
        System.out.print("[ " + element.getData() + " ], ");
        element = element.getLink();
      }
      System.out.println("[ " + element.getData() + " ]");
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    CountedSplitting list1 =new CountedSplitting(n);
    for (int i = 0; i < n; i++) {
      String str = sc.next();
      list1.insertInFirst(str);
    }
    list1.move(k, n);
    list1.displayFirst();
    list1.displaySecond();
  }
}