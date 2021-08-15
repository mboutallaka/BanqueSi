package net.boutallaka;

import java.rmi.registry.LocateRegistry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import net.boutallaka.rmi.BanqueRmiRemote;

@Configuration
public class myConfig {
    @Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8081/maBanque");
		return exporter;
	}
    @Bean
    public RmiServiceExporter getRmiService(ApplicationContext ctx) {
    	
    	RmiServiceExporter exporter= new RmiServiceExporter();
    	exporter.setService(ctx.getBean("MyRmiService"));
    	exporter.setRegistryPort(1099);
    	exporter.setServiceName("BK");
    	exporter.setServiceInterface(BanqueRmiRemote.class);
    	
    	return exporter;
    }
    
	
}
