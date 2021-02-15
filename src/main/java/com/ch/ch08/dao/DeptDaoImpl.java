package com.ch.ch08.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ch.ch08.model.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private SqlSessionTemplate sst; // 이거는 mybatis자동으로 연결하라는 거
	public List<Dept> list() {
		return sst.selectList("deptns.list");
	}
	public Dept select(int deptno) {
		return sst.selectOne("deptns.select", deptno);
	}
	public int insert(Dept dept) {
		return sst.insert("deptns.insert", dept);
	}
	public int update(Dept dept) {
		return sst.update("deptns.update", dept);
	}
	public int delete(int deptno) {
		return sst.delete("deptns.delete", deptno);
	}
}
