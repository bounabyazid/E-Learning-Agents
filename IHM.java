package TP;

import jade.gui.GuiEvent;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IHM extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public JPasswordField PasswordField1 = null;
	public JTextField TextField1 = null;
	public JLabel Label1 = null;
	public JLabel Label2 = null;
	public JLabel Label3 = null;
	public Button Button1 = null;
	public Button Button2 = null;
	public JPasswordField PasswordField2 = null;
	public Button Button3 = null;
	public Button Button4 = null;

	AGENT_IHM agentIHM;
	public IHM(AGENT_IHM a)
	{
		super("IHM");
		this.agentIHM = a;
		initialize();
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		Button3.addActionListener(this);
		Button4.addActionListener(this);
	}

	public IHM(GraphicsConfiguration arg0) {
		super(arg0);
		initialize();
	}

	public IHM(String arg0) throws HeadlessException {
		super(arg0);
		initialize();
	}

	public IHM(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		initialize();
	}

	private void initialize() {
		Label3 = new JLabel();
		Label3.setBounds(new Rectangle(29, 114, 81, 16));
		Label3.setText("Confirmation");
		Label3.setVisible(true);
		Label2 = new JLabel();
		Label2.setBounds(new Rectangle(28, 81, 62, 16));
		Label2.setText("Password");
		Label1 = new JLabel();
		Label1.setBounds(new Rectangle(28, 48, 38, 16));
		Label1.setText("User:");
		this.setLayout(null);
		this.setSize(367, 205);
		this.setTitle("Agent Interface :");

		this.add(getPasswordField1(), null);
		this.add(getTextField1(), null);
		this.add(Label1, null);
		this.add(Label2, null);
		this.add(Label3, null);
		this.add(getButton1(), null);
		this.add(getButton2(), null);
		this.add(getPasswordField2(), null);
		this.add(getButton3(), null);
		this.add(getButton4(), null);
	}

	private JPasswordField getPasswordField1() {
		if (PasswordField1 == null) {
			PasswordField1 = new JPasswordField();
			PasswordField1.setBounds(new Rectangle(114, 79, 196, 20));
		}
		return PasswordField1;
	}

	private JTextField getTextField1() {
		if (TextField1 == null) {
			TextField1 = new JTextField();
			TextField1.setBounds(new Rectangle(115, 45, 195, 20));
		}
		return TextField1;
	}

	private Button getButton1() {
		if (Button1 == null) {
			Button1 = new Button();
			Button1.setBounds(new Rectangle(8, 155, 97, 26));
			Button1.setLabel("Inscription");
		}
		return Button1;
	}

	private Button getButton2() {
		if (Button2 == null) {
			Button2 = new Button();
			Button2.setBounds(new Rectangle(115, 156, 62, 26));
			Button2.setLabel("vider");
		}
		return Button2;
	}

	private JPasswordField getPasswordField2() {
		if (PasswordField2 == null) {
			PasswordField2 = new JPasswordField();
			PasswordField2.setBounds(new Rectangle(114, 110, 198, 20));
			PasswordField2.setVisible(true);
		}
		return PasswordField2;
	}

	private Button getButton3() {
		if (Button3 == null) {
			Button3 = new Button();
			Button3.setBounds(new Rectangle(187, 156, 106, 26));
			Button3.setLabel("Connection");
		}
		return Button3;
	}

	private Button getButton4() {
		if (Button4 == null) {
			Button4 = new Button();
			Button4.setBounds(new Rectangle(298, 156, 62, 26));
			Button4.setLabel("Exit");
		}
		return Button4;
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getSource() == Button1) 
		{ 
			GuiEvent ge = new GuiEvent(this, agentIHM.INSCRIPTION);
		    ge.addParameter("");
		    agentIHM.postGuiEvent(ge);
		}
		if (ae.getSource() == Button2) 
		{ 
			GuiEvent ge = new GuiEvent(this, agentIHM.VIDER);
		    ge.addParameter("");
		    agentIHM.postGuiEvent(ge);
		}
		if (ae.getSource() == Button3) 
		{ 
			GuiEvent ge = new GuiEvent(this, agentIHM.CONNECTION);
		    ge.addParameter("");
		    agentIHM.postGuiEvent(ge);
		}
		if (ae.getSource() == Button4) 
		{ 
			GuiEvent ge = new GuiEvent(this, agentIHM.FERMER);
		    ge.addParameter("");
		    agentIHM.postGuiEvent(ge);
		}
	}

} 