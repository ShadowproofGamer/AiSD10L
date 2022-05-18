public class Node {
    Node right;
    Node left;
    int priority;
    Character character;

    public Node(char character) {
        this.character = character;
        right = null;
        left = null;
        priority = 1;
    }

    public Node() {
        character = null;
        right = null;
        left = null;
        priority = 0;
    }
}
