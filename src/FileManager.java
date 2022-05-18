import java.io.*;
import java.util.ArrayList;

public class FileManager {
    String text;
    String encodedText;
    ArrayList<Node> arr;
    HuffmanTree tree;

    public FileManager() {
        text = "";
        encodedText = "";
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

    public void saveToFile(String s) throws Exception {
        File file = new File("src/encodedText.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(s);
        bw.close();
        //System.out.println(encodedText);
    }
    public void saveToFile() throws Exception {
        saveToFile(encodedText);
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
        for(Node n: arr){
            pq.enqueue(n);
            //System.out.println(n.character);
        }


        while(pq.getSize() > 1){
            Node n = new Node();
            n.left =pq.dequeue();
            n.right=pq.dequeue();
            n.priority = (n.left.priority + n.right.priority);
            pq.enqueue(n);
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
        encodedText =encoded;
        return encoded;
    }

    /** Debug:*/
    public void printDetails(){
        for(Node node: arr){

            System.out.println("char: '"+node.character + "'\tpriority: '"  + node.priority + "'\tcode: '" + code(node.character)+"'");
        }
    }
}
