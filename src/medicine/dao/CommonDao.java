package medicine.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import medicine.util.DbUtil;

public class CommonDao {

    public static double getRound(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        double roundValue = Math.round(Double.parseDouble(df.format(value)));
        return roundValue;
    }

    public static double getTwoDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        double roundValue = Double.parseDouble(df.format(value));
        return roundValue;
    }

    public static double getPercentage(double percent, double amount) {
        double proportion ;
        double realAmount;
        if (percent > 0 && amount > 0) {
            proportion = (percent * amount) / 100;
            realAmount = amount - proportion;
        } else {
            realAmount = amount;
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(realAmount));
    }

    public static int getNumberOfRecords(String tableName) {

        int totalRecord = 0;
        try {
            Connection connection = DbUtil.getConnection();
            String sql = "SELECT  COUNT(*) totalRecord FROM " + tableName;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                totalRecord = rs.getInt("totalRecord");
            }
        } catch (Exception e) {
            System.out.println("");
        }
        return totalRecord;
    }
}
