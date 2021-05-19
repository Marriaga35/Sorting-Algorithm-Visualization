//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

//written by: Waleed Qureshi
//tested by: Waleed Qureshi
//debugged by: Waleed Qureshi

package SortingMethods;

import Main.*;

public class MergeSort implements Runnable{
   
   private boolean firstarray;
   //I added a boolean to aid the program in determining which array to sort(Waleed)
   //True is for first array, False is for second array(Waleed)
   
   public MergeSort(boolean firstarray) {
      this.firstarray = firstarray;
   }
   
   public void run() {
      Integer[] toBeSorted = SortingVisualizer.toBeSorted;
      inPlaceSort(toBeSorted);
      SortingVisualizer.isSorting=false;
   }
   public void inPlaceSort ( Integer[] x )
      {  inPlaceSort (x, 0, x.length-1);  }

   private void inPlaceSort ( Integer[] x, int first, int last )
   {
      int mid, lt, rt;
      int tmp;

      if ( first >= last ) return;

      mid = (first + last) / 2;

      inPlaceSort (x, first, mid);
      inPlaceSort (x, mid+1, last);

      lt = first;  rt = mid+1;
     
      if ( x[mid] <= x[rt])
         return;

      while (lt <= mid && rt <= last)
      {
        
         if ( x[lt] <= x[rt])
            lt++;
         
         else
         {
            tmp = x[rt];    
            for (int i = rt-lt;i>0; i--){
               x[lt+i] = x[lt+i-1];
            }
            x[lt] = tmp;
          
            lt++;  mid++;  rt++;
         }
         
         //Called upon when user wants to apply merge sort to first array(Waleed)
         if (firstarray == true) {
          SortingVisualizer.frame.reDrawArray(x, mid, rt, lt);
         }
         //Called upon when user wants to apply merge sort to second array(Waleed)
         if (firstarray == false) {
          SortingVisualizer.frame.reDrawArray2(x, mid, rt, lt);//runs second array(Waleed)
         }
         try {
            Thread.sleep(SortingVisualizer.sleep);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
     
   }
}