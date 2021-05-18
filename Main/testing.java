package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;

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

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

public class testing {

	JFrame frame;
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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

		JButton btnPause = new JButton("Pause");
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

		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(4);
		comboBox.setToolTipText("Select from list to choose first sorting method.");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bubble", "Insertion", "Merge", "Selection"}));
		comboBox.setBounds(225, 71, 110, 27);
		frame.getContentPane().add(comboBox);

		JLabel lblSortMethod_1 = new JLabel("Sort Method 2");
		lblSortMethod_1.setBounds(425, 72, 100, 20);
		frame.getContentPane().add(lblSortMethod_1);

		@SuppressWarnings("rawtypes")
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
		lblTime.setToolTipText("Time took to sort using Method 1.");
		lblTime.setBounds(194, 400, 61, 16);
		frame.getContentPane().add(lblTime);

		JLabel lblTime_1 = new JLabel("Time 2");
		lblTime_1.setToolTipText("Time took to sort using Method 1");
		lblTime_1.setBounds(194, 427, 61, 16);
		frame.getContentPane().add(lblTime_1);

		JLabel lblTimeDifference = new JLabel("Time Difference");
		lblTimeDifference.setToolTipText("Difference between Time 1 and 2.");
		lblTimeDifference.setBounds(194, 455, 110, 16);
		frame.getContentPane().add(lblTimeDifference);

		/* ============ Print Options ================*/

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
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0};
		//gbl_panel.columnWidths = new int[]{0};
		//gbl_panel.rowHeights = new int[]{0};
		//gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		panel.setLayout(gbl_panel);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(425, 102, 363, 236);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);

		/* ============ Adding All Listeners Here =================*/
		
}
}
