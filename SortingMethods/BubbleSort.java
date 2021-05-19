//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

//written by: Waleed Qureshi
//tested by: Waleed Qureshi
//debugged by: Waleed Qureshi

package SortingMethods;

import Main.*;

public class BubbleSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerElements frame;
	private boolean firstarray;
	//I added a boolean to aid the program in determining which array to sort(Waleed)
	//True is for first array, False is for second array(Waleed)
	
	public BubbleSort(Integer[] toBeSorted, VisualizerElements frame, boolean firstarray) {
		this.toBeSorted = toBeSorted;
		this.frame = frame;
		this.firstarray = firstarray;
	}
	
	//Determines whether the user would like to sort the first array or second array(Waleed)
	public void run() {
		if (firstarray == true) {
			firstArray();
		} else {
			secondArray();
		}
		SortingVisualizer.isSorting=false;
	}
	
	//sorting method for first array
	public void firstArray() {
		int temp = 0;
		boolean swapped = false;
		for(int i = 0; i<toBeSorted.length-1; i++){
			swapped = false;
			for(int j = 1; j<toBeSorted.length-i; j++){
				if (toBeSorted[j-1]> toBeSorted[j]){
					temp = toBeSorted[j-1];
					toBeSorted[j-1] = toBeSorted[j];
					toBeSorted[j]= temp;
					swapped = true;
				}
				frame.reDrawArray(toBeSorted, j, j+1);//runs first array
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (!swapped) break;
		}
	}
	
	//sorting method for second array
	public void secondArray() {
		int temp = 0;
		boolean swapped = false;
		for(int i = 0; i<toBeSorted.length-1; i++){
			swapped = false;
			for(int j = 1; j<toBeSorted.length-i; j++){
				if (toBeSorted[j-1]> toBeSorted[j]){
					temp = toBeSorted[j-1];
					toBeSorted[j-1] = toBeSorted[j];
					toBeSorted[j]= temp;
					swapped = true;
				}
				frame.reDrawArray2(toBeSorted, j, j+1);//runs second array(Waleed)
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (!swapped) break;
		}
	}

}