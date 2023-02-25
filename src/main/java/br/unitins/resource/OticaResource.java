package br.unitins.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.hql.internal.ast.exec.IdSubselectUpdateExecutor;

import br.unitins.model.Otica;

@Path("/Oculos")
public class OticaResource {
    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Otica> getall(){
        return Otica.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Otica inserir(Otica otica){
        otica.persist();
        return otica;
    }

    //altera tudo
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Otica alterarTudo(@PathParam("id")Long id, Otica otica){
        Otica oticaid = Otica.findById(id);
        oticaid.setModelo(otica.getModelo());
        oticaid.setMarca(otica.getMarca());
        oticaid.setLente(otica.getLente());
        oticaid.setFornecedor(otica.getFornecedor());
        oticaid.setTamanho(otica.getTamanho());
        return oticaid;
    }

    //altera parcialmente
    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Otica alterarParcialmente(@PathParam("id")Long id, Otica otica){
        Otica oticaid = Otica.findById(id);
        oticaid.setModelo(otica.getModelo());
        oticaid.setMarca(otica.getMarca());
        return oticaid;
    }

    //consultar
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Otica consultarId(@PathParam("id")Long id){
        return Otica.findById(id);
    }


    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Otica deletar(@PathParam("id")Long id, Otica otica){
        Otica oticaid = Otica.findById(id);
        oticaid.delete(); 
        return oticaid;
    }
}


