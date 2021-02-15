package com.ch.ch08.model;

import java.sql.Date;
import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private int sal;
	private Integer comm;
	private int deptno;
	// 관리자명
	private String mgrName;
	// join용 부서 정보
	private Dept dept;
}
