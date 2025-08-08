package com.pincodedeatil.Impl;

import com.pincodedeatil.model.PinCodeDetail;
import com.pincodedeatil.repository.PinCodeCustomRepositoryDetail;
import com.pincodedeatil.repository.PinCodeRepositoryDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PinCodeRepositoryDetailImpl implements PinCodeCustomRepositoryDetail {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PinCodeDetail> findWithCustomeFilter(String city, String state) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PinCodeDetail> criteriaQuery = criteriaBuilder.createQuery(PinCodeDetail.class);
        Root<PinCodeDetail> root = criteriaQuery.from(PinCodeDetail.class);

        List<Predicate> predicates = new ArrayList<>();

        if(city!= null) {
            predicates.add(criteriaBuilder.equal(root.get("city"), city));
        }

        if(state!=null) {
            predicates.add(criteriaBuilder.equal(root.get("state"), state));
        }

        criteriaQuery.select(root).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(criteriaQuery).getResultList();

    }
}
