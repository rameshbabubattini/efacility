package com.efacility.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import efacility.TestBean;

@Service
public class TestService {
	public static List<TestBean> getList() {
		List<TestBean> list = new ArrayList<TestBean>();
		for (long i = 1; i <= 100; i++) {
			TestBean t = new TestBean();
			t.setEmpId(String.valueOf(i));
			t.setEmpName("TESTNAME"+i);
			list.add(t);
		}
		return list;
	}
}