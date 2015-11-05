/*
Max Points on a Line

//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


 public class solution{
 	public int maxPoints(Point[] points){
 		if(points.length < 3)
 			return points.length;
 		Map<Double, Integer> map = new HashMap<Double, Intger>();
 		int res = 0;
 		for(int i = 0; i < points.length; i++){
 			for(int j = 1; j < points.length; j++)
 			{
 				
 			}
 		}
 			
 	}
 }