package cww330;

public class TreeTest {
    static class Node{
        public  String val;
        public  Node left;
        public Node  right;
        public Node(String val) {
            this.val = val;
        }
    }
    public static  Node build(){      //手动构造一棵树
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        a.left =b;
        a.right=c;
        b.left =d;
        b.right = e;
        e.left= g;
        g.left =h;
        c.right = f;
        return a;
    }
    public static void preOrder(Node root){
        //前序遍历
        if(root==null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);        //递归
    }
    public static void inOrder(Node root){   //中序遍历
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){     //后序遍历
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    public static int size(Node root){
        if(root==null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);  //递归
    }
    public static int leafSize(Node root){
        if(root==null){
            return  0;
        }
        if(root.right==null && root.left==null){
            return  1;
        }
        return leafSize(root.right) + leafSize(root.left);      //递归求叶子结点的个数
    }
   public static Node find(Node root,char toFind){   //查找元素是否存在
        if(root==null){
            return null;
        }
        if(root.val== toFind){
            return root;
        }
        Node result = find(root.left,toFind);
        if(result!=null){
            return result;
        }
        return find(root.right,toFind);
    }
    public static int kLevelSize(Node root,int k){          //递归求第k层的节点个数
        if(k<1||root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return kLevelSize(root.right,k-1)+kLevelSize(root.left,k-1);
    }
    public static void main(String[] args) {
        Node root = build();
        System.out.print("先序遍历：");
        preOrder(root);
        System.out.println();
        System.out.print("中序遍历：");
        inOrder(root);         System.out.println("后序遍历：");
        postOrder(root );
        int res =  size(root);
        System.out.println(res);
        System.out.println();
        int x = leafSize(root);
        System.out.println(x);
    }
}
