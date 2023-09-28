<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    <title>List of users</title>
  </head>
  <body>
  @if(page.getUsers().isEmpty())
    <p>There are no users</p>
  @else
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">First name</th>
          <th scope="col">Last name</th>
          <th scope="col">Email</th>
        </tr>
      </thead>
      <tbody>
      @for(var user : page.getUsers())
        <tr>
          <th scope="row">${user.getId()}</th>
          <td>${user.getFirstName()}</td>
          <td>${user.getLastName()}</td>
          <td>${user.getEmail()}</td>
        </tr>
      @endfor
      </tbody>
    </table>
  @endif
  </body>
</html>
<!-- END -->
