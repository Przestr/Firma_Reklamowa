package pl.firma;



import java.util.List;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/firma")
@Consumes({ "application/json" })
@Produces({ "application/json" })

public class FirmaReklamowaREST implements FirmaReklamowa {

	@EJB
	FirmaReklamowaEJB bean;
	
	@Override
	@POST
	@Path("/billboard")
	public void createBillboard(Billboard billboard) {
		bean.createBillboard(billboard);
	}
	
	@Override
    @TransactionAttribute
	@GET
	@Path("/billboard")
	public List<Billboard> getAllBillboards() {
		return bean.getAllBillboards();
	}
	
	@Override
	@GET
	@Path("/billboard/{id}")
	public Billboard getBillboard(@PathParam("id") int id) {
		Billboard billboard = bean.getBillboard(id);
		return billboard;
		
	}
	
	@Override
	@PUT
	@Path("/billboard")
	public String updateBillboard(Billboard billboard) {
		try {
			bean.updateBillboard(billboard);
			return "car updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "car not updated :(";
		}
	}
	
	@Override
	@DELETE
	@Path("/billboard/{id}")
	public void deleteBillboard(@PathParam("id") int id) {
		bean.deleteBillboard(id);	
	}
	
	@Override
	@POST
	@Path("/billboardReklama/{idb}/{idr}")
	public void addReklamaToBillboard(BillboardReklama billboardReklama, @PathParam("idb") int idb, @PathParam("idr") int idr) {
		bean.addReklamaToBillboard(billboardReklama, idb, idr);
	}
	
	//REKLAMA
	@Override
	@POST
	@Path("/reklama")
	public void createReklama(Reklama reklama) {
		bean.createReklama(reklama);
	}
	
	@Override
    @TransactionAttribute
	@GET
	@Path("/reklama")
	public List<Reklama> getAllReklama() {
		return bean.getAllReklama();
	}
	
	@Override
	@GET
	@Path("/reklama/{id}")
	public Reklama getReklama(@PathParam("id") int id) {
		Reklama reklama = bean.getReklama(id);
		return reklama;
		
	}
	
	@Override
	@PUT
	@Path("/reklama")
	public String updateReklama(Reklama reklama) {
		try {
			bean.updateReklama(reklama);
			return "car updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "car not updated :(";
		}
	}
	
	@Override
	@DELETE
	@Path("/reklama/{id}")
	public void deleteReklama(@PathParam("id") int id) {
		bean.deleteReklama(id);	
	}

}
