package pl.firma;



import java.util.List;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/firma")
@Consumes({ "application/json" })
@Produces({ "application/json" })

//@Consumes({ "application/xml" })
//@Produces({ "application/xml" })

public class FirmaReklamowaREST implements FirmaReklamowa {

	@EJB
	FirmaReklamowaEJB bean;
	
	@Override
	@POST
	public void createBillboard(Billboard billboard) {
		bean.createBillboard(billboard);
	}
	
	@Override
    @TransactionAttribute
	@GET
	public List<Billboard> getAllBillboards() {
		return bean.getAllBillboards();
	}

}
