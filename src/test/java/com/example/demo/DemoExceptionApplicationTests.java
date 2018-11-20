package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.service.CatagoryService;
import com.example.demo.service.OrdersService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.example.demo.util.CommonConvertor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoExceptionApplicationTests {

	Logger logger= LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private OrdersService ordersService;


	@Autowired
	private CatagoryService catagoryService;

	@Test
	public void testUserAdd() {
		Role role=new Role();
		role.setName("管理员");
		User user=new User();
		user.setBirth(new Date());
		user.setName("李世民");
		user.setRole(role);
		userService.save(user);

	}


	@Test
	public void testRoleAdd() {
		Role role=new Role();
		role.setName("开发");
		roleService.save(role);

	}

	@Test
	public void testFindRolesByName(){

	}

	@Test
	public void testFindUserByNameLike(){

	}


	@Test
	public void saveOrders(){

		Set<Product> products=new HashSet<>();

		Product product = new Product();

		product.setProductCreateTime(new Date());
		product.setProductModifyTime(CommonConvertor.getCustomeDate(1));

		//绑定分类
		Catagory catagory=catagoryService.findById(1);
		product.setCatagory(catagory);

		products.add(product);

		User user=userService.findByName("宋江");
		Orders orders=new Orders();
		orders.setUser(user);
		orders.setOrderCreateTime(new Date());
		orders.setOrderModifyTime(CommonConvertor.getCustomeDate(1));
		//order和product由order来维护关系
		orders.setProducts(products);

		ordersService.save(orders);

	}
}
