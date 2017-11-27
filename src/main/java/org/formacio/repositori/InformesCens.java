package org.formacio.repositori;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.formacio.domain.Persona;
import org.springframework.stereotype.Repository;

@Repository
public class InformesCens {


	@PersistenceContext
	private EntityManager em;
	/**
	 * Retorna la llista de persones que viuen al municipi indicat
	 */
	public List<Persona> habitantsMunicipi(String municipi) {
		TypedQuery<Persona> query = em.createQuery( "select per from Persona per where per.municipi.nom = :nomMunicipi order by per.nom", Persona.class);
		query.setParameter("nomMunicipi", municipi);
		return query.getResultList();
	}

	/**
	 * Retorna el nombre d'habitants de la illa
	 */
	public int nombreHabitantsIlla(String illa) {
		Query query = em.createQuery(
				"select count(persona) from Persona persona where persona.municipi.illa.nom = :nomIlla ");
		query.setParameter("nomIlla", illa);
		return ((Number)query.getSingleResult()).intValue();
	}
	
	/**
	 * Retorna el nombre d'habitants del municipi que son menors d'edat
	 */
	public int nombreHabitantsMenorsEdat(String municipi) {
		Query query = em.createQuery(
				"select count(persona) from Persona persona where persona.municipi.nom = :nomMunicipi and persona.edat < 18");
		query.setParameter("nomMunicipi", municipi);
		return ((Number)query.getSingleResult()).intValue();
	}

	/**
	 * Retorna la llista de persones que no tenen informat de quin municipi son
	 */
	public List<Persona> llistaPersonesSenseMunicipi() {
		return null;
    }

	/**
	 * Retorna la llista de noms de persones d'una illa ordenats per l'edat
	 * siii, ja ho se ..., no hem vist com ordenar, pero emprau order by i la vostra intuicio ;-)
	 */
	public List<String> llistaNomsPersonesOrdenatPerEdat(String illa) {
		return null;
    }
	
}
