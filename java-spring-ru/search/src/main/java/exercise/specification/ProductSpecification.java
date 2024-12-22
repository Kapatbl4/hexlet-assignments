package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {

    public Specification<Product> build(ProductParamsDTO paramsDTO) {
        return withTitleCont(paramsDTO.getTitleCont())
                .and(withCategoryId(paramsDTO.getCategoryId()))
                .and(withPriceLt(paramsDTO.getPriceLt()))
                .and(withPriceGt(paramsDTO.getPriceGt()))
                .and(withRatingGt(paramsDTO.getRatingGt()));
    }

    private Specification<Product> withTitleCont(String titleCont) {
        return ((root, query, criteriaBuilder) -> titleCont == null ? criteriaBuilder.conjunction() :
                criteriaBuilder.like(root.get("title"), titleCont));
    }

    private Specification<Product> withCategoryId(Long id) {
        return ((root, query, criteriaBuilder) -> id == null ? criteriaBuilder.conjunction() :
                criteriaBuilder.equal(root.get("category").get("id"), id));
    }

    private Specification<Product> withPriceLt(Integer price) {
        return ((root, query, criteriaBuilder) -> price == null ? criteriaBuilder.conjunction() :
                criteriaBuilder.lessThan(root.get("price"), price));
    }

    private Specification<Product> withPriceGt(Integer price) {
        return ((root, query, criteriaBuilder) -> price == null ? criteriaBuilder.conjunction() :
                criteriaBuilder.greaterThan(root.get("price"), price));
    }

    private Specification<Product> withRatingGt(Double rating) {
        return ((root, query, criteriaBuilder) -> rating == null ? criteriaBuilder.conjunction() :
                criteriaBuilder.greaterThan(root.get("rating"), rating));
    }
}
// END
