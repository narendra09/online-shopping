$(function()
{

	switch(menu)
	{
	case 'ABoutUs':
		$('#about').addClass('active');
		break;
		
	case 'Contact US':
		$('#contact').addClass('active');
		break;
		
	default:
		$('#HOME').addClass('active');
		break;
	}
}		

)