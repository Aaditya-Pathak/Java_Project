/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import service.Database;

/**
 *
 * @author aditya
 */
public class ApplicationRunner {//java file for connecting database and declaring requiered ajava classes////can be used as reference fordata management

    private static MainFrame mainFrame;//declaring only one instance present of mainframe and private for security

    public static Database database;

    public static Database getDatabase() {
        return database;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       
        //</editor-fold>

        /* Create and display the form    // calling main of the mainframe here  */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                database = new Database();
                database.establishConnection("root", "aaditya"); //ENTER SQL Details to establish connection to databse
                mainFrame = MainFrame.getFrame();
                mainFrame.setVisible(true);//above calling getframe function from Mainframe to get the current mainframe and set it as static varaiable mainframe
                mainFrame.doLogin();//adding login screen to the destopPane

            }
        });

    }
//function to get curent mainframe in another frame 

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

}
