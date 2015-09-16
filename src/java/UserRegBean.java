import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.lang.Object;
import javax.faces.component.UIInput;
import javax.faces.validator.ValidatorException;
import javax.faces.validator.FacesValidator;
import com.tmw.registration.entity.User;


@ManagedBean(name="userreg")
@SessionScoped


public class UserRegBean {

    private String username;
    private String password;
    private String confirmpassword;

    private String FirstName;
    private String LastName;

  
    private String gender;

    private String email;
   private String confirmEmail;

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }
   
   
   
   
   
   

    /**
     * Get the value of email
     *
     * @return the value of email
     */
   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
    /**
     * Get the value of FirstName
     *
     * @return the value of FirstName
     */
    
    
    public String getConfirmpassword() {
        return confirmpassword;
    }

    /**
     * Set the value of confirmpassword
     *
     * @param confirmpassword new value of confirmpassword
     */
    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getFirstName() {
        return FirstName;
    }

    /**
     * Set the value of FirstName
     *
     * @param FirstName new value of FirstName
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * Get the value of LastName
     *
     * @return the value of LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * Set the value of LastName
     *
     * @param LastName new value of LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * Get the value of confirmpassword
     *
     * @return the value of confirmpassword
     */
    
    /**
     * Get the value of Language
     *
     * @return the value of Language
   

    /**
     * Get the value of gender
     *
     * @return the value of gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set the value of gender
     *
     * @param gender new value of gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get the value of Country
     *
     * @return the value of Country
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
    
    private void addmessage(FacesMessage message){
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public String confirmuser(){
        addmessage(new FacesMessage(FacesMessage.SEVERITY_INFO," User Registation Successfull", null));
        return "success";
    }
    
String result = null;
/*User newUser = (User) getRequestMap().get("user");
// set the password into the user, because we know the
// validator was successful if we reached here.
newUser.setPassword((String) getRequestMap().get("password1"));
try {
UserRegistry.getCurrentInstance().addUser(newUser);
// Put the current user in the session
setCurrentUser(newUser);
// redirect to the main page
result = "/user/allEvents?faces-redirect=true";
} catch (EntityAccessorException ex) {
getFacesContext().addMessage(null,
new FacesMessage("Error when adding user" +
((null != newUser) ? " " + newUser.toString() : "") +
"."));
}
return result;*/
}

		

    

    
    
    
    
    
    



  