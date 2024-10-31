package cn.archongum.hive.udf

import org.apache.hadoop.hive.ql.exec.Description
import org.apache.hadoop.hive.ql.exec.UDF


/**
 * See `Description`
 * @author: Archon
 * @version: 0.0.1
 */
@Description(
    name = "my_upper",
    value = """_FUNC_(string) - return upper string"""
)
class MyUpperUDF: UDF() {

    fun evaluate(str: String?): String? {
        if (str == null) {
            return null
        }
        return str.uppercase()
    }
}

fun main() {
    println(MyUpperUDF().evaluate("my_upper_str"))
}
