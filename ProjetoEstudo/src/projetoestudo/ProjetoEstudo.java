/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoestudo;

import java.io.*;
import java.net.*;
import javax.swing.*;
/**
 *
 * @author Lucas
 *//**
 *
 * @author Lucas
 */
public class ProjetoEstudo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        WebFile file = new WebFile( "http://getbootstrap.com/examples/carousel/" );

        URL u = new URL("http://getbootstrap.com/examples/carousel/");
        InputStream is = u.openStream();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
        String s;
        
        while ((s = dis.readLine()) != null) {
            System.out.println(s);
         }
        
    }
    
}
