package cn.archongum.hive.runner;

import com.klarna.hiverunner.HiveRunnerExtension;
import com.klarna.hiverunner.HiveShell;
import com.klarna.hiverunner.annotations.HiveSQL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Based on: https://github.com/HiveRunner/HiveRunner/blob/main/src/test/java/com/klarna/hiverunner/examples/HelloHiveRunnerTest.java
 */
@ExtendWith(HiveRunnerExtension.class)
public class HelloHiveRunnerTest {

    @HiveSQL(files = {})
    private HiveShell shell;

    @BeforeEach
    public void setupSourceDatabase() {
        shell.execute("CREATE DATABASE source_db");
        shell.execute(new StringBuilder()
            .append("CREATE TABLE source_db.test_table (")
            .append("year STRING, value INT")
            .append(")")
            .toString());

        shell.execute(Paths.get("src/test/resources/HelloHiveRunnerTest/create_max.sql"));
    }

    @Test
    public void testMaxValueByYear() {
        System.out.println("executing unit test: testMaxValueByYear");
        assertEquals(2, 2);
        /*
         * Insert some source data
         */
        shell.insertInto("source_db", "test_table")
                .withColumns("year", "value")
                .addRow("2014", 3)
                .addRow("2014", 4)
                .addRow("2015", 2)
                .addRow("2015", 5)
                .commit();

        // /*
        //  * Execute the query
        //  */
        shell.execute(Paths.get("src/test/resources/HelloHiveRunnerTest/calculate_max.sql"));

        // /*
        //  * Verify the result
        //  */
        List<Object[]> result = shell.executeStatement("select * from my_schema.result");
        for (Object[] rows : result) {
            for (Object column : rows) {
                System.out.println("column value: " + column);
            } 
        }

        // assertEquals(2, result.size());
        assertArrayEquals(new Object[]{"2014",4}, result.get(0));
        assertArrayEquals(new Object[]{"2015",5}, result.get(1));
    }
}
