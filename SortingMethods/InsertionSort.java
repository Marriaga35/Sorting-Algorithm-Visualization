//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

package SortingMethods;

import Main.*;

public class InsertionSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerElements frame;
	private boolean firstarray;
	//I added a boolean to aid the program in determining which array to sort(Waleed)
	//True is for first array, False is for second array(Waleed)
	
	public InsertionSort(Integer[] toBeSorted, VisualizerElements frame, boolean firstarray) {
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
		int insert = 0;
		for(int i = 1; i<toBeSorted.length; i++){
			insert = i;
			for(int j = i-1; j>=0; j--){
				if (toBeSorted[i] < toBeSorted[j]){
					insert = j;
					if (j == 0){
						break;
					}
				}else{
					break;
				}
				frame.reDrawArray(toBeSorted, i, insert);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			temp = toBeSorted[i];
			for (int j = i; j>insert; j--){
				toBeSorted[j] = toBeSorted[j-1];
			}
			toBeSorted[insert] = temp;
		}
		frame.reDrawArray(toBeSorted);
	}
	
	//sorting method for second array
	public void secondArray() {
		int temp = 0;
		int insert = 0;
		for(int i = 1; i<toBeSorted.length; i++){
			insert = i;
			for(int j = i-1; j>=0; j--){
				if (toBeSorted[i] < toBeSorted[j]){
					insert = j;
					if (j == 0){
						break;
					}
				}else{
					break;
				}
				frame.reDrawArray2(toBeSorted, i, insert);//runs second array(Waleed)
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			temp = toBeSorted[i];
			for (int j = i; j>insert; j--){
				toBeSorted[j] = toBeSorted[j-1];
			}
			toBeSorted[insert] = temp;
		}
		frame.reDrawArray2(toBeSorted);//runs second array(Waleed)
	}
}