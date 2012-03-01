package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidateDate implements Validator {
	public ValidateDate() {
	}

	public void validate(FacesContext facesContext, UIComponent component,
			Object object) throws ValidatorException {
		if (facesContext == null || component == null) {
			throw new NullPointerException();
		}
		if (!(component instanceof UIInput)) {
			return;
		}
		FacesMessage message = new FacesMessage();
		message.setSummary("Invalid Date");
		message.setDetail("Invalid Date (Must Be In dd-MMM-yyyy Format)!");
		String[] date = new String[3];
		/* checking the format of date */
		if (!object
				.toString()
				.trim()
				.matches(
				"(0[1-9]||[12][0-9]||3[01])-(JAN||FEB||MAR||APR||MAY||JUN||JUL||AUG||SEP||OCT||NOV||DEC)-((19||20)[0-9]{2})")) {
			throw new ValidatorException(message);
		} else {
			/* Splitting the date into day, month and year */
			date = object.toString().split("-");
			int day = Integer.parseInt(date[0]);
			String month = date[1];
			int year = Integer.parseInt(date[2]);
			/* Validating the day of the month */
			if ((month.equals("APR") || month.equals("JUN")
					|| month.equals("SEP") || month.equals("NOV"))
					&& (day == 31)) {
				message.setDetail("The entered month has only 30days");
				throw new ValidatorException(message);
			}
			/* for Feb in a leap year */
			else if (((year % 400) == 0 || (year % 4) == 0)
					&& month.equals("FEB") && day > 29) {
				message.setDetail("February in a leap year hasonly 29 days");
				throw new ValidatorException(message);
			}
			/* for Feb in a non leap year */
			else if (!((year % 400) == 0 || (year % 4) == 0)
					&& month.equals("FEB") && day > 28) {
				message.setDetail("February in a non leap yearhas only 28 days");
				throw new ValidatorException(message);
			}
		}
	}
}
