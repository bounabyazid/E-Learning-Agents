package TP;

import java.io.File;
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

public class AGENT_COURS extends GuiAgent
{
	 private int command;
	 //-----------------LISTE DES COMMANDS----------------
	 
	 public static final int FERMER = 0;
	 public static final int TEST = 1;
		 
	 //----------DECLARATION D'UN AGENT INTERFACE--------
	 
	 transient protected COURS myGui;
	
    public void setup() 
    { 
    	 myGui = new COURS(this);
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
             String S = msg.getContent();
             int BR = 0,MR = 0;
             if (msg.getLanguage().equals("Agent Cognitif"))
             {
            	
            	if(S.contains("Explicite Representation of the environnement"))
            	 BR++;
            	if(S.contains("may consider  its past"))
             	 BR++;
            	if(S.contains("Complexe Agent"))
            	 BR++;
            	if(S.contains("Small number of agent "))
            	 BR++;
            	
            	if(S.contains("Not explicite representation"))
     			 MR++;
            	if(S.contains("no memory of its histiric"))
            	 MR++;
            	if(S.contains("Fonctioning stimulus/reaction "))
             	 MR++;
            	if(S.contains("Great numbre of agent"))
             	 MR++;
             }
             if (msg.getLanguage().equals("Agent Reactif"))
             {
             	if(S.contains("Explicite Representation of the environnement"))
             	 MR++;
            	if(S.contains("may consider  its past"))
            	 MR++;
            	if(S.contains("Complexe Agent"))
             	 MR++;
            	if(S.contains("Small number of agent "))
            	 MR++;
            	
            	if(S.contains("Not explicite representation"))
             	 BR++;
            	if(S.contains("no memory of its histiric"))
            	 BR++;
            	if(S.contains("Fonctioning stimulus/reaction "))
            	 BR++;
            	if(S.contains("Great numbre of agent"))
             	 BR++;
             }
         	 SendMessage("BONNE REPENSE = "+BR+" MOVAISE REPENSE = "+MR, "RESULTAT", "EXAM");
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
		    case TEST: 
		    	try 
			      {
				   SendMessage("CREATION EXAM", "EXAM", "ADMIN");
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
