

function handleRequestAdd(xhr, status, args, isAcademicYear,isCancel) {
	isAcademicYear = isAcademicYear || false;
	isCancel = isCancel || false;
	console.log(isAcademicYear);
	console.log(args.validationFailed);
	if(isCancel )
		{
		if (isAcademicYear == true)
			PF('jsAddAnneeScolaire').hide();
		else
			PF('jsAdd').hide();
		}
	if (args && !args.validationFailed) {
		if (isAcademicYear == true)
			PF('jsAddAnneeScolaire').hide();
		else
			PF('jsAdd').hide();
	}
	
	
}

function handleRequestModify(xhr, status, args) {
	PF('jsModify').hide();
}
function handleRequestshow(xhr, status, args) {
	PF('jsShow').hide();
}
