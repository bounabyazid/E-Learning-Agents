package TP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.gui.ConstraintDlg;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.wrapper.PlatformController;

public class AGENT_EXAM extends GuiAgent
{
	 public String REPENSE ="";
	 private int command;
	 //-----------------LISTE DES COMMANDS----------------
	 
	 public static final int FERMER = 0;
	 public static final int OK = 1;
		 
	 //----------DECLARATION D'UN AGENT INTERFACE--------
	 
	 transient protected EXAM myGui;
	
    public void setup() 
    { 
    	 myGui = new EXAM(this);
    	 myGui.setVisible(true);

        addBehaviour(new COMPORTEMENT()); 
    } 
    class COMPORTEMENT extends CyclicBehaviour 
    {
        public void action() 
        {
         	ACLMessage msg= receive();
            if (msg!=null)
            {
             if (msg.getLanguage().equalsIgnoreCase("RESULTAT"))
             {
              JOptionPane.showMessageDialog(null, msg.getContent()); 
             }
            }
        } 
    }     
        private void SendMessage(String S, String L, String A)
        {
           ACLMessage aclMessage2 = new ACLMessage(ACLMessage.INFORM);
           aclMessage2.setContent(S);
           aclMessage2.setLanguage(L);
           aclMessage2.addReceiver(new AID(A,AID.ISLOCALNAME));
           send(aclMessage2);
        }
       
    @Override
	protected void onGuiEvent(GuiEvent ev)
	{
		 command = ev.getType();
		   switch (command) 
		   {
		    case OK: 
		    	try 
			      {
		    	   if(myGui.RadioButton1.isSelected())
				    SendMessage(REPENSE, "Agent Cognitif", "COURS");
		    	   if(myGui.RadioButton2.isSelected())
					SendMessage(REPENSE, "Agent Reactif", "COURS");
				  }
				  catch (Exception e) 
				  {
				    e.printStackTrace();
				  }
				  return;
		    case FERMER: 
		    	try 
			      {
		    	   SendMessage("FERMER", "FERMER", "ADMIN");
			      }
				  catch (Exception e) 
				  {
				    e.printStackTrace();
				  }
				  return;
	      } 
	}
} 
