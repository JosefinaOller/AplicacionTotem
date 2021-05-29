package vistaTotem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VistaTotem extends JFrame implements KeyListener {

	private JPanel contentPane;
	public JTextField textDocumento;
	private JButton aceptar;
	private ActionListener actionlistener;

	

	/**
	 * Create the frame.
	 */
	public VistaTotem() {
		setBackground(new Color(224, 255, 255));
		setTitle("T\u00D3TEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel Welcomepanel_1 = new JPanel();
		Welcomepanel_1.setBackground(Color.CYAN);
		Welcomepanel_1.setForeground(new Color(224, 255, 255));
		panel.add(Welcomepanel_1);
		Welcomepanel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextArea txtrbienvenido = new JTextArea();
		txtrbienvenido.setBackground(Color.CYAN);
		txtrbienvenido.setEditable(false);
		txtrbienvenido.setForeground(Color.BLACK);
		txtrbienvenido.setFont(new Font("Monospaced", Font.PLAIN, 40));
		txtrbienvenido.setText("\u00A1Bienvenido!");

		
		Welcomepanel_1.add(txtrbienvenido);
			
		JPanel Ingresopanel_2 = new JPanel();
		panel.add(Ingresopanel_2);
		Ingresopanel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		Panel panel_5 = new Panel();
		panel_5.setBackground(Color.CYAN);
		Ingresopanel_2.add(panel_5);
		
		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(224, 255, 255));
		Ingresopanel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.CYAN);
		panel_6.add(panel_7);
		
		
		JTextArea txtrIngreseSuDocumento = new JTextArea();
		txtrIngreseSuDocumento.setEditable(false);
		txtrIngreseSuDocumento.setBackground(Color.CYAN);
		txtrIngreseSuDocumento.setForeground(Color.BLACK);
		panel_7.add(txtrIngreseSuDocumento);
		txtrIngreseSuDocumento.setFont(new Font("Monospaced", Font.PLAIN, 35));
		txtrIngreseSuDocumento.setText("Ingrese su Documento");

		JPanel IngresoDatospanel_3 = new JPanel();
		IngresoDatospanel_3.setBackground(Color.CYAN);
		panel.add(IngresoDatospanel_3);
		
		textDocumento = new JTextField();
		textDocumento.setBackground(Color.WHITE);
		textDocumento.setFont(new Font("Tahoma", Font.PLAIN, 32));
		IngresoDatospanel_3.add(textDocumento);
		textDocumento.setColumns(10);
		
		JPanel Aceptarpanel_4 = new JPanel();
		Aceptarpanel_4.setBackground(Color.CYAN);
		panel.add(Aceptarpanel_4);
		
		
		aceptar=new JButton("ACEPTAR");

		aceptar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Aceptarpanel_4.add(aceptar);
		this.aceptar.setActionCommand("Aceptar");

		this.textDocumento.addKeyListener(this);
		
		textDocumento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
				}
			}
		});
		this.setVisible(true);
		this.setMaximumSize(this.getSize());
	}
	public void setActionlistener(ActionListener actionlistener) {
		this.aceptar.addActionListener(actionlistener);
		this.actionlistener = actionlistener;
	}
	
	public void keyReleased(KeyEvent arg0) {
		String documento= this.textDocumento.getText();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void limpiarDNI() {
		this.textDocumento.setText(""); 
		
	}

	

}
