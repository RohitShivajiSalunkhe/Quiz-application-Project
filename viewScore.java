package QuizProject;
import java.sql.*;
import java.sql.DriverManager;

public class viewScore {

	public static void main(String[] args) {
		
		try {
			//load jdbc.
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			//connect to database.
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_application", "root", "ROOT");
			
			//create statement.
			String Query="select * from scores";
			Statement stmt=con.createStatement();
			
			//execute Query.
			ResultSet rs=stmt.executeQuery(Query);
			
			//print data.
			System.out.println("ID\t\tName");
			System.out.println("-------------------------");
			
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				
				
				System.out.println(id+"\t\t"+name);
						
			}
			rs.close();
			stmt.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
;		}

	}

}
