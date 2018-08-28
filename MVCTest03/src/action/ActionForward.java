package action;

public class ActionForward {
	private boolean isRedirect=false;//리다이렉트 여부
	private String path=null;//이동할 페이지
	
	public boolean isRedirect() {	return isRedirect;	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {	return path;	}
	public void setPath(String path) {	this.path = path;	}
	

}
