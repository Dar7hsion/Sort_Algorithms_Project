import java.util.Random;

/**************************************** 
* 
* Student Name: 		Alexander Purser
* Date Due: 			11/30/2022
* Date Submitted: 		11/30/2022
* Program Name: 		Sorting_Project_SD
* Program Description:  This program compares the time between insertion sort, bubble sort and quick sort, 
* 						with both the random case and worst case, time comparison is given in milli sec 
* 
* 
****************************************/ 

 
public class Sorting_Project_SD 
{
	
	static public boolean isSorted (int [] list)
	{
	 for (int index = 0; index < (list.length - 1); index++)
	 {
		 if (list[index] > list[index + 1])
	     return false;
	 }
	   
	 return true;
	}
	
	static public String sPrint (int [] list)
	{ 
		String str = "false";
		if (isSorted(list))
		{
			str = "true";
			return str;
		}
		str="false";
		return str;
	}
	
	public static void swap (int [] list, int i, int j)
	{
		int temp = list[i];
		list [i] = list[j];
		list[j] = temp;
	}
	
	
	public static void print (int [] list) 
	{
		for (int i = 0; i < list.length; i++)
		{
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	
	 static void swap(int [] list1, int i)
	 {
		 int temp1 = list1[i];
		 int temp2 = list1[i+1];
		 int temp3 = list1[i+2];
		 
		 list1[i] = temp3;
		 list1[i+1] = temp1;
		 list1[i+2] = temp2;
		 
	 }
	 
	
	  /////////////////////////////////////////////////////////////////
	  //
	  //  Insertion Sort
	
	public static void insertionSort (int [] list)
	{
		for (int i = 1; i < list.length; ++i)
		{
			int pivot = list[i];
			int h = i;
			while (h > 0 && list[h-1] > pivot)
			{
				list[h] = list[h - 1];
				--h;
			}
			list[h] = pivot;
		}
	}
	
//	  static void insertItem(int [] list, int startIndex, int endIndex)
//	  // Upon completion, values[0]..values[endIndex] are sorted.
//	  {
//	    boolean finished = false;
//	    int current = endIndex;
//	    boolean moreToSearch = true;
//	    while (moreToSearch && !finished)
//	    {
//	      if (list[current] < list[current - 1])
//	      {
//	        swap(list, current, current - 1);
//	        current--;
//	        moreToSearch = (current != startIndex);
//	      }
//	      else
//	        finished = true;
//	    }
//	  }
//	 
//	  static void insertionSort(int [] list)
//	  // Sorts the values array using the insertion sort algorithm.
//	  {
//	   for (int count = 1; count < list.length; count++)
//	      insertItem(list, 0, count);
//	  }
	  
	  /////////////////////////////////////////////////////////////////
	  //
	  //  Bubble Sort
	  
	  public static void bubbleSort(int[] list) 
	  {
	    for (int max = list.length - 1; max > 0; max--) 
	    {
	      boolean swapped = false;
	      for (int i = 0; i < max; i++) 
	      {
	        int left = list[i];
	        int right = list[i + 1];
	        if (left > right) 
	        {
	        	list[i + 1] = left;
	        	list[i] = right;
	          swapped = true;
	        }
	      }
	      if (!swapped) break;
	    }
	  }	

//	public static void bubbleSort (int [] list)
//	{
//		for (int i = 0; i < list.length - 1; i++)
//		{
//			for (int j = i + 1; j < list.length; j++)
//			{
//				if (list[i] > list[j])
//				{
//					int temp = list[i];
//					list[i] = list[j];
//					list[j] = temp;
//				}
//			}	
//		}	
//	}
	  
//	  static void bubbleUp(int [] list, int startIndex, int endIndex)
//	  // Switches adjacent pairs that are out of order 
//	  // between values[startIndex]..values[endIndex] 
//	  // beginning at values[endIndex].
//	  {
//	    for (int index = endIndex; index > startIndex; index--)
//	      if (list[index] < list[index - 1])
//	        swap(list, index, index - 1);
//	  }
//	 
//	  static void bubbleSort(int [] list)
//	  // Sorts the values array using the bubble sort algorithm.
//	  {
//	    int current = 0;
//	 
//	    while (current < (list.length - 1))
//	    {
//	      bubbleUp(list, current, list.length - 1);
//	      current++;
//	    }
//	  }
	  
	  /////////////////////////////////////////////////////////////////
	  //
	  //  Quick Sort
	
	  
   static void quickSort(int [] list, int first, int last)
   {
	      int my_list[] = new int[last - first + 1];
	      int top = -1;
	      my_list[++top] = first;
	      my_list[++top] = last;
	      while (top >= 0)
	      {
	    	  last = my_list[top--];
	    	  first = my_list[top--];
	         int p = partition(list, first, last);
	         if (p - 1 > first)
	         {
	            my_list[++top] = first;
	            my_list[++top] = p - 1;
	         }  
	         if (p + 1 < last)
	         {
	            my_list[++top] = p + 1;
	            my_list[++top] = last;
	         }
	      }
	   }
   
   static int partition(int [] list, int first, int last)
   {
	      int x = list[last];
	      int i = (first - 1);
	      for (int j = first; j <= last - 1; j++)
	      {
	         if (list[j] <= x)
	         {
	            i++;
	            swap(list, i, j);
	         }
	      }
	      swap(list, i + 1, last);
	      return (i + 1);
	   }
   
   
	 /////////////// 
//	static int split( int [] list, int first, int last)
//	  {
//	    int splitVal = list[first];
//	    int saveF = first;
//	    boolean onCorrectSide;
//	 
//	    first++;
//	    do
//	    {
//	      onCorrectSide = true;
//	      while (onCorrectSide)             // move first toward last
//	        if (list[first] > splitVal)
//	          onCorrectSide = false;
//	        else
//	        {
//	          first++;
//	          onCorrectSide = (first <= last);
//	        }
//	 
//	      onCorrectSide = (first <= last);
//	      while (onCorrectSide)             // move last toward first
//	        if (list[last] <= splitVal)
//	          onCorrectSide = false;
//	        else
//	         {
//	          last--;
//	          onCorrectSide = (first <= last);
//	         }
//	   
//	      if (first < last)                
//	      {
//	        swap(list, first, last);
//	        first++;
//	        last--;
//	      }
//	    } while (first <= last);
//	 
//	    swap(list, saveF, last);
//	    return last;
//	  }
//
//	  static void quickSort(int [] list, int first, int last)
//	  {
//	    if (first < last)
//	    {
//	      int splitPoint;
//	      splitPoint = split(list, first, last);
//	      quickSort(list, first, splitPoint - 1);
//	      quickSort(list, splitPoint + 1, last);
//	    }
//	  }
	

	  /////////////////////////////////////////////////////////////////
	  //
	  //  Main
	
	public static void main (String [] args) 
	{
		final int s = 500000;
		final int MAX1 = s;
		System.out.println("Random Case");
		System.out.printf("%8s %15s %15s %15s %15s %15s %15s %15s \n", "Size","isNotSorted", "Quicksort", "InsertionSort", "BubbleSort", "isSorted-Q", "isSorted_I", "isSorted_B");
		for (int n = MAX1/10; n <= MAX1; n +=MAX1/10)
		{
			int [] list1 = new int [n];
			for (int i = 0; i < n; i++)
			{
				list1[i] = (int) (Math.random()*MAX1);
				//System.out.println(list1[i]);
			}
			int [] list2 = list1.clone();
			int [] list3 = list1.clone();
			
			String I,B,Q,L ="";
			L=sPrint(list1);
			
			long start1 = System.currentTimeMillis();
			quickSort(list1,0,n-1);
			long qst = System.currentTimeMillis() - start1;
			
			
			long start2 = System.currentTimeMillis();
			insertionSort(list2);
			long ist = System.currentTimeMillis() - start2;
			
			long start3 = System.currentTimeMillis();
			bubbleSort(list3);
			long bst = System.currentTimeMillis() - start3;
			
			I=sPrint(list1);
			B=sPrint(list2);
			Q=sPrint(list3);
			System.out.printf("%8d %15s %15d %15d %15d %15s %15s %15s\n", n, L, qst, ist, bst, Q, I, B);
		}
		System.out.println();
		
//		final int MAX3 = s;
//		System.out.println("Best Case");
//		System.out.printf("%8s %15s %15s %15s %15s %15s %15s %15s \n", "Size","isNotSorted", "Quicksort", "InsertionSort", "BubbleSort", "isSorted-Q", "isSorted_I", "isSorted_B");
//		Random rand = new Random();
//		for (int n = MAX3/10; n <= MAX3; n +=MAX3/10)
//		{
//			int [] list1 = new int [n];
//			for (int i = 0; i < n; i++)
//			{
//				//list1[i] = i + (rand.nextInt(800)+1);
//				list1[i] = 1;
//			}
//			
//			
//			int [] list2 = new int [n];
//			for (int i = 0; i < n; i++)
//			{
//				list2[i] = i;
//			}
//			int [] list3 = list2.clone();
//			
//			String I,B,Q,L ="";
//			L=sPrint(list2);
//			
//			long start1 = System.currentTimeMillis();
//			quickSort(list1,0,n-1);
//			long qst = System.currentTimeMillis() - start1;
//			
//			
//			long start2 = System.currentTimeMillis();
//			insertionSort(list2);
//			long ist = System.currentTimeMillis() - start2;
//			
//			long start3 = System.currentTimeMillis();
//			bubbleSort(list3);
//			long bst = System.currentTimeMillis() - start3;
//			
//			I=sPrint(list1);
//			B=sPrint(list2);
//			Q=sPrint(list3);
//			System.out.printf("%8d %15s %15d %15d %15d %15s %15s %15s\n", n, L, qst, ist, bst, Q, I, B);
//		}
//		System.out.println();
//		
//		final int MAX2 = s;
//		System.out.println("Worst Case");
//		System.out.printf("%8s %15s %15s %15s %15s %15s %15s %15s \n", "Size","isNotSorted", "Quicksort", "InsertionSort", "BubbleSort", "isSorted-Q", "isSorted_I", "isSorted_B");
//		for (int n = MAX2/10; n <= MAX2; n +=MAX2/10)
//		{
//			String temp;
//			int [] list1 = new int [n];
//			//Worst case all elements are the same 
//			for (int i = 0; i < n; i++)
//			{
//				list1[i] = 1;
//			}
//			
//			int [] list2 = new int [n];
//			//Worst case all elements sorted completely descending
//			for (int i = 0; i < n; i++)
//			{
//				list2[(n-1)-i] = i;
//				//System.out.println(list2[i]);
//			}
//			
//			int [] list3 = new int [n];
//			//Worst case all elements sorted completely descending
//			for (int i = 0; i < n; i++)
//			{
//				list3[(n-1)-i] = i;
//			}
//			
//			String I,B,Q,L ="";
//			L=sPrint(list1);
//			
//			long start1 = System.currentTimeMillis();
//			try
//			{
//	            quickSort(list1,0,n-1);
//	            long qst = System.currentTimeMillis() - start1;
//	            temp = String.valueOf(qst);
//	        }
//	        catch(StackOverflowError e){
//	        	long qst = System.currentTimeMillis() - start1;
//	            temp = String.valueOf(qst);
//	            temp = temp + "SOFE";
//	        }
//			
//			long start2 = System.currentTimeMillis();
//			insertionSort(list2);
//			long ist = System.currentTimeMillis() - start2;
//			
//			long start3 = System.currentTimeMillis();
//			bubbleSort(list3);
//			long bst = System.currentTimeMillis() - start3;
//			
//			I=sPrint(list1);
//			B=sPrint(list2);
//			Q=sPrint(list3);
//			System.out.printf("%8d %15s %15s %15d %15d %15s %15s %15s\n", n, L, temp, ist, bst, Q, I, B);
//			//System.out.printf("%8d %15s %15d %15d\n", n, temp, ist, bst);
//		}
	}
}