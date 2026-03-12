package in.ts.icad.leagal.exception;

public class InventoryUserException  extends Exception {
	
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



	public InventoryUserException() {
        super();
    }

	
	
    public InventoryUserException(String message) {
        super(message);
    }

    public InventoryUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public InventoryUserException(Throwable cause) {
        super(cause);
    }
    
    
    public InventoryUserException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

}
