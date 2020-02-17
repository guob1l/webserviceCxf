package ws.config;


import org.apache.cxf.Bus;


import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ws.webservice.AddMerchant;
import ws.webservice.DeleteMerchant;
import ws.webservice.FindMerchant;
import ws.webservice.UpdateMerchant;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {


    @Autowired
    private Bus bus;

    @Autowired
    private FindMerchant findMerchant;

    @Autowired
    private AddMerchant addMerchant;

    @Autowired
    private UpdateMerchant updateMerchant;

    @Autowired
    private DeleteMerchant deleteMerchant;
    @Bean
    public ServletRegistrationBean disServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/webs/*");
        return servletRegistrationBean;
    }

    @Bean
    public Endpoint endpointfind() {
        EndpointImpl endpoint = new EndpointImpl(bus, findMerchant);
        endpoint.publish("/findMerchant");
        return endpoint;
    }

    @Bean
    public Endpoint endpointadd() {
        EndpointImpl endpoint = new EndpointImpl(bus, addMerchant);
        endpoint.publish("/addMerchant");
        return endpoint;
    }
    @Bean
    public Endpoint endpointupdate() {
        EndpointImpl endpoint = new EndpointImpl(bus, updateMerchant);
        endpoint.publish("/updateMerchant");
        return endpoint;
    }
    @Bean
    public Endpoint endpointdelete() {
        EndpointImpl endpoint = new EndpointImpl(bus, deleteMerchant);
        endpoint.publish("/deleteMerchant");
        return endpoint;
    }

}
