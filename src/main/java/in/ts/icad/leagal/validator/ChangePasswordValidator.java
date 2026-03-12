package in.ts.icad.leagal.validator;

import in.ts.icad.leagal.model.User;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class ChangePasswordValidator {
	
public boolean supports(Class<?> clazz) {
		
		return User.class.isAssignableFrom(clazz);
		
	}

	@SuppressWarnings("unused")
	public void validate(Object model, Errors errors) {
		User user = (User) model;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword",
				"errors.required", "oldPassword is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"errors.required", "confirm password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword",
				"errors.required", "new password is required.");
	}


}
