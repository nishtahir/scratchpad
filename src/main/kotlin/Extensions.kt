fun isValidTriangle(values: List<Int>): Boolean = values[0] + values[1] > values[2] && values[0] + values[2] > values[1] && values[1] + values[2] > values[0]

inline fun <reified T> List<T>.grouped(by: Int): List<List<T>> {
    require(by > 0)
    return if (isEmpty()) {
        emptyList()
    } else {
        (0..lastIndex / by).map {
            val fromIndex = it * by
            val toIndex = Math.min(fromIndex + by, this.size)
            subList(fromIndex, toIndex)
        }
    }
}

/**
 * Not a very good transpose function. Works for squares though...
 */
inline fun <reified T> transpose(values: List<List<T>>): List<List<T>> {
    return values.indices.map { i -> values[0].indices.map { values[it][i] } }
}