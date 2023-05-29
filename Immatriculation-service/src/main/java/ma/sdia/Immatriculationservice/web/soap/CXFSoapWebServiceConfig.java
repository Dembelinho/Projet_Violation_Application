package ma.sdia.Immatriculationservice.web.soap;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CXFSoapWebServiceConfig {
    @Autowired
    private Bus bus; // Autowired Bus object for CXF

    @Autowired
    private OwnerSoapService ownerSoapService; // Autowired OwnerSoapService object

    @Bean
    public EndpointImpl endpoint() {
        // Create a new EndpointImpl object with the provided Bus and OwnerSoapService
        EndpointImpl endpoint = new EndpointImpl(bus, ownerSoapService);

        endpoint.publish("/OwnService"); // Publish the SOAP Web Service on the specified URL

        return endpoint; // Return the configured EndpointImpl object
    }

}
