package medicine.ui;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import medicine.dao.ClientDao;
import medicine.dao.MedicineDao;
import medicine.dao.MedicineStockDao;
import medicine.dao.PurchaseReturnDao;
import medicine.dao.StockDao;
import medicine.model.Client;
import medicine.model.Medicine;
import medicine.model.PurchaseReturnDetails;
import medicine.model.PurchaseReturnMaster;
import medicine.model.Stock;
import medicine.model.User;

public final class PurchaseReturnForm extends javax.swing.JInternalFrame {

    private final User user;
    private PurchaseReturnMaster master;
    private PurchaseReturnDetails details;
    private PurchaseReturnDao returnDao;
    private StockDao stockDao;
    private List<Medicine> tempMedicine;
    private List<PurchaseReturnDetails> tempDetails;

    public PurchaseReturnForm(User user) {
        initComponents();
        this.user = user;
        loadClientList();
        clearForm();
        enableButtons();

        itemTable.setShowGrid(true);
        
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

    public void loadClientList() {
        ClientDao clientDao = new ClientDao();
        cbRep.removeAllItems();
        for (Client c : clientDao.display(3)) {
            cbRep.addItem(c);
        }
    }

    public void loadMedicines() {
        MedicineStockDao medicineStockDao = new MedicineStockDao();
        cbMedicine.removeAllItems();
        for (Medicine m : medicineStockDao.display()) {
            cbMedicine.addItem(m);
        }
    }

    public void enableButtons() {
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
    }

    public void disableButtons() {
        btnSave.setEnabled(false);
        btnDelete.setEnabled(true);
    }

    public void clearForm() {
        tempMedicine = new ArrayList<>();
        tempDetails = new ArrayList<>();
        tfReturnQuantity.setText("");
        tfSearch.setText("");
        cbMedicine.setSelectedIndex(-1);
        cbRep.setSelectedIndex(-1);
        chReturnDate.setDate(new Date());

        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        model.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbRep = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        chReturnDate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbMedicine = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tfReturnQuantity = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("PURCHASE RETURN");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Return ID");

        tfSearch.setText("jTextField1");

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
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
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Representative");

        cbRep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Return Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chReturnDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chReturnDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Medicine");

        cbMedicine.setEditable(true);

        jLabel5.setText("Return Qty.");

        tfReturnQuantity.setText("jTextField2");
        tfReturnQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfReturnQuantityActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicine/icon/math-add-icon-16px.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicine/icon/math-minus-icon-16px.png"))); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbMedicine, 0, 314, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfReturnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfReturnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Return Quantity"
            }
        ));
        itemTable.setRowHeight(22);
        itemTable.setRowMargin(2);
        jScrollPane1.setViewportView(itemTable);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        int itemsTaken = model.getRowCount();

        if (itemsTaken <= 0) {
            JOptionPane.showMessageDialog(this, "No Medicine Selected ???");
        } else if (cbRep.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select Representative ???");
        } else {
            try {
                master = new PurchaseReturnMaster();
                master.setClient((Client) cbRep.getSelectedItem());
                master.setReturnDate(chReturnDate.getDate());
                for (int i = 0; i < itemsTaken; i++) {
                    Medicine medicine = (Medicine) model.getValueAt(i, 0);
                    int returnQty = (int) model.getValueAt(i, 1);
                    details = new PurchaseReturnDetails();
                    details.setMedicine(medicine);
                    details.setReturnQuantity(returnQty);
                    details.setSubmitDate(new Date());
                    tempDetails.add(details);
                }
                master.setDetails(tempDetails);
                master.setUser(user);
                returnDao = new PurchaseReturnDao();
                returnDao.save(master);
                JOptionPane.showMessageDialog(this, "Record saved successfully.");
                clearForm();
                enableButtons();
            } catch (HeadlessException e) {
                System.out.println("Error..." + e);
                JOptionPane.showMessageDialog(this, "Cannot Save !!!");
            }
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

        String RETURN_ID = tfSearch.getText();

        if (!RETURN_ID.trim().equals("")) {
            returnDao = new PurchaseReturnDao();
            master = returnDao.find(RETURN_ID);
            if (master != null) {
                disableButtons();
                clearForm();
                tfSearch.setText("" + master.getReturnId());
                chReturnDate.setDate(master.getReturnDate());
                cbRep.getModel().setSelectedItem(master.getClient());
                tempDetails.addAll(master.getDetails());

                for (PurchaseReturnDetails det : master.getDetails()) {
                    DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
                    model.addRow(new Object[]{det.getMedicine(), det.getReturnQuantity()});
                    tempMedicine.add(det.getMedicine());
                }

            } else {
                JOptionPane.showMessageDialog(this, "No Such Record Foun !!!");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Insert Sales ID ???");
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        clearForm();
        enableButtons();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {
            try {
                returnDao = new PurchaseReturnDao();
                if (returnDao.delete(master)) {
                    JOptionPane.showMessageDialog(this, "Record Deleted successfully.");
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Record cannot delete !!!");
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        MedicineStockDao stockdao = new MedicineStockDao();
        if (tfReturnQuantity.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Return Quantity ???");
        } else if (cbMedicine.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select Medicine ???");
        } else if (!stockdao.isStockAvailable((Medicine) cbMedicine.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, "You don't have sufficient sock ???");
        } else {
            Medicine med = (Medicine) cbMedicine.getSelectedItem();
            stockDao = new StockDao();
            Stock stock = stockDao.find(med);

            if (stock.getStockQuantity() < Integer.parseInt(tfReturnQuantity.getText())) {
                JOptionPane.showMessageDialog(this, "Stock not avilable !!!");
                return;
            }

            if (!tempMedicine.contains(med)) {
                DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
                model.addRow(new Object[]{med, Integer.parseInt(tfReturnQuantity.getText())});
                tempMedicine.add(med);
            } else {
                JOptionPane.showMessageDialog(this, "Medicine Exists !!!");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        int row = itemTable.getSelectedRow();
        if (row != -1) {
            Medicine medicine = (Medicine) model.getValueAt(row, 0);
            tempMedicine.remove(medicine);
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Select Medicine Row !!!");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tfReturnQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfReturnQuantityActionPerformed
        btnAdd.doClick();
    }//GEN-LAST:event_tfReturnQuantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbMedicine;
    private javax.swing.JComboBox cbRep;
    private com.toedter.calendar.JDateChooser chReturnDate;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfReturnQuantity;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
