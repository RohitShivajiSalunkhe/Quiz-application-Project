package QuizProject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(new Color(30, 144, 254));
        setLayout(null);
        
      /*   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("score (1).png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
     add(image);*/
        
       ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Score2.png"));
       Image i5=i4.getImage().getScaledInstance(400,210,Image.SCALE_DEFAULT);
       ImageIcon i6=new ImageIcon(i5);
       JLabel image1=new JLabel(i6);
       image1.setBounds(170,100,400,210);
      add(image1);
        
      
       
        JLabel heading = new JLabel("THANK YOU " + name + " FOR PLAYING SIMPLE MINDS");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);
        
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(290, 330, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);
        //save name and score in the database code is start here........
    //    try {
        //	Conn c=new Conn();
        //	String query="INSERT INTO scores(name,score) values(' "+name+"','"+score+"')";
         //    c.s.executeUpdate(query);	
       //      c.c.close();
      //  }
      //  catch(Exception e)
     //   {
        	//e.printStackTrace();
       // }
        try {
            Conn c = new Conn();
            String query = "INSERT INTO scores(name, score) VALUES (?, ?)";
            PreparedStatement ps = c.getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, score);
            ps.executeUpdate();
            c.getConnection().close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        	
        	
        	
        	
        	
        	//save data in the database is end here code will stop here.....
        
        
        
        
        
        
        
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(315, 384, 120, 30);
        submit.setBackground(Color.yellow);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
