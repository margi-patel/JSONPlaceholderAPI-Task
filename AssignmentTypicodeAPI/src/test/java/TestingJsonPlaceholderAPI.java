import io.restassured.response.Response;

public class TestingJsonPlaceholderAPI {
    public static void main(String[] args) {
        JsonplaceholderAPI jsonplaceholderAPI = new JsonplaceholderAPI("https://jsonplaceholder.typicode.com");
        Response getResponse;

        //getResponse = jsonplaceholderAPI.getData("/posts");
        getResponse = jsonplaceholderAPI.getData("/posts/1");
        //getResponse = jsonplaceholderAPI.getData("/posts/1", "userId", "1");
        //getResponse = jsonplaceholderAPI.getData("posts/1/comments");
        //getResponse = jsonplaceholderAPI.getData("/comments", "postId", "1");

        String resultString = getResponse.getBody().asString();
        System.out.println("GET Results:-\n" + getResponse.getBody().asString());

        String postBody = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"Good Morning!\",\n" +
                "    \"body\": \"quia et suscipit\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";

        Response postResponse = jsonplaceholderAPI.postData("/posts", postBody);
        System.out.println("POST Results:-\n" + postResponse.getBody().asString());

        Response deleteResponse = jsonplaceholderAPI.deleteData("/posts/1");
        System.out.println("DELETE Results:-\n" + postResponse.getBody().asString());

        String postUpdateBody = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"Good Morning!\",\n" +
                "    \"body\": \"quia et suscipit\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";

        Response updateResponse = jsonplaceholderAPI.updateData("/posts/1", postUpdateBody);
        System.out.println("UPDATE Results:-\n" + postResponse.getBody().asString());
    }
}
