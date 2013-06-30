<%@taglib prefix="s" uri="/struts-tags" %>
<header>
    <!-- Bloque de cabecera de la pagina -->
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
    <div>

    </div>
    <nav>
        <ul>
            <li>
                <a href="listarProfesores"><s:text name="gch.app.profesores" /></a>
            </li>
            <li>
                <a href="listarLaboratorios"><s:text name="gch.app.laboratorios" /></a>
            </li>
            <li>
                <a href="listarHorarios"><s:text name="gch.app.horarios" /></a>
            </li>
            <li>
                <s:a namespace="/programa" action="listar"><s:text name="gch.app.programas" /> </s:a>
                </li>
                <li>
                    <a href="listarCursos"><s:text name="gch.app.cursos" /></a>
            </li>
        </ul>
    </nav>
    <div>
        <s:a namespace="/login" action="nuevo" style="right: 95px;">
            <s:text name="gch.app.nuevo.usuario" />
        </s:a>
        <a href="iniciarSesion">
            <s:text name="gch.app.iniciar.sesion" />
        </a>
    </div>
</header>