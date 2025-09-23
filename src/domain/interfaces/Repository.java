package domain.interfaces;
import  java.util.List;
import java.util.UUID;

public interface IRepository<T> {
    void Save(T Object);
    T FindById(UUID Id);
    List<T> FindAll();
    void Delete(UUID Id);
    

}
