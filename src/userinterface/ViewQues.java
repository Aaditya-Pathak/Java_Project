/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import bo.Question;
import static java.awt.Frame.NORMAL;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import service.Database;

/**
 *
 * @author aditya
 */
public class ViewQues extends javax.swing.JInternalFrame {

    Database db = ApplicationRunner.getDatabase();
    Question ques = new Question();
    boolean clicked = false;

    /**
     * Creates new form vVewQues
     */
    public ViewQues() {
        initComponents();
        settable();
    }

    public void getmodvalue() {
        ques.setQuestion(jTextField_question.getText());
        ques.setOption1(jTextField_option1.getText());
        ques.setOption2(jTextField_option2.getText());
        ques.setOption3(jTextField_option3.getText());
        ques.setOption4(jTextField_option4.getText());
        ques.setAns(Integer.parseInt(jTextField_ans.getText()));
        ques.setDiff(Integer.parseInt(jTextField_diff.getText()));
        ques.setQid(Integer.parseInt(jLabel_qid.getText()));

    }

    public void settable() {
        String[] columnNames = {"Question", "Difficulty Level", "Ans", "Option1", "Option2", "Option3", "Option4", "QID"};

        DefaultTableModel model = db.getQuestionTableModel();
        String quesdata[][] = db.getQuesdata();
        model.setColumnIdentifiers(columnNames);
        QuesTable.setModel(model);
        for (int i = 0; i < QuesTable.getRowCount(); i++) {
            for (int j = 0; j < 8; j++) {
                QuesTable.setValueAt(quesdata[i][j], i, j);
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        QuesTable = new javax.swing.JTable();
        DetailsPanel = new javax.swing.JPanel();
        qidLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        option1Label = new javax.swing.JLabel();
        option2Label = new javax.swing.JLabel();
        option3Label = new javax.swing.JLabel();
        optoin4Label = new javax.swing.JLabel();
        ansLabel = new javax.swing.JLabel();
        difflevelLabel = new javax.swing.JLabel();
        jTextField_ans = new javax.swing.JTextField();
        jTextField_diff = new javax.swing.JTextField();
        jTextField_question = new javax.swing.JTextField();
        jTextField_option1 = new javax.swing.JTextField();
        jTextField_option2 = new javax.swing.JTextField();
        jTextField_option3 = new javax.swing.JTextField();
        jTextField_option4 = new javax.swing.JTextField();
        jLabel_qid = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editques = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        remQues = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setAutoscrolls(true);

        QuesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        QuesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(QuesTable);

        DetailsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        qidLabel.setText("Question Id :");

        questionLabel.setText("Question : ");

        option1Label.setText("Option 1 : ");

        option2Label.setText("Option 2 :");

        option3Label.setText("Option 3 :");

        optoin4Label.setText("Option 4 :");

        ansLabel.setText("Answer Option No. : ");

        difflevelLabel.setText("Difficulty Level :  ");

        javax.swing.GroupLayout DetailsPanelLayout = new javax.swing.GroupLayout(DetailsPanel);
        DetailsPanel.setLayout(DetailsPanelLayout);
        DetailsPanelLayout.setHorizontalGroup(
            DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                        .addComponent(ansLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ans, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(difflevelLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_diff, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qidLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_qid, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(optoin4Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(option3Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(option2Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(option1Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(questionLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_question)
                            .addComponent(jTextField_option1)
                            .addComponent(jTextField_option2)
                            .addComponent(jTextField_option3)
                            .addComponent(jTextField_option4))))
                .addGap(23, 23, 23))
        );
        DetailsPanelLayout.setVerticalGroup(
            DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetailsPanelLayout.createSequentialGroup()
                        .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ansLabel)
                            .addComponent(difflevelLabel)
                            .addComponent(jTextField_ans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_diff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qidLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel_qid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionLabel)
                    .addComponent(jTextField_question, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_option1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option2Label)
                    .addComponent(jTextField_option2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option3Label)
                    .addComponent(jTextField_option3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optoin4Label)
                    .addComponent(jTextField_option4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setText("View Question :");

        editques.setText("Save Changes");
        editques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editquesActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        remQues.setText("Remove Question");
        remQues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remQuesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DetailsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(314, 314, 314)))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editques)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remQues)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editques)
                    .addComponent(refresh)
                    .addComponent(remQues))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editquesActionPerformed

