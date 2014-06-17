/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package certest;

/**
 *
 * @author WINDOWS8
 */
import java.io.IOException;
import java.net.UnknownHostException;
import java.security.cert.Certificate;
 
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
 
public class Certest {
    public static void main(final String[] args) throws UnknownHostException, IOException {
        String hostname;
        int port;
        char[] passphrase;
        if ((args.length == 1) || (args.length == 2)) {
            final String[] c = args[0].split(":");
            hostname = c[0];
            port = (c.length == 1) ? 443 : Integer.parseInt(c[1]);
            final String p = (args.length == 1) ? "changeit" : args[1];
            passphrase = p.toCharArray();
        } else {
            System.out.println(
                    "Usage: java InstallCert <host>[:port] [passphrase]");
            return;
        }
 
        
        
        // get debug information of SSL
        System.setProperty("javax.net.debug", "ssl");
 
        SSLSocketFactory factory = HttpsURLConnection.getDefaultSSLSocketFactory();
        SSLSocket socket = (SSLSocket) factory.createSocket(hostname, port);
 
        socket.startHandshake();
 
        System.out.println("===============");
 
        Certificate[] serverCerts = socket.getSession().getPeerCertificates();
        System.out.println("number of found certificates: " + serverCerts.length);
        System.out.println("===============");
        for (Certificate certificate : serverCerts) {
            System.out.println(certificate.getPublicKey());
            System.out.println(certificate);
            System.out.println("===============");
        }
 
        socket.close();
    }
}