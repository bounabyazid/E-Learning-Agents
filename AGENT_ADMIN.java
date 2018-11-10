package TP;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.PlatformController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AGENT_ADMIN extends Agent {

	 public void setup() {addBehaviour(new COMPORTEMENT());} 
	  
     private void SendMessage(String S, String L, String A)
     {
        ACLMessage aclMessage2 = new ACLMessage(ACLMessage.INFORM);
        aclMessage2.setContent(S);
        aclMessage2.setLanguage(L);
        aclMessage2.addReceiver(new AID(A,AID.ISLOCALNAME));
        send(aclMessage2);
     }
	  class COMPORTEMENT extends CyclicBehaviour 
	  {
	    public void action() 
	    {
	        ACLMessage message =null ;
	        ACLMessage msg= receive();
	        if (msg!=null)
	        {
	         if(msg.getLanguage().equalsIgnoreCase("CONNECTION"))	
	    	  SendMessage("MASQUER", "MASQUER", "IHM");
		      try
		         {
		          PlatformController container = getContainerController();
		    	  container.createNewAgent("COURS", "TP.AGENT_COURS", null).start();  
		         }
		         catch (Exception e) {e.printStackTrace();}
	    	
	         if(msg.getContent().equalsIgnoreCase("INSCRIPTION"))
	         {
	          JOptionPane.showMessageDialog(null, "INSCRIPTION"); 	 
	         }
	         if(msg.getContent().equalsIgnoreCase("FERMER"))
	         {
	          System.exit(0); 	 
	         }
	         if(msg.getContent().equalsIgnoreCase("CREATION EXAM"))
	         {
	        	 try
		         {
		          PlatformController container = getContainerController();
		    	  container.createNewAgent("TEST", "TP.AGENT_EXAM", null).start();  
		         }
		         catch (Exception e) {e.printStackTrace();}
	         }
	     }
	  }
    }
}
	