        if (clicked) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want Save the changes ?", "Edit", NORMAL);
            if (choice == JOptionPane.YES_OPTION) {
                getmodvalue();
                db.modifiQues(ques);
                JOptionPane.showMessageDialog(this, "Changes saved!");
                settable();
                clicked = false;
                jTextField_ans.setText("");
                jTextField_diff.setText("");
                jTextField_question.setText("");
                jTextField_option1.setText("");
                jTextField_option2.setText("");
                jTextField_option3.setText("");
                jTextField_option4.setText("");
                jLabel_qid.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pleases select a row to edit!!");
        }

    }//GEN-LAST:event_editquesActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed

        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want refresh table the changes made in row will be lost?", "Refresh", NORMAL);
        if (choice == JOptionPane.YES_OPTION) {
            settable();
            jTextField_ans.setText("");
            jTextField_diff.setText("");
            jTextField_question.setText("");
            jTextField_option1.setText("");
            jTextField_option2.setText("");
            jTextField_option3.setText("");
            jTextField_option4.setText("");
            jLabel_qid.setText("");
        }
        clicked = false;
    }//GEN-LAST:event_refreshActionPerformed

    private void remQuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remQuesActionPerformed

        if (clicked) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want remove the selected user?", "Remove", NORMAL);
            if (choice == JOptionPane.YES_OPTION) {
                getmodvalue();
                db.removeQues(ques);
                settable();
                clicked = false;
                jTextField_ans.setText("");
                jTextField_diff.setText("");
                jTextField_question.setText("");
                jTextField_option1.setText("");
                jTextField_option2.setText("");
                jTextField_option3.setText("");
                jTextField_option4.setText("");
                jLabel_qid.setText("");
                JOptionPane.showMessageDialog(this, "ques removed");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pleases select a row to delete!!");
        }

    }//GEN-LAST:event_remQuesActionPerformed

    private void QuesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuesTableMouseClicked

            clicked = true;
            int row = QuesTable.getSelectedRow();
            settable();
            TableModel t = QuesTable.getModel();
            String[][] data = db.getQuesdata();
            jTextField_question.setText((String) t.getValueAt(row, 0));
            jTextField_diff.setText((String) t.getValueAt(row, 1));
            jTextField_ans.setText((String) t.getValueAt(row, 2));
            jTextField_option1.setText(data[row][3]);
            jTextField_option2.setText(data[row][4]);
            jTextField_option3.setText(data[row][5]);
            jTextField_option4.setText(data[row][6]);
            jLabel_qid.setText(data[row][7]);

    }//GEN-LAST:event_QuesTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DetailsPanel;
    private javax.swing.JTable QuesTable;
    private javax.swing.JLabel ansLabel;
    private javax.swing.JLabel difflevelLabel;
    private javax.swing.JButton editques;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_qid;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_ans;
    private javax.swing.JTextField jTextField_diff;
    private javax.swing.JTextField jTextField_option1;
    private javax.swing.JTextField jTextField_option2;
    private javax.swing.JTextField jTextField_option3;
    private javax.swing.JTextField jTextField_option4;
    private javax.swing.JTextField jTextField_question;
    private javax.swing.JLabel option1Label;
    private javax.swing.JLabel option2Label;
    private javax.swing.JLabel option3Label;
    private javax.swing.JLabel optoin4Label;
    private javax.swing.JLabel qidLabel;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JButton refresh;
    private javax.swing.JButton remQues;
    // End of variables declaration//GEN-END:variables

}
