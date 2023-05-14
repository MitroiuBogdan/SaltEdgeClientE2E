package com.yllu.SaltEdgeClientE2E.saltedge;

public class SSLConf {
    @Bean
    public RestTemplate restTemplate() throws Exception {
        // Load the keystore and truststore files
        Resource keystoreResource = new ClassPathResource("path/to/keystore.jks");
        Resource truststoreResource = new ClassPathResource("path/to/truststore.jks");
        char[] keystorePassword = "keystorePassword".toCharArray();
        char[] truststorePassword = "truststorePassword".toCharArray();

        // Create a KeyStore with the loaded keystore file
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(keystoreResource.getInputStream(), keystorePassword);

        // Create a KeyManagerFactory with the keystore
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keystore, keystorePassword);

        // Create a TrustManagerFactory with the truststore
        KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());
        truststore.load(truststoreResource.getInputStream(), truststorePassword);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(truststore);

        // Create an SSLContext and initialize it with the KeyManager and TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());

        // Create a HttpClient with the custom SSLContext
        HttpClient httpClient = HttpClients.custom()
                .setSSLContext(sslContext)
                .build();

        // Create a ClientHttpRequestFactory with the custom HttpClient
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(requestFactory);
    }
}
