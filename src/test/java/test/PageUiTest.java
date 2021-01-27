package test;

import data.DataHelper;
import data.DbHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import page.DashboardPage;

import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Selenide.open;

public class PageUiTest {
    int amount = 45_000_00;

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    /*===================================*/
    /*          Approved credit         */
    /*_________________________________*/

    @Test
    @Disabled
    void shouldApproveViaCredit() {
        new DashboardPage().goToCreditPage().approved(DataHelper.getValidApprovedFields());
        assertNull(DbHelper.getPaymentId());
    }

    @Test
    void shouldInsertCId() {
        new DashboardPage().goToCreditPage().approved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getCId());
    }

    @Test
    @Disabled
    void shouldInsertCreditIdAndTransactionId() {
        new DashboardPage().goToCreditPage().approved(DataHelper.getValidApprovedFields());
        assertEquals(DbHelper.getCreditId(), DbHelper.getCreditBankId());
        assertNotNull(DbHelper.getCreditId());
    }

    @Test
    void shouldInsertCreditCreated() {
        new DashboardPage().goToCreditPage().approved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getCreditCreated());
    }

    @Test
    void shouldInsertApprovedCreditStatus() {
        new DashboardPage().goToCreditPage().approved(DataHelper.getValidApprovedFields());
        assertEquals("APPROVED", DbHelper.getCreditStatus());
    }

    @Test
    void shouldInsertCreditOrderId() {
        new DashboardPage().goToCreditPage().approved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getOrderId());
    }

    @Test
    void shouldInsertCreditOrderCreated() {
        new DashboardPage().goToCreditPage().approved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getOrderCreated());
    }

    /*===================================*/
    /*          Declined credit         */
    /*_________________________________*/

    @Test
    @Disabled
    void shouldDeclineViaCredit() {
        new DashboardPage().goToCreditPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNull(DbHelper.getPaymentId());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedCId() {
        new DashboardPage().goToCreditPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getCId());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedCreditIdAndTransactionId() {
        new DashboardPage().goToCreditPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals(DbHelper.getCreditId(), DbHelper.getCreditBankId());
        assertNotNull(DbHelper.getCreditId());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedCreditCreated() {
        new DashboardPage().goToCreditPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getCreditCreated());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedCreditStatus() {
        new DashboardPage().goToCreditPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals("DECLINED", DbHelper.getCreditStatus());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedCreditOrderId() {
        new DashboardPage().goToCreditPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getOrderId());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedCreditOrderCreated() {
        new DashboardPage().goToCreditPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getOrderCreated());
    }

    /*===================================*/
    /*          Invalid credit          */
    /*_________________________________*/

    @Test
    void shouldDeclineViaCreditWithEmptyFields() {
        new DashboardPage().goToCreditPage().declinedWithEmptyFields();
    }

    @Test
    @Disabled
    void shouldDeclineViaCreditWithInvalidCard() {
        new DashboardPage().goToCreditPage().declinedWithInvalidCard(DataHelper.getInvalidCardFields());
    }

    @Test
    @Disabled
    void shouldDeclineViaCreditWithInvalidOwner() {
        new DashboardPage().goToCreditPage().declinedWithInvalidOwner(DataHelper.getInvalidOwnerFields());
    }

    /*=======================================*/
    /*          Approved payment            */
    /*_____________________________________*/

    @Test
    void shouldApproveViaPayment() {
        new DashboardPage().goToPaymentPage().approved(DataHelper.getValidApprovedFields());
        assertNull(DbHelper.getCreditId());
    }

    @Test
    void shouldInsertPId() {
        new DashboardPage().goToPaymentPage().approved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getPId());
    }

    @Test
    void shouldInsertPaymentAmount() {
        new DashboardPage().goToPaymentPage().approved(DataHelper.getValidApprovedFields());
        assertEquals(amount, DbHelper.getPaymentAmount());
    }

    @Test
    void shouldInsertPaymentCreated() {
        new DashboardPage().goToPaymentPage().approved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getPaymentCreated());
    }

    @Test
    void shouldInsertApprovedPaymentStatus() {
        new DashboardPage().goToPaymentPage().approved(DataHelper.getValidApprovedFields());
        assertEquals("APPROVED", DbHelper.getPaymentStatus());
    }

    @Test
    void shouldInsertPaymentIdAndTransactionId() {
        new DashboardPage().goToPaymentPage().approved(DataHelper.getValidApprovedFields());
        assertEquals(DbHelper.getPaymentId(), DbHelper.getPaymentTransactionId());
        assertNotNull(DbHelper.getPaymentId());
    }

    @Test
    void shouldInsertPaymentOrderId() {
        new DashboardPage().goToPaymentPage().approved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getOrderId());
    }

    @Test
    void shouldInsertPaymentOrderCreated() {
        new DashboardPage().goToPaymentPage().approved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getOrderCreated());
    }

    /*=======================================*/
    /*          Declined payment            */
    /*_____________________________________*/

    @Test
    @Disabled
    void shouldDeclineViaPayment() {
        new DashboardPage().goToPaymentPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNull(DbHelper.getCreditId());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedPId() {
        new DashboardPage().goToPaymentPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getPId());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedPaymentAmount() {
        new DashboardPage().goToPaymentPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals(amount, DbHelper.getPaymentAmount());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedPaymentCreated() {
        new DashboardPage().goToPaymentPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getPaymentCreated());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedPaymentStatus() {
        new DashboardPage().goToPaymentPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals("DECLINED", DbHelper.getPaymentStatus());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedPaymentIdAndTransactionId() {
        new DashboardPage().goToPaymentPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals(DbHelper.getPaymentId(), DbHelper.getPaymentTransactionId());
        assertNotNull(DbHelper.getPaymentId());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedOrderId() {
        new DashboardPage().goToPaymentPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getOrderId());
    }

    @Test
    @Disabled
    void shouldInsertDeclinedPaymentOrderCreated() {
        new DashboardPage().goToPaymentPage().declinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getOrderCreated());
    }

    /*===================================*/
    /*          Invalid payment         */
    /*_________________________________*/

    @Test
    void shouldDeclineViaPaymentWithEmptyFields() {
        new DashboardPage().goToPaymentPage().declinedWithEmptyFields();
    }

    @Test
    @Disabled
    void shouldDeclineViaPaymentWithInvalidCard() {
        new DashboardPage().goToPaymentPage().declinedWithInvalidCard(DataHelper.getInvalidCardFields());
    }

    @Test
    @Disabled
    void shouldDeclineViaPaymentWithInvalidOwner() {
        new DashboardPage().goToPaymentPage().declinedWithInvalidOwner(DataHelper.getInvalidOwnerFields());
    }
}