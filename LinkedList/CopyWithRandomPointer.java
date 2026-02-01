import java.util.HashMap;
import java.util.Map;
public class CopyWithRandomPointer {

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> m=new HashMap<>();
//This handles when the next node is null
        m.put(null, null);

        Node curr=head;
        while(curr!=null){
            Node newNode=new Node(curr.val);
            //mapping the nodes from old to new
            m.put(curr, newNode);
            curr=curr.next;
        }

   curr=head;
        while(curr!=null){
            //now you got the node from map,remaining is just handling the next and random
            Node temp=m.get(curr);
            temp.next=m.get(curr.next);
            temp.random=m.get(curr.random);
            curr=curr.next;
        }

        return m.get(head);
    }
}
}
