package cn.archongum.hive.runner;

import com.klarna.hiverunner.HiveRunnerExtension;
import com.klarna.hiverunner.HiveShell;
import com.klarna.hiverunner.annotations.HiveSQL;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(HiveRunnerExtension.class)
public class MyUpperUDFTest {

    @HiveSQL(files = {})
    private HiveShell shell;

    @Test
    public void testMyUpperUDF() {
        // Create function
        String createFunctionSQL = "CREATE TEMPORARY FUNCTION my_upper AS 'cn.archongum.hive.udf.MyUpperUDF'";
        System.out.println("[INFO] Executing SQL: " + createFunctionSQL);
        shell.execute(createFunctionSQL);

        // Execute function
        String selectSQL = "select my_upper('my_upper_udf')";
        System.out.println("[INFO] Executing SQL: " + selectSQL);
        List<Object[]> result = shell.executeStatement(selectSQL);

        // Check function return
        for (Object[] rows : result) {
            for (Object column : rows) {
                System.out.println("[INFO] column value: " + column);
            } 
        }
        assertEquals("MY_UPPER_UDF", result.get(0)[0]);
    }
}
