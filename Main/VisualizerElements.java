package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class VisualizerElements extends JFrame {

	protected static final String String = null;
	private final int MAX_SPEED = 1000;
	private final int MIN_SPEED = 1;
	private final int MAX_SIZE = 500;
	private final int MIN_SIZE = 1;
	private final int DEFAULT_SPEED = 20;
	private final int DEFAULT_SIZE = 20;
	
	private final String[] Sorts = {"Bubble", "Insertion", "Merge", "Selection", };
	private final String[] Sorts2 = {"Bubble", "Insertion", "Merge", "Selection"};
	private int sizeModifier;

	private JPanel wrapper; //contains both arrayWrapper and buttonWrapper
	private JPanel arrayWrapper; //contains Array
	private JPanel arrayWrapper2;//Second array (Waleed)
	private JPanel buttonWrapper; //contain Buttons
	private JPanel[] squarePanels;
	private JButton start;
	private JButton stop;//Stop sort button(Waleed)
	private JComboBox<String> selection;
	private JComboBox<String> selection2; //second array sort (Mario)
	private JSlider speed;
	private JSlider size;
	private JLabel speedVal;
	private JLabel sizeVal;
	private GridBagConstraints c;
	
	public VisualizerElements(){
		super("Sorting Visualizer");
		
		start = new JButton("Start");
		stop = new JButton("Stop");//Stop button created(Waleed)
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
		c = new GridBagConstraints();
		
		for(String s : Sorts) selection.addItem(s);
		for(String s2 : Sorts2) selection2.addItem(s2); //Second Array (Mario)
		
		/*Sets FlowLayout to keep array panel at a fixed size
		 * prevents it from expanding when size of array is increased
		 * (Mario)
		 */
		arrayWrapper.setLayout(new FlowLayout(FlowLayout.CENTER, 0,90));
		arrayWrapper2.setLayout(new FlowLayout(FlowLayout.CENTER, 0,90));//Layout for second array(Waleed)
		wrapper.setLayout(new BorderLayout());
		

		//Set borders around both array 1 and 2. (Mario)
		arrayWrapper.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	    arrayWrapper2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	    arrayWrapper.setBackground(Color.WHITE);
	    arrayWrapper2.setBackground(Color.WHITE);
        
		
	    c.insets = new Insets(20,20,20,20);
		c.anchor = GridBagConstraints.SOUTH;
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
						SortingVisualizer.startSort((String) selection.getSelectedItem());
						SortingVisualizer.startSort2((String) selection2.getSelectedItem());			
			}
			
					});
		
		

		//Activates stopSort from SortingVisualizer(Waleed)
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortingVisualizer.stopSort((String) selection.getSelectedItem());
				SortingVisualizer.stopSort((String) selection2.getSelectedItem());
			}
		});

		speed.setMinorTickSpacing(10);
		speed.setMajorTickSpacing(100);
		speed.setPaintTicks(true);
		
		speed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				speedVal.setText(("Speed: " + Integer.toString(speed.getValue()) + "ms"));
				validate();
				SortingVisualizer.sleep = speed.getValue();
			}
		});
		
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
		
		buttonWrapper.add(start);
		buttonWrapper.add(stop); //Button for stop sort(Waleed)
		buttonWrapper.add(speedVal);
		buttonWrapper.add(speed);
		buttonWrapper.add(sizeVal);
		buttonWrapper.add(size);
		buttonWrapper.add(selection);
		buttonWrapper.add(selection2);//2nd array (Mario)
		
		wrapper.add(buttonWrapper, BorderLayout.NORTH);
		wrapper.add(arrayWrapper, BorderLayout.WEST);
		wrapper.add(arrayWrapper2, BorderLayout.EAST );//Causes second array to appear(Waleed)
		
		add(wrapper);

		setExtendedState(JFrame.MAXIMIZED_BOTH );
		
		addComponentListener(new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent e) {
				
				sizeModifier = (int) ((getHeight()*0.9)/(squarePanels.length));
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				
			}
			
		});
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	public void preDrawArray(Integer[] squares){
		squarePanels = new JPanel[SortingVisualizer.sortDataCount];
		arrayWrapper.removeAll();
		
		// 90% of the windows height, divided by the size of the sorted array.
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

