package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Artwork;

public class ArtworkHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ArtGalleryMcCammon");
	
	public void insertItem(Artwork toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Artwork> showAllArtwork() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Artwork> allResults = em.createQuery("select li from Artwork li", Artwork.class);
		List<Artwork> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
	
	public Artwork searchForArtworkById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Artwork foundItem = em.find(Artwork.class, idToEdit);
		em.close();
		return foundItem;
	}
	

	public List<Artwork> searchForItemByTitle(String title) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Artwork> typedQuery = em.createQuery("select li from Artwork li where li.title = :selectedTitle", Artwork.class);
		typedQuery.setParameter("selectedTitle", title);

		List<Artwork> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Artwork> searchForItemByArtist(String artist_name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Artwork> typedQuery = em.createQuery("select li from Artwork li where li.artist_name = :selectedArtistName", Artwork.class);
		typedQuery.setParameter("selectedArtistName", artist_name);

		List<Artwork> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		
	}
	public void updateArtwork(Artwork toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(Artwork toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Artwork> typedQuery = em.createQuery("select li from Artwork li where li.title = :selectedStore and li.artist_name = :selectedItem", Artwork.class);
		typedQuery.setParameter("selectedStore", toDelete.getTitle());
		typedQuery.setParameter("selectedItem", toDelete.getArtist_name());
		typedQuery.setMaxResults(1);
		Artwork result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

}