package TP;

import jade.gui.GuiEvent;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Label;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Font;

public class EXAM extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private List list = null;
	private Label label = null;
	public JRadioButton RadioButton1 = null;
	public JRadioButton RadioButton2 = null;
	public Button Button1 = null;
	public Button Button2 = null;
	
	AGENT_EXAM agentExam;
	public EXAM(AGENT_EXAM a) {
		super();
		agentExam = a;
		initialize();
		Button1.addActionListener(this);
		Button2.addActionListener(this);
	}

	private void initialize() {
		label = new Label();
		label.setBounds(new Rectangle(18, 37, 233, 23));
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setText("Choisi les votre réponse :");
		this.setLayout(null);
		this.setSize(481, 252);
		this.setTitle("EXAM :");
		this.add(getList(), null);
		this.add(label, null);
		this.add(getRadioButton1(), null);
		this.add(getRadioButton2(), null);
		this.add(getButton1(), null);
		this.add(getButton2(), null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getSource() == Button1) 
		{ 
			GuiEvent ge = new GuiEvent(this, agentExam.OK);
		    ge.addParameter("");
		    agentExam.postGuiEvent(ge);
		}
		if (ae.getSource() == Button2) 
		{ 
			GuiEvent ge = new GuiEvent(this, agentExam.FERMER);
		    ge.addParameter("");
		    agentExam.postGuiEvent(ge);
		}
	}

	private List getList() {
		if (list == null) {
			list = new List(8);
			list.add("Explicite Representation of the environnement");
			list.add("Great numbre of agent");
			list.add("Fonctioning stimulus/reaction ");
			list.add("Small number of agent ");
			list.add("no memory of its histiric");
			list.add("may consider  its past");
			list.add("Not explicite representation");
			list.add("Complexe Agent");
			list.setBounds(new Rectangle(18, 63, 297, 168));
			list.setMultipleMode(true);
			list.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					agentExam.REPENSE = "";
				 for(int i = 0;i<list.countItems();i++)
                  if(list.isSelected(i))
                	  agentExam.REPENSE = agentExam.REPENSE + list.getItem(i).toString();
				}
			});
			
		}
		return list;
	}

	private JRadioButton getRadioButton1() {
		if (RadioButton1 == null) {
			RadioButton1 = new JRadioButton();
			RadioButton1.setBounds(new Rectangle(323, 98, 126, 21));
			RadioButton1.setText("Agent Cognitif");
			RadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(RadioButton1.isSelected())
					 RadioButton2.setSelected(false);
				}
			});
		}
		return RadioButton1;
	}

	private JRadioButton getRadioButton2() {
		if (RadioButton2 == null) {
			RadioButton2 = new JRadioButton();
			RadioButton2.setBounds(new Rectangle(324, 66, 104, 24));
			RadioButton2.setText("Agent Reactif");
			RadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(RadioButton2.isSelected())
					 RadioButton1.setSelected(false);
				}
			});
		}
		return RadioButton2;
	}

	private Button getButton1() {
		if (Button1 == null) {
			Button1 = new Button();
			Button1.setBounds(new Rectangle(324, 132, 87, 29));
			Button1.setLabel("Valider");
		}
		return Button1;
	}

	private Button getButton2() {
		if (Button2 == null) {
			Button2 = new Button();
			Button2.setBounds(new Rectangle(327, 177, 88, 29));
			Button2.setLabel("Quitter");
		}
		return Button2;
	}

}  //  @jve:decl-index=0:visual-constraint="34,10"
