package unusualevents.login.utils;

import org.springframework.web.client.RestTemplate;

public class RemoteOauthRequest {
	private static RestTemplate restTemplate = new RestTemplate();

    public static <T> T post(String url, Object request, Class<T> clazz, Object... uriValues) {
        return restTemplate.postForObject(url, request, clazz, uriValues);
    }

    public static String get(String url) {
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    public static <T> T getT(String url, Class<T> clazz) {
        System.out.println(url);
        return restTemplate.getForObject(url, clazz);
    }

    public static <T> T postT(String url, String param, Class<T> clazz) {
        System.out.println(url + ":" + param);
        return restTemplate.postForObject(url, param, clazz);
    }

    public static <T> T postT(String url, Object param, Class<T> clazz) {
        System.out.println(url + ":" + param);
        return restTemplate.postForObject(url, param, clazz);
    }


}

