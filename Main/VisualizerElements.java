//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;//(Mario)
import java.awt.Graphics;//(Mario)
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;//(Mario)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.DataOutput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;//(Mario)
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;//(Mario)
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.Timer;

@SuppressWarnings({ "serial", "unused" })
public class VisualizerElements extends JFrame {

	
	private final int MAX_SPEED = 1000;
	private final int MIN_SPEED = 1;
	private final int MAX_SIZE = 500;
	private final int MIN_SIZE = 1;
	private final int DEFAULT_SPEED = 20;
	private final int DEFAULT_SIZE = 20;

	private final String[] Sorts = {"Bubble", "Insertion", "Merge", "Selection", };

	private int sizeModifier;

	private JPanel wrapper; //contains both arrayWrapper and buttonWrapper
	private JPanel arrayWrapper; //contains Array
	private JPanel arrayWrapper2;//Second array (Waleed)
	private JPanel buttonWrapper; //contain Buttons
	private JPanel[] squarePanels;//draws boxes which make up the array
	private JButton start;//Start Sort Button
	private JButton pause;//Pause button(Waleed)
	private JButton help;//Help Button
	private JButton save;//Save file(Mario)
	private JButton print;
	private JComboBox<String> selection;
	private JComboBox<String> selection2; //second array sort (Mario)
	private JSlider speed;
	private JSlider size;
	private JLabel speedVal;
	private JLabel sizeVal;
	private long timer1;
	private GridBagConstraints c;

