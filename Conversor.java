import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;

public class Conversor extends JFrame {
	
	private boolean magicoAMuggle = true;
	private static final Double TASA = 0.29;
	private static final Double PIB = 0.25;

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		setTitle("Calculadora banco");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Cantidad a convertir: ");
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Resultado: ");
		panel_2.add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("0");
		textPane.setEditable(false);
		panel_2.add(textPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Mágico a muggle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(magicoAMuggle) 
					btnNewButton.setText("Muggle a maǵico");
				else
					btnNewButton.setText("Mágico a muggle");
				magicoAMuggle = !magicoAMuggle;
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cambiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double valor = Double.parseDouble(textField.getText());
					Double resultado = 0.0;
					if(magicoAMuggle) resultado = (valor/TASA)*PIB;
					else resultado = (valor/PIB) * TASA;
					BigDecimal bd = new BigDecimal(resultado).setScale(2, RoundingMode.HALF_UP);
					textPane.setText(bd.toString());
				}
				catch (Exception NumberFormatException) {
					JOptionPane.showMessageDialog(null, "El texto debe de ser un número", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textField.setText("");
			}
		});
		panel.add(btnBorrar);
	}

}
