<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
            <s:a namespace="/programa" action="listar">
                <s:text name="gch.app.programas" />
            </s:a>
        </li>
        <li>
            <a href="listarCursos"><s:text name="gch.app.cursos" /></a>
        </li>
    </ul>
</nav>
