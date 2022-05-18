import java.util.ArrayList;

public class PriorityQueue {
    public int size = 0;
    ArrayList<Node> arr;

    public PriorityQueue() {
        arr = new ArrayList<>();
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public void enqueue(Node elem) {
        size = arr.size();
        boolean check = false;
        for (int i = size - 1; i >= 0; i--) {
            if (elem.priority >= arr.get(i).priority) {
                if (i == size - 1) {
                    arr.add(elem);
                    check = true;
                    break;
                } else {
                    arr.add(i + 1, elem);
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            arr.add(0, elem);
        }
    }

    public Node dequeue() {
        return arr.remove(0);
    }
}
