package rsa


object BigInteger {


    // Returns modulo exponentiation for
    // two numbers  represented as strings.
    // It is used by powerStrings()
    // TODO "Might not proper implemented, but with testing some small values it works"
    fun PowMod(sa: String, sb: String, _MOD: String): Long {
        // We convert strings to number
        var a: Long = 0
        var b: Long = 0

        var MOD: Long = 0

        for (i in 0 until _MOD.length) {
            MOD = (MOD * 10 + (_MOD.get(i) - '0'))
        }

        // calculating a % MOD
        for (i in 0 until sa.length) {
            a = (a * 10 + (sa.get(i) - '0')) % MOD
        }

        // calculating b % (MOD - 1)
        for (i in 0 until sb.length) {
            b = (b * 10 + (sb.get(i) - '0')) % (MOD - 1)
        }

        // Now a and b are long long int. We
        // calculate a^b using modulo exponentiation
        return PowModLL(a, b, MOD)
    }



    // Returns modulo exponentiation for
    // two numbers  represented as strings.
    // It is used by powerStrings()
    fun PowModLL(x: Long, y: Long, p: Long): Long {
        var x = x
        var y = y

        // Initialize result
        var res = 1L

        // Update x if it is more
        // than or equal to p
        x %= p

        while (y > 0) {
            // If y is odd, multiply x with result
            if (y % 2L != 0L)
                res = res * x % p

            // y must be even now
            y = y shr 1 // y = y/2
            x = x * x % p
        }
        return res
    }





    // multiply
    fun multiply(num1: String, num2: String): String {
        val n1 = StringBuilder(num1).reverse().toString()
        val n2 = StringBuilder(num2).reverse().toString()

        val d = IntArray(num1.length + num2.length)

        //multiply each digit and sum at the corresponding positions
        for (i in 0 until n1.length) {
            for (j in 0 until n2.length) {
                d[i + j] += (n1.get(i) - '0') * (n2.get(j) - '0')
            }
        }

        val sb = StringBuilder()

        //calculate each digit
        for (i in d.indices) {
            val mod = d[i] % 10
            val carry = d[i] / 10
            if (i + 1 < d.size) {
                d[i + 1] += carry
            }
            sb.insert(0, mod)
        }

        //remove front 0's
        while (sb.get(0) == '0' && sb.length > 1) {
            sb.deleteCharAt(0)
        }

        return sb.toString()
    }


    fun addition(_str1: String, _str2: String): String {
        var str1 = _str1
        var str2 = _str2
        // Before proceeding further, make sure length
        // of str2 is larger.
        if (str1.length > str2.length) {
            val t = str1
            str1 = str2
            str2 = t
        }

        // Take an empty String for storing result
        var str = ""

        // Calculate lenght of both String
        val n1 = str1.length
        val n2 = str2.length
        val diff = n2 - n1

        // Initialy take carry zero
        var carry = 0

        // Traverse from end of both Strings
        for (i in n1 - 1 downTo 0) {
            // Do school mathematics, compute sum of
            // current digits and carry
            val sum = (str1.get(i) - '0') +
                    (str2.get(i + diff) - '0') + carry
            str += (sum % 10 + '0'.toInt()).toChar()
            carry = sum / 10
        }

        // Add remaining digits of str2[]
        for (i in n2 - n1 - 1 downTo 0) {
            val sum = (str2.get(i) - '0') + carry
            str += (sum % 10 + '0'.toInt()).toChar()
            carry = sum / 10
        }

        // Add remaining carry
        if (carry > 0) str += (carry + '0'.toInt()).toChar()

        // reverse resultant String
        return StringBuilder(str).reverse().toString()
    }





    //TODO "Power Function isn't implemented"
    //TODO "mode function isn't implemented"

}