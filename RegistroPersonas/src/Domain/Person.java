package Domain;

import java.io.Serializable;

/**
 *
 * @author Grupo 5
 */
public class Person implements DataControl, Serializable {
    private String id,
            name,
            lastName,
            phone,
            civilState;
    private static final long serialVersionUID=1L;

    public Person() {
    }

    public Person(String id, String name, String lastName, String phone, String civilState) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.civilState = civilState;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCivilState() {
        return civilState;
    }

    public void setCivilState(String civilState) {
        this.civilState = civilState;
    }

    @Override
    public String toString() {
        return "ID:" + id + ". Name:" + name + " " + lastName;
    }

    @Override
    public String completeData() {
        return id+"."+name+lastName+phone+civilState;
    }

    @Override
    public String returnData(String type) {
        switch (type){
            //case 1. Id
            case "1":
               return  this.id;
             //case 2. Id
            case "2":
               return  this.name+ " " +this.lastName ;
             //case 2. Id
            case "3":
               return  this.phone;
            case "4":
               return  this.civilState;      
        }
        return null;
    }
        
    
}
