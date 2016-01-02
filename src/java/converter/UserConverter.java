



package converter;

import com.TMWProject.Entity.Assignments;
import java.lang.annotation.Annotation;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import javax.persistence.Converter;

/**
 *
 * @author Μάχη
 */
@FacesConverter(value = "userConverter", forClass=Assignments.class)
public class UserConverter implements Converter{

        @Override
        public boolean autoApply() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
   String getStringKey(java.lang.Object value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }
    
   
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Assignments) {
            Assignments o = (Assignments) object;
            return getStringKey(o.getUsername());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Assignments.class.getName());
        }
    }
}
