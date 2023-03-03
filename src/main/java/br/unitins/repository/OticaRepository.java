package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Otica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OticaRepository implements PanacheRepository<Otica> {

    public Otica findByNome(String modelo) {
        return find("modelo", modelo).firstResult();
    }

    public List<Otica> findByNomeList(String modelo) {
        return find("modelo LIKE ?1", "%" + modelo + "%").list();
    }
}
