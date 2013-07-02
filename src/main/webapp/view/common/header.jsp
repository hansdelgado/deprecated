    <%@taglib prefix="s" uri="/struts-tags"%>
    <header>
        <!-- Bloque de cabecera de la pagina -->
        <hgroup>
            <h1>GCH</h1>
            <h2>Sistema de Gesti&oacute;n de Carga Horaria</h2>
        </hgroup>
        <nav>
            <ul>
                <li>
                    <a href="listarProfesores">Profesores</a>
                </li>
                <li>
                    <a href="listarLaboratorios">Laboratorios</a>
                </li>
                <li>
                    <s:url action="listarHorarios" namespace="/horario" id="showHorarios" />
                    <s:a href="%{showHorarios}">Horarios</s:a>
                </li>
                <li>
                    <a href="listarProgramas">Programas</a>
                </li>
                <li>
                    <a href="listarCursos">Cursos</a>
                </li>
            </ul>
        </nav>
        <div>
            <gch:accionsesion />
        </div>
    </header>