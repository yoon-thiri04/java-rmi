import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server{

    public static void main(String[] args){
        try{

            // Set hostname for the serer using javaProperty.
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            System.out.println("Server started...");
            // Create some product objects.
            ProductImpl P1 =new ProductImpl("Laptop","lenovo laptop",1240.5);
            ProductImpl P2 =new ProductImpl("Mobile","Mi mobile",240.1);
            ProductImpl P3 =new ProductImpl("TV","Samsung TV",3400.0);
            ProductImpl P4 =new ProductImpl("Laptop","HP laptop",1240.5);


            //Export the products objects using UnicastRemoteObject class
            // as stub to use in client - > 0 indicates Port number
            Product stub1= (Product)UnicastRemoteObject.exportObject(P1,0);
            Product stub2= (Product)UnicastRemoteObject.exportObject(P2,0);
            Product stub3= (Product)UnicastRemoteObject.exportObject(P3,0);
            Product stub4= (Product)UnicastRemoteObject.exportObject(P4,0);


            // Register the exported class in RMI registry with some name,
            // Client will use that name to get the reference of those exported object.
            // Get the registry to register the objetc.

            Registry registry = LocateRegistry.createRegistry(9100);
            // l for laptop Client will be used this name.
            registry.rebind("l",stub1);
            registry.rebind("m",stub2);
            registry.rebind("t",stub3);
            registry.rebind("h",stub4);   

            System.out.println("Exproting and binding of objects has been completed..");

        }catch(Exception e){
            System.out.println("Some server error..."+e);
        }
    }
}