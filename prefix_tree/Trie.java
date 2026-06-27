package prefix_tree;

/**
 * Implement a Trie (prefix tree) data structure.
 *
 * Question:
 * A trie stores strings efficiently so we can insert words, search for an exact
 * word, and check whether a prefix exists. This is useful for autocomplete and
 * dictionary-style lookups.
 *
 * Solution:
 * Each node contains a child array of size 26, where each position represents
 * one letter. A position is either null (no child for that letter) or filled
 * with a child node. Each node also has a flag to mark the end of a word.
 * Inserting a word walks through the characters and creates missing nodes.
 * Searching checks whether the full word exists, while startsWith checks
 * whether a prefix exists.
 *
 * Example structure for words "app" and "apple":
//  ROOT
//  │
//  └──────────────► Node 0
//                   26 child slots
//       ┌─────────────────────────────────────────────────────────┐
//       │[0] [1] [2] ... [15] [16] ... [25]                      │
//       │ ↑                                                     │
//       │ ASCII = 97 ('a')                                      │
//       └─────────────────────────────────────────────────────────┘
//                      │
//                      ▼
//                  Node 'a'
//                   26 child slots
//       ┌─────────────────────────────────────────────────────────┐
//       │[0] [1] ... [15] ↑ [17] ... [25]                        │
//       │               │                                        │
//       │          ASCII = 112 ('p')                             │
//       └─────────────────────────────────────────────────────────┘
//                      │
//                      ▼
//                 Node 'ap'
//                   26 child slots
//       ┌─────────────────────────────────────────────────────────┐
//       │[0] [1] ... [15] ↑ [17] ... [25]                        │
//       │               │                                        │
//       │          ASCII = 112 ('p')                             │
//       └─────────────────────────────────────────────────────────┘
//                      │
//                      ▼
//                 Node 'app'
//               ✔ End of word ("app")
//                   26 child slots
//       ┌─────────────────────────────────────────────────────────┐
//       │[0] ... [11] ↑ [12] ... [25]                            │
//       │             │                                           │
//       │        ASCII = 108 ('l')                               │
//       └─────────────────────────────────────────────────────────┘
//                      │
//                      ▼
//                Node 'appl'
//                   26 child slots
//       ┌─────────────────────────────────────────────────────────┐
//       │[0] ... [4] ↑ [5] ... [25]                              │
//       │           │                                             │
//       │      ASCII = 101 ('e')                                 │
//       └─────────────────────────────────────────────────────────┘
//                      │
//                      ▼
//                Node 'apple'
//              ✔ End of word ("apple")
 *
 * Note: each node has a 26-slot array, and only the used letters are filled.
 *
 * Time complexity: O(L) for insert, search, and prefix check, where L is the
 * length of the word/prefix.
 * Space complexity: O(total characters stored).
 */
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
