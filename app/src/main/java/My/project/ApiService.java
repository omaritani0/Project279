package My.project;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface ApiService {
    // Fetch all messages
    @GET("/api/messages")
    Call<List<Message>> getMessages(@Query("chatName") String chatName);

    @POST("/api/messages")
    Call<Void> sendMessage(@Body Message message);

}
