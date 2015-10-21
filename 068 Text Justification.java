/*
Text Justification 

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        if(words == null || words.length == 0) return result;

        int i = 0;
        while(i < words.length){
            int j = i + 1;
            int length = words[i].length();
            while(j < words.length && length +  j - i + words[j].length() <= maxWidth){ // until current line cannot hold word and space
                length += words[j].length();  // length do not contain space
                j++;
            }
            // current j exceeds the boundary
            boolean lastLine = (j == words.length);
            boolean oneWord = (j == i + 1);
            int average = (lastLine || oneWord) ? 1 : (maxWidth - length) / (j - 1 - i);    // j decrement first as it exceeds the boundary
            int extra = (lastLine || oneWord) ? 0 : (maxWidth - length) % (j - 1 - i);

            StringBuffer sb = new StringBuffer(words[i]);
            for(int k = i + 1; k < j; k++){
                char[] space = new char[extra > 0 ? average + 1 : average];
                Arrays.fill(space, ' ');
                sb.append(space);
                sb.append(words[k]);
                extra--;
            }
            if(lastLine || oneWord){
                char[] space = new char[maxWidth - sb.length()];
                Arrays.fill(space, ' ');
                sb.append(space);
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }
}