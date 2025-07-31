package QuizProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
 
    JButton rules, back;
    JTextField tfname;
    
    Login() {
        getContentPane().setBackground(new Color(30, 144, 254));
        setLayout(null);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login (1).jpeg"));
       Image img=i1.getImage();
       Image scaleimage=img.getScaledInstance(700,1100,Image.SCALE_SMOOTH);
       ImageIcon scaledicon=new ImageIcon(scaleimage);
       
       JLabel image = new JLabel(scaledicon);
     image.setBounds(0, 0, 700, 1100);
       // image.setBounds(100,500,i1.getIconWidth(),i1.getIconHeight());
        add(image);
        
        JLabel heading = new JLabel("Simple Minds..");
        heading.setBounds(960, 110, 300, 200);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
       // heading.setForeground(new Color(30, 144, 254));-->this show the simple mind name as sky blue color.
       heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel name = new JLabel("Enter your name");
        name.setBounds(1020, 150, 300, 250);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
       // name.setForeground(new Color(30, 144, 254));--->this is a skyblue color and i want to change/replace with black color in below line.
        name.setForeground(Color.black);    
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(950, 310, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        
        //i am adding validation on below line where i only accept alfabet not an digit on this textfiend.
        tfname.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyTyped(java.awt.event.KeyEvent e)
        	{
        		char c=e.getKeyChar();
        		if(!Character.isLetter(c)&&!Character.isWhitespace(c))
        		{
        			e.consume(); //when i click some non-character then that  time ignore this character 
        		
        			JOptionPane.showMessageDialog(null, "Only letter are allowed");
        		}
        	}
        });
        
        rules = new JButton("Rules");
        rules.setBounds(1110, 370, 120, 25);
        rules.setBackground(Color.yellow);
        rules.setForeground(Color.black);
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(980, 370, 120, 25);
        back.setBackground(Color.yellow);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);
        
        setSize(1600, 1400);
        setLocation(0, 30);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name Cannot be empty!");
                return;
            }
            
          /*  try {
                /*Conn c = new Conn();
                String query = "select * from scores where name=?";
                PreparedStatement ps = c.getConnection().prepareStatement(query);
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();

                
                if(rs.next()) {
                    JOptionPane.showMessageDialog(null, "This User Already Played Simple Minds quiz.\nPlease Login With another UserName");
                } else {
                    setVisible(false);
                    new Rules(name);
                }**/
            /*} catch(Exception e) {
                e.printStackTrace();
            }*/
            setVisible(false);
            new Rules(name);

        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    
    public static void main(String[] args) {
        new Login();
    }
}

