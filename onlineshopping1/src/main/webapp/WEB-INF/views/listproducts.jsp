<div class="container">
  
  <div class="row">
  
  <!--  //to display sidebar-->
       <div class="col-mid-3">
       
       <%@include file="./shared/sidebar.jsp" %>
       
       </div>
       
         <!--  //to display products-->
        <div class="col-md-9">
        
         <!--  //addesd bread crumb-->
         <div class="row">
         <div class="col-lg-12">
         
         <c:if test="${userClickAllProducts==true}">
         <script>
         window.categoryId='';
         </script>
         <ol class="breadcrumb">
         <li><a href="${contextRoot }/index">Home</a></li>
         <li class="active">All products</li>
         </ol>
         </c:if>
          <c:if test="${userClickCategoryProducts==true}">
          <script>
         window.categoryId='${category.id}';
         </script>
         <ol class="breadcrumb">
         <li><a href="${contextRoot }/index">Home</a></li>
         <li class="active">All products</li>
         <li class="active">${category.name }</li>
         </ol>
         </c:if>
         </div>
         
         </div>
        <div class="row">
        <div class="col-xs-12">
        <table id="productlisttable" class="table table-striped table-bordered">
        <thead>
        <tr>
          <th></th>
        <th>Name</th>
         <th>Brand</th>
           <th>Price</th>
            <th>QTY.aaliable</th>
            <th></th>
        </tr>
        
        </thead>
        <tfoot>
        <tr>
          <th></th>
        <th>Name</th>
         <th>Brand</th>
           <th>Price</th>
            <th>QTY.aaliable</th>
            <th></th>
        </tr>
        </tfoot>
        </table>
        </div>
        </div>
           
        </div>
  </div>
</div>