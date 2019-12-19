package medicine.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import medicine.model.Unit;
import medicine.model.User;
import medicine.report.DailySalesReportUI;
import medicine.report.MonthlyPurchaseReportUI;
import medicine.report.OutOfStockReportUI;
import medicine.report.PaymentReportUI;
import medicine.report.PurchaseReportUI;
import medicine.report.PurchaseReturnReportUI;
import medicine.report.SalesDetailsReportUI;
import medicine.report.SalesReportUI;
import medicine.report.SalesReturnReportUI;
import medicine.report.SalesSummaryReportUI;
import medicine.report.SingleBarcodeReport;
import medicine.util.BackUP;
import medicine.util.ReportUtil;

public final class MainUI extends javax.swing.JFrame {

    private ReportUtil reportViewer;

    public MainUI(User user) {
        initComponents();
        try {
            this.user = user;
            if (user == null) {
                hideMenu();
            }
        } catch (Exception e) {
            System.out.println("MainUI Login: " + e);
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) screenSize.getHeight();
        int width = (int) screenSize.getWidth();
        setSize(width, height - 40);
    }

    public void showMenu() {

        menuBasics.setVisible(true);
        menuPurchaseSales.setVisible(true);
        menuReport.setVisible(true);
        backUPMenuItem.setVisible(true);
        changePasswordMI.setVisible(true);
        loginMI.setText("Log off");

        if (user != null && user.getUserLevel() == 1) {
            userMI.setVisible(true);
        }
    }

