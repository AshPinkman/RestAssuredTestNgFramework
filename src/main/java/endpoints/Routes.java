package endpoints;

public class Routes {

    private Routes(){

    }

    private static String base_url = "https://petstore.swagger.io/v2";

    private static final String POST_URL = base_url + "/user";
    private static final String GET_URL = base_url + "/user/{username}";
    private static final String UPDATE_URL = base_url + "/user/{username}";
    private static final String DELETE_URL = base_url + "/user/{username}";

    public static String getPostUrl(){
        return POST_URL;
    }

    public static String getGetUrl(){
        return GET_URL;
    }

    public static String getUpdateUrl(){
        return UPDATE_URL;
    }

    public static String getDeleteUrl(){
        return DELETE_URL;
    }


}
