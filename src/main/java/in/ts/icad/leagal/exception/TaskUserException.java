package in.ts.icad.leagal.exception;

public class TaskUserException extends Exception {
	
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



	public TaskUserException() {
        super();
    }

	
	
    public TaskUserException(String message) {
        super(message);
    }

    public TaskUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskUserException(Throwable cause) {
        super(cause);
    }
    
    
    public TaskUserException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

}
