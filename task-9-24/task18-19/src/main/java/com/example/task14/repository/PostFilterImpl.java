package com.example.task14.repository;

import com.example.task14.model.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.List;

public class PostFilterImpl implements PostFilter {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Post> findByText(String text) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("text"), text));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Post> finByCreationDate(LocalDate creationDate) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("creation_date"), creationDate));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
