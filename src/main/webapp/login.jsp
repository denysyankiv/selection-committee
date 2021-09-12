<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>
<c:set var="title" value="Login"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<div>
    <%@include file="/WEB-INF/jspf/header.jspf" %>
    <div class="justify-content-center align-items-center">
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <div class="card">
                        <div class="card-body">
                            <form id="login_form" action="controller"
                                  method="post">
                                <input type="hidden" name="command"
                                       value="login"/>
                                <fieldset>
                                    <legend>
                                        <fmt:message key="label.login_form.login"/>
                                    </legend>
                                    <input type="text" name="login"
                                           class="form-control"/>
                                </fieldset>
                                <fieldset>
                                    <legend>
                                        <fmt:message key="label.login_form.password"/>
                                    </legend>
                                    <input type="password" name="password"
                                           class="form-control"/>
                                </fieldset>


                                <button type="submit" class="btn btn-primary"
                                        style="margin-top: 10px"><fmt:message
                                        key="label.login_form.submit"/>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
    </div>


</div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>
