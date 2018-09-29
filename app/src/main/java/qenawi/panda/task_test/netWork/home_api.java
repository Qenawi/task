package qenawi.panda.task_test.netWork;


import io.reactivex.Single;
import qenawi.panda.task_test.netWork.models.main_catsResponse;
import retrofit2.http.GET;
public interface home_api
{
    @GET("cat_list.php")
    Single<main_catsResponse> getMainCats();
}
