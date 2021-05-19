//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

//written by:
//tested by:
//debugged by:



package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jgoodies.forms.factories.DefaultComponentFactory;

@SuppressWarnings({ "serial" })
public class VisualizerElements extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel[] dataPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnStart;
	private JButton btnPause;
	private JButton btnPrint;
	private JButton btnHelp;
	private int time = 0;
	private int time_1 = 0;
	private int officialSpeed = 10;
	private int officialSize = 20;
	private int sizeModifier;

	private GridBagConstraints constraints;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VisualizerElements(){
		//super("Sorting Algorithm Visualizer");

		frame = new JFrame("Sorting Algorithm Visualizer");
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBounds(0, 0, 2560/3, 1600/3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		/* ============ Top of Window Here ===================*/

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Controls");
		lblNewJgoodiesTitle.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewJgoodiesTitle.setBounds(28, 27, 70, 20);
		frame.getContentPane().add(lblNewJgoodiesTitle);

		JLabel lblNewLabel = new JLabel("Size");
		lblNewLabel.setBounds(131, 27, 33, 20);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setText("20");
		textField.setToolTipText("Manually insert size value.");
		//textField.setColumns(10);
		textField.setBounds(163, 26, 61, 22);
		frame.getContentPane().add(textField);

		JSlider slider = new JSlider();
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(100);
		slider.setValue(20);
		slider.setToolTipText("Slide the slider to select size value.");
		slider.setMinimum(1);
		slider.setMaximum(250);
		slider.setPaintTicks(true);
		slider.setBounds(224, 27, 122, 20);
		frame.getContentPane().add(slider);

		JLabel lblNewLabel_1 = new JLabel("Speed (ms)");
		lblNewLabel_1.setBounds(355, 27, 70, 20);
		frame.getContentPane().add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setText("10");
		textField_1.setToolTipText("Manually insert speed value.");
		//textField_1.setColumns(10);
		textField_1.setBounds(426, 26, 61, 22);
		frame.getContentPane().add(textField_1);

		JSlider slider_1 = new JSlider();
		slider_1.setMajorTickSpacing(100);
		slider_1.setMinorTickSpacing(10);
		slider_1.setValue(10);
		slider_1.setToolTipText("Slide the slider to select speed value.");
		slider_1.setMaximum(500);
		slider_1.setMinimum(1);
		slider_1.setPaintTicks(true);
		slider_1.setBounds(485, 27, 122, 20);
		frame.getContentPane().add(slider_1);

		btnStart = new JButton("Start");
		btnStart.setToolTipText("Click to begin sorting.");
		btnStart.setBounds(623, 20, 70, 29);
		frame.getContentPane().add(btnStart);

		btnPause = new JButton("Pause");
		btnPause.setToolTipText("Click to hault sorting.");
		btnPause.setBounds(695, 20, 70, 29);
		frame.getContentPane().add(btnPause);

		/* ============ Center of Window Here ================*/

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(18, 52, 790, 16);
		frame.getContentPane().add(separator);

		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Graphs");
		lblNewJgoodiesTitle_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewJgoodiesTitle_1.setBounds(28, 70, 70, 20);
		frame.getContentPane().add(lblNewJgoodiesTitle_1);

		JLabel lblSortMethod = new JLabel("Sort Method 1");
		lblSortMethod.setBounds(130, 72, 100, 20);
		frame.getContentPane().add(lblSortMethod);

		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(4);
		comboBox.setToolTipText("Select from list to choose first sorting method.");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bubble", "Insertion", "Merge", "Selection"}));
		comboBox.setBounds(225, 71, 110, 27);
		frame.getContentPane().add(comboBox);

		JLabel lblSortMethod_1 = new JLabel("Sort Method 2");
		lblSortMethod_1.setBounds(425, 72, 100, 20);
		frame.getContentPane().add(lblSortMethod_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(4);
		comboBox_1.setToolTipText("Select from list to choose second sorting method.");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Bubble", "Insertion", "Merge", "Selection"}));
		comboBox_1.setBounds(520, 71, 110, 27);
		frame.getContentPane().add(comboBox_1);

		/* ============ Bottom of Window Here ================*/

		/* ============ Results ================*/

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(28, 350, 790, 16);
		frame.getContentPane().add(separator_1);

		JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("Results");
		lblNewJgoodiesTitle_2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewJgoodiesTitle_2.setBounds(38, 364, 70, 20);
		frame.getContentPane().add(lblNewJgoodiesTitle_2);

		JLabel lblTimeToSort = new JLabel("Sort Time 1");
		lblTimeToSort.setBounds(38, 400, 90, 16);
		frame.getContentPane().add(lblTimeToSort);

		JLabel lblTemptext = new JLabel("Sort Time 2");
		lblTemptext.setBounds(38, 427, 90, 16);
		frame.getContentPane().add(lblTemptext);

		JLabel lblDifference = new JLabel("Time Difference");
		lblDifference.setBounds(38, 455, 100, 16);
		frame.getContentPane().add(lblDifference);

		JLabel lblTime = new JLabel(Integer.toString(time));
		lblTime.setToolTipText("Time took to sort using Method 1.");
		lblTime.setBounds(194, 400, 61, 16);
		frame.getContentPane().add(lblTime);

		JLabel lblTime_1 = new JLabel(Integer.toString(time_1));
		lblTime_1.setToolTipText("Time took to sort using Method 1");
		lblTime_1.setBounds(194, 427, 61, 16);
		frame.getContentPane().add(lblTime_1);

		JLabel lblTimeDifference = new JLabel(Integer.toString(Math.abs(time - time_1)));
		lblTimeDifference.setToolTipText("Difference between Time 1 and 2.");
		lblTimeDifference.setBounds(194, 455, 110, 16);
		frame.getContentPane().add(lblTimeDifference);

		/* ============ Print Options ============*/

		JLabel lblPrintOptions = DefaultComponentFactory.getInstance().createTitle("Print Options");
		lblPrintOptions.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblPrintOptions.setBounds(384, 364, 110, 20);
		frame.getContentPane().add(lblPrintOptions);

		JCheckBox chckbxSortTime = new JCheckBox("Sort Method 1");
		chckbxSortTime.setToolTipText("When checked it will be displayed.");
		chckbxSortTime.setSelected(true);
		chckbxSortTime.setBounds(384, 396, 128, 23);
		frame.getContentPane().add(chckbxSortTime);

		JCheckBox chckbxSortTime_1 = new JCheckBox("Sort Method 2");
		chckbxSortTime_1.setToolTipText("When checked it will be displayed.");
		chckbxSortTime_1.setSelected(true);
		chckbxSortTime_1.setBounds(384, 423, 128, 23);
		frame.getContentPane().add(chckbxSortTime_1);

		JCheckBox chckbxDataValues = new JCheckBox("Data Size & Values");
		chckbxDataValues.setToolTipText("When checked it will be displayed.");
		chckbxDataValues.setSelected(true);
		chckbxDataValues.setBounds(384, 451, 148, 23);
		frame.getContentPane().add(chckbxDataValues);

		JCheckBox chckbxSortingMethods = new JCheckBox("Sort Time 1");
		chckbxSortingMethods.setToolTipText("When checked it will be displayed.");
		chckbxSortingMethods.setSelected(true);
		chckbxSortingMethods.setBounds(541, 396, 148, 23);
		frame.getContentPane().add(chckbxSortingMethods);

		JCheckBox chckbxSortingMethod = new JCheckBox("Sort Time 2");
		chckbxSortingMethod.setToolTipText("When checked it will be displayed.");
		chckbxSortingMethod.setSelected(true);
		chckbxSortingMethod.setBounds(541, 423, 148, 23);
		frame.getContentPane().add(chckbxSortingMethod);

		JCheckBox chckbxDifference = new JCheckBox("Time Difference");
		chckbxDifference.setToolTipText("When checked it will be displayed.");
		chckbxDifference.setSelected(true);
		chckbxDifference.setBounds(541, 451, 133, 23);
		frame.getContentPane().add(chckbxDifference);

		btnPrint = new JButton("Print");
		btnPrint.setBounds(716, 395, 70, 29);
		frame.getContentPane().add(btnPrint);

		btnHelp = new JButton("Help");
		btnHelp.setBounds(716, 422, 70, 29);
		frame.getContentPane().add(btnHelp);

		/* ============ Center Panels for Graphs ==================*/

		constraints = new GridBagConstraints();
		constraints.insets = new Insets(0,1,0,1);
		constraints.anchor = GridBagConstraints.SOUTH; 										//using different layout compared to graphs (border v.s. flow)

		panel = new JPanel();
		panel.setBounds(38, 102, 363, 236);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		panel_1 = new JPanel();
		panel_1.setBounds(425, 102, 363, 236);
		frame.getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		/* ============ Adding All Listeners Here =================*/

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortingVisualizer.startSort((String) comboBox.getSelectedItem(), (String) comboBox_1.getSelectedItem());
				System.out.println(comboBox.getSelectedItem());
				System.out.println(comboBox_1.getSelectedItem());

			}
		});

		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortingVisualizer.stopSort(true);
			}
		});

		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Help Window");
				JLabel textLabel = new JLabel("<html>This program serves as a tool to visualize sorting algorithms in real time." 
						+ "<br/><br/>1) Select your algorithms to compare using the dropdown menus above each graph. The default is Bubble Sort." 
						+ "<br/><br/>2) Select your desired dataset size using the slider above the right graph."
						+ "<br/><br/>3) You can select your desired speed of the visual using the slider above the left graph"
						+ "<br/>It's purely cosmetic and has no effect on the actual sort time of the algorithm. It can also be changed while the sort is in progress"
						+ "<br/><br/>4) Use the 'Start' button to begin the sort, and use the pause button to pause/resume the sort while it's in progress."
						+ "</html>\"",SwingConstants.CENTER); //These are the instructions provided by the help window (Kyle));
				textLabel.setPreferredSize(new Dimension(600, 300));
				frame.getContentPane().add(textLabel, BorderLayout.CENTER);
				//Display the window 
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		});

		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPrint.print(null);
			}
		});

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				officialSize = Integer.parseInt(textField.getText());
				slider.setValue(officialSize);
				//validate();
				SortingVisualizer.sortDataCount = officialSize;
			}
		});

		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				officialSpeed = Integer.parseInt(textField_1.getText());
				slider_1.setValue(officialSpeed);
				//validate();
				SortingVisualizer.sleep = officialSpeed;
			}
		});

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textField.setText(Integer.toString(slider.getValue()));
				officialSize = slider.getValue();
				//validate();
				SortingVisualizer.sortDataCount = officialSize;
			}
		});

		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textField_1.setText(Integer.toString(slider_1.getValue()));
				officialSpeed = slider_1.getValue();
				//validate();
				SortingVisualizer.sleep = officialSpeed;
			}
		});

	}

		/* ============ Visualization of Graphs in Action ==========*/

	//Draws the first array
	public void preDrawArray(Integer[] datapanel){

		panel.removeAll();
		System.out.println("pre1: panel_1 all removed");
		dataPanel = new JPanel[SortingVisualizer.sortDataCount];
		sizeModifier = (int) ((getHeight()*0.9/(dataPanel.length)));//========================================================================================

		for(int i = 0; i<SortingVisualizer.sortDataCount; i++){
			dataPanel[i] = new JPanel();
			dataPanel[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, datapanel[i]*sizeModifier*11));
			dataPanel[i].setBackground(Color.orange);
			panel.add(dataPanel[i], constraints);
			//System.out.println("pre1: " + i);

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


	public void reDrawArray(Integer[] datapanel, int working, int comparing, int reading){

		panel.removeAll();
		System.out.println("re1: panel all removed");

		for(int i = 0; i<dataPanel.length; i++){

			dataPanel[i] = new JPanel();
			dataPanel[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, datapanel[i]*sizeModifier*11));
			if (i == working){
				dataPanel[i].setBackground(Color.green);				
			}else if(i == comparing){
				dataPanel[i].setBackground(Color.red);			
			}else if(i == reading){
				dataPanel[i].setBackground(Color.yellow);			
			}else{
				dataPanel[i].setBackground(Color.orange);
			}
			panel.add(dataPanel[i], constraints);
			//System.out.println("re1: " + i);

		}
		repaint();
		validate();
	}

	//I incorporated the preDrawArray2 and reDrawArray2 functions
	//These are based on the already existing functions: preDrawArray and reDrawArray
	//I simply replaced arrayWrapper with arrayWrapper2
	//Draws the second array(Waleed)
	public void preDrawArray2(Integer[] datapanel){

		panel_1.removeAll();
		System.out.println("pre2: panel_1 all removed");
		dataPanel = new JPanel[SortingVisualizer.sortDataCount];
		sizeModifier =  (int) ((getHeight()*0.9/(dataPanel.length))); //============================================================================================================

		for(int i = 0; i<SortingVisualizer.sortDataCount; i++){
			dataPanel[i] = new JPanel();
			dataPanel[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, datapanel[i]*sizeModifier*11));
			dataPanel[i].setBackground(Color.blue);
			panel_1.add(dataPanel[i], constraints);
			//System.out.println("pre2: " + i);

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

	public void reDrawArray2(Integer[] datapanel, int working, int comparing, int reading){

		panel_1.removeAll();
		System.out.println("re2: panel_1 all removed");

		for(int i = 0; i<dataPanel.length; i++){

			dataPanel[i] = new JPanel();
			dataPanel[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, datapanel[i]*sizeModifier*11));
			if (i == working){
				dataPanel[i].setBackground(Color.green);				
			}else if(i == comparing){
				dataPanel[i].setBackground(Color.red);			
			}else if(i == reading){
				dataPanel[i].setBackground(Color.yellow);			
			}else{
				dataPanel[i].setBackground(Color.blue);
			}
			panel_1.add(dataPanel[i], constraints);
			//System.out.println("re2: " + i);

		}
		repaint();
		validate();

	}

}

