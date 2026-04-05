package prefix_tree;

class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char c:word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = find(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String word){
        return find(word) != null;
    }

    private TrieNode find(String str){
        TrieNode node = root;
        for(char c: str.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");

        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("appl"));
        System.out.println(trie.search("appl"));
        System.out.println(trie.startsWith("cc"));
    }
}
