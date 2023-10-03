<!-- BEGIN -->
@import gg.jte.Content
@param Content content

<!DOCTYPE html>
<html lang = "en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Layout lesson</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
                    rel="stylesheet"
                    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                    crossorigin="anonymous">
    </head>
    <body>
    <div class="mx-auto p-4 py-md-5">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                  <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
                    <span class="fs-4">Layout lesson</span>
                  </a>

                  <ul class="nav nav-pills">
                    <li class="nav-item"><a href="/" class="nav-link">Home</a></li>
                    <li class="nav-item"><a href="/users" class="nav-link">Users</a></li>
                  </ul>
            </header>
            <main>
                ${content}
            </main>
            <footer class="footer border-top py-3 mt-5 bg-light">
                <div class="container-xl">
                    <div class="text-center">
                      created by
                      <a href="https://github.com/VasilyevPS/" target="_blank">Pavel Vasilyev</a>
                    </div>
                </div>
            </footer>
        </div>
    </body>
</html>
<!-- END -->
