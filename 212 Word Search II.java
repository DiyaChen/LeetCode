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
        List<String> res = new ArrayList<String>();
        if(board == null  || words == null || board.length == 0 || words.length == 0) 
            return res;
        Trie trie = new Trie();
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i = 0; i<words.length; i++)
            trie.insert(words[i]);
        for(int i = 0; i< board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                search(res, board,"",isVisited,i,j,trie);
            }
        }
        return res;
    }
    public void search(List<String> res, char[][] board, String str, boolean[][] isVisited, int i, int j, Trie trie)
    {
        if(i < 0 || i>= board.length || j < 0 || j >= board[0].length || isVisited[i][j]) return;
        str += board[i][j];
        if(!trie.startWith(str))return;
        if(trie.search(str))
        {
            if(!res.contains(str))
                res.add(str);
        }
        isVisited[i][j] = true;
        search(res, board, str,isVisited,i+1,j, trie);
        search(res, board, str,isVisited,i-1,j, trie);
        search(res, board, str,isVisited,i,j+1, trie);
        search(res, board, str,isVisited,i,j-1, trie);
        isVisited[i][j] = false;
    }
}
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
    public void insert(String word)
    {
        TrieNode parent = root;
        for(char ch : word.toCharArray())
        {
            if(parent.children[ch-'a'] == null)
                parent.children[ch-'a'] = new TrieNode();
            parent = parent.children[ch-'a'];
        }
        parent.item = word;
    }
    public boolean search(String word){
        TrieNode parent = root;
        for(char ch:word.toCharArray())
        {
            if(parent.children[ch-'a'] == null) 
                return false;
            parent = parent.children[ch-'a'];
        }
        return parent.item.equals(word);
    }
    public boolean startWith(String prefix)
    {
        TrieNode parent = root;
        for(char ch : prefix.toCharArray())
        {
            if(parent.children[ch-'a'] == null)
                return false;
            parent = parent.children[ch-'a'];
        }
        return true;
    }
}