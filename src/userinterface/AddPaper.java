/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import bo.Paper;
import bo.User;
import java.util.*;
import javax.swing.JOptionPane;
import service.Database;

/**
 *
 * @author aditya
 */
public class AddPaper extends javax.swing.JInternalFrame {

    private int setid, Uid, ll, ml, hl, total_questions;
    private Date total;
    private Database db = ApplicationRunner.getDatabase();
    private Paper paper = new Paper();
    private long timeForExam;
    private String[] listData;

    /**
     * Creates new form SetExam
     */
    public AddPaper() {
        initComponents();
        listData = new String[db.getAllUser().size()];
        setUserList();
        setSetId();
    }

    private void setUserList() {
        jComboBox_uid.removeAll();
        int i = 0;
        List<User> allUser = db.getAllUser();
        allUser.forEach((user) -> {
            jComboBox_uid.addItem(user.getUid() + "-" + user.getName());
        });

    }

    private void setSetId() {

        if (db.getSetid() > 0) {
            if (paper.getSetid() != db.getSetid()) {
                paper.setSetid(db.getSetid());
            }
        } else {
            paper.setSetid(0);
        }
        jLabel_setid.setText(Integer.toString(paper.getSetid() + 1));
    }

    private void addtopaper() {

        paper.setUid(Uid);
        paper.setLowno(ll);
        paper.setMedno(ml);
        paper.setHighno(hl);
        paper.setTime(timeForExam);
        paper.setSetid(paper.getSetid() + 1);
        db.insertSet(paper);

    }

    private void AddData() {
        String[] x = jComboBox_uid.getSelectedItem().toString().split("-");
        Uid = Integer.parseInt(x[0]);
        ll = Integer.parseInt(jTextField_low.getText());
        ml = Integer.parseInt(jTextField_med.getText());
        hl = Integer.parseInt(jTextField_high.getText());

    }

    private void settime() {
        AddData();
        timeForExam = 0;
        timeForExam = timeForExam + (ll * 60);
        timeForExam = timeForExam + (ml * 120);
        timeForExam = timeForExam + (hl * 150);
        jLabel_time.setText(timeForExam + "sec");
    }

    private boolean checkall() {

        if ((Uid != 0 && ll != 0 && ml != 0 && hl != 0) || (ll != 0 && Uid != 0) || (ml != 0 && Uid != 0) || (hl != 0 && Uid != 0)) {
            return true;
        }
        return false;

    }

    public void reset() {
        jTextField_low.setText("");
        jTextField_med.setText("");
        jTextField_high.setText("");
        jLabel_time.setText("");
        setSetId();
    }

    public boolean checkuid() {
        db.getAllUserTable();
        return !db.checkUidValidity(Uid);
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
        setpaper = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        setidLabel = new javax.swing.JLabel();
        uidLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_high = new javax.swing.JTextField();
        jTextField_low = new javax.swing.JTextField();
        jTextField_med = new javax.swing.JTextField();
        jLabel_time = new javax.swing.JLabel();
        jLabel_setid = new javax.swing.JLabel();
        TimeLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_uid = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        setpaper.setText("Set Paper");
        setpaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setpaperActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setText("Add Paper");

        setidLabel.setText("Set Id : ");

        uidLabel.setText("User Id :");

        jLabel2.setText("No. of Low level Difficulty Questions       : ");

        jLabel3.setText("No. of Medium level Difficulty Questions : ");

        jLabel4.setText("No. of High level Difficulty Questions       : ");

        jTextField_high.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_highActionPerformed(evt);
            }
        });

        jTextField_low.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_lowActionPerformed(evt);
            }
        });

        jTextField_med.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_medActionPerformed(evt);
            }
        });

        jLabel_time.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_timeMouseEntered(evt);
            }
        });

        TimeLabel1.setText("Total Examination Time :");

        jLabel5.setText("Press Enter after entering number of questions to get total time");

        jComboBox_uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_uidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TimeLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(314, 314, 314))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_high, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_med, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uidLabel)
                                    .addComponent(jLabel2)
                                    .addComponent(setidLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_setid, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(jTextField_low, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(jComboBox_uid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(268, 268, 268))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setpaper)
                .addGap(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_setid, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_uid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(setidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_low, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_med, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_high, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_time, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(setpaper)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setpaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setpaperActionPerformed

        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you set the Exam ?", "Submit", JOptionPane.YES_NO_OPTION, EXIT_ON_CLOSE);
        if (choice == JOptionPane.YES_OPTION) {
            AddData();
            if (checkall()) {
                if (checkuid()) {
                    settime();
                    addtopaper();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a valid user id of a existing user!!!! ");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter all fields ");
            }
        }

    }//GEN-LAST:event_setpaperActionPerformed


    private void jTextField_highActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_highActionPerformed
        settime();
    }//GEN-LAST:event_jTextField_highActionPerformed

    private void jTextField_lowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_lowActionPerformed
        settime();
    }//GEN-LAST:event_jTextField_lowActionPerformed

    private void jTextField_medActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_medActionPerformed
        settime();
    }//GEN-LAST:event_jTextField_medActionPerformed

    private void jLabel_timeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_timeMouseEntered

    }//GEN-LAST:event_jLabel_timeMouseEntered

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered

    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved

    }//GEN-LAST:event_jPanel1MouseMoved

    private void jComboBox_uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_uidActionPerformed

    }//GEN-LAST:event_jComboBox_uidActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TimeLabel1;
    private javax.swing.JComboBox<String> jComboBox_uid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_setid;
    private javax.swing.JLabel jLabel_time;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_high;
    private javax.swing.JTextField jTextField_low;
    private javax.swing.JTextField jTextField_med;
    private javax.swing.JLabel setidLabel;
    private javax.swing.JButton setpaper;
    private javax.swing.JLabel uidLabel;
    // End of variables declaration//GEN-END:variables
}
