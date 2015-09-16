import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped


public class BackingBean implements Serializable{
 
 
    private String firstName;
    private String Start_Date;
    private String End_Date;
    private int est_time;
    
       private String email;
       
    private String Password;
    
    private String Username;

    /**
     * Get the value of Username
     *
     * @return the value of Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * Set the value of Username
     *
     * @param Username new value of Username
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }


    /**
     * Get the value of Password
     *
     * @return the value of Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Set the value of Password
     *
     * @param Password new value of Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }


    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Get the value of emain
     *
     * @return the value of emain
     */
   
    

    
    

    public int getEst_time() {
        return est_time;
    }

    public void setEst_time(int est_time) {
        this.est_time = est_time;
    }
    
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(String Start_Date) {
        this.Start_Date = Start_Date;
    }

    public String getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(String End_Date) {
        this.End_Date = End_Date;
    }
    
  
}

