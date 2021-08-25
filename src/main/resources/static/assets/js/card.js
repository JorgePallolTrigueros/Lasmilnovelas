$(document).ready(function() {

	
	
    const TABLA = $('#example').DataTable( {
    
             /*"searchCols": [
            null
          ],*/
         //scrollY: 500,
         //scrollCollapse: true,
         "pagingType": "simple_numbers",
         "processing": true,
         "pageLength": 8,
          "lengthMenu": [ [8, 12, 16, -1], [9, 12, 16, "Todas"] ],
    
    
    
        dom: 'Bfrtip',
         'buttons': [ {
            'text': '<i class="fa fa-id-badge fa-fw" aria-hidden="true"></i>',
            'action': function (e, dt, node) {

               $(dt.table().node()).toggleClass('cards');
               $('.fa', node).toggleClass(['fa-table', 'fa-id-badge']);

               dt.draw('page');
            },
            'className': 'btn-sm',
            'attr': {
               'title': 'Change views',
            }
         }],
    } );


    setTimeout(() => {
      $( "#slider-range" ).slider({
         range: true,
         min: 0,
         max: 100,
         values: [ 12, 30 ],
         slide: function( event, ui ) {
            $( "#amount" ).val( "" + ui.values[ 0 ] + "-" + ui.values[ 1 ] );

            $.fn.dataTable.ext.search.push(
               function( settings, data, dataIndex ) {
                  var minimo = $("#amount").val().split('-')[0];
                  var maximo = $("#amount").val().split('-')[1];
                  var min = parseInt( minimo, 10 );
                  var max = parseInt( maximo, 10 );
                  var salario = parseFloat( data[2] ) || 0;

                  if ( ( isNaN( min ) && isNaN( max ) ) ||
                        ( isNaN( min ) && salario <= max ) ||
                        ( min <= salario   && isNaN( max ) ) ||
                        ( min <= salario   && salario <= max ) )
                  {
                     return true;
                  }
                  return false;
               }
            );
            TABLA.draw();
         }
      });
      $( "#amount" ).val( "" + $( "#slider-range" ).slider( "values", 0 ) +
         "-" + $( "#slider-range" ).slider( "values", 1 ) );

    }, 500)


	setTimeout(() => {
		document.getElementById('btn-buscar').addEventListener('click', () => {
			
			const nombre = document.getElementById('buscar-nombre').value;
			TABLA.columns(0).search(nombre).draw();
			
			const edadRecomendadaInput = document.getElementById('buscar-edad-input').value;
			console.log(edadRecomendadaInput);
			TABLA.columns(2).search(edadRecomendadaInput).draw();
			
			const descripciong = document.getElementById('buscar-descripcion-g').value;
			TABLA.columns(4).search(descripciong).draw();
			
			
			
		})
		
		document.getElementById('btn-limpiar').addEventListener('click', () => {
			
			document.getElementById('buscar-nombre').value = '';
			document.getElementById('buscar-descripcion-g').value = '';
			document.getElementById('buscar-edad-input').value = '';
			
		})
		
		
	}, 1000)

} );