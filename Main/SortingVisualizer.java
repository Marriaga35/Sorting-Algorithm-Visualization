//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

package Main;

import java.util.ArrayList;
import java.util.Collections;

import SortingMethods.*;

public class SortingVisualizer {
	
	private static Thread sortingThread;
	public static VisualizerElements frame;
	public static Integer[] toBeSorted;
	public static boolean isSorting = false;
	public static int sortDataCount = 20;
	public static int sleep = 20;
	public static int blockWidth;
	
	public static boolean stepped = false;
	
	public static void main(String[] args) {
		frame = new VisualizerElements();
		resetArray();
		frame.setLocationRelativeTo(null);
	}
	
	public static void resetArray(){
		
		if (isSorting) return;
		toBeSorted = new Integer[sortDataCount];
		blockWidth = (int) Math.max(Math.floor(500/sortDataCount), 1);
		for(int i = 0; i<toBeSorted.length; i++){
			if (stepped) {
				toBeSorted[i] = i;
			} else {
				toBeSorted[i] = (int) (sortDataCount*Math.random());
			}
		}
		
		if (stepped) {
			ArrayList<Integer> shuffleThis = new ArrayList<>();
			for (int i = 0; i < toBeSorted.length; i++) {
				shuffleThis.add(toBeSorted[i]);
			}
			Collections.shuffle(shuffleThis);
			toBeSorted = shuffleThis.toArray(toBeSorted);
		}
		frame.preDrawArray(toBeSorted);
		frame.preDrawArray2(toBeSorted);//Inclusion of second array (Waleed)
	}
	
	public static void startSort(String type, String type2){
		
		if (sortingThread == null || !isSorting){
			
			resetArray();
			
			isSorting = true;

			//Reads user's first choice
			switch(type){
			case "Bubble":
				sortingThread = new Thread(new BubbleSort(toBeSorted, frame, true));
				break;
				
			case "Insertion":
				sortingThread = new Thread(new InsertionSort(toBeSorted, frame, true));
				break;
				
			case "Merge":
				sortingThread = new Thread(new MergeSort(true));
				break;	
				
			case "Selection":
				sortingThread = new Thread(new SelectionSort(toBeSorted, frame, true));
				break;
			
			default:
				isSorting = false;
				return;
			}
			
			sortingThread.start();

			//Reads user's second choice
			switch(type2){
			case "Bubble":
				sortingThread = new Thread(new BubbleSort(toBeSorted, frame, false));
				break;
				
			case "Insertion":
				sortingThread = new Thread(new InsertionSort(toBeSorted, frame, false));
				break;
				
			case "Merge":
				sortingThread = new Thread(new MergeSort(false));
				break;	
				
			case "Selection":
				sortingThread = new Thread(new SelectionSort(toBeSorted, frame, false));
				break;
				
			default:
				isSorting = false;
				return;
			}
			
			sortingThread.start();
			
		}
		
	}
		
	
	     /*startSort2 switch case for second array
	     * uses sort methods 2 to perform reDrawArray2.
	     * (Mario)
	     */
		/*public static void startSort2(String s2){
			
			if (sortingThread == null || !isSorting){
				
				resetArray();
				
				isSorting = true;

				switch(s2){
				
				case "Bubble":
					sortingThread = new Thread(new BubbleSort2(toBeSorted, frame, false));
					break;
					
				case "Insertion":
					sortingThread = new Thread(new InsertionSort2(toBeSorted, frame, false));
					break;
					
				case "Merge":
					sortingThread = new Thread(new MergeSort2());
					break;	
					
				case "Selection":
					sortingThread = new Thread(new SelectionSort2(toBeSorted, frame, false));
					break;
				default:
					isSorting = false;
					return;
				}
				
				sortingThread.start();
				
			}
	}*/

	//Stops the sorting algorithm(Waleed)
	@SuppressWarnings("deprecation")
	public static void stopSort(String selectedItem) {
		
		sortingThread.stop();
		sortingThread = null;
		
	}

}
