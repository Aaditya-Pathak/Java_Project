/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import bo.User;
import static java.awt.Frame.NORMAL;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import service.Database;

/**
 *
 * @author aditya
 */
public class ViewUser extends javax.swing.JInternalFrame {

    private Connection connection;
    private Database db = ApplicationRunner.getDatabase();
    private boolean clicked = false;

    /**
     * Creates new form viewUser
     */
    public ViewUser() {
        initComponents();
        settable();
    }

    public void settable() {

        String[] columnNames = {"Username", "Mobile Number", "Id number", "Email ID", "Password"};
        DefaultTableModel model = db.getAllUserTable();
        String data[][] = db.getUserdata();
        model.setColumnIdentifiers(columnNames);
        jTable1.setModel(model);
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            for (int j = 0; j < 5; j++) {
                jTable1.setValueAt(data[i][j], i, j);
            }
        }

    }

    private User getmodvalue() {
        User user = new User();
        user.setUid(Integer.parseInt(jLabel_uid.getText()));
        user.setName(jTextField_username.getText());
        user.setEmail(jTextField_email.getText());
        user.setPassword(jTextField_password.getText());
        user.setIdno(jTextField_idno.getText());
        user.setMobno(jTextField_mobile.getText());
        user.setAddress(jTextField_ad.getText());
        user.setApplypost(jTextField_applypost.getText());
        return user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DetailsPanel = new javax.swing.JPanel();
        uidLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jTextField_ad = new javax.swing.JTextField();
        jTextField_applypost = new javax.swing.JTextField();
        jTextField_mobile = new javax.swing.JTextField();
        jTextField_idno = new javax.swing.JTextField();
        jTextField_password = new javax.swing.JTextField();
        jLabel_uid = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        edituser = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jButton_remuser = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        DetailsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        uidLabel.setText("Userid :");

        nameLabel.setText("Name : ");

        emailLabel.setText("Email Id :");

        jLabel1.setText("Mobile No. : ");

        passwordLabel.setText("Password : ");

        jLabel2.setText("Post Applied for : ");

        jLabel3.setText("ID Card No. : ");

        jLabel4.setText("Home Address :");

        javax.swing.GroupLayout DetailsPanelLayout = new javax.swing.GroupLayout(DetailsPanel);
        DetailsPanel.setLayout(DetailsPanelLayout);
        DetailsPanelLayout.setHorizontalGroup(
            DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetailsPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addComponent(uidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetailsPanelLayout.createSequentialGroup()
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_ad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_applypost, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DetailsPanelLayout.createSequentialGroup()
                                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_uid, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_idno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(48, 48, 48))))
        );
        DetailsPanelLayout.setVerticalGroup(
            DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DetailsPanelLayout.createSequentialGroup()
                                .addComponent(uidLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(DetailsPanelLayout.createSequentialGroup()
                                .addComponent(jLabel_uid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)))
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_idno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_applypost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setText("View/Edit User :");

        edituser.setText("Save Changes");
        edituser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edituserActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jButton_remuser.setText("Remove User");
        jButton_remuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_remuserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refresh)
                        .addGap(18, 18, 18)
                        .addComponent(edituser)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_remuser)
                        .addGap(13, 13, 13)))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edituser)
                    .addComponent(refresh)
                    .addComponent(jButton_remuser))
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edituserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edituserActionPerformed

        if (clicked) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want Save the changes ?", "Edit", NORMAL);
            if (choice == JOptionPane.YES_OPTION) {
                User user = getmodvalue();
                db.setuser(user);
                db.modifiUser();
                settable();
                clicked = false;
                jTextField_username.setText("");
                jTextField_password.setText("");
                jTextField_email.setText("");
                jTextField_idno.setText("");
                jTextField_mobile.setText("");
                jTextField_ad.setText("");
                jTextField_applypost.setText("");
                jLabel_uid.setText("");
                JOptionPane.showMessageDialog(this, "Changes saved!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pleases select a row to edit!!");
        }

    }//GEN-LAST:event_edituserActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed

        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want refresh table the changes made in row will be lost?", "Refresh", NORMAL);
        if (choice == JOptionPane.YES_OPTION) {
            settable();
            jTextField_username.setText("");
            jTextField_password.setText("");
            jTextField_email.setText("");
            jTextField_idno.setText("");
            jTextField_mobile.setText("");
            jTextField_ad.setText("");
            jTextField_applypost.setText("");
            jLabel_uid.setText("");
            clicked = false;
        }

    }//GEN-LAST:event_refreshActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        clicked = true;
        int row = jTable1.getSelectedRow();
        settable();
        TableModel t = jTable1.getModel();
        jTextField_username.setText((String) t.getValueAt(row, 0));
        jTextField_mobile.setText((String) t.getValueAt(row, 1));
        jTextField_idno.setText((String) t.getValueAt(row, 2));
        jTextField_email.setText((String) t.getValueAt(row, 3));
        jTextField_password.setText((String) t.getValueAt(row, 4));
        String data[][] = db.getUserdata();
        jTextField_ad.setText(data[row][5]);
        jTextField_applypost.setText(data[row][6]);
        jLabel_uid.setText(data[row][7]);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_remuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_remuserActionPerformed

        if (clicked) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want remove the selected user?", "Remove", NORMAL);
            if (choice == JOptionPane.YES_OPTION) {
                User user = getmodvalue();
                db.setuser(user);
                boolean x = db.removeUser();
                settable();
                clicked = false;
                jTextField_username.setText("");
                jTextField_password.setText("");
                jTextField_email.setText("");
                jTextField_idno.setText("");
                jTextField_mobile.setText("");
                jTextField_ad.setText("");
                jTextField_applypost.setText("");
                jLabel_uid.setText("");
                if (x) {
                    JOptionPane.showMessageDialog(this, "user removed");
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Pleases select a row to delete!!");
        }
    }//GEN-LAST:event_jButton_remuserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DetailsPanel;
    private javax.swing.JButton edituser;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton jButton_remuser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_uid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_ad;
    private javax.swing.JTextField jTextField_applypost;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_idno;
    private javax.swing.JTextField jTextField_mobile;
    private javax.swing.JTextField jTextField_password;
    private javax.swing.JTextField jTextField_username;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton refresh;
    private javax.swing.JLabel uidLabel;
    // End of variables declaration//GEN-END:variables
}
