import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import dao.Mapper;

public class dsd {

	public static void main(String[] args) {
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf=ssfb.build(TestCase.class.getClassLoader().getResourceAsStream("sqlMapConfig.xml"));
		 SqlSession ss = ssf.openSession();
		Mapper dao=ss.getMapper(Mapper.class);
		List list=dao.findOne(74);
		System.out.println(list);
 }
}
