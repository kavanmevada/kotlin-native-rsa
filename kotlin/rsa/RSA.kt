package rsa

object RSA {

    //http://extranet.cryptomathic.com/rsacalc/index

    fun encode(n: String, e: String, msgInt: String): Long {

        println("Public key (n, e) : ($n, $e)")


        val c = BigInteger.PowMod(msgInt, e, n)

        println("Encrypted data = $c")

        return c
    }


    fun decode(p: String, q: String, d: String, cipInt: String) : Long {

        val n = BigInteger.multiply(p, q)

        println("Private key (n, d) = ($n, $d)")


        // Decryption m = (c ^ d) % n
        //val m1 = c.power(d) % n
        val c = cipInt

        val m1 = BigInteger.PowMod(c, d, n)

        println("\nOriginal Message Sent = $m1")

        return m1
    }


    //Decryption Does not Working //TODO
    fun decode(n: String, d: String, cipInt: String) {

        println("Private key (n, d) = ($n, $d)")


        // Decryption m = (c ^ d) % n
        //val m1 = c.power(d) % n

        val c = cipInt
        val decry = BigInteger.PowMod(c, d, n)

        println("Decrypted data = $decry")

    }
}