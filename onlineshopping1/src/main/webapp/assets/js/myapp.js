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
		
	case 'All products':
		$('#allproducts').addClass('active');
		break;
		
		
	default:
		if(menu=='HOME')break;
		$('#a_'+menu).addClass('active');
		break;
	}
	

	
	var $table=$('#productlisttable')
	
	if($table.length)
		{
		
		var jsonURL='';
		if(window.categoryId=='')
			{
			jsonURl=window.contextRoot+'/json/data/all/products';
			}
		else{
			jsonURl=window.contextRoot+'/json/data/category/'+ window.categoryId +'/products';
		}
		$table.DataTable({
			lengthMenu:[[3,5,6,-1] ['3 records','5 records','6records','all records']],
			pageLength:3,
		  ajax:{
			  
			 url:jsonURl,
			 dataSrc: ''
		  },
		  columns:[
			  {
					data : 'code',
					bSortable : false,
					mRender : function(data, type, row) {

						return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg" class="dataTableImg"/>';

					}
			  },
			  {
				  data:'name'
			  },
			  {
				  data:'brand'
			  },
			  {
				  data:'unitprice',
				  mRender:function(data,type,row)
				  {
					  return '&#8377; '+data
				  }
			  },
			  {

					data : 'quantity',
					mRender : function(data, type, row) {

						if (data < 1) {
							return '<span style="color:red">Out of Stock!</span>';
						}

						return data;

					}
				},
			  {
				  data:'id',
				  bSortable:false,
				  mRender:function(data,type,row)
				  {
					  var str='';
					 
					  str +='<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"</span></a>&#160;';
					  if(row.quantity<1)
					  {
						  str +='<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					  }else{
					  str +='<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					  
					  }
					  return str;
				  }
			  },
		  ]
		  
		}
				
		)
		}
	
	
	
	
}		

)