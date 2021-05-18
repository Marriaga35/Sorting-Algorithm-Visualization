//Most of the code is not our original work
//Any code added will be signed by the contributor who did the work

package Main;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class testing {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testing window = new testing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sorting Algorithm Visualizer");
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(0, 0, 2560/3, 1600/3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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
		lblNewLabel.setLabelFor(textField);
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
		lblNewLabel_1.setLabelFor(textField_1);
		textField_1.setColumns(10);
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

		JButton btnStart = new JButton("Start");
		btnStart.setToolTipText("Click to begin sorting.");
		btnStart.setBounds(623, 20, 70, 29);
		frame.getContentPane().add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.setToolTipText("Click to hault sorting.");
		btnStop.setBounds(695, 20, 70, 29);
		frame.getContentPane().add(btnStop);

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

		JLabel lblTime = new JLabel("Time 1");
		lblTime.setBounds(194, 400, 61, 16);
		frame.getContentPane().add(lblTime);

		JLabel lblTime_1 = new JLabel("Time 2");
		lblTime_1.setBounds(194, 427, 61, 16);
		frame.getContentPane().add(lblTime_1);

		JLabel lblTimeDifference = new JLabel("Time Difference");
		lblTimeDifference.setBounds(194, 455, 110, 16);
		frame.getContentPane().add(lblTimeDifference);

		/* ============ Print Options ================*/

		JLabel lblPrintOptions = DefaultComponentFactory.getInstance().createTitle("Print Options");
		lblPrintOptions.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblPrintOptions.setBounds(384, 364, 110, 20);
		frame.getContentPane().add(lblPrintOptions);

		JCheckBox chckbxSortTime = new JCheckBox("Sort Method 1");
		chckbxSortTime.setBounds(384, 396, 128, 23);
		frame.getContentPane().add(chckbxSortTime);

		JCheckBox chckbxSortTime_1 = new JCheckBox("Sort Method 2");
		chckbxSortTime_1.setBounds(384, 423, 128, 23);
		frame.getContentPane().add(chckbxSortTime_1);

		JCheckBox chckbxDataValues = new JCheckBox("Data Size & Values");
		chckbxDataValues.setBounds(384, 451, 148, 23);
		frame.getContentPane().add(chckbxDataValues);

		JCheckBox chckbxSortingMethods = new JCheckBox("Sort Time 1");
		chckbxSortingMethods.setBounds(541, 396, 148, 23);
		frame.getContentPane().add(chckbxSortingMethods);

		JCheckBox chckbxSortingMethod = new JCheckBox("Sort Time 2");
		chckbxSortingMethod.setBounds(541, 423, 148, 23);
		frame.getContentPane().add(chckbxSortingMethod);

		JCheckBox chckbxDifference = new JCheckBox("Time Difference");
		chckbxDifference.setBounds(541, 451, 133, 23);
		frame.getContentPane().add(chckbxDifference);

		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(716, 395, 70, 29);
		frame.getContentPane().add(btnPrint);

		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(716, 422, 70, 29);
		frame.getContentPane().add(btnHelp);

		/* ============ Center Panels for Graphs ==================*/

		JPanel panel = new JPanel();
		panel.setBounds(38, 102, 363, 236);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(425, 102, 363, 236);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		/* ============ Adding All Listeners Here =================*/

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//activates startSort with user selections for the two arrays(Waleed)
				SortingVisualizer.startSort((String) comboBox.getSelectedItem(), (String) comboBox_1.getSelectedItem());			
			}
		});

		//Activates stopSort from SortingVisualizer(Waleed)
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortingVisualizer.stopSort((String) comboBox.getSelectedItem(), (String) comboBox_1.getSelectedItem());
			}
		});

		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create the window. 
				JFrame frame = new JFrame("Help Menu");
				//Text in window
				JLabel textLabel = new JLabel("TEMP: Example information placed here" ,SwingConstants.CENTER);
				textLabel.setPreferredSize(new Dimension(500, 250));
				frame.getContentPane().add(textLabel, BorderLayout.CENTER);
				//Display the window 
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		});

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


}
