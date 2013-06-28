<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:text name="gch.app.nuevo.usuario" var="nuevo_usuario" />
<gch:base titulo="${nuevo_usuario}">
    <div class="informacion" style="margin-bottom: 7px">
        <s:property value="mensaje" />
        <s:fielderror/>
    </div>
    <s:form namespace="/login" action="registrar" method="post">
        <fieldset>
            <div>
                <s:label key="gch.login.usuario" />
                <s:textfield name="usuario" />
            </div>
            <div>
                <s:label key="gch.login.clave" />
                <s:textfield name="clave" />
            </div>
            <div>
                <s:label key="gch.login.reclave" />
                <s:textfield name="reclave" />
            </div>
        </fieldset>
        <div class="comandos">
            <s:submit value="%{getText('gch.login.registrar')}"/>
        </div>
    </s:form>
</gch:base>