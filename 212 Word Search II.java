/*
Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
*/

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0){
            return result;
        }
        
        Set<String> set = new HashSet<String>();
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] checker = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfs(set, board, checker, trie, i, j, "");
            }
        }
        result = new ArrayList<String>(set);
        return result;
    }
    
    private void dfs(Set<String> set, char[][] board, boolean[][] checker, Trie trie, int row, int col, String str){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;
        if(checker[row][col]) return;   // loop exists
        str += board[row][col];
        if(!trie.startWith(str)) return;
        if(trie.search(str)){
            set.add(str);
        }
        checker[row][col] = true;
        dfs(set, board, checker, trie, row + 1, col, str);
        dfs(set, board, checker, trie, row - 1, col, str);
        dfs(set, board, checker, trie, row, col + 1, str);
        dfs(set, board, checker, trie, row, col - 1, str);
        checker[row][col] = false;
    }
}

class TrieNode{
    public String item; // leaf node's item is the word, otherwise it is null
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