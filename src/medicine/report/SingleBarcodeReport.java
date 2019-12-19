package medicine.report;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import medicine.dao.MedicineDao;
import medicine.dao.MedicineStockDao;
import medicine.dao.PrintDao;
import medicine.model.Medicine;
import medicine.model.PrintSingleMedicineBarcode;
import medicine.model.User;
import medicine.util.ReportUtil;

public final class SingleBarcodeReport extends javax.swing.JInternalFrame {

    private final User user;
    private HashMap hashMap;
    private ReportUtil reportViewer;

    public SingleBarcodeReport(User user) {
        initComponents();
        this.user = user;
        tfCopy.setText("");

        cbMedicine.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != 38 && e.getKeyCode() != 40 && e.getKeyCode() != 10) {
                    String a = cbMedicine.getEditor().getItem().toString();
                    String formatedString = a.toUpperCase();
                    cbMedicine.removeAllItems();
                    cbMedicine.addItem(null);
                    int st = 0;
                    if (formatedString.length() >= 3) {
                        MedicineDao medicineDao = new MedicineDao();
                        for (Medicine m : medicineDao.getMatch(formatedString)) {
                            cbMedicine.addItem(m);
                            st++;
                        }
                    }

                    cbMedicine.getEditor().setItem(a);
                    cbMedicine.hidePopup();
                    if (st != 0) {
                        cbMedicine.showPopup();
                    }
                }
            }
        });
    }

    public void loadMedicines() {
        MedicineStockDao medicineStockDao = new MedicineStockDao();
        cbMedicine.removeAllItems();
        for (Medicine m : medicineStockDao.display()) {
            cbMedicine.addItem(m);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbMedicine = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tfCopy = new javax.swing.JTextField();
        btnPreview = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Medicine");

        cbMedicine.setEditable(true);

        jLabel2.setText("Copy");

        tfCopy.setText("jTextField1");

        btnPreview.setText("Preview");
        btnPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPreview)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfCopy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreview))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desktopPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviewActionPerformed

        try {
            if (cbMedicine.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Select Medicine ???");
            } else if (tfCopy.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Insert Total Copy ???");
            } else {
                Medicine m = (Medicine) cbMedicine.getSelectedItem();
                int copy = Integer.parseInt(tfCopy.getText());
                DecimalFormat df = new DecimalFormat("00000");
                String format = df.format(m.getMedicineId());

                PrintDao printDao = new PrintDao();
                printDao.removeAllRows();

                for (int i = 0; i < copy; i++) {
                    PrintDao dao = new PrintDao();
                    PrintSingleMedicineBarcode print = new PrintSingleMedicineBarcode();
                    print.setMedicine(m);
                    print.setUser(user);
                    dao.save(print);
                }
                
                printReport(m, format, copy);
            }

        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("Error...." + e);
        }
    }//GEN-LAST:event_btnPreviewActionPerformed

    public void printReport(Medicine m, String formatId, int limit) {
        hashMap = new HashMap();
        hashMap.put("MEDICINE_ID", m.getMedicineId());
        hashMap.put("FORMAT_MEDICINE_ID", formatId);
        hashMap.put("MEDICINE_NAME", m.getMedicineName());
        hashMap.put("TOTAL_COUNT", limit);
        reportViewer = new ReportUtil("reports/SINGLE_MEDICINE_PRINT.jasper", hashMap);
        reportViewer.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.removeAll();
        desktopPane.add(reportViewer);
        try {
            reportViewer.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SingleBarcodeReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPreview;
    private javax.swing.JComboBox cbMedicine;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfCopy;
    // End of variables declaration//GEN-END:variables
}
