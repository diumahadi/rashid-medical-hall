package medicine.report;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import medicine.dao.SalesDao;
import medicine.model.SalesMaster;
import medicine.util.ReportUtil;

public class PrintSalesVoucherUI extends javax.swing.JDialog {

    private final ReportUtil reportViewer;

    public PrintSalesVoucherUI(java.awt.Frame parent, boolean modal, SalesMaster master) {
        super(parent, modal);
        initComponents();
    
        HashMap hashMap = new HashMap();
        SalesDao salesDao = new SalesDao();
        master = salesDao.find(String.valueOf(master.getSalesId()));

        DecimalFormat df = new DecimalFormat("00000000000");
        String salesIdFormat = df.format(master.getSalesId());
        hashMap.put("FORMATTED_ID", "SLS".concat(salesIdFormat));
        hashMap.put("SALES_ID", master.getSalesId());
        hashMap.put("CUSTOMER_NAME", master.getClient().getFirstName());
        hashMap.put("SALES_DATE", master.getSalesDate());
        hashMap.put("PAID_AMOUNT", master.getPaidAmount());
        hashMap.put("DUE_AMOUNT", master.getDueAmount());

        reportViewer = new ReportUtil("reports/PARTICULAR_SALES_VOUCHER.jasper", hashMap);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        reportViewer.setSize((int) width - 40, (int) height - 20);
        desktopPane.add(reportViewer);
        try {
            reportViewer.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PrintSalesVoucherUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HOSSAIN DRUG HOUSE");

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    // End of variables declaration//GEN-END:variables
}
