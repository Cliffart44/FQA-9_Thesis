package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class DbHelper {
    private final static Connection conn = establishConnection();
    private final static QueryRunner runn = new QueryRunner();

    private DbHelper() {
    }

    @SneakyThrows
    private static Connection establishConnection() {
        /* First for PostgreSQL */
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        /* Second for MySQL */
    }

    /* credit_request_entity table */

    @SneakyThrows
    public static String getCId() {
        List<Fields> ids = runn.query(conn, "SELECT id FROM credit_request_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return ids.get(ids.size() - 1).getId();
    }

    @SneakyThrows
    public static String getCreditBankId() {
        List<Fields> bankIds = runn.query(conn, "SELECT bank_id FROM credit_request_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return bankIds.get(bankIds.size() - 1).getBank_id();
    }

    @SneakyThrows
    public static String getCreditCreated() {
        List<Fields> created = runn.query(conn, "SELECT created FROM credit_request_entity;", new BeanListHandler<>(Fields.class));
        return created.get(created.size() - 1).getCreated();
    }

    @SneakyThrows
    public static String getCreditStatus() {
        List<Fields> statuses = runn.query(conn, "SELECT status FROM credit_request_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return statuses.get(statuses.size() - 1).getStatus();
    }

    /* order_entity table */

    @SneakyThrows
    public static String getOrderId() {
        List<Fields> orderIds = runn.query(conn, "SELECT id FROM order_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return orderIds.get(orderIds.size() - 1).getId();
    }

    @SneakyThrows
    public static String getOrderCreated() {
        List<Fields> created = runn.query(conn, "SELECT created FROM order_entity;", new BeanListHandler<>(Fields.class));
        return created.get(created.size() - 1).getCreated();
    }

    @SneakyThrows
    public static String getCreditId() {
        List<Fields> creditIds = runn.query(conn, "SELECT credit_id FROM order_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return creditIds.get(creditIds.size() - 1).getCredit_id();
    }

    @SneakyThrows
    public static String getPaymentId() {
        List<Fields> paymentIds = runn.query(conn, "SELECT payment_id FROM order_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return paymentIds.get(paymentIds.size() - 1).getPayment_id();
    }

    /* payment_entity table*/

    @SneakyThrows
    public static String getPId() {
        List<Fields> ids = runn.query(conn, "SELECT id FROM payment_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return ids.get(ids.size() - 1).getId();
    }

    @SneakyThrows
    public static int getPaymentAmount() {
        List<Fields> amounts = runn.query(conn, "SELECT amount FROM payment_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return amounts.get(amounts.size() - 1).getAmount();
    }

    @SneakyThrows
    public static String getPaymentCreated() {
        List<Fields> created = runn.query(conn, "SELECT created FROM payment_entity;", new BeanListHandler<>(Fields.class));
        return created.get(created.size() - 1).getCreated();
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        List<Fields> statuses = runn.query(conn, "SELECT status FROM payment_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return statuses.get(statuses.size() - 1).getStatus();
    }

    @SneakyThrows
    public static String getPaymentTransactionId() {
        List<Fields> transactionIds = runn.query(conn, "SELECT transaction_id FROM payment_entity ORDER BY created;", new BeanListHandler<>(Fields.class));
        return transactionIds.get(transactionIds.size() - 1).getTransaction_id();
    }
}
