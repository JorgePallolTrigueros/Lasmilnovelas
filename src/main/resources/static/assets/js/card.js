$(document).ready(function() {

	
	
    const TABLA = $('#example').DataTable( {
    
             "searchCols": [
            null
          ],
         //scrollY: 500,
         //scrollCollapse: true,
         "pagingType": "simple_numbers",
         "processing": true,
         'pageLength': 8,
         'lengthMenu': [ [8, 12, 16, -1], [9, 12, 16, "Todas"] ],
    
    
    
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
		document.getElementById('btn-buscar').addEventListener('click', () => {
			const descripciong = document.getElementById('buscar-descripcion-g').value;
             TABLA.columns(2).search(descripciong).draw();
		})
	}, 1000)

} );