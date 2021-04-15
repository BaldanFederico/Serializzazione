/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializzazione;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baldan.federico
 */
public class Serializzazione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Studente st= new Studente("Federico","Baldan",4);
    
        try {
        FileOutputStream fo= new FileOutputStream("Test.ser");
        ObjectOutputStream os= new ObjectOutputStream(fo);
        os.writeObject(9);
        os.writeObject("Hola");
        os.writeFloat((float) 0.434);
//        os.writeObject(true);
//        os.writeObject("a");
        os.flush();
        os.close();
        fo.close();
         FileInputStream fi= new FileInputStream("Test.ser");
         ObjectInputStream oi = new ObjectInputStream(fi);
         int v1= (int)oi.readObject();
         System.out.println("v1 : "+v1);
         String v2= (String)oi.readObject();
         System.out.println("v2 : "+v2);
         float v3= (float)oi.readObject();
         System.out.println("v3 : "+v3);
        } catch (FileNotFoundException ex) {
            System.out.println("Impossibile trovare il file");
        }
        catch (IOException ex) {
            System.out.println("Non va nulla");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializzazione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
 