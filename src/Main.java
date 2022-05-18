public class Main {
    public static void main(String[] args) throws Exception {
        FileManager fm = new FileManager();
        fm.readFromFile();
        fm.countCharacters();
        fm.createHuffmanTree();
        //System.out.println(fm.getHtree().howManyLeaves(fm.getHtree().getRoot()));
        fm.printDetails();
        String str = fm.encodeText();
        System.out.println(str);
        fm.saveToFile();
    }
}
