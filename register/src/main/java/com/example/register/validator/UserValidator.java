package com.example.register.validator;

import com.example.register.model.User;
import com.example.register.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Autowired
    private UserSevice userSevice;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32){
            errors.rejectValue("username","Size.userForm.username");
        }
        if (userSevice.findByUsername(user.getUsername()) != null){
            errors.rejectValue("username","Duplicate.userFrom.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty");
        if (user.getPassword().length() < 8 || user.getUsername().length() > 32){
            errors.rejectValue("password","Size.userForm.username");
        }
        if (userSevice.findByUsername(user.getUsername()) != null){
            errors.rejectValue("passwordConfirm","Diff.userFrom.passwordConfirm");
        }
    }
}
