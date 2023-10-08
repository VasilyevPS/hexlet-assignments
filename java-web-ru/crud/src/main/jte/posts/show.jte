<!-- BEGIN -->
@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes;
@param PostPage page

@template.layout.page(
    content = @`
        <div>
            <h2>${page.getPost().getName()}</h2>
            <p>${page.getPost().getBody()}</p>
        </div>
        <a href="${NamedRoutes.postsPath()}">Все посты</a>
    `
)
<!-- END -->
