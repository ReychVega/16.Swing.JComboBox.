package Domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reych
 */
public class FileManagement {

    private ArrayList<Person> people;
    private File file;
    private String fileName;
    public static FileManagement SingletonFileManagement;

    private FileManagement() {
        people = new ArrayList<>();
        fileName = "people.dat";
        file = new File(fileName);
    }

    public static FileManagement getInstance() {
        if (SingletonFileManagement == null) {
            SingletonFileManagement = new FileManagement();
        }
        return SingletonFileManagement;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    //métodos
    public void savePerson(Person person) throws FileNotFoundException, IOException, ClassNotFoundException {

        // System.out.println(element.toString());
        if (file.exists()) {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream((file)));
            Object aux = input.readObject();
            this.people = ((ArrayList<Person>) (List<Person>) aux);
            input.close();
        }

        this.people.add(person);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream((this.fileName)));
        output.writeUnshared(this.people);
        output.close();
    }

    public boolean verifyExistence(String dni) {
        if (file.exists()) {
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream((file)));
                Object aux = input.readObject();
                this.people = ((ArrayList<Person>) (List<Person>) aux);
                input.close();
            } catch (IOException | ClassNotFoundException ex) {
                return false;
            }
        }

        if (!this.people.isEmpty()) {
            for (int i = 0; i < this.people.size(); i++) {
                if (this.people.get(i).getId().equalsIgnoreCase(dni)) {
                    return true;
                }
            }
        }

        return false;
    }

    //actualiza lista en caso de datos nuevos
    public void actualizaLista() {
        if (file.exists()) {
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream((file)));
                Object aux = input.readObject();
                this.people = ((ArrayList<Person>) (List<Person>) aux);
                input.close();
            } catch (IOException | ClassNotFoundException ex) {
            }
        }

    }

    //desplega lista
    public String archivoCompleto() throws IOException, FileNotFoundException, ClassNotFoundException {
        String s = "";
        for (int i = 0; i < this.people.size(); i++) {
            s += this.people.get(i).toString() + "\n";
        }
        return s;
    }

}
