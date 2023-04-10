package com.example.task14.repository;

import com.example.task14.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.List;

public class UserFilterImpl implements UserFilter {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findByFirstName(String firstName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("firstName"), firstName));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<User> findByLastName(String lastName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("last_name"), lastName ));
        return entityManager.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public List<User> findByMiddleName(String middleName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("middle_name"), middleName));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<User> findByBirthDate(LocalDate birthDay) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("birth_date"), birthDay));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
