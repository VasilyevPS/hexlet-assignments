<!-- BEGIN -->
@template.layout.page(
    content = @`
        <form class="input-group" action="/users" method="post">
            <div class="input-group mb-3">
                <label>
                    Имя
                    <input type="text" class="form-control" name="firstName" />
                </label>
            </div>
            <div class="input-group mb-3">
                <label>
                    Фамилия
                    <input type="text" class="form-control" name="lastName" />
                </label>
            </div>
            <div class="input-group mb-3">
                <label>
                Email
                <input type="email" class="form-control" required name="email" />
                </label>
            </div>
            <div class="input-group mb-3">
                <label>
                Пароль
                <input type="password" class="form-control" required name="password" />
                </label>
            </div>
            <input type="submit" class="btn btn-outline-primary" value="Зарегистрировать" />
        </form>
    `
)
<!-- END -->
