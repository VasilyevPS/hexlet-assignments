package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        int currentPage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int limit = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
        int offset = (currentPage - 1) * limit;
        List<Post> posts = new ArrayList<>(PostRepository.getEntities());
        int pagesNumber = posts.size() / limit;
        List<Post> selectedPosts = posts.subList(offset, offset + limit);
        var page = new PostsPage(selectedPosts, currentPage, pagesNumber);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        long id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
