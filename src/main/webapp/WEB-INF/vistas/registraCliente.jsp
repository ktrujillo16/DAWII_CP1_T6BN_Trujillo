
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css" rel="stylesheet"/>

<title>Registra Cliente</title>
</head>
<body>

<div class="container">
<h1>Registra Cliente</h1>
	<c:if test="${sessionScope.MENSAJE != null}">
		<div class="alert alert-success fade in" id="success-alert">
		 <a href="#" class="close" data-dismiss="alert">&times;</a>
		 <strong>${sessionScope.MENSAJE}</strong>
		</div>
		
	</c:if>
	<c:remove var="MENSAJITO" />

	<form action="registraCliente" id="id_form" method="post"> 
			<input type="hidden" name="metodo" value="registra">	
			<div class="form-group">
				<label class="control-label" for="id_nombre">Nombre</label>
				<input class="form-control" type="text" id="id_nombre" name="nom_cliente" placeholder="Ingrese el nombre" maxlength="40">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_apellido">Apellido</label>
				<input class="form-control" type="text" id="id_apellido" name="ape_cliente" placeholder="Ingrese el apellido" maxlength="40">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_dni">DNI</label>
				<input class="form-control" type="text" id="id_dni" name="dni_cliente" placeholder="Ingrese el dni" maxlength="8">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_fecha">Fecha de Nacimiento</label>
				<input class="form-control" type="text"  id="id_fecha" name="fec_nac_cliente" placeholder="YYYY/MM/DD">
				
			</div>
			
			<div class="form-group">
				<label class="control-label" for="id_tipo">Tipo Cliente</label>
				<select id="id_tipo" name="tipo" class='form-control'>
					<option value=" " disabled selected>[Seleccione]</option>    
				</select>
		    </div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary"  >Crear Cliente</button>
			</div>
			
			
	</form>
</div>


<script type="text/javascript">
$("#success-alert").fadeTo(2000, 1000).slideUp(1000, function(){
    $("#success-alert").slideUp(1000);
});
</script>

<script type="text/javascript">

$.getJSON("cargaTipo", {}, function(data){
	$.each(data, function(index,item){
		$("#id_tipo").append("<option value="+item.cod_tipo +">"+ item.nom_tipo +"</option>");
	});
});
</script>



<script type="text/javascript">

$('#id_form').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	nom_cliente: {
    		selector : '#id_nombre',
            validators: {
                notEmpty: {
                    message: 'El nombre es un campo obligatorio'
                },
                stringLength :{
                	message:'El nombre es de 3 a 40 caracteres',
                	min : 3,
                	max : 40
                }
            }
        },
        ape_cliente: {
    		selector : '#id_apellido',
    		validators: {
                notEmpty: {
                    message: 'El apellido es un campo obligatorio'
                },
                stringLength :{
                	message:'El apellido es de 3 a 40 caracteres',
                	min : 3,
                	max : 40
                }
            }
        },
        dni_cliente:{
            selector: '#id_dni',
            validators:{
                notEmpty: {
                     message: 'El dni es obligatorio'
                },
                regexp: {
                    regexp: /^[0-9]{8}$/,
                    message: 'Ingrese solo números'
                }
            }
        },
        fec_nac_cliente: {
            validators: {
       		 	notEmpty: {
            		message: 'La fecha es obligatoria'
        		}	
            }
        },
        tipo: {
    		selector : '#id_tipo',
            validators: {
            	notEmpty: {
                    message: 'El tipo un campo obligatorio'
                },
            }
        },
        
    }
    
   
});

</script>

<script type="text/javascript">
$(function () {
    $('#id_fecha').datepicker({
        language: "es",
        autoclose: true,
        format: "yyyy-mm-dd",
        todayHighlight: true,
        startDate : new Date('1900-01-01'),
        endDate : new Date()
    	
    });
});

</script>
<script type="text/javascript">

// Validate the form manually
$('#validateBtn').click(function() {
    $('#id_form').bootstrapValidator('validate');
});

</script>


</body>
</html>