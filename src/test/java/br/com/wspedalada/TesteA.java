package br.com.wspedalada;

import java.lang.reflect.Field;

public class TesteA {

	public static void main(String args[]) throws NoSuchFieldException, SecurityException{
		
		TesteVO testeVO = new TesteVO();
		testeVO.setTeste("NOME DELE");
		testeVO.setTetseB(1);
		
		try {
			teste(testeVO);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void teste(Object c) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		for(Field fields : c.getClass().getDeclaredFields()){
			fields = 	c.getClass().getDeclaredField(fields.getName());
			fields.setAccessible(true);
			
			System.out.println(fields.get(c)+" "+fields.getName());
		}
		
	}
}
