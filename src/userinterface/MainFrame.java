/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import service.Database;

/**
 *
 * @author aditya
 */
public class MainFrame extends javax.swing.JFrame {

//MAIN IS CALLED IN APPLICIATION RUNNER
    static int openFrameCount = 0;
    private BufferedImage img;
    private JDesktopPane mainDesktopPane = new JDesktopPane();
    private Database db = ApplicationRunner.getDatabase();
    private Admin admin;
    private login loginScreen;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ;
    private Exam exam;

    private String userName, password;

    private int Userid;

    public int getUserid() {
        return Userid;
    }

    private static MainFrame mainFrame; //declaring a static mainframe to access overall

    public static MainFrame getFrame() {//function to get mainframe for current program
        if (mainFrame == null) {
            mainFrame = new MainFrame();
        }
        return mainFrame;
    }

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        try {
            img = (BufferedImage) new ImageIcon(this.getClass().getResource("/images/bell-icon16.png")).getImage();
        } catch (Exception ex) {
        }

        // A specialized layered pane to be used with JInternalFrames
        mainDesktopPane = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(img, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(img.getWidth(), img.getHeight());
            }
        };
        //adding desktoppane\
        initComponents();
        this.add(mainDesktopPane);
        mainDesktopPane.add(jLabel_logo);
        jLabel_logo.setVisible(true);
        mainDesktopPane.setBounds(0, 0, screenSize.width, screenSize.height);
        mainDesktopPane.setVisible(true);
        setBounds(0, 0, screenSize.width, screenSize.height);
        mainDesktopPane.setDragMode(0);

    }


    private void add(JInternalFrame internalFrame) {//adding internalframe to the desktopPane

        //to remove al present frames from desktoppane
        JInternalFrame[] allFrames = mainDesktopPane.getAllFrames();
        for (JInternalFrame allFrame : allFrames) {
            mainDesktopPane.remove(allFrame);
        }

        //adding the required internalframe to the desktoppane
        mainDesktopPane.add(internalFrame);
        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) internalFrame.getUI()).getNorthPane();
        internalFrame.remove(titlePane);
        internalFrame.setBounds((int) (screenSize.getWidth() - internalFrame.getWidth()) / 2, (int) (screenSize.getHeight() - internalFrame.getHeight()) / 2 + 40, internalFrame.getWidth(), internalFrame.getHeight());
        internalFrame.setVisible(true);

    }

    public void doLogin() {//function to add login screen when required and remove otherframes

        //when admin InternalFrame  is peresent remove admin
        if (admin != null) {
            admin.setVisible(false);
            admin.dispose();
            admin = null;
        }
        //allocate memory to login secreen and add it to desktopPane
        loginScreen = new login();
        add(loginScreen);
    }

    public void loginPerformed() {//for validating login deatils with database

        //take username and password
        userName = loginScreen.getUserName();//calling get functions declared in loginscreen for us and pwd
        password = loginScreen.getPassword();
        //check 
        if (userName.equals("Admin")) {//if sucessful login then dispose login screen
            if (password.equals("1234")) {
                loginScreen.setVisible(false);
                loginScreen.dispose();
                loginScreen = null;
                //add admin internalframe to desktopPane
                admin = new Admin();
                add(admin);
                JOptionPane.showMessageDialog(this, "Welcome Admin!!", "Login Successful ", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, " Invalid Password", "Login Error! ", JOptionPane.ERROR_MESSAGE);
            }

        } else if (db.validateUser(userName, password)) {
            loginScreen.setVisible(false);
            loginScreen.dispose();
            loginScreen = null;
            Userid = Integer.valueOf(userName);
            exam = new Exam();
            add(exam);
            JOptionPane.showMessageDialog(this, "Welcome Student!!", "Login Successful ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid userId or Password", "ERROR", JOptionPane.ERROR_MESSAGE);
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

        jLabel_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(566, Short.MAX_VALUE)
                .addComponent(jLabel_logo)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel_logo)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_logo;
    // End of variables declaration//GEN-END:variables
}
