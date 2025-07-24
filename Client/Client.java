package rmi.Client;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client{
    public static void main(String[] args){
        try{
            
            // Locate the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",9100);

            // Get the reference of exported object from RMI Registry.
            Product laptop = (Product) registry.lookup("l");
            Product mobile = (Product) registry.lookup("m");
            Product tv = (Product) registry.lookup("t");
            Product hp = (Product) registry.lookup("h");


            // Invoke the method of the referenced objects.
            System.out.println("The name of the laptop is "+laptop.getName());
            System.out.println("The description is "+laptop.getDescription());
            System.out.println("The price is "+laptop.getPrice());

            System.out.println(mobile.getName());
            System.out.println(tv.getName());
            System.out.println(hp.getName());

        }catch(Exception e){
            System.out.println("Client side error..."+e);
        }
    }
}