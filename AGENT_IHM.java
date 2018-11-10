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

public class AGENT_IHM extends GuiAgent
{
	 private int command;
	 //-----------------LISTE DES COMMANDS----------------
	 
	 public static final int FERMER = 0;
	 public static final int INSCRIPTION = 1;
	 public static final int VIDER = 2;
	 public static final int CONNECTION = 3;
	
	 
	 //----------DECLARATION D'UN AGENT INTERFACE--------
	 
	 transient protected IHM myGui;
	
    public void setup() 
    { 
    	 myGui = new IHM(this);
    	 myGui.setVisible(true);

         try
         {
          PlatformController container = getContainerController();
    	  container.createNewAgent("ADMIN", "TP.AGENT_ADMIN", null).start();  
         }
         catch (Exception e) {e.printStackTrace();}
        addBehaviour(new COMPORTEMENT()); 
    } 
    class COMPORTEMENT extends CyclicBehaviour 
    {
        public void action() 
        {
         	ACLMessage msg= receive();
            if (msg!=null)
            {
             if (msg.getContent().equalsIgnoreCase("MASQUER"))
             {
              myGui.setVisible(false); 
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
		    case INSCRIPTION: 
		    	try 
			      {
		    	   
				   SendMessage("INSCRIPTION", "INTERFACE", "ADMIN");
				  }
				  catch (Exception e) 
				  {
				    e.printStackTrace();
				  }
				  return;
		    case VIDER: 
		    	try 
			      {
				   myGui.TextField1.setText("");
		    	   myGui.PasswordField1.setText("");
		    	   myGui.PasswordField2.setText("");
				  }
				  catch (Exception e) 
				  {
				    e.printStackTrace();
				  }
				  return;
		    case CONNECTION: 
		    	try 
			      {
		    		SendMessage("nom = '"+myGui.TextField1.getText()+"' and motdepass = '"+myGui.PasswordField1.getText()+"';","CONNECTION", "ADMIN");
				  }
				  catch (Exception e) 
				  {
				    e.printStackTrace();
				  }
				  return;
		    case FERMER: 	  
		    	try 
			      {
				    System.exit(0);
				  }
				  catch (Exception e) 
				  {
				    e.printStackTrace();
				  }
				  return;
	      } 
	}
} 
