/*
 * Created on Jun 17, 2013
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ird.portal.user;

import java.util.HashSet;

/**
 * Anonymous DTO
 */
public class AnonymousUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 130626;

	public AnonymousUser() {
		super();
		setUserId("ANONYM");
		setUserName("Anonymous User");
		setDept("DV");
		setStatus(UserStatus.ACTIVE);
		setRoles(new HashSet<Role>());
	}
}
