/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bo.Paper;
import bo.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import userinterface.ApplicationRunner;

/**
 *
 * @author aditya
 */
public class ExamService {

    Paper finalQuestionList=new Paper();
    List<Question> finalQuestions = new ArrayList<>();
    List<Question> allQues = ApplicationRunner.getDatabase().getAllQues();
    int lowLevelQuestions = 0;
    int medLevelQuestions = 0;
    int highLevelQuestions = 0;

    public List<Question> getExam(int uid) {
        finalQuestionList = ApplicationRunner.getDatabase().getFinalQuestionList(uid);
        if (finalQuestionList == null) {
            JOptionPane.showMessageDialog(ApplicationRunner.getMainFrame(), "ERROR!\n Pleases contact admin.\n NO exam is set!", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        lowLevelQuestions = finalQuestionList.getLowno();
        medLevelQuestions = finalQuestionList.getMedno();
        highLevelQuestions = finalQuestionList.getHighno();

        for (int i = 0; i < allQues.size(); i++) {
            Question question = allQues.get(new Random().nextInt(allQues.size() - 1));
            int diff = question.getDiff();

            if (lowLevelQuestions > 0 && diff == 1) {
                finalQuestions.add(question);
                lowLevelQuestions--;
                continue;
            } else if (medLevelQuestions > 0 && diff == 2) {
                finalQuestions.add(question);
                medLevelQuestions--;
                continue;
            } else if (highLevelQuestions > 0 && diff == 3) {
                finalQuestions.add(question);
                highLevelQuestions--;
                continue;
            }

        }

        return finalQuestions;

    }

    public long getQuestionPaperTime() {

        return finalQuestionList.getTime() * 1000;

    }

}
