package lv.lu.finalwork.system;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.repository.ProductRepository;
import lv.lu.finalwork.ui.Launcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern numberPattern = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
    private static final Pattern decimalPattern = Pattern.compile("^[0-9]*\\.[0-9]+$", Pattern.CASE_INSENSITIVE);
    private static final Pattern wordPattern = Pattern.compile("([A-Za-z])", Pattern.CASE_INSENSITIVE);

    public static boolean validateMenu(String _userInput, char... _allowedChars) {
        for (char character : _allowedChars) {
            if (Character.toUpperCase(_userInput.charAt(0)) == character) return true;
        }
        Matcher matcher = numberPattern.matcher(_userInput);
        return matcher.find();
    }

    public static boolean validateMenuOnlyChars(String _userInput, char... _allowedChars) {
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
        } catch (Exception e){
            return false;
        }
        return false;
    }

}
