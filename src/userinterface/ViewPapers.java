/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import bo.Paper;
import static java.awt.Frame.NORMAL;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import service.Database;

/**
 *
 * @author aditya
 */
public class ViewPapers extends javax.swing.JInternalFrame {

    private Database db = ApplicationRunner.getDatabase();
    private Paper paper = new Paper();
    private boolean clicked = false;
    private int hrs, min, sec;

    /**
     * Creates new form ViewPapers
     */
    public ViewPapers() {
        initComponents();
        settable();
    }

    public void settable() {
        String[] columnNames = {"SetId", "UserId", "Low level", "Med level", "High level", "Time"};
        DefaultTableModel model = db.getAllPapers();
        int data[][] = db.getSetdata();
        model.setColumnIdentifiers(columnNames);
        SetTable.setModel(model);
        for (int i = 0; i < SetTable.getRowCount(); i++) {
            for (int j = 0; j < 6; j++) {
                SetTable.setValueAt(data[i][j], i, j);
            }
        }

    }

    private void setmodvalue() {

        paper.setUid(Integer.parseInt(jTextField_uid.getText()));
        paper.setLowno(Integer.parseInt(jTextField_low.getText()));
        paper.setMedno(Integer.parseInt(jTextField_med.getText()));
        paper.setHighno(Integer.parseInt(jTextField_high.getText()));
        paper.setSetid(Integer.parseInt(jLabel_setid.getText()));
        System.out.print(jLabel_setid.getText());

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
        DetailsPanel = new javax.swing.JPanel();
        setidLabel = new javax.swing.JLabel();
        uidLabel = new javax.swing.JLabel();
        llLabel = new javax.swing.JLabel();
        hlLabel = new javax.swing.JLabel();
        mlLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jTextField_uid = new javax.swing.JTextField();
        jTextField_low = new javax.swing.JTextField();
        jTextField_med = new javax.swing.JTextField();
        jTextField_high = new javax.swing.JTextField();
        jLabel_total = new javax.swing.JLabel();
        jLabel_setid = new javax.swing.JLabel();
        timeLabel1 = new javax.swing.JLabel();
        jLabel_time = new javax.swing.JLabel();
        removepaper = new javax.swing.JButton();
        editpaper = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SetTable = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DetailsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        setidLabel.setText("Set Id : ");

        uidLabel.setText("For User Id : ");

        llLabel.setText("No. of Low Difficulty Questions :  ");

        hlLabel.setText("No. of High Difficulty Questions :  ");

        mlLabel.setText("No. of Med Difficulty Questions :  ");

        timeLabel.setText("Total no.of questions : ");

        timeLabel1.setText("Total ExamTime : ");

        javax.swing.GroupLayout DetailsPanelLayout = new javax.swing.GroupLayout(DetailsPanel);
        DetailsPanel.setLayout(DetailsPanelLayout);
        DetailsPanelLayout.setHorizontalGroup(
            DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetailsPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mlLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(llLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DetailsPanelLayout.createSequentialGroup()
                                .addComponent(setidLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_setid, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_med, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_high, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DetailsPanelLayout.createSequentialGroup()
                                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_low, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_uid, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                                        .addComponent(timeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                                        .addComponent(timeLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_time, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(uidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hlLabel))
                .addGap(55, 55, 55))
        );
        DetailsPanelLayout.setVerticalGroup(
            DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetailsPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(setidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_setid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_uid)))
                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_time, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_low))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_med))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_high))
                .addContainerGap())
        );

        removepaper.setText("Remove Paper");
        removepaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removepaperActionPerformed(evt);
            }
        });

        editpaper.setText("Save Changes");
        editpaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpaperActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setText("View QuestionPapers :");

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        SetTable.setModel(new javax.swing.table.DefaultTableModel(
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
        SetTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SetTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh)
                .addGap(18, 18, 18)
                .addComponent(editpaper)
                .addGap(18, 18, 18)
                .addComponent(removepaper)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removepaper)
                    .addComponent(editpaper)
                    .addComponent(refresh))
                .addContainerGap(79, Short.MAX_VALUE))
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

    private void editpaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editpaperActionPerformed

        if (clicked) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want Save the changes ?", "Edit", NORMAL);
            if (choice == JOptionPane.YES_OPTION) {
                setmodvalue();
                db.modifiSet(paper);
                jLabel_setid.setText("");
                jTextField_uid.setText("");
                jTextField_low.setText("");
                jTextField_med.setText("");
                jTextField_high.setText("");
                jLabel_time.setText("");
                jLabel_total.setText("");
                clicked = false;
                settable();
                JOptionPane.showMessageDialog(this, "Changes saved!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pleases select a row to edit!!");
        }
    }//GEN-LAST:event_editpaperActionPerformed

    private void removepaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removepaperActionPerformed

        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want remove the Paper ?", "Remove", NORMAL);
        if (choice == JOptionPane.YES_OPTION) {
            setmodvalue();
            db.removeSet(paper);
            jLabel_setid.setText("");
            jTextField_uid.setText("");
            jTextField_low.setText("");
            jTextField_med.setText("");
            jTextField_high.setText("");
            jLabel_time.setText("");
            jLabel_total.setText("");
            clicked = false;
            settable();
            JOptionPane.showMessageDialog(this, "Paper removed!");
        } else {
            JOptionPane.showMessageDialog(this, "Pleases select a row to remove!!");
        }

    }//GEN-LAST:event_removepaperActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed

        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want refresh ?\n Note : The changes made to the the row will be lost!!", "Refresh", NORMAL);
        if (choice == JOptionPane.YES_OPTION) {
            jLabel_setid.setText("");
            jTextField_uid.setText("");
            jTextField_low.setText("");
            jTextField_med.setText("");
            jTextField_high.setText("");
            jLabel_time.setText("");
            jLabel_total.setText("");
            settable();
            clicked = false;
        }

    }//GEN-LAST:event_refreshActionPerformed

    private void SetTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetTableMouseClicked

        int row = SetTable.getSelectedRow();
        TableModel t = SetTable.getModel();

        jLabel_setid.setText(Integer.toString((int) t.getValueAt(row, 0)));
        jTextField_uid.setText(Integer.toString((int) t.getValueAt(row, 1)));
        jTextField_low.setText(Integer.toString((int) t.getValueAt(row, 2)));
        jTextField_med.setText(Integer.toString((int) t.getValueAt(row, 3)));
        jTextField_high.setText(Integer.toString((int) t.getValueAt(row, 4)));
        int[][] data = db.getSetdata();
        //set total time label
        int sum = data[row][2] + data[row][3] + data[row][4];
        jLabel_total.setText(Integer.toString(sum));
        //set time label
        jLabel_time.setText(Integer.toString(data[row][5]) + "sec");
        clicked = true;

    }//GEN-LAST:event_SetTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DetailsPanel;
    private javax.swing.JTable SetTable;
    private javax.swing.JButton editpaper;
    private javax.swing.JLabel hlLabel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_setid;
    private javax.swing.JLabel jLabel_time;
    private javax.swing.JLabel jLabel_total;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_high;
    private javax.swing.JTextField jTextField_low;
    private javax.swing.JTextField jTextField_med;
    private javax.swing.JTextField jTextField_uid;
    private javax.swing.JLabel llLabel;
    private javax.swing.JLabel mlLabel;
    private javax.swing.JButton refresh;
    private javax.swing.JButton removepaper;
    private javax.swing.JLabel setidLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeLabel1;
    private javax.swing.JLabel uidLabel;
    // End of variables declaration//GEN-END:variables
}
