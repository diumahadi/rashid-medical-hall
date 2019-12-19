package medicine.service;

import java.util.List;

public interface BaseDao<T> {

    public T save(T data);

    public T update(T data);

    public boolean delete(T data);

    public T find(String id);

    public List<T> display();
}
