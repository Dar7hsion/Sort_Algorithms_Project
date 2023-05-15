import java.text.DecimalFormat;
import java.util.Random;

/**************************************** 
* 
* Student Name: 		Alexander Purser
* Date Due: 			11/30/2022
* Date Submitted: 		11/30/2022
* Program Name: 		Sorting_Project_SD_Test
* Program Description:  This program compares the time between insertion sort, bubble sort and quick sort, 
* 						with both the random case and worst case, time comparison is given in milli sec 
* 
* 
****************************************/ 

 
public class Sorting_Project_SD_Test 
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
	
	static public void printValues(int [] list)
	  // Prints all the values integers.
	  {
	    int value;
	    DecimalFormat fmt = new DecimalFormat("00");
	    System.out.println("The values array is:");
	    for (int index = 0; index < list.length; index++)
	    {
	      value = list[index];
	      if (((index + 1) % 10) == 0)
	        System.out.println(fmt.format(value));
	      else
	        System.out.print(fmt.format(value) + " ");
	    }
	    System.out.println();
	  }
	  /////////////////////////////////////////////////////////////////
	  //
	  //  Insertion Sort
	
//	public static void insertionSort (int [] list)
//	{
//		for (int i = 1; i < list.length; ++i)
//		{
//			int pivot = list[i];
//			int h = i;
//			while (h > 0 && list[h-1] > pivot)
//			{
//				list[h] = list[h - 1];
//				--h;
//			}
//			list[h] = pivot;
//		}
//	}
	
	  static void insertItem(int [] list, int startIndex, int endIndex)
	  // Upon completion, values[0]..values[endIndex] are sorted.
	  {
	    boolean finished = false;
	    int current = endIndex;
	    boolean moreToSearch = true;
	    while (moreToSearch && !finished)
	    {
	      if (list[current] < list[current - 1])
	      {
	        swap(list, current, current - 1);
	        current--;
	        moreToSearch = (current != startIndex);
	      }
	      else
	        finished = true;
	    }
	  }
	 
	  static void insertionSort(int [] list)
	  // Sorts the values array using the insertion sort algorithm.
	  {
	   for (int count = 1; count < list.length; count++)
	      insertItem(list, 0, count);
	  }
	  
	  /////////////////////////////////////////////////////////////////
	  //
	  //  Bubble Sort

//	public static void bubbleSort (int list [])
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
	  
	  static void bubbleUp(int [] list, int startIndex, int endIndex)
	  // Switches adjacent pairs that are out of order 
	  // between values[startIndex]..values[endIndex] 
	  // beginning at values[endIndex].
	  {
	    for (int index = endIndex; index > startIndex; index--)
	      if (list[index] < list[index - 1])
	        swap(list, index, index - 1);
	  }
	 
	  static void bubbleSort(int [] list)
	  // Sorts the values array using the bubble sort algorithm.
	  {
	    int current = 0;
	 
	    while (current < (list.length - 1))
	    {
	      bubbleUp(list, current, list.length - 1);
	      current++;
	    }
	  }
	  
	  /////////////////////////////////////////////////////////////////
	  //
	  //  Quick Sort
	  
	static int split( int [] list, int first, int last)
	  {
	    int splitVal = list[first];
	    int saveF = first;
	    boolean onCorrectSide;
	 
	    first++;
	    do
	    {
	      onCorrectSide = true;
	      while (onCorrectSide)             // move first toward last
	        if (list[first] > splitVal)
	          onCorrectSide = false;
	        else
	        {
	          first++;
	          onCorrectSide = (first <= last);
	        }
	 
	      onCorrectSide = (first <= last);
	      while (onCorrectSide)             // move last toward first
	        if (list[last] <= splitVal)
	          onCorrectSide = false;
	        else
	         {
	          last--;
	          onCorrectSide = (first <= last);
	         }
	   
	      if (first < last)                
	      {
	        swap(list, first, last);
	        first++;
	        last--;
	      }
	    } while (first <= last);
	 
	    swap(list, saveF, last);
	    return last;
	  }

	  static void quickSort(int [] list, int first, int last)
	  {
	    if (first < last)
	    {
	      int splitPoint;
	      splitPoint = split(list, first, last);
	      quickSort(list, first, splitPoint - 1);
	      quickSort(list, splitPoint + 1, last);
	    }
	  }
	
	  /////////////////////////////////////////////////////////////////
	  //
	  //  Main
	
	public static void main (String [] args) 
	{
		Random rand = new Random();
		int MAX = 50;
		int [] list1 = new int [MAX]; 
		for (int i = 0; i < MAX; i++)
		{
			list1[i] = Math.abs(rand.nextInt()) % 100;;
		}
		int [] list2 = list1.clone();
		int [] list3 = list1.clone();
		
		System.out.println("Testing wheteher the three sorting algorithms work correctly\n");
		
		//Insertion Sort//////////////////////////////////
		printValues(list1);
		System.out.println("values is sorted: " + isSorted(list1));
	    System.out.println();
	    insertionSort(list1);
	    printValues(list1);
	    System.out.println("values is sorted: " + isSorted(list1));
	    System.out.println();
	    /////////////////////////////////////////////////
		
	    
		//Bubble Sort////////////////////////////////////
		printValues(list2);
		System.out.println("values is sorted: " + isSorted(list1));
	    System.out.println();
	    bubbleSort(list2);
	    printValues(list2);
	    System.out.println("values is sorted: " + isSorted(list1));
	    System.out.println();
	    //////////////////////////////////////////////////
		
	    
		//Quick Sort//////////////////////////////////////
		printValues(list3);
		System.out.println("values is sorted: " + isSorted(list1));
	    System.out.println(); 
	    quickSort(list3, 0, list1.length - 1);
	    printValues(list3);
	    System.out.println("values is sorted: " + isSorted(list1));
	    System.out.println();
	    /////////////////////////////////////////////////
	}
}