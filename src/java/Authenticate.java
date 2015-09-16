
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Μάχη
 */


  public class Authenticate implements PhaseListener {
    
    /**
     * <p>The outcome to trigger navigation to the login page.</p>
     */
    private static final String USER_LOGIN_OUTCOME = "SignIn";
       
    // ---------------------------------------------- Methods from PhaseListener

    /**
     * <p>Determines if the user is authenticated.  If not, direct the
     * user to the login view, otherwise all the user to continue to the
     * requested view.</p>
     *
     * <p>Implementation Note: We do this in the <code>afterPhase</code>
     * to make use of the <code>NavigationHandler</code>.</p>
     */
    public void afterPhase(PhaseEvent event) {
        
    }

    /**
     * <p>This is a no-op.</p>
     */
    public void beforePhase(PhaseEvent event) {        
    }

    /**
     * @return <code>PhaseId.RESTORE_VIEW</code>
     */
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
    // --------------------------------------------------------- Private Methods       
    
    /**
     * <p>Determine if the user has been authenticated by checking the session
     * for an existing <code>Wuser</code> object.</p>
     * 
     * @param context the <code>FacesContext</code> for the current request
     * @return <code>true</code> if the user has been authenticated, otherwise
     *  <code>false</code>
     */
    private boolean userExists(FacesContext context) {
        ExternalContext extContext = context.getExternalContext();
        return (extContext.getSessionMap().containsKey(LoginBean.USER_SESSION_KEY));
    }
    
    /**
     * <p>Determines if the requested view is one of the login pages which will
     * allow the user to access them without being authenticated.</p>
     *
     * <p>Note, this implementation most likely will not work if the 
     * <code>FacesServlet</code> is suffix mapped.</p>
     *
     * @param context the <code>FacesContext</code> for the current request
     * @return <code>true</code> if the requested view is allowed to be accessed
     *  without being authenticated, otherwise <code>false</code>
     */
    private boolean requestingSecureView(FacesContext context) {
        ExternalContext extContext = context.getExternalContext();       
        String path = extContext.getRequestPathInfo();
        return (!"SignIn.xhtml".equals(path) && !"registeruser.xhtml".equals(path));              
    }
}
