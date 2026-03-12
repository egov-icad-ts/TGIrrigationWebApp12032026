package in.ts.icad.leagal.exception;

public class ComponentUserException extends Exception {
private static final long serialVersionUID = 1L;
	

	private String errCode;
	private String errMsg;
	
	public String getErrCode() {
		return errCode;
	}



	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}



	public String getErrMsg() {
		return errMsg;
	}



	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}



	public ComponentUserException() {
        super();
    }

	
	
    public ComponentUserException(String message) {
        super(message);
    }

    public ComponentUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComponentUserException(Throwable cause) {
        super(cause);
    }
    
    
    public ComponentUserException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

}
