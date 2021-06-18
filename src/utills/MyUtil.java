package utills;

/**
 * @author mzx
 *
 * 用来放置算法
 */
public class MyUtil {
	public static final String dateFormat="yyyy-MM-dd";
	public static final String longDateTimeFormat="yyyy-MM-dd HH:mm:ss"; 
	public static final String longDateTimeWithMillisFormat="yyyy-MM-dd HH:mm:ss.SSS";// yyyy-MM-dd HH:mm:ss.SSS 精确到毫秒
	private static String productImageURLRoot="/upload/productImages/", tempDirectory="/upload/temp/";
	public static String getDateFormat(int theType) {
		String temp=longDateTimeWithMillisFormat;
		switch (theType) {
		case 0:
			temp=dateFormat;
			break;		
		case 1:
			temp=longDateTimeFormat;
			break;	
		default:
			temp=longDateTimeWithMillisFormat;
		}	
		return temp;
	}
	

    //商品的排序算法

    //用户排序算法

    
}
