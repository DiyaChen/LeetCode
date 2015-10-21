/*
Implement Trie (Prefix Tree) 

Implement a trie with insert, search, and startsWith methods.
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class TrieNode{
    public String item;
    public TrieNode[] children;
    public TrieNode(){
        item = "";
        children = new TrieNode[26];
    }
}

class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    
    // Insert a word into trie
    public void insert(String word){
        TrieNode parent = root;
        for(char ch : word.toCharArray()){
            if(parent.children[ch - 'a'] == null){
                parent.children[ch - 'a'] = new TrieNode();
            }
            parent = parent.children[ch - 'a'];
        }
        parent.item = word;
    }
    
    // if the word is in the trie
    public boolean search(String word){
        TrieNode parent = root;
        for(char ch : word.toCharArray()){
            if(parent.children[ch - 'a'] == null){
                return false;
            }
            parent = parent.children[ch - 'a'];
        }
        return parent.item.equals(word);
    }
    
    // if there is any word in the trie that starts with the given prefix
    public boolean startWith(String prefix){
        TrieNode parent = root;
        for(char ch : prefix.toCharArray()){
            if(parent.children[ch - 'a'] == null){
                return false;
            }
            parent = parent.children[ch - 'a'];
        }
        return true;
    }
}

// Another solution

class TrieNode {
    
    public char c;
    public boolean isLeaf;
    public HashMap<Character, TrieNode> children;
    
    // Initialize your data structure here.
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode(char c){
        this.c = c;
        children = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode t;
            if(!children.containsKey(c)){
                t = new TrieNode(c);
                children.put(c, t);
            }else{
                t = children.get(c);
            }
            children = t.children;
            if(i == word.length() - 1){
                t.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchAux(word);
        if(t != null && t.isLeaf == true){
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchAux(prefix) == null) 
            return false;
        else
            return true;
    }
    
    private TrieNode searchAux(String word){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!children.containsKey(c)){
                return null;
            }else{
                t = children.get(c);
                children = t.children;
            }
        }
        return t;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");