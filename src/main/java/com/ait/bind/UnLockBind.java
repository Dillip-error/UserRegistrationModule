package com.ait.bind;

import lombok.Data;

@Data
public class UnLockBind {
	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;

}
