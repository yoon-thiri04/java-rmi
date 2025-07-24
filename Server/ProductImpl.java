import java.rmi.RemoteException;
// Implement the interface
public class ProductImpl implements Product{

    // Attr of Product
    public String name;
    public String description;
    public double price;

    // Contructor
    public ProductImpl(String newName, String newDesc, double newPrice) throws RemoteException{
        this.name = newName;
        this.description= newDesc;
        this.price = newPrice;
    }

    //Method implementation of Product
    public String getName() throws RemoteException{
        return this.name;
    }

    public String getDescription() throws RemoteException{
        return this.description;
    }

    public double getPrice() throws RemoteException{
        return this.price;
    }
}