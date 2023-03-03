package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
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

import br.unitins.model.Otica;
import br.unitins.repository.OticaRepository;

@Path("/otica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OticaResource {

    @Inject
    private OticaRepository repository;

    @GET
    @Path("/all")
    public List<Otica> getall() {
        return repository.findAll().list();
    }

    @POST
    @Transactional
    public Otica inserir(Otica otica) {
        repository.persist(otica);
        return otica;
    }

    // altera tudo
    @PUT
    @Path("/{id}")
    @Transactional
    public Otica alterarTudo(@PathParam("id") Long id, Otica otica) {
        Otica oticaid = repository.findById(id);
        oticaid.setModelo(otica.getModelo());
        oticaid.setMarca(otica.getMarca());
        oticaid.setLente(otica.getLente());
        oticaid.setFornecedor(otica.getFornecedor());
        oticaid.setTamanho(otica.getTamanho());
        return oticaid;
    }

    // altera parcialmente
    @PATCH
    @Path("/{id}")
    @Transactional
    public Otica alterarParcialmente(@PathParam("id") Long id, Otica otica) {
        Otica oticaid = repository.findById(id);
        oticaid.setModelo(otica.getModelo());
        oticaid.setMarca(otica.getMarca());
        return oticaid;
    }

    // consultar
    @GET
    @Path("/{id}")
    public Otica consultarId(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Otica deletar(@PathParam("id") Long id, Otica otica) {
        Otica oticaid = repository.findById(id);
        repository.delete(oticaid);
        return oticaid;
    }

    // pesquisar por modelo
    @GET
    @Path("/search/{modelo}")
    public Otica buscarModelo(@PathParam("modelo") String modelo) {
        return repository.findByNome(modelo);
    }

    @GET
    @Path("/searchList/{modelo}")
    public List<Otica> buscarLista(@PathParam("modelo") String modelo) {
        return repository.findByNomeList(modelo);
    }
}
