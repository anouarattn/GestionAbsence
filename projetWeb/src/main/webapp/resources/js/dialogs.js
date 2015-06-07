function handleRequestAdd(xhr, status, args, isAcademicYear,isCancel) {
	isAcademicYear = isAcademicYear || false;
	isCancel = isCancel || false;
	if(isCancel )
		{
		if (isAcademicYear == true)
			PF('jsAddAnneeScolaire').hide();
		else{
			PF('jsAdd').hide();
		}
		}
	else if (args && !args.validationFailed) {
		console.log("dddlmsdsldkf")
		if (isAcademicYear == true)
			PF('jsAddAnneeScolaire').hide();
		else
			PF('jsAdd').hide();
	}
	
	
}

function handleRequestModify(xhr, status, args ,isCancel) {
	
	if(isCancel )
		PF('jsModify').hide();
	else if (args && !args.validationFailed) {
	PF('jsModify').hide();
	}
}
function handleRequestshow(xhr, status, args) {
	PF('jsShow').hide();
}

function handleRequestAbsence(xhr, status, args) {
	PF('jsAbsence').hide();
}
