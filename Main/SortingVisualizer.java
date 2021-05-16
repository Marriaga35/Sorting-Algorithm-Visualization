//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

package Main;

import java.util.ArrayList;
import java.util.Collections;

import SortingMethods.*;

public class SortingVisualizer {
	
	private static Thread sortingThread;
	private static Thread sortingThread2;//Added sortingThread2 to process different start/stop calls(Waleed)
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
		//Added String type2 to accept user choice for both arrays(Waleed)
		//Inclusion of sortingThread2
		if (sortingThread == null || sortingThread2 == null || !isSorting){
			
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
				sortingThread2 = new Thread(new BubbleSort(toBeSorted, frame, false));
				break;
				
			case "Insertion":
				sortingThread2 = new Thread(new InsertionSort(toBeSorted, frame, false));
				break;
				
			case "Merge":
				sortingThread2 = new Thread(new MergeSort(false));
				break;	
				
			case "Selection":
				sortingThread2 = new Thread(new SelectionSort(toBeSorted, frame, false));
				break;
				
			default:
				isSorting = false;
				return;
			}
			
			sortingThread2.start();
			
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

	//int x = 1 serves as a secondary condition to pass(Waleed)
	//The two conditions determine whether the sorting process will pause or continue
	static int x = 1;
	public static void stopSort(Boolean pause) {
		if (pause == true && x == 1) {
			sortingThread.suspend();
			sortingThread2.suspend();
			x++;
		}
		else {
			sortingThread.resume();
			sortingThread2.resume();
			x--;
		}
		
	}

}