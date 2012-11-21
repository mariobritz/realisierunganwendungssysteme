package helloWorld.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String name;

	public String execute() throws Exception {
		if ("SECRET".equals(name)||"SPACKO".equals(name)){
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
