<%@ include file="../../jspf/directive/page.jspf" %>
<%@ include file="../../jspf/directive/taglib.jspf" %>


<html>
<c:set var="title" value="Entrant Register"/>
<%@ include file="../../jspf/head.jspf" %>


<body>
<p></p>

<form id="entrant_register_form" action="controller" method="post">
    <input type="hidden" name="command" value="entrant_register"/>
    <fieldset>
        <label for="full_name_input"><fmt:message
                key="label.full_name"/></label>
        <input id="full_name_input" type="text" name="full_name"/>

        <label for="email_input"><fmt:message key="label.email"/></label>
        <input id="email_input" type="text" name="email"/>

        <label for="city_input"><fmt:message key="label.city"/></label>
        <input id="city_input" type="text" name="city"/>

        <label for="region_input"><fmt:message key="label.region"/></label>
        <input id="region_input" type="text" name="region"/>

        <label for="school_name_input"><fmt:message key="label.school_name"/></label>
        <input id="school_name_input" type="text" name="school_name"/>
    </fieldset>
    <fieldset>
        <label for="login_input"><fmt:message key="label.login"/></label>
        <input id="login_input" type="text" name="login"/>

        <label for="password_input"><fmt:message key="label.password"/></label>
        <input id="password_input" type="password" name="password"/>
    </fieldset>
    <input type="submit" value='<fmt:message key="label.submit"/> '/>
</form>


<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>
