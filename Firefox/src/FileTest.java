import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public static void main(String[] args) {
		
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        // get current date time with Date()
        Date date = new Date(0);
        System.out.println(dateFormat.format(date));
		 Calendar cal = Calendar.getInstance();
		 System.out.println(dateFormat.format(cal.getTime()));
		 
		 String homeDir=System.getProperty("user.home");
		 System.out.println(homeDir);
		 
		 String testRundata = "TestRun"+(dateFormat.format(cal.getTime()));
		 System.out.println(testRundata);
		 String callerMethodName = new Exception().getStackTrace()[1].getMethodName();
		 System.out.println(callerMethodName);

	}

}
