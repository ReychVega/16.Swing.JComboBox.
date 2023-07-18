package Domain;

import javax.swing.JOptionPane;

/**
 *
 * @author Reych
 */
public class PersonRegistration {
    public Person persona;
    
    public PersonRegistration() {
       persona=null; 
    }
        
    public Person insertPersona(String id, String name, String lastName, String phone, String civilState) {
      
       try{ 
             if (id!=null & name!=null & lastName!=null & phone!=null & civilState!=null
                   & !id.isEmpty() & !name.isEmpty() & !lastName.isEmpty() & !phone.isEmpty() & !civilState.isEmpty()) {
            persona=new Person(id, name, lastName,phone,civilState);
           }
        }catch(Exception e){
            return null;
        }
      return persona;
    }

    public Person getPersona() {
        return persona;
    }

    public void setPersona(Person persona) {
        this.persona = persona;
    }
      
     public void mostrar() {        
        if (this.persona != null) {
            JOptionPane.showMessageDialog(null, this.persona.toString());
        }
    } 
    
}
