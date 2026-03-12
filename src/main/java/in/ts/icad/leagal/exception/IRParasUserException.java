package in.ts.icad.leagal.exception;

public class IRParasUserException   extends Exception{
	
	
	
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



	public IRParasUserException() {
        super();
    }

	
	
    public IRParasUserException(String message) {
        super(message);
    }

    public IRParasUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public IRParasUserException(Throwable cause) {
        super(cause);
    }
    
    
    public IRParasUserException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

}
