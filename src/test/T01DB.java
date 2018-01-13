package test;

import java.util.List;

import org.junit.Test;

import dao.ContentDao;
import dao.ModuleDao;
import dao.PartDao;
import dao.impl.CardDaoImpl;
import dao.impl.ContentDaoImpl;
import dao.impl.ModuleDaoImpl;
import dao.impl.PartDaoImpl;
import entity.Module;
import entity.Part;

public class T01DB {
	public static void main(String[] args) {
		CardDaoImpl dao=new CardDaoImpl();
		//dao.findCardsPageByModuleId(1L, 10L);
		System.out.println(dao.countCardsByModuleId(1));
	}
	
	@Test
	public void test00(){
		PartDao dao=new PartDaoImpl();
		List<Part> parts=dao.findAllPart();
		System.out.println(parts);
	}
	
	@Test
	public void test01(){
		ModuleDao dao=new ModuleDaoImpl();
		List<Module> modules=dao.findAllModule();
		System.out.println(modules);
	}
	@Test
	public void test02(){
		ContentDao dao=new ContentDaoImpl();
		dao.findContentsPageByCardId(1L, 10L,210542);
	}
}
