public class HuffmanTree {
    public Node root;

    public HuffmanTree(){
        root=null;
    }
    public HuffmanTree(Node root){
        this.root = root;
    }

    public BinderClass getCode(Character c, Node n, BinderClass bc){
        if(n.character != null && n.character == c)
            bc.bool=true;

        if( !bc.bool && n.left != null){
            bc = getCode(c, n.left, bc);

            if(n.character != null){
                System.out.print(c);
            }

            if(bc.bool){
                bc.string = ("0" + bc.string);
            }
        }

        if(!bc.bool && n.right != null){
            bc = getCode(c, n.right, bc);
            if(bc.bool){
                bc.string = ("1" + bc.string);
            }
        }

        return bc;
    }
}
