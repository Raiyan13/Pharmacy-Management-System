
package PharmacyManagementSystem;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author S.m.Tahmin Kabir Raiyan
 * ID: 181-115-006
 * Department: CSE
 * Metropolitan University.
 */
public class DateTime {
    
    
    Date today,time;

    public String getDate() 
    {
      today = new Date();
      SimpleDateFormat ft = 
      new SimpleDateFormat ("dd/MM/yyyy");

      //System.out.println("Current Date: " + ft.format(today));
        return ft.format(today);
    }

    public String getTime() 
    {
       time = new Date();
       SimpleDateFormat ft = 
       new SimpleDateFormat ("hh:mma");

      //System.out.println("Current Date: " + ft.format(today));
        return ft.format(time);
    }
    
    public static void main(String[] args) {
        
        DateTime dt = new DateTime();
        System.out.println(dt.getTime());
        System.out.println(dt.getDate());  
    }
}
