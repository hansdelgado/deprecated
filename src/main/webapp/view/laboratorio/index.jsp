 private String codigo;
    private String nombre;
    private String descripcion;
    private String local;
    private String pabellon;
    private String salon;
    private int capacidad;
    private EstadoLaboratorio estado;

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Laboratorios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="buscarLaboratorio">
        <fieldset>
            <legend>Datos de B&uacute;squeda</legend>
            <div>
                <label for="nombre">
                    Nombre
                </label>
                <input type="search" name="nombre" id="nombre" maxlength="50" />
            </div>
            <div>
                <label for="descripcion">
                    Descripcion
                </label>
                <input type="search" name="descripcion" id="descripcion" maxlength="50" />
            </div>
            <div>
                <label for="local">
                    Lacal
                </label>
                <input type="search" name="local" id="local" maxlength="50" />
            </div>
            <div>
                <label for="tipoBusqueda">
                    Tipo Busqueda
                </label>
                <select name="tipoBusqueda">
                    <option value="0">Completa</option>
                    <option value="1">Parcial</option>
                </select>
            </div>  
        </fieldset>
        <button><span>Buscar</span></button>
    </form>
    <div>
        <nav>
            <ul>
                <li>
                    <a href="irRegistroLaboratorio">
                        Registrar nuevo laboratorio
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <ul id="resultadoConsulta">
            <li class="cabeceraConsulta">
                <span>Codigo</span>
                <span>Nombre</span>
                <span>Descripcion</span>
                <span>Local</span>
            </li>
            <c:forEach var="laboratorio" items="${requestScope.laboratorios}" >
                <li>
                    <span>${laboratorio.codigo}</span>
                    <span>${laboratorio.nombre}</span>
                    <span>${laboratorio.descripcion}</span>
                    <span>${laboratorio.local}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
</gch:base>