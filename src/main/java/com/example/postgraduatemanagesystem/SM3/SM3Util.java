package com.example.postgraduatemanagesystem.SM3;

import org.bouncycastle.jcajce.provider.digest.SM3;
import org.bouncycastle.util.encoders.Hex;

public class SM3Util {
    public static String hash(String input) {
        SM3.Digest sm3Digest = new SM3.Digest();
        byte[] hash = sm3Digest.digest(input.getBytes());
        return Hex.toHexString(hash);
    }
}
