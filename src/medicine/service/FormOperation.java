package medicine.service;

import java.util.List;

public interface FormOperation <T> {

    public boolean save(T data);

    public boolean update(T data);

    public boolean delete(T data);

    public T find(String id);

    public List<T> display();

}
