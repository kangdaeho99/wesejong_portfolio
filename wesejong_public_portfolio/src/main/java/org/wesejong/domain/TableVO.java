package org.wesejong.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TableVO {
	private String table_name;
	private String Field;
	private String Type;
	private String Null;
	private String Key;
	private String Default;
	private String Extra;

}