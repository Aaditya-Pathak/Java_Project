/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import bo.*;
import service.Database;

/**
 *
 * @author aditya
 */
public class AddUser extends javax.swing.JInternalFrame {

    Database db = ApplicationRunner.getDatabase();
  
    String uname, Mobno, uadl, uemail, applypost, password, idnum;
    int uid;

    /**
     * Creates new form AddUser1
     */
    public AddUser() {

        initComponents();
        setuidlabel();
    }

    private void setuidlabel() {
        if(db.getuid()!=0)
           jLabel_uid.setText("" + db.getuid());
        else
            jLabel_uid.setText("1");
       
    }

    private boolean checkall() {

            if (!Mobno.equals("") && !idnum.equals("") && !password.equals("") && !uemail.equals("") && !uadl.equals("") && !uname.equals("") && !applypost.equals("")) {
                return true;
            }
            return false;

    }

    private void addtouser() {
        
        User user=new User();
        user.setEmail(uemail);
        user.setName(uname);
        user.setMobno(Mobno);
        user.setApplypost(applypost);
        user.setIdno(idnum);
        user.setPassword(password);
        user.setAddress(uadl);
        user.setUid(uid);
        db.insertUser(user);
    }

    private void setVar() {
        uemail = emailid.getText();
        uname = Name.getText();
        idnum = idno.getText();
        Mobno = mobno.getText();
        uadl = addline.getText();
        password = password_u.getText();
        applypost = applyingpost.getText();
        uid=Integer.valueOf(jLabel_uid.getText());
    }

    private void reset() {
        emailid.setText("");
        Name.setText("");
        idno.setText("");
        mobno.setText("");
        addline.setText("");
        password_u.setText("");
        applyingpost.setText("");
        setuidlabel();
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
        password_label = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        userid_label = new javax.swing.JLabel();
        apply_label = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        idno = new javax.swing.JTextField();
        emailid = new javax.swing.JTextField();
        mobno = new javax.swing.JTextField();
        addline = new javax.swing.JTextField();
        applyingpost = new javax.swing.JTextField();
        submit_user = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();
        password_u = new javax.swing.JTextField();
        email_label = new javax.swing.JLabel();
        Mobno_label = new javax.swing.JLabel();
        jLabel_uid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setDoubleBuffered(true);
        setFocusCycleRoot(false);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        password_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        password_label.setText("Password :");

        Address.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Address.setText("Home Address :");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Identication Card No.:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Allocate Details to Candidate :");

        userid_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        userid_label.setText("UserId :");

        apply_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        apply_label.setText("Applying for Post of :");

        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        idno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idnoActionPerformed(evt);
            }
        });

        emailid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailidActionPerformed(evt);
            }
        });

        mobno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobnoActionPerformed(evt);
            }
        });

        addline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addlineActionPerformed(evt);
            }
        });

        applyingpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyingpostActionPerformed(evt);
            }
        });

        submit_user.setText("Submit User");
        submit_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_userActionPerformed(evt);
            }
        });

        name_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        name_label.setText("Name (Full) :");

        password_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_uActionPerformed(evt);
            }
        });

        email_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        email_label.setText("Email Id :");

        Mobno_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Mobno_label.setText("Mobile No.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email_label)
                            .addComponent(Mobno_label)
                            .addComponent(jLabel8)
                            .addComponent(name_label))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailid, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobno, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idno, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userid_label)
                                    .addComponent(password_label)
                                    .addComponent(Address))
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(apply_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addline, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                .addGap(62, 62, 62))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(submit_user)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(password_u, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(applyingpost, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_uid, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_label))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(idno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_label)
                    .addComponent(emailid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mobno_label)
                    .addComponent(mobno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Address)
                    .addComponent(addline, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userid_label)
                    .addComponent(jLabel_uid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_label)
                    .addComponent(password_u, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apply_label)
                    .addComponent(applyingpost, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submit_user)
                .addGap(160, 160, 160))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setText("Add User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submit_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_userActionPerformed

        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit ?", "Submit", JOptionPane.YES_NO_OPTION, EXIT_ON_CLOSE);
      
        if (choice == JOptionPane.YES_OPTION) {
             setVar();
            if (checkall()) {
                 
                addtouser();
                reset();
                JOptionPane.showMessageDialog(this, "User added!");
            } else {
                JOptionPane.showMessageDialog(this, "Error\nPlease enter all feilds!");
            }

        }
    }//GEN-LAST:event_submit_userActionPerformed


    private void emailidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailidActionPerformed
        uemail = emailid.getText();
    }//GEN-LAST:event_emailidActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        uname = Name.getText();
    }//GEN-LAST:event_NameActionPerformed

    private void idnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idnoActionPerformed
        idnum = idno.getText();
    }//GEN-LAST:event_idnoActionPerformed

    private void mobnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobnoActionPerformed
        Mobno = mobno.getText();
    }//GEN-LAST:event_mobnoActionPerformed

    private void addlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addlineActionPerformed
        uadl = addline.getText();
    }//GEN-LAST:event_addlineActionPerformed

    private void password_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_uActionPerformed
        password = password_u.getText();
    }//GEN-LAST:event_password_uActionPerformed

    private void applyingpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyingpostActionPerformed
        applypost = applyingpost.getText();
    }//GEN-LAST:event_applyingpostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JLabel Mobno_label;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField addline;
    private javax.swing.JLabel apply_label;
    private javax.swing.JTextField applyingpost;
    private javax.swing.JLabel email_label;
    private javax.swing.JTextField emailid;
    private javax.swing.JTextField idno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_uid;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mobno;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel password_label;
    private javax.swing.JTextField password_u;
    private javax.swing.JButton submit_user;
    private javax.swing.JLabel userid_label;
    // End of variables declaration//GEN-END:variables
}
