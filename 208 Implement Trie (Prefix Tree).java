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


// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");