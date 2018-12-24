package com.utils;

/**
 * 响应信息
 * @author Administrator
 *
 */
public class RespMsg {
	private boolean flag;
	
	private String code;

	private String msg;
	
	private String codeDesc;

	private Object data;

	public RespMsg() {
		super();
	}

	public RespMsg(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	
	public RespMsg(boolean flag, String msg) {
		super();
		this.flag = flag;
		this.msg = msg;
	}

	public RespMsg(boolean flag, Object data) {
		this.flag = flag;
		this.data = data;
	}

	public RespMsg(boolean flag, String code, String msg, String codeDesc) {
		super();
		this.flag = flag;
		this.code = code;
		this.msg = msg;
		this.codeDesc = codeDesc;
	}

	public RespMsg(boolean flag, String code, String msg) {
		super();
		this.flag = flag;
		this.code = code;
		this.msg = msg;
	}


	public RespMsg(boolean flag, String code, String msg, Object data) {
		this.flag = flag;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public RespMsg(boolean flag, String code, String msg, String codeDesc, Object data) {
		super();
		this.flag = flag;
		this.code = code;
		this.msg = msg;
		this.codeDesc = codeDesc;
		this.data = data;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	
	public void setResult(boolean flag, String code, String msg){
		setFlag(flag);
		setCode(code);
		setMsg(msg);
	}
	
	public void setResult(boolean flag,  String code, String msg, Object data){
		setFlag(flag);
		setCode(code);
		setMsg(msg);
		setData(data);
	}
}
