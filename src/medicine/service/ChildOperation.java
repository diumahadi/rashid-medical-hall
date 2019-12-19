package medicine.service;

import java.sql.Connection;
import java.util.List;

public interface ChildOperation<D,M> {
    
    public D save(D details,M master,Connection conn);

    public D update(D details,M master,Connection conn);

    public boolean deleteSingleRecord(D details,Connection conn);
    
    public boolean deleteChildRecords(M master,Connection conn);

    public D findSingleResult (String id);

    public List<D> childUnderParent (M master);
    
    public List<D> display();
}
