
package medicine.service;

import medicine.dao.*;
import medicine.model.*;

public class Test {
    public static void main(String[] args) {
        ClientPaymentDao dao=new ClientPaymentDao();
        Client cl=new Client();
        cl.setClientId(3);
        System.out.println(""+dao.getTotalPurchaseDue(cl));
    }
}
