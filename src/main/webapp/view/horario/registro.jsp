<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Horarios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="registrarHorario" method="post">
        <fieldset>
            <legend>Datos</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8" required autofocus >
            </div>
            <div>
                <label for="descripcion">Descripci&oacute;n</label>
                <input type="text" id="descripcion" name="descripcion" required maxlength="50" />
            </div>
        </fieldset>
        <button>Registrar</button>
    </form>
</gch:base>