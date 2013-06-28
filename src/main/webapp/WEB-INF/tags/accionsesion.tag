    <%@tag description="pone un enlace para iniciar/cerrar sesion, segun estado"
           pageEncoding="UTF-8"%>
    <%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@attribute name="message"%>
    <s:a namespace="/login" action="nuevo" style="right: 95px;"><s:text name="gch.app.nuevo.usuario" /></s:a>
    <a href="iniciarSesion"><s:text name="gch.app.iniciar.sesion" /></a>

