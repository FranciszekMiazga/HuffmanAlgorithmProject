import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    PriorityQueue<Node> pQue;


    public void implementNodes(Map<Character,Integer> occurances, int size){
        pQue= new PriorityQueue<Node>(size, new NodeComparator());
        for (Map.Entry<Character, Integer> entry : occurances.entrySet()) {
            Node node=new Node();
            node.c=entry.getKey();
            node.data=entry.getValue();

            pQue.add(node);
        }

        createTree();
    }
    public void createTree(){
        Node root=null;

        while(pQue.size()>1){
            Node firstMin= pQue.peek();
            pQue.poll();

            Node secondMin=pQue.peek();
            pQue.poll();
            Node connectedNode;
            connectedNode=createNode(firstMin,secondMin);

            root=connectedNode;
            pQue.add(connectedNode);
        }
        printCode(root,"");
    }
    private Node createNode(Node f,Node s){
        Node connectedNode=new Node();

        connectedNode.data=f.data+s.data;
        connectedNode.c='.';
        connectedNode.left=f;
        connectedNode.right=s;

        return connectedNode;
    }
    static int finalSum=0;
    public static void printCode(Node root, String s)
    {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            int size=s.length();
            int bits= size*root.data;
            finalSum+=bits;
            System.out.println(root.c + ":" + s+" - "+root.data+" : lacznie bitow: "+bits);
            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
}
