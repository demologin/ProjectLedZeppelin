<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
        crossorigin="anonymous"></script>
<div class="container">
    <h1>Edit user page</h1>


    <form class="form-horizontal" method="post" action="edit-user">
        <fieldset>

            <!-- Form Name -->
            <legend>Edit user ${requestScope.user.login}</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" value="${requestScope.user.login}" name="login" type="text"
                           placeholder="placeholde" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" value="${requestScope.user.password}" name="password" type="password"
                           placeholder="2...32 symbols" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Select Multiple -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="role">Role</label>
                <div class="col-md-4">
                    <select id="role" name="role" class="form-control" multiple="multiple">
                        <option value="ADMIN">ADMIN</option>
                        <option value="USER">USER</option>
                        <option value="GUEST">GUEST</option>
                    </select>
                </div>
            </div>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="create">Create</label>
                <div class="col-md-8">
                    <button id="create" name="create" class="btn btn-success">Create</button>
                    <button id="update" name="update" class="btn btn-info">Update</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>