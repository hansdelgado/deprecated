<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <tiles:insertAttribute name="gch.view.plantilla.encabezado"/>
    </head>
    <body>
        <header>
            <div>
                <s:url var="urlEn" >
                    <s:param name="request_locale">en</s:param>
                </s:url>
                <s:url  var="urlEs" >
                    <s:param name="request_locale">es</s:param>
                </s:url>
                <s:a href="%{urlEn}" id="urls" style="right :120px" >English</s:a>
                <s:a href="%{urlEs}" id="urls" >Español</s:a>
                </div>
                <hgroup>
                    <h1>GCH</h1>
                    <h2><s:text name="gch.app.principal"/></h2>
            </hgroup>

            <tiles:insertAttribute name="gch.view.plantilla.menu"/>
            <div>
                <s:if test="%{#session.GCH_SESION_USUARIO  == null}">
                    <s:a namespace="/login" action="acceso" id="urls">
                        <s:text name="gch.app.iniciar.sesion" />
                    </s:a>
                </s:if>
                <s:else>
                    <s:a namespace="/login" action="logout" id="urls">
                        <s:text name="gch.app.cerrar.sesion" />
                    </s:a>
                </s:else>
            </div>
        </header>

        <tiles:insertAttribute name="gch.view.plantilla.ayuda"/>
        <section id="contenido">
            <div>
                <tiles:insertAttribute name="gch.view.plantilla.cuerpo" />
            </div>
        </section>
        <tiles:insertAttribute name="gch.view.plantilla.pie"/>
    </body>
</html>

