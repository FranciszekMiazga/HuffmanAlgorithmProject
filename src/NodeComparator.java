import java.util.Comparator;

public class NodeComparator  implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if(o1.data==o2.data){
            return Character.compare(o1.c,o2.c);
        }
        return o1.data-o2.data;
    }
}
