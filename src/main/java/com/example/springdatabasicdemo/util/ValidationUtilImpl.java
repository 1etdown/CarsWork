
package com.example.springdatabasicdemo.util;
import com.example.springdatabasicdemo.repositories.*;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidationUtilImpl implements ConstraintValidator<ValidationUtil, String> {
    private final BrandRepository brandRepository;

    public ValidationUtilImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return brandRepository.findByName(value).isEmpty();
    }
}