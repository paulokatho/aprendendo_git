package com.dbServer.tratoFeito.config.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dbServer.tratoFeito.config.JPAConfig;
import com.dbServer.tratoFeito.config.ServiceConfig;
import com.dbServer.tratoFeito.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	/**
	 * Aqui é antes da parte web, antes da pagina ser carregada
	 * Os Beans que forem configurados aqui ficarão disponiveis para o getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {JPAConfig.class, ServiceConfig.class};
		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {//aqui é a parte web/mapeamento da View
		
		//Esse é o padrão de url que o Servlet vai receber
		return new String[] { "/" } ;
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return new Filter[] { characterEncodingFilter };
	}

}
