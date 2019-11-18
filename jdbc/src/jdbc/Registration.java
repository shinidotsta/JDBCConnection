package jdbc;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



import javax.swing.JButton;
import java.awt.ActiveEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Registration  extends JFrame 
{
	String name,Password,EmailID,user,PhoneNo;
	
	Registration()
	{
		
		JLabel l1=new JLabel("Name");
		l1.setBounds(50, 50, 100, 30);
		
		JTextField t1=new JTextField();
		 t1.setBounds(140, 50, 150, 20);
		
		JLabel l2=new JLabel("Password");
		l2.setBounds(50, 100, 100, 30);
		
		JTextField t2=new JTextField();
		 t2.setBounds(140, 100, 150, 20);
		
		JLabel l3=new JLabel("EmailID");
		l3.setBounds(50, 150, 100, 30);
		
		JTextField t3=new JTextField();
		 t3.setBounds(140, 150, 150, 20);
		
		JLabel l4=new JLabel("Phone No");
		l4.setBounds(50, 200, 100, 30);
		

		JTextField t4=new JTextField();
		 t4.setBounds(140, 200, 150, 20);
		 
		JLabel l5=new JLabel("User Name");
		l5.setBounds(50, 250, 150, 30);
		
		JTextField t5=new JTextField();
		 t5.setBounds(140, 250, 150, 20);
		
		
	    JButton btn=new JButton("Submit");
	    btn.setBounds(60, 350, 95, 30);
	    
	    JButton btnlgn=new JButton("Login");
	    btnlgn.setBounds(200, 350, 95, 30);
	    
	 
		
	    btnlgn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			Login lg=new Login();
				
			}
		});
	   
	   JLabel warning=new JLabel();
	   warning.setBounds(140, 400, 150, 30);
		 
	     add(l1);add(t1);add(l2);add(t2);
	     add(l3);add(t3);add(l4);add(t4);
	     add(l5);add(t5);
	     add(btn);add(btnlgn);
	     
	     
	      
	      btn.addActionListener(new ActionListener() {
	  		
	  		@Override
	  		public void actionPerformed(ActionEvent e)
	  		{
	  			
	  			 name=t1.getText();
	  		      Password=t2.getText();
	  		      EmailID=t3.getText();
	  		      PhoneNo=t4.getText();
	  		      user=t5.getText();
	  		      
	  			try {
	  				Class.forName("com.mysql.jdbc.Driver");
	  			  Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
	  			
	  			   Statement stn=con.createStatement(); ;
	  			  
	  			
	  		     stn.execute("insert into register values('"+name+"','"+Password+"','"+EmailID +"','"+user+"','"+PhoneNo+"')");
	  		     warning.setText("Registration Successful");
	  			}
	  		catch (SQLException|ClassNotFoundException e1) {
	  				// TODO Auto-generated catch block
	  				e1.printStackTrace();
	  			} 
	  			add(warning);
	  			t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");
	  
	  		}
	  		
	  	});
	      
	     add(warning);
	     
	     setSize(400,800);
	     setLayout(null);
	     setVisible(true);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	

}
