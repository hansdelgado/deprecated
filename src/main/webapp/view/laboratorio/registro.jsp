<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Laboratorio">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="registrarLaboratorio" method="post">
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8" required autofocus >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Laboratorio</legend>
            <div>
                <label for="nombre">Nombres</label>
                <input type="text" id="nombre" name="nombre" required maxlength="50" />
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <input type="text" id="descripcion" name="descripcion" required maxlength="50" />
            </div>
            <div>
                <label for="local">Local</label>
                <input type="text" id="local" name="local" required maxlength="50" />
            </div>
            <div>
                <label for="pabellon">Pabellon</label>
                <input type="text" id="pabellon" name="pabellon" required maxlength="50" />
            </div>
            <div>
                <label for="salon">Salon</label>
                <input type="text" id="salon" name="salon" required maxlength="50" />
            </div>
            <div>
                <label for="capacidad">Capacidad</label>
                <input type="text" id="capacidad" name="capacidad" required maxlength="50" />
            </div>
            
        </fieldset>
       
        <button>Registrar</button>
    </form>
</gch:base>

