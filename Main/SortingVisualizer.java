//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

package Main;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;


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
				sortingThread = new Thread(new MergeSort());
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
				sortingThread2 = new Thread(new MergeSort());
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
		


	//int x = 1 serves as a secondary condition to pass(Waleed)
	//The two conditions determine whether the sorting process will pause or continue
	static int x = 1;
	@SuppressWarnings("removal")
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
	

     //Captures Image of Jframe to save to file. (Mario)
	public static BufferedImage SaveImage(Component component) {
		BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
		component.paint(image.getGraphics());
		return image;}
	
	//Calls on SaveImage method.
	protected static void SaveScreenShot(Component component, String filename)  throws Exception {
		
		BufferedImage image = SaveImage(frame);
		ImageIO.write(image,"jpeg", new File (filename));
	}
}