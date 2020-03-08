package service;

import bo.Paper;
import bo.Question;
import bo.ResultClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import bo.User;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import userinterface.ApplicationRunner;

/**
 *
 * @author aditya
 */
public class Database {

//////////////////////////////////////////////////declarations for user
    private String password, email, name, mobile, id, address, applypost;
    private int uid;
    private String[][] data;

//////////////////////////////////////////////////declarations for questions
    private String question, opt1, opt2, opt3, opt4;
    private int qid, ans, diff;
    private String[][] quesdata;

////////////////////////////////////////////////////declarations for papers
    private int setid, lowno, medno, highno, userid;
    private long time;
    private int[][] setdata;

    private Connection connection;
    String url = "jdbc:mysql://localhost:3306/exam";

    public Database() {

    }

    public boolean establishConnection(String username, String password) {
        try {

            if (connection != null) {
                connection.close();
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected succesfully");

        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public boolean isConnected() {
        try {
            if (connection == null) {
                return false;
            }
            return !connection.isClosed();
        } catch (Exception e) {
            return false;
        }
    }

////////////////////////////////////////////////////////user functions//////////////////////////////////////////////////////////////
    public boolean insertUser(User user) {
        try {
            if (!isConnected()) {
                return false;
            }

            PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO user (full_name, mobile_number, identification_number, email,address,password,applypost,uid)"
                    + "VALUES (?,?,?,?,?,?,?,?)");

            prepareStatement.setString(1, user.getName());
            prepareStatement.setString(2, user.getMobno());
            prepareStatement.setString(3, user.getIdno());
            prepareStatement.setString(4, user.getEmail());
            prepareStatement.setString(5, user.getAddress());
            prepareStatement.setString(6, user.getPassword());
            prepareStatement.setString(7, user.getApplypost());
            prepareStatement.setInt(8, user.getUid());
            prepareStatement.execute();
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean checkUidValidity(int uid) {

        if (!isConnected()) {
            return false;
        }
        PreparedStatement prepareStatement;
        try {
            String sql = "SELECT * FROM paper u WHERE u.uid = ?";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, uid);
            ResultSet rs = prepareStatement.executeQuery();
            return rs.next();

        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public int getuid() {
        try {
            int uid = 1;
            if (!isConnected()) {
            }
            PreparedStatement State = connection.prepareStatement("select * from user");
            ResultSet rs = State.executeQuery();
            rs.last();
            if (rs.isLast()) {
                uid = rs.getInt("uid");
                return uid + 1;
            }
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uid;
    }

    public boolean removeUser() {
        try {
            if (!isConnected()) {
                return false;
            }

            PreparedStatement prepareStatement = connection.prepareStatement("DELETE from user WHERE uid=? ");

            prepareStatement.setInt(1, u.getUid());
            prepareStatement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ApplicationRunner.getMainFrame(), "ERROR!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return false;
    }
    User u;

    public void setuser(User user) {
        u = user;
    }

    public boolean modifiUser() {
        try {
            if (!isConnected()) {
                return false;
            }
            PreparedStatement prepareStatement = connection.prepareStatement(" update user set full_name=?, mobile_number=?, identification_number=?, email=?,address=?,password=?,applypost=? where uid=?");
            prepareStatement.setString(1, u.getName());
            prepareStatement.setString(2, u.getMobno());
            prepareStatement.setString(3, u.getIdno());
            prepareStatement.setString(4, u.getEmail());
            prepareStatement.setString(5, u.getAddress());
            prepareStatement.setString(6, u.getPassword());
            prepareStatement.setString(7, u.getApplypost());
            prepareStatement.setInt(8, u.getUid());
            prepareStatement.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<User> getAllUser() {
        if (!isConnected()) {
            return null;
        }
        try {
            List<User> UserList = new ArrayList<>();
            PreparedStatement prepareStatement = connection.prepareStatement("select * from user");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("full_name");
                String Address = rs.getString("address");
                String emailid = rs.getString("email");
                String mobnum = rs.getString("mobile_number");
                String idnum = rs.getString("identification_number");
                String Password = rs.getString("password");
                String Applypost = rs.getString("applypost");
                int userId = rs.getInt("uid");
                User user = new User();
                user.setUid(userId);
                user.setAddress(Address);
                user.setApplypost(Applypost);
                user.setEmail(emailid);
                user.setMobno(mobnum);
                user.setIdno(idnum);
                user.setPassword(Password);
                user.setName(userName);
                UserList.add(user);
            }

            return UserList;

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public String[][] getUserdata() {
        return data;
    }

    public void setdata(int i) {
        try {
            data[i][0] = name;
            data[i][1] = mobile;
            data[i][2] = id;
            data[i][3] = email;
            data[i][4] = password;
            data[i][5] = address;
            data[i][6] = applypost;
            data[i][7] = Integer.toString(uid);
        } catch (Exception e) {
        }
    }

    public DefaultTableModel getAllUserTable() {
        if (!isConnected()) {
            return null;
        }

        try {
            data = new String[100][8];
            DefaultTableModel model = new DefaultTableModel();
            PreparedStatement prepareStatement = connection.prepareStatement("select * from user");
            ResultSet rs = prepareStatement.executeQuery();
            int i = 0;
            while (rs.next()) {
                name = rs.getString("full_name");
                mobile = rs.getString("mobile_number");
                id = rs.getString("identification_number");
                email = rs.getString("email");
                password = rs.getString("password");
                address = rs.getString("address");
                applypost = rs.getString("applypost");
                uid = rs.getInt("uid");
                Object[] obj = new Object[]{name, mobile, id, email, password};
                model.addRow(obj);
                setdata(i);
                i++;
            }
            return model;

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public boolean validateUser(String username, String password) {
        if (!isConnected()) {
            return false;
        }
        PreparedStatement prepareStatement;
        try {
            String sql = "SELECT * FROM user u WHERE u.uid = ? and u.password = ?";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, Integer.parseInt(username));
            prepareStatement.setString(2, password);
            ResultSet rs = prepareStatement.executeQuery();

            return rs.next();

        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

///////////////////////////////////////////////////////////questions functions//////////////////////////////////////////////////////////////////
    public boolean insertQues(Question ques) {
        try {
            if (!isConnected()) {
                return false;
            }

            PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO question (qid,questions, option1, option2,option3,option4,ans,difficulty_level)"
                    + "VALUES (?,?,?,?,?,?,?,?)");

            prepareStatement.setInt(1, ques.getQid());
            prepareStatement.setString(2, ques.getQuestion());
            prepareStatement.setString(3, ques.getOption1());
            prepareStatement.setString(4, ques.getOption2());
            prepareStatement.setString(5, ques.getOption3());
            prepareStatement.setString(6, ques.getOption4());
            prepareStatement.setInt(7, ques.getAns());
            prepareStatement.setInt(8, ques.getDiff());
            prepareStatement.execute();

        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public int getQid() {
        try {
            int qid = 0;
            if (!isConnected()) {
            }
            PreparedStatement State = connection.prepareStatement("select * from question");
            ResultSet rs = State.executeQuery();
            rs.last();
            if (rs.isLast()) {
                qid = Integer.parseInt(rs.getString("qid"));
                return qid;
            } else {
                return qid;
            }
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public boolean modifiQues(Question ques) {
        try {
            if (!isConnected()) {
                return false;
            }

            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE question SET questions=?, option1=?, option2=?, option3=?,option4=?,ans=?,difficulty_level=? WHERE qid=?");
            prepareStatement.setString(1, ques.getQuestion());
            prepareStatement.setString(2, ques.getOption1());
            prepareStatement.setString(3, ques.getOption2());
            prepareStatement.setString(4, ques.getOption3());
            prepareStatement.setString(5, ques.getOption4());
            prepareStatement.setInt(6, ques.getAns());
            prepareStatement.setInt(7, ques.getDiff());
            prepareStatement.setInt(8, ques.getQid());
            prepareStatement.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean removeQues(Question ques) {
        try {
            if (!isConnected()) {
                return false;
            }
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE from question WHERE qid=?");
            prepareStatement.setInt(1, ques.getQid());
            prepareStatement.execute();
            return true;
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public List<Question> getAllQues() {
        if (!isConnected()) {
            return null;
        }

        try {
            List<Question> questions = new ArrayList<>();
            PreparedStatement prepareStatement = connection.prepareStatement("select * from question");
            ResultSet rs = prepareStatement.executeQuery();
            int i = 0;
            while (rs.next()) {
                String questionName = rs.getString("questions");
                opt1 = rs.getString("option1");
                opt2 = rs.getString("option2");
                opt3 = rs.getString("option3");
                opt4 = rs.getString("option4");
                ans = rs.getInt("ans");
                diff = rs.getInt("difficulty_level");
                qid = rs.getInt("qid");
                Question question = new Question();
                question.setQid(qid);
                question.setDiff(diff);
                question.setAns(diff);
                question.setOption1(opt1);
                question.setOption2(opt2);
                question.setOption3(opt3);
                question.setOption4(opt4);
                question.setQuestion(questionName);
                questions.add(question);
            }
            return questions;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setquesdata(int i) {
        try {
            quesdata[i][0] = question;
            quesdata[i][1] = Integer.toString(diff);
            quesdata[i][2] = Integer.toString(ans);
            quesdata[i][3] = opt1;
            quesdata[i][4] = opt2;
            quesdata[i][5] = opt3;
            quesdata[i][6] = opt4;
            quesdata[i][7] = Integer.toString(qid);
        } catch (Exception e) {
        }
    }

    public String[][] getQuesdata() {
        return quesdata;
    }

    public DefaultTableModel getQuestionTableModel() {
        if (!isConnected()) {
            return null;
        }

        try {
            quesdata = new String[100][8];
            DefaultTableModel model = new DefaultTableModel();
            PreparedStatement prepareStatement = connection.prepareStatement("select * from question");
            ResultSet rs = prepareStatement.executeQuery();
            int i = 0;
            while (rs.next()) {
                question = rs.getString("questions");
                opt1 = rs.getString("option1");
                opt2 = rs.getString("option2");
                opt3 = rs.getString("option3");
                opt4 = rs.getString("option4");
                ans = rs.getInt("ans");
                diff = rs.getInt("difficulty_level");
                qid = rs.getInt("qid");
                Object[] obj = new Object[]{question, diff, ans, opt1, opt2, opt3, opt4};
                model.addRow(obj);
                setquesdata(i);
                i++;
            }
            return model;

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

//////////////////////////////////////////////////////////paper functions///////////////////////////////////////////////////////////////
    public boolean insertSet(Paper paper) {
        try {
            if (!isConnected()) {
                return false;
            }

            PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO paper (setid,uid,low_diff,med_diff,high_diff,Total_time)"
                    + "VALUES (?,?,?,?,?,?)");
            prepareStatement.setInt(1, paper.getSetid());
            prepareStatement.setInt(2, paper.getUid());
            prepareStatement.setInt(3, paper.getLowno());
            prepareStatement.setInt(4, paper.getMedno());
            prepareStatement.setInt(5, paper.getHighno());
            prepareStatement.setLong(6, paper.getTime());
            prepareStatement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(ApplicationRunner.getMainFrame(), "Paper already set for the given Uid !!Pleases edit the Papaer!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        JOptionPane.showMessageDialog(ApplicationRunner.getMainFrame(), "Paper Added");
        return true;
    }

    public int getSetid() {
        try {
            int setid = 0;
            if (!isConnected()) {
            }
            PreparedStatement State = connection.prepareStatement("select setid from paper");
            ResultSet rs = State.executeQuery();
            rs.last();
            if (rs.isLast()) {
                setid = Integer.parseInt(rs.getString("setid"));
                return setid;
            } else {
                return setid;
            }
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int[][] getSetdata() {
        return setdata;
    }

    public boolean removeSet(Paper paper) {
        try {
            if (!isConnected()) {
                return false;
            }
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE from paper WHERE setid=?");
            prepareStatement.setInt(1, paper.getSetid());
            prepareStatement.execute();
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return false;
    }

    public boolean modifiSet(Paper paper) {
        try {
            if (!isConnected()) {
                return false;
            }

            long timeForExam = 0;
            timeForExam = timeForExam + (paper.getLowno() * 60);
            timeForExam = timeForExam + (paper.getMedno() * 120);
            timeForExam = timeForExam + (paper.getHighno() * 150);
            paper.setTime(timeForExam);

            PreparedStatement prepareStatement = connection.prepareStatement(" update paper set low_diff = ?, med_diff = ?, high_diff = ?, uid = ? , Total_time = ? where setid = ?");
            prepareStatement.setInt(1, paper.getLowno());
            prepareStatement.setInt(2, paper.getMedno());
            prepareStatement.setInt(3, paper.getHighno());
            prepareStatement.setInt(4, paper.getUid());
            prepareStatement.setLong(5, timeForExam);
            prepareStatement.setInt(6, paper.getSetid());
            prepareStatement.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void setSetData(int row) {
        setdata[row][0] = setid;
        setdata[row][1] = userid;
        setdata[row][2] = lowno;
        setdata[row][3] = medno;
        setdata[row][4] = highno;
        setdata[row][5] = (int) time;
    }

    public DefaultTableModel getAllPapers() {
        if (!isConnected()) {
            return null;
        }

        try {
            setdata = new int[100][8];
            DefaultTableModel model = new DefaultTableModel();
            PreparedStatement prepareStatement = connection.prepareStatement("select * from paper");
            ResultSet rs = prepareStatement.executeQuery();
            int i = 0;
            while (rs.next()) {
                setid = rs.getInt("setid");
                userid = rs.getInt("uid");
                lowno = rs.getInt("low_diff");
                medno = rs.getInt("med_diff");
                highno = rs.getInt("high_diff");
                time = rs.getLong("Total_time");
                Object[] obj = new Object[]{setid, userid, lowno, medno, highno, time};
                setSetData(i);
                model.addRow(obj);
                i++;
            }

            return model;

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
///////////////////////////////////////////////////////////////EXAM SET///////////////////////////////////////////////////////////////////////////////

    long time_final = 0;
    int countfinal = 0, userID = 0, setID = 0;

    public int getSetID() {
        return setID;
    }

    public void setTime_final(long time_final) {
        this.time_final = time_final;
    }

    public int getcountfinal() {
        return countfinal;
    }

    public long getTime_final() {
        return time_final;
    }

    public Paper getFinalQuestionList(int uid) {

        //compare userid with set table and set no. of questions
        try {

            int low = 0, med = 0, high = 0;
            Paper paper = new Paper();
            CallableStatement prepared = connection.prepareCall("SELECT * FROM paper WHERE uid=?");
            prepared.setInt(1, uid);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {
                setID = rs.getInt("setid");
                userID = rs.getInt("uid");
                low = rs.getInt("low_diff");
                med = rs.getInt("med_diff");
                high = rs.getInt("high_diff");
                long time = rs.getLong("Total_time");
                paper.setTime(time);
                paper.setSetid(setID);
                paper.setHighno(high);
                paper.setMedno(med);
                paper.setLowno(low);
                return paper;
            }
        } catch (Exception e) {
        }

        return null;

    }
/////////////////////////////////////////////////////////RESULT DATABASE//////////////////////////////////////////////////////////////////////

    private int[][] resultdata;
    private int attempt, total, score, user;

    public boolean insertResult(ResultClass result) {
        try {
            if (!isConnected()) {
                return false;
            }

            PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO result (uid,setid,attempted_questions,total_questions,score)"
                    + "VALUES (?,?,?,?,?)");
            prepareStatement.setInt(1, result.getUid());
            prepareStatement.setInt(2, result.getSetid());
            prepareStatement.setInt(3, result.getAttempted());
            prepareStatement.setInt(4, result.getTotal());
            prepareStatement.setInt(5, result.getCorrect());
            prepareStatement.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void setResultData(int i) {
        resultdata[i][0] = user;
        resultdata[i][1] = setid;
        resultdata[i][2] = attempt;
        resultdata[i][3] = total;
        resultdata[i][4] = score;
    }

    public int[][] getResultdata() {
        return resultdata;
    }

    public DefaultTableModel getAllResults() {
        if (!isConnected()) {
            return null;
        }

        try {
            resultdata = new int[100][5];
            DefaultTableModel model = new DefaultTableModel();
            PreparedStatement prepareStatement = connection.prepareStatement("select * from result");
            ResultSet rs = prepareStatement.executeQuery();
            int i = 0;
            while (rs.next()) {
                setid = rs.getInt("setid");
                user = rs.getInt("uid");
                attempt = rs.getInt("attempted_questions");
                total = rs.getInt("total_questions");
                score = rs.getInt("score");
                Object[] obj = new Object[]{user, setid, attempt, total, score};
                setResultData(i);
                model.addRow(obj);
                i++;
            }

            return model;

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
