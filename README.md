Rongo
=====
Rongo es una aplicación de la Escuela Superior Politénica del Litoral. Creada como proyecto para la materia
Ingeniería de Software I y II.

Archivos Útiles: SSLPoke
=====

    package sslpoke;
    
	import javax.net.ssl.SSLSocket;
	import javax.net.ssl.SSLSocketFactory;
	import java.io.*;
			 
	public class SSLPoke {
		public static void main(String[] args) {
			if (args.length != 2) {
				System.out.println("Usage: " + SSLPoke.class.getName() + 
				"<host> <port>");
				System.exit(1);
			}
			try {
				SSLSocketFactory sslsocketfactory = (SSLSocketFactory)
				SSLSocketFactory.getDefault();
				SSLSocket sslsocket = (SSLSocket)
				sslsocketfactory.createSocket(args[0], Integer.parseInt(args[1]));
	 
				InputStream in = sslsocket.getInputStream();
				OutputStream out = sslsocket.getOutputStream();
	 
				// Write a test byte to get a reaction :)
				out.write(1);
	 
				while (in.available() > 0) {
					System.out.print(in.read());
				}
				System.out.println("Successfully connected");
	 
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

Archivos Utiles: InstallCert
=====

    package installcert;

    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStream;
    import java.security.KeyStore;
    import java.security.MessageDigest;
    import java.security.cert.CertificateException;
    import java.security.cert.X509Certificate;
 
    import javax.net.ssl.SSLContext;
    import javax.net.ssl.SSLException;
    import javax.net.ssl.SSLSocket;
    import javax.net.ssl.SSLSocketFactory;
    import javax.net.ssl.TrustManager;
    import javax.net.ssl.TrustManagerFactory;
    import javax.net.ssl.X509TrustManager;
     
    public class InstallCert {
 
        public static void main(final String[] args) throws Exception {
            String host;
            int port;
            char[] passphrase;
            if ((args.length == 1) || (args.length == 2)) {
                final String[] c = args[0].split(":");
                host = c[0];
                port = (c.length == 1) ? 443 : Integer.parseInt(c[1]);
                final String p = (args.length == 1) ? "changeit" : args[1];
                passphrase = p.toCharArray();
            } else {
                System.out.println(
                        "Usage: java InstallCert <host>[:port] [passphrase]");
                return;
            }
     
            File file = new File("jssecacerts");
            if (file.isFile() == false) {
                final char SEP = File.separatorChar;
                final File dir = new File(System.getProperty("java.home")
                        + SEP + "lib" + SEP + "security");
                file = new File(dir, "jssecacerts");
                if (file.isFile() == false) {
                    file = new File(dir, "cacerts");
                }
            }
     
            System.out.println("Loading KeyStore " + file + "...");
            final InputStream in = new FileInputStream(file);
            final KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(in, passphrase);
            in.close();
     
            final SSLContext context = SSLContext.getInstance("TLS");
            final TrustManagerFactory tmf =
                    TrustManagerFactory.getInstance(TrustManagerFactory
                            .getDefaultAlgorithm());
            tmf.init(ks);
            final X509TrustManager defaultTrustManager =
                    (X509TrustManager) tmf.getTrustManagers()[0];
            final SavingTrustManager tm = new SavingTrustManager(
                    defaultTrustManager);
            context.init(null, new TrustManager[] { tm }, null);
            final SSLSocketFactory factory = context.getSocketFactory();
     
            System.out.println("Opening connection to "
                    + host + ":" + port + "...");
            final SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
            socket.setSoTimeout(10000);
            try {
                System.out.println("Starting SSL handshake...");
                socket.startHandshake();
                socket.close();
                System.out.println();
                System.out.println("No errors, certificate is already trusted");
            } catch (final SSLException e) {
                System.out.println();
                e.printStackTrace(System.out);
            }
     
            final X509Certificate[] chain = tm.chain;
            if (chain == null) {
                System.out.println("Could not obtain server certificate chain");
                return;
            }
     
            final BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
     
            System.out.println();
            System.out.println("Server sent " + chain.length + " certificate(s):");
            System.out.println();
            final MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            for (int i = 0; i < chain.length; i++) {
                final X509Certificate cert = chain[i];
                System.out.println(" " + (i + 1) + " Subject "
                        + cert.getSubjectDN());
                System.out.println("   Issuer  " + cert.getIssuerDN());
                sha1.update(cert.getEncoded());
                System.out.println("   sha1    " + toHexString(sha1.digest()));
                md5.update(cert.getEncoded());
                System.out.println("   md5     " + toHexString(md5.digest()));
                System.out.println();
            }
     
            System.out.println("Enter certificate to add to trusted keystore"
                    + " or 'q' to quit: [1]");
            final String line = reader.readLine().trim();
            int k;
            try {
                k = (line.length() == 0) ? 0 : Integer.parseInt(line) - 1;
            } catch (final NumberFormatException e) {
                System.out.println("KeyStore not changed");
                return;
            }
     
            final X509Certificate cert = chain[k];
            final String alias = host + "-" + (k + 1);
            ks.setCertificateEntry(alias, cert);
     
            final OutputStream out = new FileOutputStream(file);
            ks.store(out, passphrase);
            out.close();
     
            System.out.println();
            System.out.println(cert);
            System.out.println();
            System.out.println(
                    "Added certificate to keystore 'cacerts' using alias '"
                            + alias + "'");
        }
     
        private static final char[] HEXDIGITS = "0123456789abcdef".toCharArray();
     
        private static String toHexString(final byte[] bytes) {
            final StringBuilder sb = new StringBuilder(bytes.length * 3);
            for (int b : bytes) {
                b &= 0xff;
                sb.append(HEXDIGITS[b >> 4]);
                sb.append(HEXDIGITS[b & 15]);
                sb.append(' ');
            }
            return sb.toString();
        }
     
        private static class SavingTrustManager implements X509TrustManager {
     
            private final X509TrustManager tm;
            private X509Certificate[] chain;
     
            SavingTrustManager(final X509TrustManager tm) {
                this.tm = tm;
            }
     
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
                // throw new UnsupportedOperationException();
            }
     
            @Override
            public void checkClientTrusted(final X509Certificate[] chain,
                    final String authType)
                    throws CertificateException {
                throw new UnsupportedOperationException();
            }
     
            @Override
            public void checkServerTrusted(final X509Certificate[] chain,
                    final String authType)
                    throws CertificateException {
                this.chain = chain;
                this.tm.checkServerTrusted(chain, authType);
            }
        }
    }

Solucionar el problema del Handshake al correr Rongo
=====

 1. Compilar InstallCert.
 2. Ejecutar >> `java -jar InstallCert.jar auth.espol.edu.ec`
(Respuesta: auth.espol.edu.ec añadido al keystore)
 3. Ejecutar >> `java -jar InstallCert.jar localhost:8181`
(Respuesta: localhost añadido al keystore)
(El puerto 8181 es el puerto de seguridad de Glassfish)
 4. Compilar SSLPoke.
 5. Ejecutar >> `java -jar SSLPoke.jar auth.espol.edu.ec 443`
(Respuesta: Exitoso)
 6. Ejecutar `java -jar SSLPoke.jar localhost 8181`
(Respuesta: Exitoso)
 7. Copiar el archivo **cacerts** de la carpeta `-pathTo-\Java\jdk-version-\jre\lib\security` en la `pathTo\glassfish-4.0\glassfish\domains\domain1\config` del Glassfish, y añadirle la extensión jks.
 8. Correr el proyecto.

Si con lo de arriba aún no funciona, realizar lo siguiente:

 1. En el CMD >> `keytool -list -v -keystore /path/to/cacerts  > java_cacerts.txt`
 2. Coloque la contraseña "changeit"
 3. Ver si java_cacerts.txt incluye el mismo certificado que está presente en el browser buscando el número serial. En caso de no estar presente, vaya al browser, exporte el Root CA. Escoja "X.509 Certificate (DER).
 4. Asumiendo que el archivo se llama example.der: `keytool -import -alias example -keystore  /path/to/cacerts -file example.der`
 5. Coloque la contraseña "changeit"
 6. Copiar el archivo cacerts de la carpeta keytool en la carpeta domain del Glassfish con extensión jks.



