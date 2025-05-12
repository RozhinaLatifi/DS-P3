public class Tree {
    TreeNode root = new TreeNode("root",false);
    public void print(){
        print2(root);
    }
    private void print2(TreeNode node){
        if (node == null){
            return;
        }
        else {
            System.out.println(node.data.toString());
            Node head = node.ll.head;
            while (head != null) {
                print2(head.data);
                head = head.next;
            }
        }
    }
    public void insert(String node_name,Object data,boolean is_book){
        if (find(node_name) && !find(data)){
            root = insert2(root,node_name,data,is_book);
        }
    }
    private TreeNode insert2(TreeNode node,String node_name,Object data,boolean is_book){
        if (node == null){
            return node;
        } else if (node.data.equals(node_name)) {
            TreeNode t = new TreeNode(data,is_book);
            node.ll.add(t);
        }
        else {
            Node head = node.ll.head;
            while (head != null) {
                head.data = insert2(head.data,node_name,data,is_book);
                head = head.next;
            }
            return node;
        }
        return node;
    }
    private boolean find2(TreeNode node,Object to_find){
        if (node == null){
            return false;
        } else if (node.data.equals(to_find)) {
            return true;
        }
        else {
            Node head = node.ll.head;
            boolean b = false;
            while (head != null){
                b = (b || find2(head.data,to_find));
                head = head.next;
            }
            return b;
        }
    }
    public boolean find(Object to_find){
        return find2(root,to_find);
    }
    private TreeNode delete2(TreeNode node,String node_name,LinkedList books){
        if (node == null){
            return node;
        } else{
            Node head = node.ll.head;
            while (head != null) {
                if(head.data.data.equals(node_name)){

                    get_all_books(head.data,books);
                    node.ll.remove(head.data);
                    return node;
                }
                head = head.next;
            }
            head = node.ll.head;
            while (head != null) {
                head.data = delete2(head.data,node_name,books);
                head = head.next;
            }
            return node;
        }
    }
    public LinkedList delete(String node_name){
        if (node_name.equals("root")){
            root = new TreeNode("root",false);
            LinkedList ll = new LinkedList();
            get_all_books(root,ll);
            return ll;
        }
        else{
            LinkedList books = new LinkedList();
            root = delete2(root,node_name,books);
            return books;
        }

    }
    public LinkedList get_books2(TreeNode node,String name){
        if (node == null){
            return null;
        } else if (node.data.equals(name)) {
            LinkedList list = new LinkedList();
            get_all_books(node,list);
            return list;
        }
        else {
            Node head = node.ll.head;
            while (head != null){
                LinkedList k = get_books2(head.data,name);
                if (k != null){
                    return k;
                }
                head = head.next;
            }
            return null;
        }
    }
    public void get_all_books(TreeNode node,LinkedList ans){
        if (node == null){
            return;
        }
        if (node.is_book) {
            ans.add(node);
        }
        Node head = node.ll.head;
        while (head != null){
            get_all_books(head.data,ans);
            head = head.next;
        }


    }
    public LinkedList get_books(String name){
        return get_books2(this.root,name);
    }
}
