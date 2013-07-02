<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<gch:base titulo="Bienvenido">
    <p>
        <s:url action="principal" namespace="/" id="mainEnglish">
            <s:param name="request_locale">en</s:param>
        </s:url>
        <s:a href="%{mainEnglish}">Go to mainpage</s:a>
        <br />
        <s:url action="principal" namespace="/" id="mainSpanish">
            <s:param name="request_locale">es</s:param>
        </s:url>
        <s:a href="%{mainSpanish}">Ir a la página principal</s:a>
    </p>
</gch:base>