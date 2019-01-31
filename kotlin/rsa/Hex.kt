package rsa

object Hex {

    fun toDecimal(s: String): String {
        var s = s.toUpperCase()
        val digits = "0123456789ABCDEF"
        s = s.toUpperCase()
        var value = ""
        for (i in 0 until s.length) {
            val c = s.get(i)
            val d = digits.indexOf(c)
            //value = 16 * `val` + d

            val multi = BigInteger.multiply("16", value)
            value = BigInteger.addition(multi, "$d")
        }
        return value
    }
}