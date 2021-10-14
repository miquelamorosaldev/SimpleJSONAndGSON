package com.mycompany.simplejsonandgson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author xcheko51x
 */
public class MainSimpleJSON {

    public static void main(String[] args) {
        
        JSONParser parser = new JSONParser();
        
        try {
            
            Object obj = parser.parse(
                    new FileReader("usuarios.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + jsonObject);
            
            JSONArray array = (JSONArray) jsonObject.get("Usuarios");
            System.out.println("");
            
            for(int i = 0 ; i < array.size() ; i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                
                System.out.println("DATOS DEL USUARIO: " + i);
                System.out.println("ID: " + jsonObject1.get("id"));
                System.out.println("Nombre: " + jsonObject1.get("nombre"));
                System.out.println("Telefono: " + jsonObject1.get("telefono"));
                System.out.println("Email: " + jsonObject1.get("email"));
                
                System.out.println("");
            }
            
        } 
        catch(FileNotFoundException e) { 
            System.out.println("Error al leer el fichero: "+e.getMessage());
        }
        catch(IOException e) { 
            System.out.println("Error IOException: "+e.getMessage());
        }
        catch(ParseException e) { 
            System.out.println("Error al convertir el contenido del fichero JSON. "+e.getMessage());
        }
    }
    
}