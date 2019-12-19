package medicine.ui;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import medicine.dao.UserDao;
import medicine.model.User;

public final class UserForm extends javax.swing.JInternalFrame {

    private final User loginUser;
    private User newUser;
    private UserDao userDao;

    public UserForm(User user) {
        initComponents();
        this.loginUser = user;
        loadUser();
        clearForm();
        enableButtons();
    }

    public void loadUser() {
        cbSearch.removeAllItems();
        UserDao dao = new UserDao();
        for (User u : dao.display()) {
            cbSearch.addItem(u);
        }
    }

    public void clearForm() {
        cbSearch.setSelectedIndex(-1);
        tfAddress.setText("");
        tfContactNumber.setText("");
        tfEmail.setText("");
        tfFirstName.setText("");
        tfLastName.setText("");
        tfUsername.setText("");
        tfUsername.setEditable(true);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbSearch = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfContactNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbActive = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btfClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("USER");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        jLabel1.setText("First Name");

        tfFirstName.setText("jTextField1");

        jLabel2.setText("Last Name");

        tfLastName.setText("jTextField2");

        jLabel3.setText("Username");

        tfUsername.setText("jTextField3");

        jLabel4.setText("Email");

        tfEmail.setText("jTextField4");

        jLabel5.setText("Contact Number");

        tfContactNumber.setText("jTextField5");

        jLabel6.setText("Address");

        tfAddress.setText("jTextField6");

        jLabel7.setText("Active");

        cbActive.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Block" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFirstName)
                    .addComponent(tfLastName)
                    .addComponent(tfUsername)
                    .addComponent(tfEmail)
                    .addComponent(tfContactNumber)
                    .addComponent(tfAddress)
                    .addComponent(cbActive, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btfClear.setText("Clear");
        btfClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfClearActionPerformed(evt);
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
                .addComponent(btfClear, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btfClear)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
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

        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String userName = tfUsername.getText();

        userDao = new UserDao();
        User u = userDao.findByUserName(userName.trim());

        if (u.getUserId() != 0) {
            JOptionPane.showMessageDialog(this, "Username Exists !!!");
            return;
        }

        if (firstName.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert First Name ???");
        } else if (lastName.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Last Name ???");
        } else if (userName.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Username ???");
        } else {
            try {
                newUser = new User();
                newUser.setAddress(tfAddress.getText());
                newUser.setContactNumber(tfContactNumber.getText());
                newUser.setEmail(tfEmail.getText());
                newUser.setFirstName(tfFirstName.getText().trim());
                newUser.setLastName(tfLastName.getText().trim());
                newUser.setGroupId(1);
                newUser.setImage(null);
                int act = cbActive.getSelectedIndex();
                if (act == 0) {
                    newUser.setIsActive(1);
                } else {
                    newUser.setIsActive(0);
                }
                newUser.setPassword(UserDao.getMD5("12345"));
                newUser.setUserLevel(2);
                newUser.setUserName(tfUsername.getText().trim());

                if (loginUser.getUserLevel() != 1) {
                    JOptionPane.showMessageDialog(this, "You are not a vaid user to add !!!");
                    dispose();
                } else {
                    userDao = new UserDao();
                    userDao.save(newUser);

                    loadUser();
                    clearForm();
                    enableButtons();
                    JOptionPane.showMessageDialog(this, "Record Saved Successfully.");
                }

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Error..");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed

        try {
            User uu = (User) cbSearch.getSelectedItem();
            tfAddress.setText(uu.getAddress());
            tfContactNumber.setText(uu.getContactNumber());
            tfEmail.setText(uu.getEmail());
            tfFirstName.setText(uu.getFirstName());
            tfLastName.setText(uu.getLastName());
            tfUsername.setText(uu.getUserName());
            if (uu.getIsActive() == 1) {
                cbActive.setSelectedIndex(0);
            } else {
                cbActive.setSelectedIndex(1);
            }
            tfUsername.setEditable(false);
            disableButtons();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String userName = tfUsername.getText();

        if (firstName.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert First Name ???");
        } else if (lastName.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Last Name ???");
        } else if (userName.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Username ???");
        } else {
            try {
                userDao = new UserDao();
                User u = userDao.findByUserName(userName.trim());

                newUser = new User();
                newUser.setAddress(tfAddress.getText());
                newUser.setContactNumber(tfContactNumber.getText());
                newUser.setEmail(tfEmail.getText());
                newUser.setFirstName(tfFirstName.getText().trim());
                newUser.setLastName(tfLastName.getText().trim());
                newUser.setGroupId(1);
                newUser.setImage(null);
                int act = cbActive.getSelectedIndex();
                if (act == 0) {
                    newUser.setIsActive(1);
                } else {
                    newUser.setIsActive(0);
                }
                newUser.setUserLevel(u.getUserLevel());
                newUser.setUserName(u.getUserName());
                newUser.setUserId(u.getUserId());

                if (loginUser.getUserLevel() != 1) {
                    JOptionPane.showMessageDialog(this, "You are not a vaid user to update !!!");
                    dispose();
                } else {

                    userDao = new UserDao();
                    userDao.update(newUser);
                    loadUser();
                    clearForm();
                    enableButtons();
                    JOptionPane.showMessageDialog(this, "Record Updated Successfully.");
                }

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Error..");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {

            if (loginUser.getUserLevel() != 1) {
                JOptionPane.showMessageDialog(this, "You are not vaid user to Delete !!!");
                dispose();
            } else {
                userDao = new UserDao();
                User u = userDao.findByUserName(tfUsername.getText().trim());
                u.setIsActive(2);
                userDao.update(u);
                
                loadUser();
                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Deleted Successfully.");

            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btfClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfClearActionPerformed

        clearForm();
        enableButtons();
    }//GEN-LAST:event_btfClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btfClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbActive;
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
    private javax.swing.JTextField tfContactNumber;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

}
