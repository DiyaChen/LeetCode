/*
Rectangle Area 

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

      (C,D)                      (G,H)
(A,B)                       (E,F)

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(G < A || C < E || D < F || H < B){
            return (C-A)*(D-B) + (G-E)*(H-F);
        }
        
        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        
        return (C-A)*(D-B) + (G-E)*(H-F) - (right - left)*(top - bottom);
    }
}