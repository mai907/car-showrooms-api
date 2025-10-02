package com.car.showrooms.specification;

import com.car.showrooms.dao.CarSearchRequest;
import com.car.showrooms.entity.Car;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarSpecs {
    private CarSpecificationRepository specificationRepository;

    public static Specification<Car> containsVin(String provideVin) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("vin")), "%" + provideVin.toLowerCase() + "%" );
    }

    public static Specification<Car> containsMaker(String provideMaker) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("maker")), "%" + provideMaker.toLowerCase() + "%");
    }

    public static Specification<Car> containsModel(String provideModel) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("model")), "%" + provideModel.toLowerCase() + "%");
    }

    public static Specification<Car> hasModelYear(String provideModelYear) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("modelYear"), provideModelYear);
    }

    public static Specification<Car> hasAmount(String provideAmount) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("price"), provideAmount);
    }

    public static Specification<Car> containsCarShowroomName(String provideCarShowroomName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("showroom").get("name")), "%" + provideCarShowroomName.toLowerCase() + "%");
    }

    public static Specification<Car> containsContactNumber(String provideContactNumber) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("showroom").get("contactNumber"), provideContactNumber);
    }

    public Page<Car> findCarsByCriteria(CarSearchRequest searchRequest, Pageable pageable) {
        Specification<Car> spec = Specification.unrestricted();

        if (searchRequest.getVin() != null) {
            spec = spec.and(containsVin(searchRequest.getVin()));
        }
        if (searchRequest.getMaker() != null) {
            spec = spec.and(containsMaker(searchRequest.getMaker()));
        }
        if (searchRequest.getModel() != null) {
            spec = spec.and(containsModel(searchRequest.getModel()));
        }
        if (searchRequest.getModelYear() != null) {
            spec = spec.and(hasModelYear(String.valueOf(searchRequest.getModelYear())));
        }
        if (searchRequest.getAmount() != null) {
            spec = spec.and(hasAmount(String.valueOf(searchRequest.getAmount())));
        }
        if (searchRequest.getCarShowroomName() != null) {
            spec = spec.and(containsCarShowroomName(searchRequest.getCarShowroomName()));
        }
        if (searchRequest.getContactNumber() != null) {
            spec = spec.and(containsContactNumber(String.valueOf(searchRequest.getContactNumber())));
        }

        return this.specificationRepository.findAll(spec, pageable);


    }

}
