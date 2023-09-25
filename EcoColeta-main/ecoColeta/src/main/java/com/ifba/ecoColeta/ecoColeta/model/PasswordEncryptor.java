//CLASSE TESTE DE CRIPTOGRAFIA DE SENHA






// package com.ifba.ecoColeta.ecoColeta.model;

// import java.security.NoSuchAlgorithmException;
// import java.security.MessageDigest;
// //import java.security.NoSuchAlgorithmException;

// public class PasswordEncryptor {
//     public static String encryptPassword(String password) {
//         try {
//             // Create MD5 hashing instance
//             MessageDigest md = MessageDigest.getInstance("MD5");

//             // Add password bytes to digest
//             md.update(password.getBytes());

//             // Get the hashed password bytes
//             byte[] hashedBytes = md.digest();

//             // Convert the bytes to hexadecimal format
//             StringBuilder sb = new StringBuilder();
//             for (byte hashedByte : hashedBytes) {
//                 sb.append(Integer.toString((hashedByte & 0xff) + 0x100, 16).substring(1));
//             }

//             // Return the hashed password
//             return sb.toString();
//         } catch (NoSuchAlgorithmException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }
