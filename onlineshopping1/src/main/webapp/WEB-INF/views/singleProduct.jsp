<div class="container">
<div class="row">

	<div class="col-xs-12">
	
	  <ol class="breadcrumb">
	  <li><a href="${contextRoot }/home">Home</a></li>
	  <li><a href="${contextRoot }/show/all/products">Products</a></li>
	  <li class="active">${product.name} </li>
	  </ol>
	
	</div>

</div>

<div class="row">
	<div class="col-xs-12 col-xm-4">
		<div class="thumbnail">
		<img src="${images }/${product.code}.jpg" clas="img img-responsive"/>
		
		</div>
	
	</div>
	
	<div class="col-xs-12 col-xm-8">
	<h3>${product.name }</h3>
	</hr>
	
	<p>${product.description }</p>
	</hr>
	
	<h4>price:<strong>&#8377;${product.unitprice }/-</strong></h4>
	</hr>
    
    <h6>QTY.Available:${product.quantity }</h6>
	</hr>
	<a href="${contextRoot }/cart/add/${product.id}/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>ADD TO CART</a>
	<a href="${contextRoot }/show/all/products" class="btn btn-primary">BACK</a>	
		</div>
	
	</div>

</div>
</div>