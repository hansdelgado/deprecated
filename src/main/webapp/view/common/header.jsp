    <%@taglib prefix="s" uri="/struts-tags"%>
    <header>
        <!-- Bloque de cabecera de la pagina -->
        <hgroup>
            <s:url action="principal" namespace="/" id="main" />
            <h1><s:a href="%{main}">GCH</s:a></h1>
            <h2><s:text name="subtitulo" /></h2>
        </hgroup>
        <nav>
            <ul>
                <li>
                    <a href=""><s:text name="menu.profesores" /></a>
                    
                </li>
                <li>
                    <a href=""><s:text name="menu.laboratorios" /></a>
                </li>
                <li>
                    <s:url action="listarHorarios" namespace="/horario" id="showHorarios" />
                    <s:a href="%{showHorarios}"><s:text name="menu.horarios" /></s:a>
                </li>
                <li>
                    <a href=""><s:text name="menu.programas" /></a>
                </li>
                <li>
                    <a href=""><s:text name="menu.cursos" /></a>
                </li>
            </ul>
        </nav>
        <div>
            <gch:accionsesion />
        </div>
    </header>