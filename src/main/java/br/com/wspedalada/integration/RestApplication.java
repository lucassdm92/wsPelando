package br.com.wspedalada.integration;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestApplication extends Application{
	// All request scoped resources and providers
		@Override
		public Set<Class<?>> getClasses() {
			Set<Class<?>> classes = new HashSet<Class<?>>();
			classes.add(ServicesIntegration.class);
			return classes;
		}

		// all singleton resources and providers
		@Override
		public Set<Object> getSingletons() {
			Set<Object> singletons = new HashSet<Object>();
			return singletons;
		}

}
