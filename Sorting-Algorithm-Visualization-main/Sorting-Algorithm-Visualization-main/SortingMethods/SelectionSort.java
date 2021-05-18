//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

package SortingMethods;

import Main.*;

public class SelectionSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerElements frame;
	private boolean firstarray;
	//I added a boolean to aid the program in determining which array to sort(Waleed)
	//True is for first array, False is for second array(Waleed)
	
	public SelectionSort(Integer[] toBeSorted, VisualizerElements frame, boolean firstarray) {
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
		int selected = 0;
		for(int i = 0; i<toBeSorted.length; i++){
			selected = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				
				if (toBeSorted[j] <= toBeSorted[selected]){
					selected = j;
				}
				frame.reDrawArray(toBeSorted, selected, j-1);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[selected];
			toBeSorted[selected]= temp;
		}
		frame.reDrawArray(toBeSorted);
	}
	
	//sorting method for second array
	public void secondArray() {
		int temp = 0;
		int selected = 0;
		for(int i = 0; i<toBeSorted.length; i++){
			selected = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				
				if (toBeSorted[j] <= toBeSorted[selected]){
					selected = j;
				}
				frame.reDrawArray2(toBeSorted, selected, j-1);//runs second array(Waleed)
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[selected];
			toBeSorted[selected]= temp;
		}
		frame.reDrawArray2(toBeSorted);//runs second array(Waleed)
	}

}