package com.example.myapplication.security

import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom

/**
 * Object that holds common encryption methods and a salt generation method.
 *
 * @author Michael Wyda
 */
class Encryption {

    /**
     * Encrypts a string in hexadecimal format using the SHA-256 hash algorithm.
     * If SHA-256 does not exist, then the original string is returned. This is
     * a cryptographic hash function, designed not to be decrypted. Use this
     * concept to store passwords in a database
     *
     * @param originalString The original string.
     * @return The encrypted string.
     */
    private fun encryptSHA256(originalString: String): String {
        var digest: ByteArray? = null
        var hexString: StringBuilder = StringBuilder()
        try {
            val md:MessageDigest = MessageDigest.getInstance("SHA-256")
            /*
                Uses UTF 8
                This means it uses 1 byte to represent characters in the ASCII set
             */
            md.update(originalString.toByte())
            digest = md.digest()
            for (i in digest.indices) {
                if ((0xff and digest[i].toInt()) < 0x10) {
                    hexString.append("0")
                }
                hexString.append(Integer.toHexString(0xFF and digest[i].toInt()))
            }
        } catch (ex:NoSuchAlgorithmException) {
            return originalString
        }
        return hexString.toString()
    }

    /**
     * Encrypts a string in hexadecimal format using the SHA-1 hash algorithm.
     * If SHA-1 does not exist, then the original string is returned. This is a
     * cryptographic hash function, designed not to be decrypted. Use this
     * concept to store passwords in a database
     *
     * @param originalString The original string.
     * @return The encrypted string.
     */
    private fun encryptSHA1(originalString: String): String {
        val alg = "SHA-1"
        var bytes: ByteArray? = null
        try {
            // gets bytes from encryption algorithm
            bytes = MessageDigest.getInstance(alg).digest(originalString.toByteArray())
        } catch (e: NoSuchAlgorithmException) {
            val msg = ("The encryption algorithm " + alg
                    + " is not available or does not exist.")
            return originalString
        }

        // translates bytes to hex string
        val hexStrBuf = java.lang.StringBuilder()
        for (b in bytes) {
            val str = Integer.toHexString(b.toInt() and 0xff)
            hexStrBuf.append(if (str.length == 1) "0" else "").append(str)
        }

        return hexStrBuf.toString()
    }

    /**
     * Encrypts a string in hexadecimal format using the MD5 hash algorithm.
     * If MD5 does not exist, then the original string is returned. This is a
     * cryptographic hash function, designed not to be decrypted. Use this
     * concept to store passwords in a database
     *
     * @param originalString The original string.
     * @return The encrypted string.
     */
    private fun encryptMD5(originalString: String): String {
        val alg = "MD5"
        var bytes: ByteArray? = null
        try {
            // gets bytes from encryption algorithm
            bytes = MessageDigest.getInstance(alg).digest(originalString.toByteArray())
        } catch (e: NoSuchAlgorithmException) {
            val msg = ("The encryption algorithm " + alg
                    + " is not available or does not exist.")
            return originalString
        }

        // translates bytes to hex string
        val hexStrBuf = java.lang.StringBuilder()
        for (b in bytes) {
            val str = Integer.toHexString(b.toInt() and 0xff)
            hexStrBuf.append(if (str.length == 1) "0" else "").append(str)
        }

        return hexStrBuf.toString()
    }

    /**
     * A method that when given a hashed string will determine the hashing algorithm used
     * to generate the string based on the length of the string.
     * The legal algorithms are MD5 or SHA-1 or SHA-256.
     */
    fun determineHashAlgorithm(hashedValue: String): String? {
        val algorithm: String? = null
        if (hashedValue.length == 32) return "MD5"
        if (hashedValue.length == 40) return "SHA-1"
        if (hashedValue.length == 64) return "SHA-256"
        return algorithm
    }

    /**
     * Encrypt the given string based on the name of the one way hashing algorithm
     * specified. Legal algorithms are MD5, SHA-1, SHA-256.
     *
     * @param originalString The string to hash.
     * @param algorithm The algorithm to use to perform the hashing.
     * @return The hashed string if a legal algorithm is specified, otherwise
     * the original string.
     */
    fun encrypt(originalString: String?, algorithm: String?): String? {
        if (originalString == null || algorithm == null) return originalString
        val encryptedString: String? = null
        if (algorithm.equals("MD5", ignoreCase = true)) return encryptMD5(
            originalString
        )
        if (algorithm.equals("SHA-1", ignoreCase = true)) return encryptSHA1(
            originalString
        )
        if (algorithm.equals(
                "SHA-256",
                ignoreCase = true
            )
        ) return encryptSHA256(originalString)
        return encryptedString //Return the original string if not one of our 3 algs.
    }

    fun generateSalt(): String {
        /* 128 bits for strong security */
        val random = SecureRandom()
        return BigInteger(130, random).toString(32)
        /*
          BigInteger(130, random) -- a random integer between 0 and 2^130 -1
          toString(32) -> We are getting the string representation of the number
          in base 32 instead of the traditional base 10. If you passed 16, you
          would get the number in hexadecimal format, with digits going from 0 to f.
          If you passed 8, you would get it as an octal number, with digits going from 0 to 7.
          toString(32) --> 32 = 2^5, so each character will take 5 of the 130 bits.
          130/5 = 26.  So 130 bits will produce 26 characters if you use 5 bits to
          determine each character.

         */
    }

    /**
     * Encrypts a string in hexadecimal format using the SHA-256 hash algorithm.
     * If SHA-256 does not exist, then the original string is returned. This is
     * a cryptographic hash function, designed not to be decrypted. Use this
     * concept to store passwords in a database
     *
     * @param s The original string.
     * @return The encrypted string.
     */
    fun hashString(s: String): String {
        var digest: ByteArray? = null
        val hexString = java.lang.StringBuilder()
        try {
            val md = MessageDigest.getInstance("SHA-256")
            md.update(s.toByteArray(StandardCharsets.UTF_8))
            digest = md.digest()
            for (i in digest.indices) {
                if ((0xff and digest[i].toInt()) < 0x10) {
                    hexString.append("0")
                }
                hexString.append(Integer.toHexString(0xFF and digest[i].toInt()))
            }
        } catch (ex: NoSuchAlgorithmException) {
            return s
        }
        return hexString.toString()
    }

}