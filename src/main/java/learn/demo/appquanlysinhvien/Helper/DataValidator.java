package learn.demo.appquanlysinhvien.Helper;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Ngô Duy Minh
 */
public class DataValidator {
        public static void validateEmpty (JTextField field, StringBuilder sb, String errorMessage)  {
        if (field.getText().equals(""))   {                 // kiểm tra nd truyền vào text nếu rỗng thì hiển thị message
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else {
            field.setBackground(Color.white);
    }
}
    public static void validateEmpty (JPasswordField field, StringBuilder sb, String errorMessage)  {
            String password = new String(field.getPassword());
        if (password.equals(""))   {                 // kiểm tra nd truyền vào text nếu rỗng thì hiển thị message
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else {
            field.setBackground(Color.white);
    }
}
    
}
