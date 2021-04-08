package lv.lu.finalwork.system;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.repository.ProductRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern numberPattern = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
    private static final Pattern decimalPattern = Pattern.compile("^[0-9]*\\.[0-9]+$", Pattern.CASE_INSENSITIVE);
    private static final Pattern wordPattern = Pattern.compile("([A-Za-z])", Pattern.CASE_INSENSITIVE);

    public static boolean validateMenuChars(String _userInput, char... _allowedChars) {

        if(_userInput.isEmpty()) return false;
        for (char character : _allowedChars) {
            if (Character.toUpperCase(_userInput.charAt(0)) == character) return true;
        }
        return false;
    }


    public static boolean validateTextInput(String _userInput) {
        Matcher decimalMatcher = decimalPattern.matcher(_userInput);
        Matcher wordMatcher = wordPattern.matcher(_userInput);
        Matcher numberMatcher = numberPattern.matcher(_userInput);
        return decimalMatcher.find() || wordMatcher.find() || numberMatcher.find();
    }

    public static boolean validateCategoryMenuInput(String _userInput, char... _allowedChars) {
        try {
            int inputNumber = Integer.parseInt(_userInput);
            return inputNumber <= ProductCategory.values().length && inputNumber >= 1;
        } catch (Exception e) {
            for (char character : _allowedChars) {
                if (Character.toUpperCase(_userInput.charAt(0)) == character) return true;
            }
        }
        return false;

    }

    public static boolean validateProductIdAllRange(String _userInput, ProductRepository _repo) {
        try {
            int inputNumber = Integer.parseInt(_userInput);
            for (Product product : _repo.findAll()) {
                if (product.getId() == inputNumber) return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean validateProductIdWithinCategoryRange(String _userInput, ProductRepository _repo, ProductCategory _category) {
        try {
            int inputNumber = Integer.parseInt(_userInput);
            for (Product product : _repo.findAll()) {
                if (product.getId() == inputNumber && product.getCategory() == _category) return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean validateDoubleInput(String value) {
        try{
            Double.parseDouble(value);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean validatePercentageInput(String value) {
        try{
            int result = Integer.parseInt(value);
            if(result >= 0 && result <= 99) return true;

        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean validateYesNoInput(String value) {
        char letter = value.charAt(0);
        if (Character.toUpperCase(letter) == 'Y' || Character.toUpperCase(letter) == 'N') return true;
        return true;
    }
}