	public VisualizerElements(){
		super("Sorting Visualizer");

		start = new JButton("Start");
		pause = new JButton("Pause");//Stop button created(Waleed)
		help = new JButton("Help");
		print = new JButton("Print");
		save = new JButton("Save");//Save button (Mario)
		buttonWrapper = new JPanel();
		arrayWrapper = new JPanel();
		arrayWrapper2 = new JPanel();//Second array created(Waleed)
		wrapper = new JPanel();
		selection = new JComboBox<String>();
		selection2 = new JComboBox<String>();//Second array (Mario)
		speed = new JSlider(MIN_SPEED, MAX_SPEED, DEFAULT_SPEED);
		size = new JSlider(MIN_SIZE, MAX_SIZE, DEFAULT_SIZE);
		speedVal = new JLabel("Speed: 20 ms");
		sizeVal = new JLabel("Size: 20 values");
		 JLabel timeLabel = new JLabel();
		c = new GridBagConstraints();

		for(String s : Sorts) selection.addItem(s);
		for(String s : Sorts) selection2.addItem(s);//(Waleed)

		/*Sets FlowLayout to keep array panel at a fixed size
		 * prevents it from expanding when size of array is increased
		 * (Mario)
		 */
		arrayWrapper2.setLayout(new FlowLayout(FlowLayout.CENTER, 0,90));
		arrayWrapper.setLayout(new GridBagLayout());
		arrayWrapper2.setLayout(new GridBagLayout());//Layout for second array(Waleed)
		wrapper.setLayout(new BorderLayout());


		//Set borders around both array 1 and 2. (Mario)
		arrayWrapper.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		arrayWrapper2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		arrayWrapper.setBackground(Color.WHITE);
		arrayWrapper2.setBackground(Color.WHITE);

		c.insets = new Insets(0,1,0,1);
		c.anchor = GridBagConstraints.SOUTH;

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SortingVisualizer.startSort((String) selection.getSelectedItem(), (String) selection2.getSelectedItem());			
			}
		});

		/*Activates stopSort from SortingVisualizer(Waleed)
		 * Used a boolean to aid in determining whether to pause or continue the sort
		 * (Waleed)
		 */
		
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortingVisualizer.stopSort(true);
			}
		});

		help.addActionListener(new ActionListener() {            //(Gerardo)
			public void actionPerformed(ActionEvent e) {
				//Create the window. 
				JFrame frame = new JFrame("Help Menu");
				//Help option in  pop up window (Mario)
				JLabel textLabel = new JLabel(
						"<html>Sorting Options - Select two Sorting Methods to compare.<br/> "
						+ "<html> Start        - Click start button to perform Algorithms. <br/>  "
						+ "<html>Pause         - Select Pause stops to compare current results. <br/>"
						+ "<html>Speed         - Adjust speed rate of algorithm.<br/>"
						+ "<html>Size          - Adjust the size of data. <br/>"
						+ "<html>Print         - Print the results of Algorithm comparison. <br/>"
						+ "<html>Save          - Save results to local file system. "
						+ "");
				
				frame.getContentPane().add(textLabel, BorderLayout.CENTER);
				//Display the window 
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		});
		/*

		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					print.print(null);
				}
				catch (java.awt.print.PrinterException e)
				{
					System.err.format("No Printer Found", e.getMessage());
				}
			}
		});*/
		
		 
		
		//Save button saves result comparisons data. (Mario)		
		save.addActionListener((ActionListener) new ActionListener() {
		
		  public void actionPerformed(ActionEvent e){
			  try {  
				  				  
			            
			  //Saves results as a jpeg image.(Mario)
			 JFrame frame = new JFrame("Save"); 
			  BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			  ImageIO.write(image,"jpeg", new File("D:\\Sorting Algorithm.jpeg"));
			  Graphics2D graphics2D = image.createGraphics();
			  frame.paint(graphics2D);		
			  }catch(Exception evt){System.out.println(e);}    
			  
			
		        
			  JFrame frame = new JFrame("Save");
			  JLabel textLabel = new JLabel("Save sucessful",SwingConstants.CENTER);
			  frame.getContentPane().add(textLabel, BorderLayout.CENTER);
			  frame.setLocationRelativeTo(null);
			  frame.pack();
		      frame.setVisible(true);
	     }    



		} );                        
	


		size.setMinorTickSpacing(10);
		size.setMajorTickSpacing(100);
		size.setPaintTicks(true);

		size.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				sizeVal.setText(("Size: " + Integer.toString(size.getValue()) + " values"));
				validate();
				SortingVisualizer.sortDataCount = size.getValue();
			}
		});

		//Buttons are visually created in top-down order
		buttonWrapper.add(selection);
		buttonWrapper.add(start);
		buttonWrapper.add(pause); //Button for pause(Waleed)
		buttonWrapper.add(speedVal);
		buttonWrapper.add(speed);
		buttonWrapper.add(sizeVal);
		buttonWrapper.add(size);
		buttonWrapper.add(selection2);//2nd array (Mario)
		buttonWrapper.add(help);
		buttonWrapper.add(print);
		buttonWrapper.add(save);//(Mario)
		
	
		wrapper.add(buttonWrapper, BorderLayout.NORTH);
		wrapper.add(arrayWrapper, BorderLayout.WEST);
		wrapper.add(arrayWrapper2, BorderLayout.EAST );//Causes second array to appear(Waleed)

		add(wrapper);

		setExtendedState(JFrame.MAXIMIZED_BOTH );
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	//Draws the first array
	public void preDrawArray(Integer[] squares){
		squarePanels = new JPanel[SortingVisualizer.sortDataCount];
		arrayWrapper.removeAll();
		sizeModifier =  (int) ((getHeight()*0.9)/(squarePanels.length));
		for(int i = 0; i<SortingVisualizer.sortDataCount; i++){
			squarePanels[i] = new JPanel();
			squarePanels[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, squares[i]*sizeModifier));
			squarePanels[i].setBackground(Color.blue);
			arrayWrapper.add(squarePanels[i], c);

		}
		repaint();
		validate();
	}

	public void reDrawArray(Integer[] x){
		reDrawArray(x, -1);
	}

	public void reDrawArray(Integer[] x, int y){
		reDrawArray(x, y, -1);
	}

	public void reDrawArray(Integer[] x, int y, int z){
		reDrawArray(x, y, z, -1);
	}


	public void reDrawArray(Integer[] squares, int working, int comparing, int reading){
		arrayWrapper.removeAll();

		setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 0,90));//keeps graph contained during redraw(Mario)
		
		for(int i = 0; i<squarePanels.length; i++){
			squarePanels[i] = new JPanel();
			squarePanels[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, squares[i]*sizeModifier));
			if (i == working){
				squarePanels[i].setBackground(Color.green);				
			}else if(i == comparing){
				squarePanels[i].setBackground(Color.red);			
			}else if(i == reading){
				squarePanels[i].setBackground(Color.yellow);			
			}else{
				squarePanels[i].setBackground(Color.blue);
			}
			arrayWrapper.add(squarePanels[i], c);
		}
	
		
		repaint();
		validate();
	}

	//Draws the second array(Waleed)
	public void preDrawArray2(Integer[] squares){
		squarePanels = new JPanel[SortingVisualizer.sortDataCount];
		arrayWrapper2.removeAll();

		sizeModifier =  (int) ((getHeight()*0.9)/(squarePanels.length));
		for(int i = 0; i<SortingVisualizer.sortDataCount; i++){
			squarePanels[i] = new JPanel();
			squarePanels[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, squares[i]*sizeModifier));
			squarePanels[i].setBackground(Color.blue);
			arrayWrapper2.add(squarePanels[i], c);
		}
		repaint();
		validate();
	}

	public void reDrawArray2(Integer[] x){
		reDrawArray2(x, -1);
	}

	public void reDrawArray2(Integer[] x, int y){
		reDrawArray2(x, y, -1);
	}

	public void reDrawArray2(Integer[] x, int y, int z){
		reDrawArray2(x, y, z, -1);
	}


	public void reDrawArray2(Integer[] squares, int working, int comparing, int reading){
		arrayWrapper2.removeAll();
		setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 0,90));//keeps graph contained during redraw(Mario)

		for(int i = 0; i<squarePanels.length; i++){
			squarePanels[i] = new JPanel();
			squarePanels[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, squares[i]*sizeModifier));
			if (i == working){
				squarePanels[i].setBackground(Color.green);				
			}else if(i == comparing){
				squarePanels[i].setBackground(Color.red);			
			}else if(i == reading){
				squarePanels[i].setBackground(Color.yellow);			
			}else{
				squarePanels[i].setBackground(Color.blue);
			}
			arrayWrapper2.add(squarePanels[i], c);
		}
		repaint();
		validate();

	}

}

