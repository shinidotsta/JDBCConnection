package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame
{
	int count=0;
	
Login()
{
	
	JLabel l1=new JLabel("UserName");
	l1.setBounds(50, 50, 100, 30);
	
	JTextField t1=new JTextField();
	 t1.setBounds(140, 50, 150, 20);
	
	JLabel l2=new JLabel("Password");
	l2.setBounds(50, 100, 100, 30);
	
	JTextField t2=new JTextField();
	 t2.setBounds(140, 100, 150, 20);
	 
	 
	  JButton btn=new JButton("Login");
	    btn.setBounds(60, 350, 95, 30);
	    
	    JLabel suc=new JLabel();
	    suc.setBounds(50, 400, 100, 30);
	 
	    
	 add(l1);add(t1);add(l2);add(t2);add(btn);
	 
	 btn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			  Connection con;
			
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
			
			   Statement stn = null;
			
				stn = con.createStatement();
			
			  ResultSet rs = null;
			
				rs = stn.executeQuery("Select username,password from register");
				String uname=t1.getText();
				String pwd=t2.getText();
				
				t1.setText("");t2.setText("");
			
				while(rs.next())
				  {
					 
						if(rs.getString(1).equals(uname) && rs.getString(2).equals(pwd))
						  {
							 suc.setText("Login success");
							  count++;
							  break;
						  }
					
				  }
			
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  if(count==0)
					suc.setText("Invalid user");
		}
	});
	 add(suc);
	 setSize(400,800);
     setLayout(null);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
}
