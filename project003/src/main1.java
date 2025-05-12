import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main1 {
    public static class MinHeap {
        public int[] heap;
        private int size;
        private static final int FRONT = 1;

        public MinHeap(int capacity) {
            this.size = 0;
            this.heap = new int[capacity + 1]; // Index 0 is not used
        }

        private int parent(int pos) {
            return pos / 2;
        }

        private int leftChild(int pos) {
            return 2 * pos;
        }

        private int rightChild(int pos) {
            return 2 * pos + 1;
        }

        private boolean isLeaf(int pos) {
            return pos > size / 2;
        }

        private void swap(int fpos, int spos) {
            int tmp = heap[fpos];
            heap[fpos] = heap[spos];
            heap[spos] = tmp;
        }

        private void minHeapify(int pos) {
            if (!isLeaf(pos)) {
                int swapPos;
                if (rightChild(pos) <= size) {
                    swapPos = (heap[leftChild(pos)] < heap[rightChild(pos)]) ? leftChild(pos) : rightChild(pos);
                } else {
                    swapPos = leftChild(pos);
                }
                if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                    swap(pos, swapPos);
                    minHeapify(swapPos);
                }
            }
        }

        public void insert(int element) {
            if (size >= heap.length - 1) {
                return; // Heap is full
            }
            heap[++size] = element;
            int current = size;
            while (heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public int remove() {
            int popped = heap[FRONT];
            heap[FRONT] = heap[size--];
            minHeapify(FRONT);
            return popped;
        }

        public void print() {
            for (int i = 1; i <= size / 2; i++) {
                System.out.println("PARENT: " + heap[i] +
                        " LEFT CHILD: " + heap[2 * i] +
                        " RIGHT CHILD: " + heap[2 * i + 1]);
            }
        }


    }

    public static class BST{
        BNode root;
        public static class BNode{

                int value;
                BNode left;
                BNode right;

                BNode(int value) {
                    this.value = value;
                    this.left = null;
                    this.right = null;
                }


        }
        private BNode addRecursive(BNode current, int value) {
            if (current == null) {
                return new BNode(value);
            }
            if (value <= current.value) {
                current.left = addRecursive(current.left, value);
            } else{
                current.right = addRecursive(current.right, value);
            }
            return current;
        }

        public void add(int value) {
            root = addRecursive(root, value);
        }
        public ArrayList get(int small){
            ArrayList arr = new ArrayList<>();
            get_(root,small,arr);
            return arr;
        }
        private void get_(BNode cur,int small,ArrayList arr){
            if (cur == null){
                return;
            }
            if(cur.value > small){
                get_(cur.left,small,arr);
            }else{
                arr.add(cur.value);
                get_(cur.left,small,arr);
                get_(cur.right,small,arr);
            }
        }
    }
    public static class Trie {

        // Alphabet size (# of symbols)
        public static final int ALPHABET_SIZE = 27;

        // trie node
        public static class TrieNode {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];
            String data = "";
            // isEndOfWord is true if the node represents
            // end of a word
            boolean isEndOfWord;

            TrieNode(String data) {
                this.data = data;
                isEndOfWord = false;
                for (int i = 0; i < ALPHABET_SIZE; i++)
                    children[i] = null;
            }
        }



        TrieNode root = new TrieNode("");
        public void print(){
            print2(root);
        }
        private void print2(TrieNode node){
            if (node == null){
                return;
            }
            else {
                System.out.println(node.data);
                for (TrieNode i : node.children){
                    if(i != null){
                        print2(i);
                    }
                }
            }
        }
        // If not present, inserts key into trie
        // If the key is prefix of trie node,
        // just marks leaf node
        public void insert(String key) {
            int level = 0;
            int length = key.length();
            int index;
//        if (root == null){
//            root = new TrieNode("" + key.charAt(0));
//            level++;
//        }
            TrieNode pCrawl = root;

            for (; level < length; level++) {
                index = (key.charAt(level) != ' ' ? key.charAt(level) - 'a' : 26);
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode(pCrawl.data + key.charAt(level));

                pCrawl = pCrawl.children[index];
            }

            // mark last node as leaf
            pCrawl.isEndOfWord = true;
        }

        public boolean delete(String key) {
            int level;
            int length = key.length();
            int index;
            TrieNode pCrawl = root;

            for (level = 0; level < length; level++) {
                index = (key.charAt(level) != ' ' ? key.charAt(level) - 'a' : 26);

                if (pCrawl.children[index] == null)
                    return false;

                pCrawl = pCrawl.children[index];
            }
            pCrawl.isEndOfWord = false;
            return true;
        }


        public boolean search(String key,ArrayList arr) {
            int level;
            int length = key.length();
            int index;
            TrieNode pCrawl = root;

            for (level = 0; level < length; level++) {
                index = (key.charAt(level) != ' ' ? key.charAt(level) - 'a' : 26);

                if (pCrawl.children[index] == null)
                    return false;

                pCrawl = pCrawl.children[index];
            }

            return getWords(pCrawl,arr);
        }
        public void clear(){
            root =new TrieNode("");
        }
        public boolean getWords(TrieNode pCrawl, ArrayList arr) {
            if (pCrawl == null) {
                return false;
            }
            if (pCrawl.isEndOfWord) {
                arr.add(pCrawl.data);
            }
            for (int i = 0; i < 27; i++) {
                getWords(pCrawl.children[i],arr);
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String p = "1";
        if(p.equals("1")){
            Trie t = new Trie();
            String[] inp = scan.nextLine().split(",");
            for(String x:inp){
                t.insert(x);

            }
            String a = scan.nextLine();
            ArrayList arr = new ArrayList();
            t.search(a,arr);
            Collections.sort(arr);
            for(int i = 0;i < arr.size();i++){
                System.out.print(arr.get(i));
                if(i != arr.size()-1) System.out.print(",");
            }
        }else if(p.equals("2")){
            BST b = new BST();
            String[] inp = scan.nextLine().split(",");
            for(String x:inp){
                b.add(Integer.parseInt(x));

            }
            int a = Integer.parseInt(scan.nextLine());
            ArrayList arr = new ArrayList();
            arr = b.get(a);
            Collections.sort(arr);
            for(int i = 0;i < arr.size();i++){
                System.out.print(arr.get(i));
                if(i != arr.size()-1) System.out.print(",");
            }
        }else if(p.equals("3")){
            MinHeap mh = new MinHeap(200);
            String[] inp = scan.nextLine().split(",");
            for(String x:inp){
                mh.insert(Integer.parseInt(x));

            }
            for(int i = 1;i <= inp.length;i++){
                System.out.print(mh.heap[i]);
                if(i != inp.length) System.out.print(",");
            }
        }
    }
}
