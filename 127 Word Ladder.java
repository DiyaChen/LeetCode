/*
Word Ladder 

Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(beginWord == null || endWord == null || wordDict == null){
            return 0;
        }
        wordDict.add(endWord);
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        wordQueue.add(beginWord);
        distanceQueue.add(1);   // begin word != end word, so at least 1 distance
        
        while(wordQueue.size() != 0){
            String currentWord = wordQueue.poll();
            int currentDistance = distanceQueue.poll();
            if(currentWord.equals(endWord)){
                return result = currentDistance;
            }
            
            for(int i = 0; i < currentWord.length(); i++){
                char[] transform = currentWord.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    transform[i] = ch;
                    String newWord = new String(transform);
                    if(wordDict.contains(newWord)){
                        wordQueue.add(newWord);
                        distanceQueue.add(currentDistance + 1);
                        wordDict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}