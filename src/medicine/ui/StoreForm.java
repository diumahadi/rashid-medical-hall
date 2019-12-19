package medicine.ui;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import medicine.dao.ClientDao;
import medicine.dao.DistrictDao;
import medicine.model.Client;
import medicine.model.District;
import medicine.model.User;

public final class StoreForm extends javax.swing.JInternalFrame {

    private User user;
    private Client client;
    private List<Client> customerList = new ArrayList<>();

    public StoreForm(User user) {
        initComponents();
        this.user = user;
        loadDistrictList();
        enableButtons();
        clearForm();
        
        cbSearch.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != 38 && e.getKeyCode() != 40 && e.getKeyCode() != 10) {
                    String a = cbSearch.getEditor().getItem().toString();
                    String formatedString = a.toUpperCase();
                    cbSearch.removeAllItems();
                    cbSearch.addItem(null);
                    
                    int st = 0;
                    
                    if (formatedString.length() >= 3) {
                        ClientDao clientDao = new ClientDao();
                        for (Client c : clientDao.getMatch(formatedString, 2)) {
                            cbSearch.addItem(c);
                            st++;
                        }
                    } 
                    
                    cbSearch.getEditor().setItem(a);
                    cbSearch.hidePopup();
                    if (st != 0) {
                        cbSearch.showPopup();
                    }
                }
            }
        });
    }

    public void loadClientList() {
        ClientDao clientDao = new ClientDao();
        customerList = clientDao.display(2);
        cbSearch.removeAllItems();
        for (Client c : customerList) {
            cbSearch.addItem(c);
        }
    }

    public void loadDistrictList() {
        DistrictDao districtDao = new DistrictDao();
        cbPresentDisctrict.removeAllItems();
        for (District d : districtDao.display()) {
            cbPresentDisctrict.addItem(d);
        }
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
        tfAddress.setText("");
        tfEmail.setText("");
        tfFirstName.setText("");
        tfMobile.setText("");
        tfStartingDue.setText("");
        cbDisplay.setSelectedIndex(0);
        cbSearch.setSelectedIndex(-1);
        cbPresentDisctrict.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbSearch = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfMobile = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbDisplay = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        tfStartingDue = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbPresentDisctrict = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("STORE");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbSearch.setEditable(true);
        cbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Store Name");

        tfFirstName.setText("jTextField1");

        jLabel2.setText("Email");

        tfEmail.setText("jTextField2");

        jLabel3.setText("Mobile");

        tfMobile.setText("jTextField3");

        jLabel4.setText("Address");

        tfAddress.setText("jTextField4");

        jLabel5.setText("Display");

        cbDisplay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Show", "Hide" }));

        jLabel6.setText("Starting Due");

        tfStartingDue.setText("jTextField4");

        jLabel7.setText("Disctrict");

        cbPresentDisctrict.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(tfEmail)
                    .addComponent(tfMobile)
                    .addComponent(tfAddress)
                    .addComponent(cbDisplay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfStartingDue)
                    .addComponent(cbPresentDisctrict, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbPresentDisctrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfStartingDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
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

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed

        try {
            client = (Client) cbSearch.getSelectedItem();
            if (client != null) {
                tfAddress.setText(client.getAddress());
                tfEmail.setText(client.getEmail());
                tfFirstName.setText(client.getFirstName());
                tfMobile.setText(client.getMobile());
                tfStartingDue.setText("" + client.getStartingDue());
                if (client.getDisplay() == 1) {
                    cbDisplay.setSelectedIndex(0);
                } else {
                    cbDisplay.setSelectedIndex(1);
                }
                cbPresentDisctrict.getModel().setSelectedItem(client.getPresentDistrict());
                disableButtons();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbSearchActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        String firstName = tfFirstName.getText();

        if (firstName.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert first name ???");
        } else {
            try {
                client = new Client();
                client.setAddress(tfAddress.getText());
                client.setAge(0);
                client.setBloodGroup("");
                client.setClientType(2);
                client.setCompany(null);
                client.setDateOfBirth(null);
                if (cbDisplay.getSelectedIndex() == 0) {
                    client.setDisplay(1);
                } else {
                    client.setDisplay(0);
                }
                client.setEmail(tfEmail.getText());
                client.setFirstName(firstName);
                client.setLastName("");
                client.setMobile(tfMobile.getText());
                client.setPermanentAddress("");
                client.setPermanentDistrict(null);
                client.setPresentDistrict((District) cbPresentDisctrict.getSelectedItem());
                client.setAddress(tfAddress.getText());
                if (tfStartingDue.getText().trim().equals("")) {
                    client.setStartingDue(0);
                } else {
                    client.setStartingDue(Double.parseDouble(tfStartingDue.getText()));
                }
                client.setUser(user);

                ClientDao clientDao = new ClientDao();
                clientDao.save(client);
                JOptionPane.showMessageDialog(this, "Record saved successfully.");
                loadClientList();
                enableButtons();
                clearForm();
            } catch (HeadlessException e) {
                System.out.println("Error.." + e);
                JOptionPane.showMessageDialog(this, "Error...");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {
            ClientDao dao = new ClientDao();
            if (dao.delete(client)) {
                JOptionPane.showMessageDialog(this, "Deleted Successfully.");
                loadClientList();
                enableButtons();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cannot Delete !!!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String firstName = tfFirstName.getText();

        if (firstName.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert first name ???");
        } else {
            try {
                client.setAddress(tfAddress.getText());
                client.setAge(0);
                client.setBloodGroup("");
                client.setClientType(2);
                client.setCompany(null);
                client.setDateOfBirth(null);
                if (cbDisplay.getSelectedIndex() == 0) {
                    client.setDisplay(1);
                } else {
                    client.setDisplay(0);
                }
                client.setEmail(tfEmail.getText());
                client.setFirstName(firstName);
                client.setLastName("");
                client.setMobile(tfMobile.getText());
                client.setPermanentAddress("");
                client.setPermanentDistrict(null);
                client.setPresentDistrict((District) cbPresentDisctrict.getSelectedItem());
                client.setAddress(tfAddress.getText());
                if (tfStartingDue.getText().trim().equals("")) {
                    client.setStartingDue(0);
                } else {
                    client.setStartingDue(Double.parseDouble(tfStartingDue.getText()));
                }
                client.setUser(user);

                ClientDao clientDao = new ClientDao();
                clientDao.update(client);
                
                loadClientList();
                enableButtons();
                clearForm();
                JOptionPane.showMessageDialog(this, "Record updated successfully.");

            } catch (HeadlessException e) {
                System.out.println("Error.." + e);
                JOptionPane.showMessageDialog(this, "Error...");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        loadClientList();
        enableButtons();
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbDisplay;
    private javax.swing.JComboBox cbPresentDisctrict;
    private javax.swing.JComboBox cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfMobile;
    private javax.swing.JTextField tfStartingDue;
    // End of variables declaration//GEN-END:variables
}
