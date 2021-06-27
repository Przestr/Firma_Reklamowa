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
	public void addReklamaToBillboard(BillboardReklama billboardReklama, @PathParam("idb") int idb,
			@PathParam("idr") int idr) {
		bean.addReklamaToBillboard(billboardReklama, idb, idr);
	}
	
	//BILLBOARDREKLAMA	
	

	@Override
	@TransactionAttribute
	@GET
	@Path("/billboardReklama")
	public List<BillboardReklama> getAllBillboardReklama() {
		return bean.getAllBillboardReklama();
	}

	@Override
	@GET
	@Path("/billboardReklama/{id}")
	public BillboardReklama getBillboardReklama(@PathParam("id") int id) {
		BillboardReklama billboardReklama = bean.getBillboardReklama(id);
		return billboardReklama;

	}
	
	@Override
	@PUT
	@Path("/billboardReklama")
	public String updateBillboardReklama(BillboardReklama billboardReklama) {
		try {
			bean.updateBillboardReklama(billboardReklama);
			return "car updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "car not updated :(";
		}
	}
	
	@Override
	@DELETE
	@Path("/billboardReklama/{id}")
	public void deleteBillboardReklama(@PathParam("id") int id) {
		bean.deleteBillboardReklama(id);
	}

	// REKLAMA
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

	//KLIENT
	@Override
	@POST
	@Path("/klient")
	public void createKlient(Klient klient) {
		bean.createKlient(klient);
	}

	@Override
	@TransactionAttribute
	@GET
	@Path("/klient")
	public List<Klient> getAllKlient() {
		return bean.getAllKlient();
	}

	@Override
	@GET
	@Path("/klient/{id}")
	public Klient getKlient(@PathParam("id") int id) {
		Klient klient = bean.getKlient(id);
		return klient;

	}

	@Override
	@PUT
	@Path("/klient")
	public String updateKlient(Klient klient) {
		try {
			bean.updateKlient(klient);
			return "car updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "car not updated :(";
		}
	}

	@Override
	@DELETE
	@Path("/klient/{id}")
	public void deleteKlient(@PathParam("id") int id) {
		bean.deleteKlient(id);
	}
	
	//FAKTURA
	@Override
	@POST
	@Path("/faktura")
	public void createFaktura(Faktura faktura) {
		bean.createFaktura(faktura);
	}

	@Override
	@TransactionAttribute
	@GET
	@Path("/faktura")
	public List<Faktura> getAllFaktura() {
		return bean.getAllFaktura();
	}

	@Override
	@GET
	@Path("/faktura/{id}")
	public Faktura getFaktura(@PathParam("id") int id) {
		Faktura faktura = bean.getFaktura(id);
		return faktura;

	}

	@Override
	@PUT
	@Path("/faktura")
	public String updateFaktura(Faktura faktura) {
		try {
			bean.updateFaktura(faktura);
			return "car updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "car not updated :(";
		}
	}

	@Override
	@DELETE
	@Path("/faktura/{id}")
	public void deleteFaktura(@PathParam("id") int id) {
		bean.deleteKlient(id);
	}
	
	@Override
	@POST
	@Path("/faktura/{idf}/{idk}")
	public void addFakturaToKlient(@PathParam("idf") int idf, @PathParam("idk") int idk) {
		bean.addFakturaToKlient(idf, idk);
	}

}
