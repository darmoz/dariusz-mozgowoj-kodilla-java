import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;

public class StoredProcTestSuite {
    @Test
    public void testUpdateBestseller() throws Exception {
        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = FALSE";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //when
        String sqlProcedureCall = "CALL UpdateBestseller()";
        statement.execute(sqlProcedureCall);
        //then
        String checkUpdate = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = TRUE";
        ResultSet resultSet = statement.executeQuery(checkUpdate);
        int howMany = -1;
        if(resultSet.next()) {
            howMany=resultSet.getInt("HOW_MANY");
        }
        Assert.assertEquals(1, howMany);
    }
}
