import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String retstr = "";

    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();
        Trie trie = new Trie();
        boolean exitCondition = false;
        do {
            System.out.println("1.add ctg A to ctg B    2.remove ctg A     3.add book A to ctg B     4.remove book A     5.search book with ctg      6.search book with name and trie     7.panel");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: {
                    System.out.println("enter ctg1 , ctg2");
                    String ctg1 = scanner.nextLine();
                    String ctg2 = scanner.nextLine();
                    tree.insert(ctg2, ctg1, false);
                    break;
                }
                case 2: {
                    String ctg1 = scanner.nextLine();
                    Node x = tree.delete(ctg1).head;
                    if (ctg1.equals("root")) {
                        trie.clear();
                    } else {
                        while (x != null) {
                            trie.delete(((Book) x.data.data).name);
                            x = x.next;
                        }
                    }
                    break;

                }
                case 3: {
                    System.out.println("enter ctg1 , book");
                    String ctg1 = scanner.nextLine();
                    String name = scanner.nextLine();
                    Book book = new Book(name);
                    book.writer = scanner.nextLine();
                    tree.insert(ctg1, book, true);
                    trie.insert(name);
//                    tree.print();
//                    trie.print();
                    break;
                }
                case 4: {
                    Book book1 = new Book(scanner.nextLine());

                    tree.delete(book1.name);
                    trie.delete(book1.name);
                    break;
                }
                case 5: {
                    String ctg = scanner.nextLine();
                    tree.get_books(ctg).printList();
                    System.out.println();
                    break;
                }
                case 6: {
                    String name = scanner.nextLine();

                    trie.search(name);
                    break;
                }
                case 7: {
                    Book book = new Book(scanner.nextLine());

                    tree.get_books(book.name).printList();
                    System.out.println();
                    break;
                }
                default: {
                    exitCondition = true;
                    break;
                }
            }
        }
        while (!exitCondition);
//    }


//        trie = new Trie();
////        tree.insert("root", "child1", false);
////        tree.insert("root", "child2", false);
////        tree.insert("root", "child3", false);
////        tree.insert("root", "child4", false);
////        tree.insert("child2", "child5", false);
////        tree.insert("root", new Book("bookone"), true);
//
//        trie.insert("bookone");
//        trie.insert("booktwo");
//        trie.insert("bookthree");
//        trie.delete("booke");
//        trie.search("b");


//        tree.insert("root", new Book("booktwo"), true);
//        tree.insert("child5", new Book("bookthree"), true);
//
//
//
//
//        //for delete :
//        // if root : trie.clear()
//        //if not root : loop below:
//        Node x = tree.delete("child2").head;
//        while(x != null){
//            trie.delete(((Book)x.data.data).name);
//            x = x.next;
//        }
//        //end of delete
//        trie.search("book");
//


//        tree.print();
//        System.out.println(tree.get_books("root").toString());
//        Scanner scanner = new Scanner(System.in);
//        do {
//            System.out.println("1.add category A to B   2.remove A categiry   3.add book A to category B   4.remove A book   5.print books(category)   6.print books(tree)   7.panel");
//            int choice = Integer.parseInt(scanner.nextLine());
//
//            switch (choice){
//                case 1:
//            }
    }
}