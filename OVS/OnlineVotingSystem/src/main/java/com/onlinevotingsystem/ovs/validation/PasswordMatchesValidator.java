package com.onlinevotingsystem.ovs.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.onlinevotingsystem.ovs.user.CrmUser;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final CrmUser user = (CrmUser) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
