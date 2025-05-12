
public class Trie {

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

    ;

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


    public boolean search(String key) {
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

        return getWords(pCrawl);
    }
    public void clear(){
        root =new TrieNode("");
    }
    public boolean getWords(TrieNode pCrawl) {
        if (pCrawl == null) {
            return false;
        }
        if (pCrawl.isEndOfWord) {
            System.out.println(pCrawl.data);
        }
        for (int i = 0; i < 27; i++) {
            getWords(pCrawl.children[i]);
        }
        return true;
    }

}

