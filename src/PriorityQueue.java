import java.util.ArrayList;

public class PriorityQueue {
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

    public void enqueue(Node node) {
        int size = arr.size();
        boolean check = false;
        for (int i = size - 1; i >= 0; i--) {
            if (node.priority >= arr.get(i).priority) {
                if (i == size - 1) {
                    arr.add(node);
                    check = true;
                    break;
                } else {
                    arr.add(i + 1, node);
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            arr.add(0, node);
        }
    }

    public int getSize(){
        return arr.size();
    }

    public Node dequeue() {
        return arr.remove(0);
    }
}
