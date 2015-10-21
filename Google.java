// recursive sum to n
public static int sum(int n){
	if(n == 1) return 1;
	return n + sum(n - 1);
}


//longest consecutive numbers in one dimension array
public static List<Integer> longest(int[] nums){
    List<Integer> result = new ArrayList<Integer>();
    if(nums == null || nums.length == 0) return result;
    int start = 0;
    int end = 0;
    int length = 1;
    int i = 0;
    while(i < nums.length - 1){
        int j = i + 1;
        while(j < nums.length && nums[j - 1] + 1 == nums[j]){
            j++;
        }
        int len = j - i;
        if(len > length){
            length = len;
            start = i;
            end = j - 1;
        }
        i = j;
    }
    for(int k = start; k <= end; k++){
        result.add(nums[k]);
    }
    return result;
}


// follow up binary tree, output longest length
int static longest = 1;
public static void longest(TreeNode root){
	if(root == null){
		longest = 0;
		return;
	}
	aux(root.left, root.val, 1);
	aux(root.right, root.val, 1);
}

private static void aux(TreeNode current, int parentVal, int sum){
	if(current == null){
		longest = Math.max(longest, sum);
		return;
	}

	if(parentVal + 1 == current.val){
		sum++;
	}else{
		sum = 1;
	}
	longest = Math.max(longest, sum);

	aux(current.left, current.val, sum);
	aux(current.right, current.val, sum);
}


// length of longest path in two dimention array 
public static int longestPath(int[][] array){
        if(array == null || array.length == 0 || array[0].length == 0) return 0;
        TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();   // <current, next>
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                int cur = array[i][j];
                if(hasNext(array, i, j)){
                    tree.put(cur, cur + 1); // pair current and next
                }else{
                    tree.put(cur, cur); // no path
                }
            }
        }
        int result = 0;
        int sum = 0;    // number of path, not dot
        while(!tree.isEmpty()){
            int curKey = tree.firstKey();
            int curVal = tree.get(curKey);
            if(curKey + 1 == curVal){   // has one path
                sum++;
                result = Math.max(result, sum);
                tree.remove(curKey);
                if(!tree.isEmpty()){    // may have further path
                    int nextKey = tree.firstKey();
                    if(curVal != nextKey){  // actually not
                        sum = 0;
                    }
                }
            }else{
                tree.remove(curKey);
            }
        }
        return result + 1;  // number of node == path + 1
    }

private static boolean hasNext(int[][] array, int row, int col){
    int cur = array[row][col];
    if(row > 0 && array[row - 1][col] == cur + 1) return true;
    if(col > 0 && array[row][col - 1] == cur + 1) return true;
    if(row < array.length - 1 && array[row + 1][col] == cur + 1) return true;
    if(col < array[0].length - 1 && array[row][col + 1] == cur + 1) return true;
    return false;
}


// Validating UTF-8 byte array
public static boolean validate(byte[] bytes) {
    int expectedLen;
    if      (bytes.length == 0)                     return false;
    else if ((bytes[0] & 0b10000000) == 0b00000000) expectedLen = 1;
    else if ((bytes[0] & 0b11100000) == 0b11000000) expectedLen = 2;
    else if ((bytes[0] & 0b11110000) == 0b11100000) expectedLen = 3;
    else if ((bytes[0] & 0b11111000) == 0b11110000) expectedLen = 4;
    else if ((bytes[0] & 0b11111100) == 0b11111000) expectedLen = 5;
    else if ((bytes[0] & 0b11111110) == 0b11111100) expectedLen = 6;
    else    return false;

    if (expectedLen != bytes.length) return false;

    for (int i = 1; i < bytes.length; i++) {
        if ((bytes[i] & 0b11000000) != 0b10000000) {
            return false;
        }
    }

    return true;
}


// design a class represent fractional number
public class Fractional{
	public int nominator;
	public int denominator;

	public Fractional(){
		nominator = 0;
		denominator = 1;
	}

	public Fractional(int n, int d){
		nominator = n;
		denominator = d;
	}

	public float asFloat(){
		return ((float) nominator) / denominator;
	}

	public boolean equals(Fractional num){
		return nominator * num.denominator == num.nominator * denominator;
	}

	public Fractional add(Fractional num){
		int d = denominator * num.denominator;
		int n = nominator * num.denominator + num.nominator * denominator;
		int gcd = gcd(d, n);
		return new Fractional(n / gcd, d / gcd);
	}

	public Fractional subtract(Fractional num){
		int d = denominator * num.denominator;
		int n = nominator * num.denominator - num.nominator * denominator;
		int gcd = gcd(d, n);
		return new Fractional(n / gcd, d / gcd);
	}

