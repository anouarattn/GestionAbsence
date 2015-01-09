$(document).ready(function(){
	$('#dataTables-example').DataTable({
		responsive: true
	});
	$("table").attr({
		class:"table table-striped table-bordered table-hover dataTable no-footer"+$("table").attr("class")
	});
	$("tr th").attr({
 		class:"sorting",
		tabindex:"0",
		rowspan:"1",
		colspan:"1",
		style:"width: 172px;"
	});
	$("tr:first-child").attr({
		class:"sorting_asc"
	});


	$("tbody tr:odd").attr({
		class:"gradeA odd"
	});

	$("tbody tr:even").attr({
		class:"gradeA even"
	});

});