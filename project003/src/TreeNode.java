public class TreeNode {
    Object data;
    boolean is_book;
    LinkedList ll = new LinkedList();
    TreeNode(Object data,boolean is_book){
        this.data = data;
        this.is_book = is_book;
    }
    @Override
    public boolean equals(Object obj) {
        return data.equals(((TreeNode)obj).data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
