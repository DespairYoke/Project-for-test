package dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import annotations.MybatisRepository;
import entity.Employee;
@RequestMapping("empDAO")
@MybatisRepository
public interface Mapper {
	public List<Employee> findOne(int id);
	public  List<Employee>findAll();
}
