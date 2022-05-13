package pl.devopsi.akademia.mod7zad1.customvalidator;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {

    private String localizationCode;

    @Override
    public void initialize(PhoneNumber phoneNumber) {
        System.out.println("Inicjalizacja PhoneNumberValidator: "+ phoneNumber.localization());
        ConstraintValidator.super.initialize(phoneNumber);
        this.localizationCode = phoneNumber.localization();
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Validowanie PhoneNumberValidator dla: "+ phoneNumber+", lokalizacja: "+this.localizationCode);
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try{
            PhoneNumberUtil.ValidationResult result = phoneUtil.isPossibleNumberWithReason(phoneUtil.parse(phoneNumber,this.localizationCode));
            if (result == PhoneNumberUtil.ValidationResult.IS_POSSIBLE)
                return true;
            else {
                System.out.println("Walidator numeru telefonu zwrócił błąd dla numeru:  "+phoneNumber+", kodu lokalizacji: "+this.localizationCode+", o treści: "+result);
            }

        }catch(NumberParseException e) {
            System.err.println("Walidator numeru telefonu zgłosił wyjątek dla numeru:  "+phoneNumber+", kodu lokalizacji: "+this.localizationCode+", o treści: "+e );
        }
        return false;
    }

}
