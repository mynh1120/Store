package learn.demo.appquanlysinhvien.Helper;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Ngô Duy Minh
 */
public class MessageDialogHelper {
        public static void showMessageDialog(Component parent, String content, String title)   {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showErrorDialog(Component parent, String content, String title)  {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.ERROR_MESSAGE);
    }
    public static int showConfirmDialog(Component parent, String content, String title)    {
        int choose = JOptionPane.showConfirmDialog(parent, title, 
                content, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
    }
    
}
