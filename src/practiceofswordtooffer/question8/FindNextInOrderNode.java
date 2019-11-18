package practiceofswordtooffer.question8;

public class FindNextInOrderNode {

    static class Node{
       private int value;
       private Node left;
       private Node right;
       private Node parent;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    private Node findNextNodeInOrder(Node node) {
        //该节点拥有右子树，获取右子树最左的那个节点
        if (node.right != null) {
            Node rNode = node.right;
            while (rNode.left != null) {
                rNode = rNode.left;
            }
            return rNode;
        }

        //该节点没有右子树，且还是父亲节点的右子节点
        if (node.parent.right == node) {
            return node.parent;
        }else {
            Node pNode = node.parent;
            while (pNode != node.parent.left) {
                pNode = pNode.parent;
            }
            return pNode.parent;
        }
    }
}
