import java.io.*;
import java.util.ArrayList;

public class FileManager {
    String text;
    String codedText;
    ArrayList<Node> arr;
    HuffmanTree tree;

    public FileManager() {
        text = "";
        codedText = "";
        arr = new ArrayList<>();
        tree = new HuffmanTree();
    }

    public void readFromFile() throws Exception {
        File file = new File("src/initialText.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String read;
        while ((read = br.readLine()) != null) text += read;
        br.close();
        System.out.println(text);
    }

    public void saveToFile() throws Exception {
        File file = new File("src/encodedText.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(codedText);
        bw.close();
        //System.out.println(codedText);
    }

    public void countCharacters() {
        for (int i = 0; i < text.length(); i++) {
            boolean check = false;
            for (Node n : arr) {
                if (n.character == text.charAt(i)) {
                    n.priority++;
                    check = true;
                    break;
                }
            }
            if (!check) {
                arr.add(new Node(text.charAt(i)));
            }
        }
    }

    public void createHuffmanTree(){
        PriorityQueue pq = new PriorityQueue();
        for(Node n: arr)
            pq.enqueue(n);
            printPQ(pq);

        while(pq.size > 1){
            Node n = new Node();
            n.left =pq.dequeue();
            n.right=pq.dequeue();
            n.priority = (n.left.priority + n.right.priority);
            pq.enqueue(n);
            printPQ(pq);
        }

        tree.root = pq.dequeue();
    }

    public String code(char c){
        BinderClass bc = tree.getCode(c, tree.root, new BinderClass("", false));
        return bc.string;
    }

    public String encodeText(){
        String encoded = "";
        int length = text.length();
        String txt = text;
        for(int i = 0; i < length; i++){
            encoded += code(txt.charAt(i));
        }
        codedText=encoded;
        return encoded;
    }

    /** Debug:*/
    public PriorityQueue printPQ(PriorityQueue pq){ //method to check if PQ works properly
        PriorityQueue pqs = new PriorityQueue();
        while(!pq.isEmpty()) {
            Node n = pq.dequeue();
            System.out.println(n.priority);
            pqs.enqueue(n);
        }
        System.out.println();
        return pqs;
    }
    public void printOutInformation(){
        for(Node node: arr){

            System.out.println(node.character + " | "  + node.priority + " | " + code(node.character));
        }
    }
}
