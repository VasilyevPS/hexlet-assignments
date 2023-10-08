<!-- BEGIN -->
@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes;
@param PostsPage page

@template.layout.page(
    content = @`
        @if(page.getPosts().isEmpty())
                <h1>Постов пока нет</h1>
        @else
            <div>
                @for(var post : page.getPosts())
                    <div>
                        <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                    </div>
                @endfor
            </div>
            <div class="container">
                <nav aria-label="Page navigation">
                  <ul class="pagination justify-content-center">
                    <li class="page-item + ${page.getCurrentPage() <= 1 ? " disabled" : ""}">
                      <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() < 2 ? 1 : page.getCurrentPage() - 1}">Prev</a>
                    </li>
                    <li class="page-item + ${page.getCurrentPage() >= page.getPagesNumber() ? " disabled" : ""}">
                      <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() + 1}">Next</a>
                    </li>
                  </ul>
                </nav>
              </div>
        @endif
    `
)
<!-- END -->
