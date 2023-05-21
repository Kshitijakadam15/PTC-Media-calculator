
package coustomexception;

public class NoComponentException  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage()
	{
		return "Their is no component to fetch";
		
	}
	

}
