package medicine.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import medicine.dao.MedicineConsumeDao;
import medicine.dao.MedicineDao;
import medicine.model.Medicine;
import medicine.model.MedicineConsume;
import medicine.model.User;

public final class MedicineConsumeUI extends javax.swing.JInternalFrame {

    private final User user;
    private MedicineConsume consume;
    private MedicineConsumeDao consumeDao;

    public MedicineConsumeUI(User user) {
        initComponents();
        this.user = user;
        clearForm();
        enableButtons();

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

    public void enableButtons() {
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    public void disableButtons() {
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }

    public void clearForm() {
        tfPrice.setText("");
        tfQuantity.setText("");
        tfReason.setText("");
        tfSearch.setText("");
        cbMedicine.setSelectedItem(null);
        chConsumeDate.setDate(new Date());
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
        cbMedicine = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chConsumeDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        tfPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfReason = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("MEDICINE COMSUME");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("CONSUME ID");

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
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
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

        jLabel2.setText("Medicine");

        cbMedicine.setEditable(true);

        jLabel3.setText("Quantity");

        tfQuantity.setText("jTextField2");

        jLabel4.setText("Date");

        jLabel5.setText("Price");

        tfPrice.setText("jTextField3");

        jLabel6.setText("Reason");

        tfReason.setColumns(20);
        tfReason.setRows(5);
        jScrollPane1.setViewportView(tfReason);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMedicine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chConsumeDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tfPrice)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(chConsumeDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (tfPrice.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Price ???");
            tfPrice.requestFocus();
        } else if (tfQuantity.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Quantity ???");
            tfQuantity.requestFocus();
        } else if (tfReason.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Reason ???");
            tfReason.requestFocus();
        } else {
            try {
                consume = new MedicineConsume();
                consume.setConsumeDate(chConsumeDate.getDate());
                consume.setMedicine((Medicine) cbMedicine.getSelectedItem());
                consume.setPrice(Double.parseDouble(tfPrice.getText()));
                consume.setQuantity(Integer.parseInt(tfQuantity.getText()));
                consume.setReason(tfReason.getText());
                consume.setUser(user);
                consumeDao = new MedicineConsumeDao();
                consumeDao.save(consume);
                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Successfully Saved.");

            } catch (NumberFormatException num) {
                System.out.println("Error.." + num);
                JOptionPane.showMessageDialog(this, "Invalid Number !!!");
            } catch (Exception e) {
                System.out.println("Error.." + e);
                JOptionPane.showMessageDialog(this, "Error !!!");

            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

        try {
            consumeDao = new MedicineConsumeDao();
            consume = consumeDao.find(tfSearch.getText());

            if (consume.getConsumeId() != 0) {
                tfPrice.setText(""+consume.getPrice());
                tfQuantity.setText(""+consume.getQuantity());
                tfReason.setText(consume.getReason());
                cbMedicine.getModel().setSelectedItem(consume.getMedicine());
                chConsumeDate.setDate(consume.getConsumeDate());
                disableButtons();
            }else{
                JOptionPane.showMessageDialog(this, "No Such Record Found !!!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        if (tfPrice.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Price ???");
            tfPrice.requestFocus();
        } else if (tfQuantity.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Quantity ???");
            tfQuantity.requestFocus();
        } else if (tfReason.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Reason ???");
            tfReason.requestFocus();
        } else {
            try {
                consume.setConsumeDate(chConsumeDate.getDate());
                consume.setMedicine((Medicine) cbMedicine.getSelectedItem());
                consume.setPrice(Double.parseDouble(tfPrice.getText()));
                consume.setQuantity(Integer.parseInt(tfQuantity.getText()));
                consume.setReason(tfReason.getText());
                consume.setUser(user);
                consumeDao = new MedicineConsumeDao();
                consumeDao.update(consume);
                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Successfully Updated.");

            } catch (NumberFormatException num) {
                System.out.println("Error.." + num);
                JOptionPane.showMessageDialog(this, "Invalid Number !!!");
            } catch (Exception e) {
                System.out.println("Error.." + e);
                JOptionPane.showMessageDialog(this, "Error !!!");

            }
        }        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {
            try {
                consumeDao=new MedicineConsumeDao();
                consumeDao.delete(consume);
                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Delete successfully.");
            } catch (Exception e) {
                System.out.println("Error..."+e);
                System.out.println("Error !!!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbMedicine;
    private com.toedter.calendar.JDateChooser chConsumeDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextArea tfReason;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
