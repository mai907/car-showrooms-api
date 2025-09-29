package com.car.showrooms.dao;


import com.car.showrooms.entity.Car;
import com.car.showrooms.entity.Showroom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class CarSearchDao {

    private EntityManager entityManager;

    public List<Car> findAllByCriteria(CarSearchRequest searchRequest) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        List<Predicate> predicates = new ArrayList<Predicate>();

        Root<Car> root = criteriaQuery.from(Car.class);
        Join<Car, Showroom> showroomJoin = root.join("showroom", JoinType.INNER);

        if (searchRequest.getVin() != null) {
            Predicate vinPredicate = criteriaBuilder.like(root.get("vin"), "%" + searchRequest.getVin() + "%");
            predicates.add(vinPredicate);
        }
        if (searchRequest.getMaker() != null) {
            Predicate makerPredicate = criteriaBuilder.like(root.get("maker"), "%" + searchRequest.getMaker() + "%");
            predicates.add(makerPredicate);
        }
        if (searchRequest.getModel() != null) {
            Predicate modelPredicate = criteriaBuilder.like(root.get("model"), "%" + searchRequest.getModel() + "%");
            predicates.add(modelPredicate);
        }
        if (searchRequest.getModelYear() != null) {
            Predicate modelYearPredicate = criteriaBuilder.equal(root.get("modelYear"),  searchRequest.getModelYear());
            predicates.add(modelYearPredicate);
        }
        if (searchRequest.getAmount() != null) {
            Predicate amountPredicate = criteriaBuilder.like(root.get("price"), "%" + searchRequest.getAmount() + "%");
            predicates.add(amountPredicate);
        }
        if (searchRequest.getCarShowroomName() != null) {
            Predicate carShowroomNamePredicate = criteriaBuilder.like(showroomJoin.get("name"), "%" + searchRequest.getCarShowroomName() + "%");
            predicates.add(carShowroomNamePredicate);
        }

        if (searchRequest.getContactNumber() != null) {
            Predicate contactNumberPredicate = criteriaBuilder.equal(showroomJoin.get("contactNumber"),  searchRequest.getContactNumber() );
            predicates.add(contactNumberPredicate);

        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Car> query = entityManager.createQuery(criteriaQuery);

        //TODO: pagination
        return query.getResultList();
    }
}
