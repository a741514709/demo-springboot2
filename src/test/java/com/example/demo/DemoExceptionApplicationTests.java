package com.example.demo;

import com.example.demo.service.CatagoryService;
import com.example.demo.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoExceptionApplicationTests {



	@Autowired
	private OrdersService ordersService;


	@Autowired
	private CatagoryService catagoryService;



	@Test
	public  void testGetResourceByRoleId(){



	}


}
