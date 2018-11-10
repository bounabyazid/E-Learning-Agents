package TP;

import jade.gui.GuiEvent;

import java.awt.Frame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;

public class COURS extends Frame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	AGENT_COURS agentCOURS;
	private Button Button1 = null;
	private Button Button2 = null;

	public COURS(AGENT_COURS a) {
		
		super();
		agentCOURS = a;
		initialize();
		Button1.addActionListener(this);
		Button2.addActionListener(this);

	}

	private void initialize() {
		
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(18, 46, 631, 340));
		jLabel.setIcon(new ImageIcon(getClass().getResource("/TP/Cours_AGENT.jpg")));
		jLabel.setText("");
		this.setLayout(null);
		this.setSize(667, 445);
		this.setTitle("AGENT COURS :");
		this.add(jLabel, null);
		this.add(getButton1(), null);
		this.add(getButton2(), null);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getSource() == Button1) 
		{ 
			GuiEvent ge = new GuiEvent(this, agentCOURS.TEST);
		    ge.addParameter("");
		    agentCOURS.postGuiEvent(ge);
		}
		if (ae.getSource() == Button2) 
		{ 
			GuiEvent ge = new GuiEvent(this, agentCOURS.FERMER);
		    ge.addParameter("");
		    agentCOURS.postGuiEvent(ge);
		}
	}

	private Button getButton1() {
		if (Button1 == null) {
			Button1 = new Button();
			Button1.setBounds(new Rectangle(20, 404, 107, 23));
			Button1.setLabel("Test");
		}
		return Button1;
	}

	private Button getButton2() {
		if (Button2 == null) {
			Button2 = new Button();
			Button2.setBounds(new Rectangle(537, 404, 108, 23));
			Button2.setLabel("Quitter");
		}
		return Button2;
	}
}