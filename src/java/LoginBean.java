import com.tmw.Util.Util;
import com.tmw.login.entity.Login;
import com.tmw.registration.entity.User;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
 
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    public static final String USER_SESSION_KEY = "user";
    
     
    @PersistenceContext 
    private EntityManager em;
    
    /**
     * <p>The transaction resource.</p>
     */
    @Resource 
    private UserTransaction utx;
 
    private static final long serialVersionUID = 1L;
  
    private  String username;
    private  String password;
    private  String passwordv;
    private  String fname;
    private  String lname;
    private  Character gender;
    private  String emailaddress;

    public String getPasswordv() {
        return passwordv;
    }

    public void setPasswordv(String passwordv) {
        this.passwordv = passwordv;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
  
    public String validateUser() {   
        FacesContext context = FacesContext.getCurrentInstance();
        Login user = getUser();
        if (user != null) {
            if (!user.getPassword().equals(password)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                           "Login Failed!",
                                           "The password specified is not correct.");
                context.addMessage(null, message);
                return null;
            }
            
            context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
            return "index.xhtml?faces-redirect=true";
        } else {           
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login Failed!",
                    "Username '"
                    + username
                    +
                    "' does not exist.");
            context.addMessage(null, message);
            return null;
        }
    }
    
    
   
   public void clear(){
       setUsername("");
       setPassword("");
   }
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "/SignIn.xhtml?faces-redirect=true";
   }
    
     private Login getUser() {
        try {
            Login user = (Login)
            em.createNamedQuery("Login.findByUsername").
                    setParameter("username", username).getSingleResult();
            return user; 
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}