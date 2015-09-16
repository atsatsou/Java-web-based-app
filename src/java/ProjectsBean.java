import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
 
import javax.annotation.Resource;
import javax.faces.bean.SessionScoped;

import javax.sql.DataSource;
import com.projects.model.Projects;

@SessionScoped
@ManagedBean("projects")
public class ProjectsBean implements Serializable{
 
	//resource injection
	@Resource(name="jdbc/TMWdb")
	private DataSource ds;
 
	//if resource injection is not support, you still can get it manually.
	/*public CustomerBean(){
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mkyongdb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
 
	}*/
 
	//Σύνδεση στη Βάση και ανάκτηση της Λίστας με τα Έργα
	public List<Projects> getProjectsList() throws SQLException{
 		if(ds==null)
			throw new SQLException("Can't get data source");
 		//get database connection
		Connection con = ds.getConnection();
 		if(con==null)
			throw new SQLException("Can't get database connection");
 
		PreparedStatement ps 
			= con.prepareStatement(
			   
                                "select * from \"public\".\"Projects\""); 
 
		//get customer data from database
		ResultSet result =  ps.executeQuery();
 
		ArrayList<Projects> list = new ArrayList<Projects>();
 
		while(result.next()){
                    //Δημιουργία αντικειμένου για ανάκτηση πεδίων
			Projects projects = new Projects();
 
                        projects.setId(result.getInt("\"Id\""));
			projects.setName(result.getString("\"Name\""));
			projects.setType(result.getString("\"Type\""));
			projects.setStatus(result.getString("\"Status\""));
                        projects.setStart_Date(result.getDate("\"Start_Date\""));
                        projects.setStart_Date(result.getDate("\"End_Date\""));
 
			//Αποθήκευση των Δεδομένων στη Λίστα
			list.add(projects);
		}
 
		return list;
	}
}
    

