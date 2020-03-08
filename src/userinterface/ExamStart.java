/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import bo.Question;
import bo.ResultClass;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import service.Database;
import service.ExamService;

/**
 *
 * @author aditya
 */
public class ExamStart extends javax.swing.JPanel {

    private ExamService examService;
    private Database db = ApplicationRunner.getDatabase();
    private final ButtonGroup bg = new ButtonGroup();
    private List<Question> examQuestions;
    private int currentQuestionNumber = 1;
    private Question currentQuestion = null;
    private long examTime;
    private boolean flag;
    private boolean[] attemptStatus;
    private boolean[] x;
    private int score = 0;
    private int[] attemptedAns;

    /**
     * Creates new form ExamStart
     */
    public ExamStart() {
        initComponents();
        bg.add(jRadioButton_option1);
        bg.add(jRadioButton_option2);
        bg.add(jRadioButton_option3);
        bg.add(jRadioButton_option4);
        examService = new ExamService();

    }

    public void startExam(int uid) {
        examQuestions = examService.getExam(uid);
        startTime();
        attemptStatus = new boolean[examQuestions.size()];
        attemptedAns = new int[examQuestions.size()];
        x = new boolean[examQuestions.size()];
        displyQuestions();

    }

    public void startTime() {

        examTime = examService.getQuestionPaperTime();

        new Thread() {
            @Override
            public void run() {

                flag = true;
                while (flag) {

                    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(examTime),
                            TimeUnit.MILLISECONDS.toMinutes(examTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(examTime)),
                            TimeUnit.MILLISECONDS.toSeconds(examTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(examTime)));

                    jLabel_time.setText(hms);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ExamStart.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    examTime = examTime - 1000;
                    if (examTime <= 0) {
                        flag = false;
                    }
                }

                if (!flag) {
                    int attempted = 0;

                    for (int i = 0; i < examQuestions.size(); i++) {
                        if (attemptStatus[i]) {
                            attempted++;
                        }
                    }
                    ResultClass result = new ResultClass();
                    result.setAttempted(attempted);
                    result.setCorrect(score);
                    result.setSetid(db.getSetID());
                    result.setTotal(examQuestions.size());
                    result.setUid(ApplicationRunner.getMainFrame().getUserid());
                    /////submit
                    db.insertResult(result);
                    JOptionPane.showMessageDialog(ApplicationRunner.getMainFrame(), "The time is over and the Exam as been automatically submitted!\nThe results will be declared later\nThank you!", "Time Over!", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(1);
                }

            }

        }.start();
    }

    private void displyQuestions() {
        currentQuestion = examQuestions.get(currentQuestionNumber - 1);
        bg.clearSelection();

        jLabel_quesnumber.setText("Q" + currentQuestionNumber + ".");
        jLabel_question.setText(currentQuestion.getQuestion());
        jRadioButton_option1.setText("a) " + currentQuestion.getOption1());
        jRadioButton_option2.setText("b) " + currentQuestion.getOption2());
        jRadioButton_option3.setText("c) " + currentQuestion.getOption3());
        jRadioButton_option4.setText("d) " + currentQuestion.getOption4());

        prev_button.setEnabled(currentQuestionNumber != 1);

        next_button.setText(currentQuestionNumber == examQuestions.size() ? "Submit" : "Next");

        if (attemptStatus[currentQuestionNumber-1] == true) {
            if (attemptedAns[currentQuestionNumber-1] == 1) {
                jRadioButton_option1.setSelected(true);
            } else if (attemptedAns[currentQuestionNumber-1] == 2) {
                jRadioButton_option2.setSelected(true);
            } else if (attemptedAns[currentQuestionNumber-1] == 3) {
                jRadioButton_option3.setSelected(true);
            } else if (attemptedAns[currentQuestionNumber-1] == 4) {
                jRadioButton_option4.setSelected(true);
            }

        }

    }

