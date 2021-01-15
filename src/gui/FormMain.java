/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.EmployeeEntity;
import java.net.URISyntaxException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class FormMain extends javax.swing.JFrame {

    private Boolean checkAdmin = false;
    private Home home;
    private AccountList accountList;
    private ProductList productList;
    private CouponList coupontList;
    private BillList billList;
    private CategoryList categoryList;
    private Statistic statistic;
    private RoleList roleList;
    public static EmployeeEntity em = null;

    /**
     * Creates new form FormMain
     */
    public FormMain(EmployeeEntity em, Boolean checkAdmin) throws URISyntaxException {
        this.checkAdmin = checkAdmin;
        initComponents();
        this.em = em;
        username.setText(em.getFullname());

        if (checkAdmin) {
            home = new Home();
            home.setName(em.getFullname());
            accountList = new AccountList();
            productList = new ProductList();
            roleList = new RoleList();
            coupontList = new CouponList(em);

            billList = new BillList(em);
            categoryList = new CategoryList();
            statistic = new Statistic();

            destop.add(home).setVisible(true);
            destop.add(productList);
            destop.add(accountList);
            destop.add(coupontList);
            destop.add(billList);
            destop.add(categoryList);
            destop.add(roleList);
            destop.add(statistic);
        } else {
            home = new Home();
            home.setName(em.getFullname());
            accountList = new AccountList();
            roleList = new RoleList();
            productList = new ProductList();
            coupontList = new CouponList(em);
            billList = new BillList(em);
            account.setEnabled(false);
            categoryList = new CategoryList();
            statistic = new Statistic();

            destop.add(home).setVisible(true);
            destop.add(productList);
            destop.add(accountList);
            destop.add(coupontList);
            destop.add(billList);
            destop.add(roleList);
            destop.add(categoryList);
            destop.add(statistic);
        }
    }

    public FormMain() throws URISyntaxException {
        initComponents();
    }

    public FormMain(EmployeeEntity em) throws URISyntaxException {
        initComponents();
        this.em = em;
        username.setText(em.getFullname());
        home = new Home();
        accountList = new AccountList();
        productList = new ProductList();
        coupontList = new CouponList(em);
        billList = new BillList();
        categoryList = new CategoryList();
        roleList = new RoleList();
        statistic = new Statistic();

        destop.add(home).setVisible(true);
        destop.add(productList);
        destop.add(accountList);
        destop.add(coupontList);
        destop.add(billList);
        destop.add(categoryList);
        destop.add(roleList);
        destop.add(statistic);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnStore = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        product = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        couponShow = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        account = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnRoleList = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btnCategoryList = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnShowBillList = new javax.swing.JLabel();
        destop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lí Cửa Hàng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnLogout.setBackground(new java.awt.Color(0, 0, 0));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/exit.png"))); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_settings_30px.png"))); // NOI18N

        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("User Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(username)
                .addGap(476, 476, 476)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(username)))
                        .addGap(4, 4, 4)))
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_small_business_30px_3.png"))); // NOI18N

        btnStore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStore.setForeground(new java.awt.Color(255, 255, 255));
        btnStore.setText("Cửa Hàng");
        btnStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStoreMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_truck_30px.png"))); // NOI18N

        product.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        product.setForeground(new java.awt.Color(255, 255, 255));
        product.setText("Sản Phẩm");
        product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_multiple_smartphones_30px.png"))); // NOI18N

        couponShow.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        couponShow.setForeground(new java.awt.Color(255, 255, 255));
        couponShow.setText("Phiếu Nhập");
        couponShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                couponShowMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nhân Viên");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_assistant_30px.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_key_30px.png"))); // NOI18N

        account.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        account.setForeground(new java.awt.Color(255, 255, 255));
        account.setText("Tài Khoản");
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountMouseClicked(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_police_badge_30px.png"))); // NOI18N

        btnRoleList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRoleList.setForeground(new java.awt.Color(255, 255, 255));
        btnRoleList.setText("Quyền");
        btnRoleList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRoleListMouseClicked(evt);
            }
        });

        btnCategoryList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCategoryList.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoryList.setText("Loại Sản Phẩm");
        btnCategoryList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCategoryListMouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_dossier_folder_30px.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_agreement_30px.png"))); // NOI18N

        btnShowBillList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnShowBillList.setForeground(new java.awt.Color(255, 255, 255));
        btnShowBillList.setText("Hóa Đơn");
        btnShowBillList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowBillListMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStore)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(couponShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator5)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCategoryList, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(btnShowBillList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRoleList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(btnCategoryList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnShowBillList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(couponShow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRoleList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)))
                .addGap(29, 29, 29)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        destop.setAutoscrolls(true);

        javax.swing.GroupLayout destopLayout = new javax.swing.GroupLayout(destop);
        destop.setLayout(destopLayout);
        destopLayout.setHorizontalGroup(
            destopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        destopLayout.setVerticalGroup(
            destopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(destop))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(destop)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseClicked
        if (checkAdmin) {
            home.setVisible(false);
            productList.setVisible(false);
            coupontList.setVisible(false);
            billList.setVisible(false);
            categoryList.setVisible(false);
            roleList.setVisible(false);
            accountList.setVisible(true);
            statistic.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Bạn Không Có Quyền Truy Cập");
        }
    }//GEN-LAST:event_accountMouseClicked

    private void productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMouseClicked
        home.setVisible(false);
        billList.setVisible(false);
        coupontList.setVisible(false);
        accountList.setVisible(false);
        categoryList.setVisible(false);
        roleList.setVisible(false);
        productList.setVisible(true);
        statistic.setVisible(false);
    }//GEN-LAST:event_productMouseClicked

    private void couponShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_couponShowMouseClicked
        home.setVisible(false);
        billList.setVisible(false);
        coupontList.setVisible(true);
        accountList.setVisible(false);
        roleList.setVisible(false);
        categoryList.setVisible(false);
        productList.setVisible(false);
        statistic.setVisible(false);
    }//GEN-LAST:event_couponShowMouseClicked

    private void btnShowBillListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowBillListMouseClicked
        home.setVisible(false);
        billList.setVisible(true);
        roleList.setVisible(false);
        coupontList.setVisible(false);
        accountList.setVisible(false);
        categoryList.setVisible(false);
        productList.setVisible(false);
        statistic.setVisible(false);
    }//GEN-LAST:event_btnShowBillListMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed

        int opcion = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất?", "CẢNH BÁO!", JOptionPane.YES_NO_OPTION);
        if (opcion == 0) {
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCategoryListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoryListMouseClicked
        home.setVisible(false);
        billList.setVisible(false);
        roleList.setVisible(false);
        coupontList.setVisible(false);
        accountList.setVisible(false);
        categoryList.setVisible(true);
        productList.setVisible(false);
        statistic.setVisible(false);
    }//GEN-LAST:event_btnCategoryListMouseClicked

    private void btnRoleListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoleListMouseClicked
        home.setVisible(false);
        billList.setVisible(false);
        roleList.setVisible(true);
        coupontList.setVisible(false);
        accountList.setVisible(false);
        categoryList.setVisible(false);
        productList.setVisible(false);
        statistic.setVisible(false);
    }//GEN-LAST:event_btnRoleListMouseClicked

    private void btnStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStoreMouseClicked
        home.setVisible(false);
        billList.setVisible(false);
        roleList.setVisible(false);
        coupontList.setVisible(false);
        accountList.setVisible(false);
        categoryList.setVisible(false);
        productList.setVisible(false);
        statistic.setVisible(true);
    }//GEN-LAST:event_btnStoreMouseClicked
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new FormMain().setVisible(true);
//                } catch (URISyntaxException ex) {
//                    Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel account;
    private javax.swing.JLabel btnCategoryList;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel btnRoleList;
    private javax.swing.JLabel btnShowBillList;
    private javax.swing.JLabel btnStore;
    private javax.swing.JLabel couponShow;
    private javax.swing.JDesktopPane destop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel product;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
