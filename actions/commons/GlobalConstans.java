package commons;

public class GlobalConstans {
	// Constans: là dữ liệu không cho phép thay đổi trong quá trình chạy.
	// Dữ liệu dùng chung cho toàn bộ framework (System)
	// Bất kì 1 package/class nào cũng dùng chung dữ liệu trong class này được
	// URL/ Server/ DB /User/ Password
	// Đường dẫn thư mục/ Setting/.....

	public static String ROOT_FOLDER = System.getProperty("user.dir");
	public static long LONG_TIMEOUT = 30;
	public static long SORT_TIMEOUT = 10;
	public static String BROWSER_LOG_FOLDER = ROOT_FOLDER + "/browserLog";
	
}
