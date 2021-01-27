package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

    private static String cardNumber(int item) {
        /* 4441 card is APPROVED, 4442 - DECLINED, others - INVALID */
        String[] cards = {"4444 4444 4444 4444", "4444 4444 4444 4441", "4444 4444 4444 4442"};
        if (item >= 1 && item <= 2) {
            return cards[item];
        }
        return cards[0];
    }

    private static String fullName() {
        return new Faker().name().firstName().toUpperCase(Locale.ROOT) + " " + new Faker().name().firstName().toUpperCase(Locale.ROOT);
    }

    private static String cvcCvv() {
        Random dgt = new Random();
        return String.valueOf(dgt.nextInt(10)) + dgt.nextInt(10) + dgt.nextInt(10);
    }

    @Value
    public static class RequiredFields {
        String cardNumber;
        String month;
        String year;
        String owner;
        String cvcCvv;
    }

    public static RequiredFields getValidApprovedFields() {
        return new RequiredFields(cardNumber(1), "12", "26", fullName(), cvcCvv());
    }

    public static RequiredFields getValidDeclinedFields() {
        return new RequiredFields(cardNumber(2), "12", "26", fullName(), cvcCvv());
    }

    public static RequiredFields getInvalidCardFields() {
        return new RequiredFields(cardNumber(0), "12", "26", fullName(), cvcCvv());
    }

    public static RequiredFields getInvalidOwnerFields() {
        return new RequiredFields(cardNumber(1), "12", "26", "Ъ", cvcCvv());
    }
}