    public void keepScore() {
        try {///////////////////////////////////////////////////////////////////////////////////
            if (attemptStatus[currentQuestionNumber-1] && x[currentQuestionNumber-1]) {

                if (currentQuestion.getAns() != attemptedAns[currentQuestionNumber-1]) {
                    score--;
                    x[currentQuestionNumber-1] = false;
                }

            }
            if (currentQuestion.getAns() == attemptedAns[currentQuestionNumber-1] && x[currentQuestionNumber-1] == false) {
                score++;
                x[currentQuestionNumber-1] = true;
            }
        } catch (Exception e) {
        }
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
        jRadioButton_option2 = new javax.swing.JRadioButton();
        jRadioButton_option3 = new javax.swing.JRadioButton();
        jRadioButton_option4 = new javax.swing.JRadioButton();
        prev_button = new javax.swing.JButton();
        next_button = new javax.swing.JButton();
        jLabel_question = new javax.swing.JLabel();
        timer_label = new javax.swing.JLabel();
        jRadioButton_option1 = new javax.swing.JRadioButton();
        jLabel_time = new javax.swing.JLabel();
        jLabel_quesnumber = new javax.swing.JLabel();
        JButton_clear = new javax.swing.JButton();

        jRadioButton_option2.setText("option2");
        jRadioButton_option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_option2ActionPerformed(evt);
            }
        });

        jRadioButton_option3.setText("option3");
        jRadioButton_option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_option3ActionPerformed(evt);
            }
        });

        jRadioButton_option4.setText("option4");
        jRadioButton_option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_option4ActionPerformed(evt);
            }
        });

        prev_button.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        prev_button.setText("Previous");
        prev_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev_buttonActionPerformed(evt);
            }
        });

        next_button.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        next_button.setText("Next");
        next_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_buttonActionPerformed(evt);
            }
        });

        jLabel_question.setText("question");

        timer_label.setText("TIme left:");

        jRadioButton_option1.setText("option1");
        jRadioButton_option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_option1ActionPerformed(evt);
            }
        });

        JButton_clear.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        JButton_clear.setText("Clear Selection");
        JButton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(timer_label)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel_time, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(prev_button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JButton_clear)
                                .addGap(185, 185, 185)
                                .addComponent(next_button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 22, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel_quesnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel_question, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jRadioButton_option2, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                                    .addComponent(jRadioButton_option1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                                    .addComponent(jRadioButton_option4, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                                    .addComponent(jRadioButton_option3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel_time, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_quesnumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_question, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton_option1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jRadioButton_option2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jRadioButton_option3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton_option4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prev_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButton_clear)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 32, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void next_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_buttonActionPerformed
        keepScore();

        if ((currentQuestionNumber == examQuestions.size())) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit the Exam ?", "Submit", JOptionPane.YES_NO_OPTION, EXIT_ON_CLOSE);
            if (choice == JOptionPane.YES_OPTION) {
                int attempted = 0;

                for (int i = 0; i < (examQuestions.size()); i++) {
                    if (attemptStatus[i]) {
                        attempted++;
                    }
                }
                ResultClass result = new ResultClass();
                result.setAttempted(attempted);
                result.setCorrect(score);
                result.setSetid(db.getSetID());
                result.setTotal(examQuestions.size());
                result.setUid(ApplicationRunner.getMainFrame().getUserid());
                /////submit
                db.insertResult(result);
                JOptionPane.showMessageDialog(this, "Exam Submitted!\nThe results will be declared later", "Submitted Succesfullt!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(1);
            }

//        } else if (next_button.getText().equals("Submit")) {
//            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit the Exam ?", "Submit", JOptionPane.YES_NO_OPTION, EXIT_ON_CLOSE);
//            if (choice == JOptionPane.YES_OPTION) {
//
//                int attempted = 0;
//
//                for (int i = 0; i < examQuestions.size(); i++) {
//                    if (attemptStatus[i]) {
//                        attempted++;
//                    }
//                }
//                ResultClass result = new ResultClass();
//                result.setAttempted(attempted);
//                result.setCorrect(score);
//                result.setSetid(db.getSetID());
//                result.setTotal(examQuestions.size());
//                result.setUid(ApplicationRunner.getMainFrame().getUserid());
//                /////submit
//                db.insertResult(result);
//                JOptionPane.showMessageDialog(this, "Exam Submitted!\nThe results will be declared later", "Submitted Succesfullt!", JOptionPane.INFORMATION_MESSAGE);
//                System.exit(1);
//            }
        } else {
            currentQuestionNumber++;
            displyQuestions();
        }

    }//GEN-LAST:event_next_buttonActionPerformed

    private void prev_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev_buttonActionPerformed

        keepScore();
        currentQuestionNumber--;
        displyQuestions();

    }//GEN-LAST:event_prev_buttonActionPerformed

    private void jRadioButton_option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_option1ActionPerformed
        attemptedAns[currentQuestionNumber-1] = 1;
        attemptStatus[currentQuestionNumber-1] = true;
        
    }//GEN-LAST:event_jRadioButton_option1ActionPerformed

    private void jRadioButton_option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_option2ActionPerformed
        attemptedAns[currentQuestionNumber-1] = 2;
        attemptStatus[currentQuestionNumber-1] = true;
    }//GEN-LAST:event_jRadioButton_option2ActionPerformed

    private void jRadioButton_option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_option3ActionPerformed
        attemptedAns[currentQuestionNumber-1] = 3;
        attemptStatus[currentQuestionNumber-1] = true;
    }//GEN-LAST:event_jRadioButton_option3ActionPerformed

    private void jRadioButton_option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_option4ActionPerformed
        attemptedAns[currentQuestionNumber-1] = 4;
        attemptStatus[currentQuestionNumber-1] = true;
    }//GEN-LAST:event_jRadioButton_option4ActionPerformed

    private void JButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_clearActionPerformed
        bg.clearSelection();
        attemptedAns[currentQuestionNumber] = 0;
        attemptStatus[currentQuestionNumber] = false;
    }//GEN-LAST:event_JButton_clearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButton_clear;
    private javax.swing.JLabel jLabel_quesnumber;
    private javax.swing.JLabel jLabel_question;
    private javax.swing.JLabel jLabel_time;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton_option1;
    private javax.swing.JRadioButton jRadioButton_option2;
    private javax.swing.JRadioButton jRadioButton_option3;
    private javax.swing.JRadioButton jRadioButton_option4;
    private javax.swing.JButton next_button;
    private javax.swing.JButton prev_button;
    private javax.swing.JLabel timer_label;
    // End of variables declaration//GEN-END:variables

}
