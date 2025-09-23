package domain.interfaces;
import java.sql.Connection;
import  java.util.List;
import java.util.UUID;
import domain.repository.dataBaseConnection;

public abstract class  Repository<T> {
    protected String Delect = "SELECT * FROM";
    protected String Delete= "DELETE FROM";
    protected String Update= "UPDATE ";
    protected String Insert= "INSERT INTO ";
    protected final Connection Instance = dataBaseConnection.getInstence();

    public abstract void Save(T Object)throws Exception ;
    public abstract T FindById(UUID Id);
    public abstract List<T> FindAll();
    public abstract void Delete(UUID Id);
}
