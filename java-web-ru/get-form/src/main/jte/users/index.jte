<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h1>Пользователи</h1>
            <form action="/users" method="get">
            <label class="form-label">Please enter the name</label>
            <div class="input-group mb-3">
                <input type="search" name="term" value="${page.getTerm()}" />
            </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
            <table class="table table-striped">
                @for(var user : page.getUsers())
                   <tr>
                       <td>
                           ${user.getId()}
                       </td>
                       <td>
                           ${user.getFirstName()} ${user.getLastName()}
                       </td>
                   </tr>
                @endfor
            </table>
    `
)
<!-- END -->