    public void hideMenu() {
        menuBasics.setVisible(false);
        menuPurchaseSales.setVisible(false);
        menuReport.setVisible(false);
        backUPMenuItem.setVisible(false);
        changePasswordMI.setVisible(false);
        userMI.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuBasics = new javax.swing.JMenu();
        medicineMI = new javax.swing.JMenuItem();
        expenseHeadMI = new javax.swing.JMenuItem();
        companyMenuItem = new javax.swing.JMenuItem();
        repMI = new javax.swing.JMenuItem();
        customerMI = new javax.swing.JMenuItem();
        psTitleMI = new javax.swing.JMenuItem();
        storeMI = new javax.swing.JMenuItem();
        unitMI = new javax.swing.JMenuItem();
        dosageMI = new javax.swing.JMenuItem();
        locationMI = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        menuPurchaseSales = new javax.swing.JMenu();
        salesMI = new javax.swing.JMenuItem();
        purchaseMI = new javax.swing.JMenuItem();
        expenseMI = new javax.swing.JMenuItem();
        storePaymentMI = new javax.swing.JMenuItem();
        repPaymentMI = new javax.swing.JMenuItem();
        customerPaymentMI = new javax.swing.JMenuItem();
        purchaseReturnMI = new javax.swing.JMenuItem();
        purchaseReturnTakenMI = new javax.swing.JMenuItem();
        salesReturnMI = new javax.swing.JMenuItem();
        medicineConsumeMI = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        dailySalesReportMI = new javax.swing.JMenuItem();
        salesDetailsMI = new javax.swing.JMenuItem();
        salesReportMI = new javax.swing.JMenuItem();
        salesSummaryMI = new javax.swing.JMenuItem();
        purchaseReportMI = new javax.swing.JMenuItem();
        monthlyPurchaseMenuItem = new javax.swing.JMenuItem();
        paymentReportMI = new javax.swing.JMenuItem();
        unitReportMI = new javax.swing.JMenuItem();
        medicineMenu = new javax.swing.JMenu();
        medicineListMI = new javax.swing.JMenuItem();
        barcodeMenuItem = new javax.swing.JMenuItem();
        singleMedicineBarcodeMI = new javax.swing.JMenuItem();
        medicinePricingMI = new javax.swing.JMenuItem();
        currentStockMI = new javax.swing.JMenuItem();
        outOfStockMI = new javax.swing.JMenuItem();
        crossedReorderLevelMI = new javax.swing.JMenuItem();
        customerDueListMI = new javax.swing.JMenuItem();
        repDuesMI = new javax.swing.JMenuItem();
        prchaseReturnReportMI = new javax.swing.JMenuItem();
        salesReturnReportMI = new javax.swing.JMenuItem();
        customerListMI = new javax.swing.JMenuItem();
        storeListMI = new javax.swing.JMenuItem();
        representativeListMI = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        menuSecurity = new javax.swing.JMenu();
        loginMI = new javax.swing.JMenuItem();
        changePasswordMI = new javax.swing.JMenuItem();
        backUPMenuItem = new javax.swing.JMenuItem();
        userMI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOSSAIN DRUG HOUSE");
        setIconImage(Toolkit.getDefaultToolkit().getImage("img//main-icon.png"));

        menuBasics.setMnemonic('f');
        menuBasics.setText("Basics");

        medicineMI.setText("Medicine");
        medicineMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicineMIActionPerformed(evt);
            }
        });
        menuBasics.add(medicineMI);

        expenseHeadMI.setText("Expense Head");
        expenseHeadMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseHeadMIActionPerformed(evt);
            }
        });
        menuBasics.add(expenseHeadMI);

        companyMenuItem.setMnemonic('o');
        companyMenuItem.setText("Company");
        companyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyMenuItemActionPerformed(evt);
            }
        });
        menuBasics.add(companyMenuItem);

        repMI.setMnemonic('s');
        repMI.setText("Representative");
        repMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repMIActionPerformed(evt);
            }
        });
        menuBasics.add(repMI);

        customerMI.setMnemonic('a');
        customerMI.setText("Customer");
        customerMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerMIActionPerformed(evt);
            }
        });
        menuBasics.add(customerMI);

        psTitleMI.setText("PS Title");
        psTitleMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psTitleMIActionPerformed(evt);
            }
        });
        menuBasics.add(psTitleMI);

        storeMI.setText("Store");
        storeMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeMIActionPerformed(evt);
            }
        });
        menuBasics.add(storeMI);

        unitMI.setText("Unit");
        unitMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitMIActionPerformed(evt);
            }
        });
        menuBasics.add(unitMI);

        dosageMI.setText("Format");
        dosageMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosageMIActionPerformed(evt);
            }
        });
        menuBasics.add(dosageMI);

        locationMI.setText("Location");
        locationMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationMIActionPerformed(evt);
            }
        });
        menuBasics.add(locationMI);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        menuBasics.add(exitMenuItem);

        menuBar.add(menuBasics);

        menuPurchaseSales.setText("Purchase & Sales");

        salesMI.setText("Sales");
        salesMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(salesMI);

        purchaseMI.setText("Purchase");
        purchaseMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(purchaseMI);

        expenseMI.setText("Expense");
        expenseMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(expenseMI);

        storePaymentMI.setText("Store Payment");
        storePaymentMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storePaymentMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(storePaymentMI);

        repPaymentMI.setText("Rep. Payment");
        repPaymentMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repPaymentMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(repPaymentMI);

        customerPaymentMI.setText("Customer Payment");
        customerPaymentMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerPaymentMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(customerPaymentMI);

        purchaseReturnMI.setText("Purchase Return");
        purchaseReturnMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseReturnMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(purchaseReturnMI);

        purchaseReturnTakenMI.setText("Purchase Return Taken");
        purchaseReturnTakenMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseReturnTakenMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(purchaseReturnTakenMI);

        salesReturnMI.setText("Sales Return");
        salesReturnMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesReturnMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(salesReturnMI);

        medicineConsumeMI.setText("Medicine Consume");
        medicineConsumeMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicineConsumeMIActionPerformed(evt);
            }
        });
        menuPurchaseSales.add(medicineConsumeMI);

        menuBar.add(menuPurchaseSales);

        menuReport.setText("Medicine Reports");

        jMenu2.setText("Sales");

        dailySalesReportMI.setText("Daily Sales");
        dailySalesReportMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailySalesReportMIActionPerformed(evt);
            }
        });
        jMenu2.add(dailySalesReportMI);

        salesDetailsMI.setText("Detail Sales");
        salesDetailsMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesDetailsMIActionPerformed(evt);
            }
        });
        jMenu2.add(salesDetailsMI);

        salesReportMI.setText("Particular Sales");
        salesReportMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesReportMIActionPerformed(evt);
            }
        });
        jMenu2.add(salesReportMI);

        salesSummaryMI.setText("Sales Summary");
        salesSummaryMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesSummaryMIActionPerformed(evt);
            }
        });
        jMenu2.add(salesSummaryMI);

        menuReport.add(jMenu2);

        purchaseReportMI.setText("Purchase");
        purchaseReportMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseReportMIActionPerformed(evt);
            }
        });
        menuReport.add(purchaseReportMI);

        monthlyPurchaseMenuItem.setText("Monthly Purchase");
        monthlyPurchaseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyPurchaseMenuItemActionPerformed(evt);
            }
        });
        menuReport.add(monthlyPurchaseMenuItem);

        paymentReportMI.setText("Payments");
        paymentReportMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentReportMIActionPerformed(evt);
            }
        });
        menuReport.add(paymentReportMI);

        unitReportMI.setText("Unit");
        unitReportMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitReportMIActionPerformed(evt);
            }
        });
        menuReport.add(unitReportMI);

        medicineMenu.setText("Medicine");

        medicineListMI.setText("Medicine List");
        medicineListMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicineListMIActionPerformed(evt);
            }
        });
        medicineMenu.add(medicineListMI);

        barcodeMenuItem.setText("Barcode");
        barcodeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeMenuItemActionPerformed(evt);
            }
        });
        medicineMenu.add(barcodeMenuItem);

        singleMedicineBarcodeMI.setText("Single Medicine Barcode");
        singleMedicineBarcodeMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleMedicineBarcodeMIActionPerformed(evt);
            }
        });
        medicineMenu.add(singleMedicineBarcodeMI);

        medicinePricingMI.setText("Medicine Pricing");
        medicinePricingMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicinePricingMIActionPerformed(evt);
            }
        });
        medicineMenu.add(medicinePricingMI);

        currentStockMI.setText("Current Stock");
        currentStockMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentStockMIActionPerformed(evt);
            }
        });
        medicineMenu.add(currentStockMI);

        outOfStockMI.setText("Out of Stock");
        outOfStockMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outOfStockMIActionPerformed(evt);
            }
        });
        medicineMenu.add(outOfStockMI);

        crossedReorderLevelMI.setText("Crossed Reorder Level");
        crossedReorderLevelMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crossedReorderLevelMIActionPerformed(evt);
            }
        });
        medicineMenu.add(crossedReorderLevelMI);

        menuReport.add(medicineMenu);

        customerDueListMI.setText("Customer Dues");
        customerDueListMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerDueListMIActionPerformed(evt);
            }
        });
        menuReport.add(customerDueListMI);

        repDuesMI.setText("Representative Dues");
        repDuesMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repDuesMIActionPerformed(evt);
            }
        });
        menuReport.add(repDuesMI);

        prchaseReturnReportMI.setText("Purchase Return");
        prchaseReturnReportMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prchaseReturnReportMIActionPerformed(evt);
            }
        });
        menuReport.add(prchaseReturnReportMI);

        salesReturnReportMI.setText("Sales Return");
        salesReturnReportMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesReturnReportMIActionPerformed(evt);
            }
        });
        menuReport.add(salesReturnReportMI);

        customerListMI.setText("Customer List");
        customerListMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerListMIActionPerformed(evt);
            }
        });
        menuReport.add(customerListMI);

        storeListMI.setText("Store List");
        storeListMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeListMIActionPerformed(evt);
            }
        });
        menuReport.add(storeListMI);

        representativeListMI.setText("Representative List");
        representativeListMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                representativeListMIActionPerformed(evt);
            }
        });
        menuReport.add(representativeListMI);

        menuBar.add(menuReport);

        menuHelp.setMnemonic('h');
        menuHelp.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        menuHelp.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        menuHelp.add(aboutMenuItem);

        menuBar.add(menuHelp);

        menuSecurity.setMnemonic('e');
        menuSecurity.setText("Security");

        loginMI.setMnemonic('y');
        loginMI.setText("Login");
        loginMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMIActionPerformed(evt);
            }
        });
        menuSecurity.add(loginMI);

        changePasswordMI.setText("Change Password");
        changePasswordMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordMIActionPerformed(evt);
            }
        });
        menuSecurity.add(changePasswordMI);

        backUPMenuItem.setText("Backup DB");
        backUPMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backUPMenuItemActionPerformed(evt);
            }
        });
        menuSecurity.add(backUPMenuItem);

        userMI.setText("User");
        userMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userMIActionPerformed(evt);
            }
        });
        menuSecurity.add(userMI);

        menuBar.add(menuSecurity);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void companyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyMenuItemActionPerformed

        CompanyForm Form = new CompanyForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 400, 355);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_companyMenuItemActionPerformed

    private void repMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repMIActionPerformed

        RepForm Form = new RepForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 400, 393);
        desktopPane.add(Form);
        Form.setVisible(true);

    }//GEN-LAST:event_repMIActionPerformed

    private void customerMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerMIActionPerformed

        CustomerForm Form = new CustomerForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 530, 473);
        desktopPane.add(Form);
        Form.setVisible(true);

    }//GEN-LAST:event_customerMIActionPerformed

    private void loginMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMIActionPerformed

        if (loginMI.getText().equalsIgnoreCase("login")) {

            LoginForm Form = new LoginForm(this);
            Dimension dimension = desktopPane.getSize();
            int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
            Form.setBounds(x, y, 500, 260);
            desktopPane.add(Form);
            Form.setVisible(true);
            user = Form.getUser();
            if (user != null) {
                showMenu();
            }

        } else {
            user = null;
            hideMenu();
            JInternalFrame frames[] = desktopPane.getAllFrames();
            for (JInternalFrame frame : frames) {
                frame.dispose();
            }
            loginMI.setText("Login");
        }

    }//GEN-LAST:event_loginMIActionPerformed

    private void storeMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeMIActionPerformed

        StoreForm Form = new StoreForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 400, 385);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_storeMIActionPerformed

    private void locationMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationMIActionPerformed

        LocationForm Form = new LocationForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 350, 220);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_locationMIActionPerformed

    private void dosageMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosageMIActionPerformed

        MedicineTypeForm Form = new MedicineTypeForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 350, 220);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_dosageMIActionPerformed

    private void medicineMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineMIActionPerformed
        MedicineForm Form = new MedicineForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 480, 385);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_medicineMIActionPerformed

    private void psTitleMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psTitleMIActionPerformed
        PSForm Form = new PSForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 350, 220);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_psTitleMIActionPerformed

    private void unitMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitMIActionPerformed
        UnitForm Form = new UnitForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 350, 220);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_unitMIActionPerformed

    private void purchaseMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseMIActionPerformed

        PurchaseForm Form = new PurchaseForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 950, 505);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_purchaseMIActionPerformed

    private void salesMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesMIActionPerformed

        SalesForm Form = new SalesForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 900, 505);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_salesMIActionPerformed

    private void unitReportMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitReportMIActionPerformed
        showReport("reports/UNIT_REPORT.jasper");
    }//GEN-LAST:event_unitReportMIActionPerformed

    private void medicineListMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineListMIActionPerformed
        showReport("reports/MEDICINE_LIST.jasper");
    }//GEN-LAST:event_medicineListMIActionPerformed

    private void medicinePricingMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicinePricingMIActionPerformed
        showReport("reports/MEDICINE_PRICING_LIST.jasper");
    }//GEN-LAST:event_medicinePricingMIActionPerformed

    private void currentStockMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentStockMIActionPerformed
        showReport("reports/CURRENT_STOCK.jasper");
    }//GEN-LAST:event_currentStockMIActionPerformed

    private void outOfStockMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outOfStockMIActionPerformed

        OutOfStockReportUI Report = new OutOfStockReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_outOfStockMIActionPerformed

    private void salesReportMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesReportMIActionPerformed

        SalesReportUI Report = new SalesReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_salesReportMIActionPerformed

    private void purchaseReportMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseReportMIActionPerformed

        PurchaseReportUI Report = new PurchaseReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_purchaseReportMIActionPerformed

    private void repPaymentMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repPaymentMIActionPerformed

        RepPaymentForm Form = new RepPaymentForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 400, 300);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_repPaymentMIActionPerformed

    private void customerPaymentMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerPaymentMIActionPerformed

        CustomerPaymentUI Form = new CustomerPaymentUI(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 400, 300);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_customerPaymentMIActionPerformed

    private void storePaymentMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storePaymentMIActionPerformed

        StorePayment Form = new StorePayment(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 420, 340);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_storePaymentMIActionPerformed

    private void salesDetailsMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesDetailsMIActionPerformed

        SalesDetailsReportUI Report = new SalesDetailsReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_salesDetailsMIActionPerformed

    private void paymentReportMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentReportMIActionPerformed

        PaymentReportUI Report = new PaymentReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_paymentReportMIActionPerformed

    private void customerDueListMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerDueListMIActionPerformed

        HashMap hashMap = new HashMap();
        List<Unit> unitList = new ArrayList<>();
        unitList.add(new Unit(1, "u1"));
        unitList.add(new Unit(2, "u2"));
        hashMap.put("unit_list", unitList);

        reportViewer = new ReportUtil("reports/CLIENT_DUE_REPORT.jasper", hashMap);
        reportViewer.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.add(reportViewer);
        try {
            reportViewer.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_customerDueListMIActionPerformed

    private void dailySalesReportMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailySalesReportMIActionPerformed
        DailySalesReportUI Report = new DailySalesReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_dailySalesReportMIActionPerformed

    private void crossedReorderLevelMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crossedReorderLevelMIActionPerformed

        reportViewer = new ReportUtil("reports/MEDICINE_CROSSED_REORDER_LEVEL.jasper");
        reportViewer.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.add(reportViewer);
        try {
            reportViewer.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_crossedReorderLevelMIActionPerformed

    private void purchaseReturnMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseReturnMIActionPerformed

        PurchaseReturnForm Form = new PurchaseReturnForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 420, 445);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_purchaseReturnMIActionPerformed

    private void prchaseReturnReportMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prchaseReturnReportMIActionPerformed

        PurchaseReturnReportUI Report = new PurchaseReturnReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_prchaseReturnReportMIActionPerformed

    private void salesReturnMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesReturnMIActionPerformed

        SalesReturnUI Form = new SalesReturnUI(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 420, 490);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_salesReturnMIActionPerformed

    private void salesReturnReportMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesReturnReportMIActionPerformed

        SalesReturnReportUI Report = new SalesReturnReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_salesReturnReportMIActionPerformed

    private void purchaseReturnTakenMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseReturnTakenMIActionPerformed

        PurchaseReturnTakenUI Form = new PurchaseReturnTakenUI(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 420, 405);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_purchaseReturnTakenMIActionPerformed

    private void monthlyPurchaseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyPurchaseMenuItemActionPerformed

        MonthlyPurchaseReportUI Report = new MonthlyPurchaseReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_monthlyPurchaseMenuItemActionPerformed

    private void barcodeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeMenuItemActionPerformed
        showReport("reports/MEDICINE_BARCODES.jasper");
    }//GEN-LAST:event_barcodeMenuItemActionPerformed

    private void backUPMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backUPMenuItemActionPerformed

        BackUP Form = new BackUP();
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 460, 200);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_backUPMenuItemActionPerformed

    private void singleMedicineBarcodeMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleMedicineBarcodeMIActionPerformed

        SingleBarcodeReport Report = new SingleBarcodeReport(user);
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_singleMedicineBarcodeMIActionPerformed

    private void changePasswordMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordMIActionPerformed

        ChangePassUI Form = new ChangePassUI(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 400, 200);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_changePasswordMIActionPerformed

    private void salesSummaryMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesSummaryMIActionPerformed

        SalesSummaryReportUI Report = new SalesSummaryReportUI();
        int x = desktopPane.getWidth();
        int y = desktopPane.getHeight();
        Report.setBounds(0, 0, x, y);
        desktopPane.add(Report);
        Report.setVisible(true);
    }//GEN-LAST:event_salesSummaryMIActionPerformed

    private void repDuesMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repDuesMIActionPerformed
        showReport("reports/REPRESENTATIVE_DUE_REPORT.jasper");
    }//GEN-LAST:event_repDuesMIActionPerformed

    private void userMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMIActionPerformed

        UserForm Form = new UserForm(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 420, 390);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_userMIActionPerformed

    private void medicineConsumeMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineConsumeMIActionPerformed

        MedicineConsumeUI Form = new MedicineConsumeUI(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 400, 370);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_medicineConsumeMIActionPerformed

    private void expenseHeadMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseHeadMIActionPerformed

        ExpenseHeadUI Form = new ExpenseHeadUI(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 400, 220);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_expenseHeadMIActionPerformed

    private void expenseMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseMIActionPerformed

        ExpenseUI Form = new ExpenseUI(user);
        Dimension dimension = desktopPane.getSize();
        int x = (int) ((dimension.getWidth() - Form.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Form.getHeight()) / 2);
        Form.setBounds(x, y, 400, 285);
        desktopPane.add(Form);
        Form.setVisible(true);
    }//GEN-LAST:event_expenseMIActionPerformed

    private void customerListMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerListMIActionPerformed
        showReport("reports/CUSTOMER_LIST.jasper");
    }//GEN-LAST:event_customerListMIActionPerformed

    private void storeListMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeListMIActionPerformed
        showReport("reports/STORE_LIST.jasper");
    }//GEN-LAST:event_storeListMIActionPerformed

    private void representativeListMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_representativeListMIActionPerformed
        showReport("reports/REP_LIST.jasper");
    }//GEN-LAST:event_representativeListMIActionPerformed

    public void showReport(String reportURL) {
        reportViewer = new ReportUtil(reportURL);
        reportViewer.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.add(reportViewer);
        try {
            reportViewer.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem backUPMenuItem;
    private javax.swing.JMenuItem barcodeMenuItem;
    private javax.swing.JMenuItem changePasswordMI;
    private javax.swing.JMenuItem companyMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem crossedReorderLevelMI;
    private javax.swing.JMenuItem currentStockMI;
    private javax.swing.JMenuItem customerDueListMI;
    private javax.swing.JMenuItem customerListMI;
    private javax.swing.JMenuItem customerMI;
    private javax.swing.JMenuItem customerPaymentMI;
    private javax.swing.JMenuItem dailySalesReportMI;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem dosageMI;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem expenseHeadMI;
    private javax.swing.JMenuItem expenseMI;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem locationMI;
    private javax.swing.JMenuItem loginMI;
    private javax.swing.JMenuItem medicineConsumeMI;
    private javax.swing.JMenuItem medicineListMI;
    private javax.swing.JMenuItem medicineMI;
    private javax.swing.JMenu medicineMenu;
    private javax.swing.JMenuItem medicinePricingMI;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBasics;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuPurchaseSales;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenu menuSecurity;
    private javax.swing.JMenuItem monthlyPurchaseMenuItem;
    private javax.swing.JMenuItem outOfStockMI;
    private javax.swing.JMenuItem paymentReportMI;
    private javax.swing.JMenuItem prchaseReturnReportMI;
    private javax.swing.JMenuItem psTitleMI;
    private javax.swing.JMenuItem purchaseMI;
    private javax.swing.JMenuItem purchaseReportMI;
    private javax.swing.JMenuItem purchaseReturnMI;
    private javax.swing.JMenuItem purchaseReturnTakenMI;
    private javax.swing.JMenuItem repDuesMI;
    private javax.swing.JMenuItem repMI;
    private javax.swing.JMenuItem repPaymentMI;
    private javax.swing.JMenuItem representativeListMI;
    private javax.swing.JMenuItem salesDetailsMI;
    private javax.swing.JMenuItem salesMI;
    private javax.swing.JMenuItem salesReportMI;
    private javax.swing.JMenuItem salesReturnMI;
    private javax.swing.JMenuItem salesReturnReportMI;
    private javax.swing.JMenuItem salesSummaryMI;
    private javax.swing.JMenuItem singleMedicineBarcodeMI;
    private javax.swing.JMenuItem storeListMI;
    private javax.swing.JMenuItem storeMI;
    private javax.swing.JMenuItem storePaymentMI;
    private javax.swing.JMenuItem unitMI;
    private javax.swing.JMenuItem unitReportMI;
    private javax.swing.JMenuItem userMI;
    // End of variables declaration//GEN-END:variables

    User user;
}
