package com.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.dao.HelloDao;
import com.hello.domain.Holloworld;

@Service
public class HelloService {
	
	@Autowired
	HelloDao helloDao;
	
	public List<Holloworld> getHolloworlds() {
		return helloDao.getAll();
	}
}