	public Fractional multiple(Fractional num){
		int n = nominator * num.nominator;
		int d = denominator * num.denominator;
		int gcd = gcd(d, n);
		return new Fractional(n / gcd, d / gcd);
	}

	public Fractional divide(Fractional num){
		int n = nominator * num.denominator;
		int d = denominator * num.nominator;
		int gcd = gcd(d, n);
		return new Fractional(n / gcd, d / gcd);
	}

	private int gcd(int p, int q){
		if(q == 0) return p;
		return gcd(q, p % q);
	}
}

//
// a simple hashtable
public class HashEntry {
      private int key;
      private int value;
 
      HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
      }     
 
      public int getKey() {
            return key;
      }
 
      public int getValue() {
            return value;
      }
}

public class HashMap {
      private final static int TABLE_SIZE = 128;
 
      HashEntry[] table;
 
      HashMap() {
            table = new HashEntry[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++)
                  table[i] = null;
      }
 
      public int get(int key) {
            int hash = (key % TABLE_SIZE);
            while (table[hash] != null && table[hash].getKey() != key)
                  hash = (hash + 1) % TABLE_SIZE;
            if (table[hash] == null)
                  return -1;
            else
                  return table[hash].getValue();
      }
 
      public void put(int key, int value) {
            int hash = (key % TABLE_SIZE);
            while (table[hash] != null && table[hash].getKey() != key)
                  hash = (hash + 1) % TABLE_SIZE;
            table[hash] = new HashEntry(key, value);
      }
}

//

// closed addressing
public class LinkedHashEntry {
      private int key;
      private int value;
      private LinkedHashEntry next;
 
      LinkedHashEntry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
      }
 
      public int getValue() {
            return value;
      }
 
      public void setValue(int value) {
            this.value = value;
      }
 
      public int getKey() {
            return key;
      }
 
      public LinkedHashEntry getNext() {
            return next;
      }
 
      public void setNext(LinkedHashEntry next) {
            this.next = next;
      }
}
 
public class HashMap {
      private final static int TABLE_SIZE = 128;
 
      LinkedHashEntry[] table;
 
      HashMap() {
            table = new LinkedHashEntry[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++)
                  table[i] = null;
      }
 
      public int get(int key) {
            int hash = (key % TABLE_SIZE);
            if (table[hash] == null)
                  return -1;
            else {
                  LinkedHashEntry entry = table[hash];
                  while (entry != null && entry.getKey() != key)
                        entry = entry.getNext();
                  if (entry == null)
                        return -1;
                  else
                        return entry.getValue();
            }
      }
 
      public void put(int key, int value) {
            int hash = (key % TABLE_SIZE);
            if (table[hash] == null)
                  table[hash] = new LinkedHashEntry(key, value);
            else {
                  LinkedHashEntry entry = table[hash];
                  while (entry.getNext() != null && entry.getKey() != key)
                        entry = entry.getNext();
                  if (entry.getKey() == key)
                        entry.setValue(value);
                  else
                        entry.setNext(new LinkedHashEntry(key, value));
            }
      }
 
      public void remove(int key) {
            int hash = (key % TABLE_SIZE);
            if (table[hash] != null) {
                  LinkedHashEntry prevEntry = null;
                  LinkedHashEntry entry = table[hash];
                  while (entry.getNext() != null && entry.getKey() != key) {
                        prevEntry = entry;
                        entry = entry.getNext();
                  }
                  if (entry.getKey() == key) {
                        if (prevEntry == null)
                             table[hash] = entry.getNext();
                        else
                             prevEntry.setNext(entry.getNext());
                  }
            }
      }
}

// merge sort array
import java.util.*;

public class MergerSort
{

  public static void mergeSortWrapper(Comparable [ ] a)
  {
    Comparable[] tmp = new Comparable[a.length];
    mergeSort(a, tmp,  0,  a.length - 1);
  }


  private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
  {
    if( left < right )
    {
      int center = (left + right) / 2;
      mergeSort(a, tmp, left, center);
      mergeSort(a, tmp, center + 1, right);
      merge(a, tmp, left, center + 1, right);
    }
  }


    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
 }

// quick sort
public static void quickSortWrapper(int[] arr){
        int len = arr.length;
        quickSort(arr, 0, len - 1);
    }

    public static int partition(int[] arr, int left, int right)
    {
        int pivot = arr[right];
        int i = left - 1;
        for(int j = left; j < right; j++){
            if(arr[j] <= pivot){
                i++;
                swap (arr, i, j);
            }
        }
        i++;
        swap(arr, i, right);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index + 1 < right)
            quickSort(arr, index + 1, right);
    }


