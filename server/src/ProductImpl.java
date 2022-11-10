import java.rmi.RemoteException;

public class ProductImpl implements Product{
    public String name;
    public String desc;
    public double price;

    ProductImpl(String newName, String newDesc, double newPrice) throws RemoteException{
        this.name = newName;
        this.price = newPrice;
        this.desc = newDesc;
    }

    public String getName()throws RemoteException {
        return this.name;
    }
    public double getPrice()throws RemoteException {
        return this.price;
    }
    public String getDesc()throws RemoteException {
        return this.desc;
    }
}
